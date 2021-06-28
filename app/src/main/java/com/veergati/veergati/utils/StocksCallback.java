package com.veergati.veergati.utils;

import com.veergati.veergati.data.StockTable;

import java.util.List;

public interface StocksCallback {
    public void onError(Error error);
    public void onSucess(List<StockTable> stocks);
}
