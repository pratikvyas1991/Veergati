package com.veergati.veergati.utils;

public interface IncrementedTransactionIdCallback {
    public void onError(Error error);
    public void onSucess(int transactionId);
}
