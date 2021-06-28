package com.veergati.veergati.ui.stocks;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.veergati.veergati.data.StockTable;
import com.veergati.veergati.database.DatabaseManager;

import java.util.List;

public class StocksViewModel extends AndroidViewModel {

    private LiveData<List<StockTable>> stockList;
    private DatabaseManager mDatabaseManager;

    public StocksViewModel(@NonNull Application application) {
        super(application);
        mDatabaseManager = new DatabaseManager(application);
        stockList = mDatabaseManager.getAllNotes();
    }

    public void addStock(StockTable note) {
        mDatabaseManager.addStock(note);
    }

    public void insert(StockTable note) {
        mDatabaseManager.insert(note);
    }

    public void update(StockTable note) {
        mDatabaseManager.update(note);
    }

    public void delete(StockTable note) {
        mDatabaseManager.delete(note);
    }

    public void deleteAllNotes() {
        mDatabaseManager.deleteAllNotes();
    }

    public LiveData<List<StockTable>> getAllNotes() {
        return stockList;
    }

}