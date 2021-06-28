package com.veergati.veergati.utils;

import com.veergati.veergati.data.TransactionTable;

import java.util.List;

public interface TrasactionCallback {
    public void onError(Error error);
    public void onSucess(List<TransactionTable> transactions);
}
