
package com.veergati.veergati.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiV3Response {

    @SerializedName("stockData")
    @Expose
    private List<StockDatum> stockData = null;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;

    public List<StockDatum> getStockData() {
        return stockData;
    }

    public void setStockData(List<StockDatum> stockData) {
        this.stockData = stockData;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
