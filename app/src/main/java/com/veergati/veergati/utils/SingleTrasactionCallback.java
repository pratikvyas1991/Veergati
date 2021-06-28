package com.veergati.veergati.utils;

import com.veergati.veergati.data.TransactionTable;

public interface SingleTrasactionCallback {
    public void onError(Error error);
    public void onSucess(Boolean isAllowed);
}
