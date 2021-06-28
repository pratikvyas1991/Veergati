package com.veergati.veergati.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable {
    String nameOfDeceased;
    String age;
    String reason;
    String timeOfDeath;
    String place;
    String nameOfCustomer;
    String mobileNumber;

    public String getNameOfDeceased() {
        return nameOfDeceased;
    }

    public String getAge() {
        return age;
    }

    public String getReason() {
        return reason;
    }

    public String getTimeOfDeath() {
        return timeOfDeath;
    }

    public String getPlace() {
        return place;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Customer(String nameOfDeceased, String age, String reason, String timeOfDeath, String place, String nameOfCustomer, String mobileNumber) {
        this.nameOfDeceased = nameOfDeceased;
        this.age = age;
        this.reason = reason;
        this.timeOfDeath = timeOfDeath;
        this.place = place;
        this.nameOfCustomer = nameOfCustomer;
        this.mobileNumber = mobileNumber;
    }

    protected Customer(Parcel in) {
        nameOfDeceased = in.readString();
        age = in.readString();
        reason = in.readString();
        timeOfDeath = in.readString();
        place = in.readString();
        nameOfCustomer = in.readString();
        mobileNumber = in.readString();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameOfDeceased);
        dest.writeString(age);
        dest.writeString(reason);
        dest.writeString(timeOfDeath);
        dest.writeString(place);
        dest.writeString(nameOfCustomer);
        dest.writeString(mobileNumber);
    }
}
