package com.veergati.veergati.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Stocks implements Parcelable {
    String itemId;
    String itemName;
    String itemUnit;
    String itemQuantity;
    String itemPrice;
    String itemOrganization;

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemOrganization() {
        return itemOrganization;
    }

    public Stocks(String itemId, String itemName, String itemUnit, String itemQuantity, String itemPrice, String itemOrganization) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemUnit = itemUnit;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemOrganization = itemOrganization;
    }

    protected Stocks(Parcel in) {
        itemId = in.readString();
        itemName = in.readString();
        itemUnit = in.readString();
        itemQuantity = in.readString();
        itemPrice = in.readString();
        itemOrganization = in.readString();
    }

    public static final Creator<Stocks> CREATOR = new Creator<Stocks>() {
        @Override
        public Stocks createFromParcel(Parcel in) {
            return new Stocks(in);
        }

        @Override
        public Stocks[] newArray(int size) {
            return new Stocks[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemId);
        dest.writeString(itemName);
        dest.writeString(itemUnit);
        dest.writeString(itemQuantity);
        dest.writeString(itemPrice);
        dest.writeString(itemOrganization);
    }
}
