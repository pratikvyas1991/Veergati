
package com.veergati.veergati.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StocksDatum {

    @SerializedName("transitemid")
    @Expose
    private String transitemid;
    @SerializedName("transactionid")
    @Expose
    private String transactionid;
    @SerializedName("itemname")
    @Expose
    private String itemname;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("quantity")
    @Expose
    private String quantity;

    public String getTransitemid() {
        return transitemid;
    }

    public void setTransitemid(String transitemid) {
        this.transitemid = transitemid;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
