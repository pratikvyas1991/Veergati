package com.veergati.veergati.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.veergati.veergati.R;
import com.veergati.veergati.data.StockTable;
import com.veergati.veergati.database.DatabaseManager;
import com.veergati.veergati.utils.StocksCallback;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManagerActivity extends AppCompatActivity {
    private DatabaseManager mDatabaseManager;
    private Button btn_load_trasaction,btn_insert_trasaction,btn_load_stock,btn_insert_stock,btn_upload_server;
    private boolean isUploaded = false;
    private List<Integer> itemsTobeUploaded =new ArrayList<>();
    List<Integer> itemListFromWeb =new ArrayList<>();
    List<Integer> itemListFromDb =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_manager);
        btn_insert_trasaction = findViewById(R.id.btn_insert_trasaction);
        btn_load_trasaction = findViewById(R.id.btn_load_trasaction);
        btn_load_stock = findViewById(R.id.btn_load_stock);
        btn_insert_stock = findViewById(R.id.btn_insert_stock);
        btn_upload_server = findViewById(R.id.btn_upload_server);

//        mDatabaseManager = DatabaseManager.getInstance(getApplicationContext());

        btn_insert_trasaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btn_load_trasaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btn_insert_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btn_load_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mDatabaseManager.retrieveStock(new StocksCallback() {
//                    @Override
//                    public void onError(Error error) {
//                        Log.v("@@@"," error : "+error.toString());
//                    }
//
//                    @Override
//                    public void onSucess(List<StockTable> stocks) {
//                        Log.v("@@@"," onSucess : "+stocks.size());
//                    }
//                });
            }
        });

        btn_upload_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}