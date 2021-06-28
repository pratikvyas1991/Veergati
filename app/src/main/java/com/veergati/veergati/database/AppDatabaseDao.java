package com.veergati.veergati.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.veergati.veergati.data.StockTable;
import com.veergati.veergati.data.TransactionTable;

import java.util.List;

@Dao
public interface AppDatabaseDao {

    // Stocks Related Operations

    @Query("SELECT * FROM stock ORDER BY itemid")
    LiveData<List<StockTable>> loadAllStocks();

    @Insert
    void insertStock(StockTable stockTable);

    @Update
    void updateStock(StockTable stockTable);

    @Delete
    void deleteStock(StockTable stockTable);

    @Query("SELECT * FROM stock WHERE itemid = :itemid")
    StockTable loadStockById(int itemid);


//    @Query("SELECT * FROM stock ORDER BY itemid DESC")
//    void deleteAllStocks();

}
