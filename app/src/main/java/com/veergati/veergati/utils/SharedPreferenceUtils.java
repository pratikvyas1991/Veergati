package com.veergati.veergati.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {
    static SharedPreferenceUtils mSharedPreferenceUtils;
    private String APPPREFERENCES = "veergati_preference";
    private String APPPREFERENCES_MOBILE = "mobile";
    SharedPreferences sharedpreferences;
    private Context mContext;

    public static SharedPreferenceUtils getInstance() {
        if (mSharedPreferenceUtils == null) {
            mSharedPreferenceUtils = new SharedPreferenceUtils();
        }
        return mSharedPreferenceUtils;
    }

    public void init(Context context) {
        this.mContext = context;
        sharedpreferences = mContext.getSharedPreferences(APPPREFERENCES, Context.MODE_PRIVATE);
    }

    public void setAuth(String mobile) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        if(mobile!=null){
            editor.putString(APPPREFERENCES_MOBILE, mobile);
        }else {
            editor.clear();
        }
        editor.apply();
    }

    public String getAuth() {
        return sharedpreferences.getString(APPPREFERENCES_MOBILE, "0");
    }
}
