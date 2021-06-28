package com.veergati.veergati.ui.bills;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.veergati.veergati.data.TransactionTable;
import com.veergati.veergati.database.DatabaseManager;
import com.veergati.veergati.utils.TrasactionCallback;

import java.util.List;

public class BillsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<TransactionTable>> trasactions;
    private DatabaseManager mDatabaseManager;

    public void initBillsVM(Context context){
//        mDatabaseManager = DatabaseManager.getInstance(context);
    }

    public BillsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

//    public LiveData<List<TransactionTable>> getTrasactions() {
//        mDatabaseManager.retrieveTransaction(new TrasactionCallback() {
//            @Override
//            public void onError(Error error) {
//                Log.v("@@@","onError ");
//            }
//
//            @Override
//            public void onSucess(List<TransactionTable> data) {
//                Log.v("@@@","onSucess ");
//                trasactions = (MutableLiveData<List<TransactionTable>>) data;
//            }
//        });
//        return trasactions;
//    }

}