package com.veergati.veergati.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Ticket implements Parcelable {
    String companyTitle;
    String billNumber;
    String systemDate;
    String mobileNumber;
    List<TicketItem> itemList;

    public String getCompanyTitle() {
        return companyTitle;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public String getSystemDate() {
        return systemDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public List<TicketItem> getItemList() {
        return itemList;
    }

    public Ticket(String companyTitle, String billNumber, String systemDate, String mobileNumber, List<TicketItem> itemList ) {
        this.companyTitle = companyTitle;
        this.billNumber = billNumber;
        this.systemDate = systemDate;
        this.mobileNumber = mobileNumber;
        this.itemList = itemList;
    }

    protected Ticket(Parcel in) {
        companyTitle = in.readString();
        billNumber = in.readString();
        systemDate = in.readString();
        mobileNumber = in.readString();
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(companyTitle);
        dest.writeString(billNumber);
        dest.writeString(systemDate);
        dest.writeString(mobileNumber);
    }
}
