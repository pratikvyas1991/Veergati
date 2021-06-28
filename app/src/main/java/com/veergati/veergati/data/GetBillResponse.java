
package com.veergati.veergati.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBillResponse {

    @SerializedName("transactionData")
    @Expose
    private List<TransactionDatum> transactionData = null;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;

    public List<TransactionDatum> getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(List<TransactionDatum> transactionData) {
        this.transactionData = transactionData;
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
