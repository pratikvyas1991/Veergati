package com.veergati.veergati.ui.stocks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.veergati.veergati.R;
import com.veergati.veergati.data.StockTable;

import java.util.List;

public class StocksFragment extends Fragment {

    private StocksViewModel stocksViewModel;
    RecyclerView rvView;
    Button btnAddStock;
    StockTable newStock;
    ItemStockAdapter itemStockAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        stocksViewModel =
                ViewModelProviders.of(this).get(StocksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stocks, container, false);

        btnAddStock = root.findViewById(R.id.btn_add_Stock);
        rvView = root.findViewById(R.id.rv_stock_list);

        itemStockAdapter = new ItemStockAdapter(getActivity(), new StockClickedListener() {
            @Override
            public void onStockClicked(StockTable StockDatum, View view,StockItemAction action) {
                switch (action){
                    case DELETE:
                        stocksViewModel.delete(StockDatum);
                        break;
                    case SELECT:
                        break;
                }
            }
        });
        rvView.setAdapter(itemStockAdapter);

        stocksViewModel.getAllNotes().observe(getActivity(), new Observer<List<StockTable>>() {
            @Override
            public void onChanged(List<StockTable> stockTables) {
                itemStockAdapter.setData(stockTables);
            }
        });

        newStock = new StockTable();
        newStock.setItemid(3);
        newStock.setItemname("Matki");
        newStock.setOrganization("GT");
        newStock.setPrice("100");
        newStock.setQuantity("110");
        newStock.setUnit("pieces");

        btnAddStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_stocks_list_to_add_stocks);
            }
        });

        return root;
    }


}

