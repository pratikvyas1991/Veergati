package com.veergati.veergati.ui.stocks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;
import com.veergati.veergati.R;
import com.veergati.veergati.data.StockTable;

public class AddStocksFragment extends Fragment {

    private StocksViewModel stocksViewModel;
    TextInputEditText tvItemName,tvItemQuantity,tvItemPrice,tvItemUnit;
    Button btnSaveStock;
    StockTable newStock;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        stocksViewModel =
                ViewModelProviders.of(this).get(StocksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add_stocks, container, false);

        btnSaveStock = root.findViewById(R.id.btn_save_Stock);
        tvItemName = root.findViewById(R.id.item_name);
        tvItemQuantity = root.findViewById(R.id.item_quantity);
        tvItemPrice = root.findViewById(R.id.item_price);
        tvItemUnit = root.findViewById(R.id.item_unit);


        btnSaveStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndAddStock(v);
            }
        });

        return root;
    }

    void validateAndAddStock(View v){
        newStock = new StockTable();
        String name = tvItemName.getText().toString();
        String quantity = tvItemQuantity.getText().toString();
        String price = tvItemPrice.getText().toString();
        String unit = tvItemUnit.getText().toString();

        newStock.setItemname(name);
        newStock.setQuantity(quantity);
        newStock.setPrice(price);
        newStock.setUnit(unit);

        stocksViewModel.addStock(newStock);

        Navigation.findNavController(v).navigate(R.id.action_add_stocks_stockList);

    }


}

