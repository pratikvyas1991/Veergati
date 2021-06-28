
package com.veergati.veergati.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionDatum implements Parcelable {

    @SerializedName("transactionid")
    @Expose
    private String transactionid;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("totalamount")
    @Expose
    private String totalamount;
    @SerializedName("stocksData")
    @Expose
    private List<StocksDatum> stocksData = null;

    protected TransactionDatum(Parcel in) {
        transactionid = in.readString();
        date = in.readString();
        time = in.readString();
        totalamount = in.readString();
    }

    public static final Creator<TransactionDatum> CREATOR = new Creator<TransactionDatum>() {
        @Override
        public TransactionDatum createFromParcel(Parcel in) {
            return new TransactionDatum(in);
        }

        @Override
        public TransactionDatum[] newArray(int size) {
            return new TransactionDatum[size];
        }
    };

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public List<StocksDatum> getStocksData() {
        return stocksData;
    }

    public void setStocksData(List<StocksDatum> stocksData) {
        this.stocksData = stocksData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(transactionid);
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(totalamount);
    }
}
