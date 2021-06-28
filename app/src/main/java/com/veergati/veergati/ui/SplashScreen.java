package com.veergati.veergati.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kloadingspin.KLoadingSpin;
import com.veergati.veergati.R;
import com.veergati.veergati.thermalprinting.PrintingUtilsScreen;
import com.veergati.veergati.ui.auth.LoginScreen;
import com.veergati.veergati.utils.SharedPreferenceUtils;

public class SplashScreen extends AppCompatActivity {
    boolean isAuthenticated = false;
    SharedPreferenceUtils sharedPreferenceUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferenceUtils = SharedPreferenceUtils.getInstance();

        sharedPreferenceUtils.init(getApplicationContext());

        KLoadingSpin a = findViewById(R.id.KLoadingSpin);
        a.startAnimation();
        a.setIsVisible(true);

        isAuthenticated = Double.parseDouble(SharedPreferenceUtils.getInstance().getAuth()) == 0 ? false : true;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (isAuthenticated) {
//                    intent = new Intent(SplashScreen.this, PrintingUtilsScreen.class);
                    intent = new Intent(SplashScreen.this, MainActivity.class);
                } else {
                    intent = new Intent(SplashScreen.this, LoginScreen.class);
                }

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 2000);
    }
}
