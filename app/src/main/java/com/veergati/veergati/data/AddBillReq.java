
package com.veergati.veergati.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddBillReq {

    @SerializedName("transactionid")
    @Expose
    private String transactionid;
    @SerializedName("currdate")
    @Expose
    private String currdate;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("totalamount")
    @Expose
    private String totalamount;

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getCurrdate() {
        return currdate;
    }

    public void setCurrdate(String currdate) {
        this.currdate = currdate;
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

}
