package com.veergati.veergati.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class BillTransactionData implements Parcelable {
    String billingId;
    String billingDate;
    String billingTime;
    List<Stocks> itemsPurchased;
    String totalAmount;

    public BillTransactionData(String billingId, String billingDate, String billingTime, List<Stocks> itemsPurchased, String totalAmount) {
        this.billingId = billingId;
        this.billingDate = billingDate;
        this.billingTime = billingTime;
        this.itemsPurchased = itemsPurchased;
        this.totalAmount = totalAmount;
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


    public List<Stocks> getItemsPurchased() {
        return itemsPurchased;
    }

    public String getTotalAmount() {
        return totalAmount;
    }


    protected BillTransactionData(Parcel in) {
        billingId = in.readString();
        billingDate = in.readString();
        billingTime = in.readString();
        totalAmount = in.readString();
    }

    public static final Creator<BillTransactionData> CREATOR = new Creator<BillTransactionData>() {
        @Override
        public BillTransactionData createFromParcel(Parcel in) {
            return new BillTransactionData(in);
        }

        @Override
        public BillTransactionData[] newArray(int size) {
            return new BillTransactionData[size];
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
