package com.veergati.veergati.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.veergati.veergati.R;
import com.veergati.veergati.data.AddStock;
import com.veergati.veergati.data.StockTable;
import com.veergati.veergati.data.TransactionTable;
import com.veergati.veergati.database.DatabaseManager;
import com.veergati.veergati.utils.AddTrasactionCallback;
import com.veergati.veergati.utils.IncrementedTransactionIdCallback;
import com.veergati.veergati.utils.StocksCallback;

import java.util.ArrayList;
import java.util.List;

public class BillStockFormScreen extends AppCompatActivity implements StockEditedClicked{
    List<StockTable> stocksList;
    List<StockTable> stocksListTemp;
    LinearLayout.LayoutParams params;
    Button btn_print;
    Double totalAmount = 0.0;
    TextView total_amount;
    String transactionid,date,time;
    private DatabaseManager mDatabaseManager;
    private RecyclerView rv_stock_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
        btn_print = findViewById(R.id.btn_print);
        total_amount = findViewById(R.id.tv_total_amount);
        stocksList = new ArrayList<>();
        transactionid = "5";
        date = "8-10-2020";
        time = "10:52";

        params = new LinearLayout.LayoutParams(0, ActionBar.LayoutParams.WRAP_CONTENT,0.33f);
        params.setMargins(10,10,10,10);
//        mDatabaseManager = new  DatabaseManager.getInstance(getApplicationContext());
        rv_stock_items = findViewById(R.id.rv_stock_items);
        rv_stock_items.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        total_amount.setText(String.valueOf(totalAmount));
        btn_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }


    @Override
    public void onStockChanged(StockTable stockTable,int position,int selectedQty) {
        if(stockTable!=null){
            StockTable updatedVal = stocksListTemp.get(position);
            Log.v("@@@","Selected Qty updatedVal (QTY)"+selectedQty);
            Log.v("@@@","stocksListTemp updatedVal (QTY)"+updatedVal.getQuantity());
            Log.v("@@@","stockTable updatedVal (QTY)"+stockTable.getQuantity());
            totalAmount = totalAmount+(Integer.parseInt(stockTable.getQuantity())*Double.parseDouble(stockTable.getPrice()));
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    total_amount.setText(String.valueOf(totalAmount));
                }
            });
        }
    }

    @Override
    public void onStockChangedReduced(StockTable stockTable) {
        if(stockTable!=null){
            totalAmount = totalAmount+(Integer.parseInt(stockTable.getQuantity())*Double.parseDouble(stockTable.getPrice()));
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    total_amount.setText(String.valueOf(totalAmount));
                }
            });
        }
    }
}

interface StockEditedClicked{
    void onStockChanged(StockTable stockTable,int position,int selectedQty);
    void onStockChangedReduced(StockTable stockTable);
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {
    List<StockTable> billDataList;
    Context mContext;
    StockEditedClicked stockEditedClicked;

    MyAdapter(List<StockTable> list, Context context,StockEditedClicked stockEditedClicked) {
        billDataList = list;
        this.mContext = context;
        this.stockEditedClicked = stockEditedClicked;
    }

    @NonNull
    @Override
    public MyAdapter.MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_bill_form, parent, false);
        return new MyAdapter.MyAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyAdapterViewHolder holder, final int position) {
        StockTable row = billDataList.get(position);
        Log.v("@@@","(Adapter) : Item Name "+row.getItemname()+" Qty "+row.getQuantity());
        holder.tv_item.setText(String.valueOf(row.getItemname()));
        holder.tv_price.setText(String.valueOf(row.getPrice()));
        holder.et_qty.setText("0");

        holder.et_qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!(s.toString().equalsIgnoreCase("")||s.toString().equalsIgnoreCase(" "))){
                    int editedQty = Integer.parseInt(s.toString());
                    if(editedQty>(Integer.parseInt(row.getQuantity()))){
                        Toast.makeText(mContext,"Invalid stock entry",Toast.LENGTH_LONG).show();
                        holder.et_qty.setText("0");
                    }else {
//                        row.setQuantity(s.toString());
                        stockEditedClicked.onStockChanged(row,position,Integer.parseInt(s.toString()));
                    }
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return billDataList.size();
    }

    class MyAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tv_item, tv_price;
        EditText et_qty;

        public MyAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_item = itemView.findViewById(R.id.tv_item);
            tv_price = itemView.findViewById(R.id.tv_price);
            et_qty = itemView.findViewById(R.id.et_qty);
        }
    }
}
