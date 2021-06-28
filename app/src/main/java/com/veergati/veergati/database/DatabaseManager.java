package com.veergati.veergati.database;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.veergati.veergati.data.StockTable;

import java.util.List;

public class DatabaseManager {
    private AppDatabase appDatabase;
    private AppDatabaseDao appDatabaseDao;
    private LiveData<List<StockTable>> stockList;

    public  DatabaseManager(Application application){
        appDatabase = AppDatabase.getInstance(application);
        appDatabaseDao = appDatabase.appDatabaseDao();
        stockList = appDatabaseDao.loadAllStocks();
    }


    public void addStock(StockTable stockTable){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                StockTable row = appDatabaseDao.loadStockById(stockTable.getItemid());
                if(row ==null){
                    appDatabaseDao.insertStock(stockTable);
                    Log.v("@@@","addTrasaction() checking for trasaction ID : "+stockTable.getItemid()+" Inserted sucessfully");
                }else {
                    Log.v("@@@","addTrasaction() checking for trasaction ID : "+stockTable.getItemid()+" Inserted failed");
                }
                stockList = appDatabaseDao.loadAllStocks();
            }
        });
    }


    public void insert(StockTable note) {
        new InsertNoteAsyncTask(appDatabaseDao).execute(note);
    }

    public void update(StockTable note) {
        new UpdateNoteAsyncTask(appDatabaseDao).execute(note);
    }

    public void delete(StockTable note) {
        new DeleteNoteAsyncTask(appDatabaseDao).execute(note);
    }

    public void deleteAllNotes() {
        new DeleteAllStocksAsyncTask(appDatabaseDao).execute();
    }

    public LiveData<List<StockTable>> getAllNotes() {
        return stockList;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<StockTable, Void, Void> {

        private AppDatabaseDao appDatabaseDao;

        private InsertNoteAsyncTask(AppDatabaseDao appDatabaseDao) {
            this.appDatabaseDao = appDatabaseDao;
        }

        @Override
        protected Void doInBackground(StockTable... notes) {
            appDatabaseDao.insertStock(notes[0]);
            return null;
        }
    }

    //
    private static class UpdateNoteAsyncTask extends AsyncTask<StockTable, Void, Void> {

        private AppDatabaseDao appDatabaseDao;

        private UpdateNoteAsyncTask(AppDatabaseDao appDatabaseDao) {
            this.appDatabaseDao = appDatabaseDao;
        }

        @Override
        protected Void doInBackground(StockTable... notes) {
            appDatabaseDao.updateStock(notes[0]);
            return null;
        }
    }

    //

    private static class DeleteNoteAsyncTask extends AsyncTask<StockTable, Void, Void> {
        private AppDatabaseDao appDatabaseDao;

        private DeleteNoteAsyncTask(AppDatabaseDao appDatabaseDao) {
            this.appDatabaseDao = appDatabaseDao;
        }

        @Override
        protected Void doInBackground(StockTable... notes) {
            appDatabaseDao.deleteStock(notes[0]);
            return null;
        }
    }

    //
    private static class DeleteAllStocksAsyncTask extends AsyncTask<Void, Void, Void> {

        private AppDatabaseDao appDatabaseDao;

        private DeleteAllStocksAsyncTask(AppDatabaseDao appDatabaseDao) {
//            this.appDatabaseDao = appDatabaseDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
//            appDatabaseDao.deleteAllStocks();
            return null;
        }
    }
}
