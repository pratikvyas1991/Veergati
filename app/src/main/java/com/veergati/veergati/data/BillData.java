package com.veergati.veergati.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class BillData implements Parcelable {
    String billingId;
    String billingDate;
    String billingTime;
    User currentLoggedUser;
    List<Stocks> itemsPurchased;
    String totalAmount;
    Customer customer;

    public BillData(String billingId, String billingDate, String billingTime, User currentLoggedUser, List<Stocks> itemsPurchased, String totalAmount, Customer customer) {
        this.billingId = billingId;
        this.billingDate = billingDate;
        this.billingTime = billingTime;
        this.currentLoggedUser = currentLoggedUser;
        this.itemsPurchased = itemsPurchased;
        this.totalAmount = totalAmount;
        this.customer = customer;
    }

    public String getBillingId() {
        return billingId;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public String getBillingTime() {
        return billingTime;
    }

    public User getCurrentLoggedUser() {
        return currentLoggedUser;
    }

    public List<Stocks> getItemsPurchased() {
        return itemsPurchased;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    protected BillData(Parcel in) {
        billingId = in.readString();
        billingDate = in.readString();
        billingTime = in.readString();
        totalAmount = in.readString();
    }

    public static final Creator<BillData> CREATOR = new Creator<BillData>() {
        @Override
        public BillData createFromParcel(Parcel in) {
            return new BillData(in);
        }

        @Override
        public BillData[] newArray(int size) {
            return new BillData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(billingId);
        dest.writeString(billingDate);
        dest.writeString(billingTime);
        dest.writeString(totalAmount);
    }
}
