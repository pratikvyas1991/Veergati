package com.veergati.veergati.utils;

import com.veergati.veergati.data.TransactionTable;

public interface TrasactionByIDCallback {
    public void onError(Error error);
    public void onSucess(TransactionTable transactionTable);
}
