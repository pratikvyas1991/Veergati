package com.veergati.veergati.data;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String userId;
    String userMobile;
    String userName;

    public String getUserId() {
        return userId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public String getUserName() {
        return userName;
    }

    public User(String userId, String userMobile, String userName) {
        this.userId = userId;
        this.userMobile = userMobile;
        this.userName = userName;
    }

    protected User(Parcel in) {
        userId = in.readString();
        userMobile = in.readString();
        userName = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userId);
        dest.writeString(userMobile);
        dest.writeString(userName);
    }
}
