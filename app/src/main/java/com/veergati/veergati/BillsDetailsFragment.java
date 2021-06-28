package com.veergati.veergati;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.veergati.veergati.data.BillData;
import com.veergati.veergati.data.StockDatum;
import com.veergati.veergati.data.Stocks;
import com.veergati.veergati.data.StocksDatum;
import com.veergati.veergati.data.TransactionDatum;
import com.veergati.veergati.ui.MainActivity;
import com.veergati.veergati.utils.FragmentType;

public class BillsDetailsFragment extends Fragment {
    TextView tv_date,tv_time,bill_number,total_amount;
    LinearLayout lnr_items;
    Button btn_print;
    TransactionDatum data;
    public static BillsDetailsFragment newInstance() {
        return new BillsDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        data = getArguments().getParcelable("billdata");
        Log.v("@@@", "Bills Dateils" + data);

        View root = inflater.inflate(R.layout.bills_details_fragment, container, false);

        lnr_items = root.findViewById(R.id.lnr_items);
        btn_print = root.findViewById(R.id.btn_print);

        bill_number = root.findViewById(R.id.bill_number);
        tv_date = root.findViewById(R.id.tv_date);
        tv_time = root.findViewById(R.id.tv_time);
        total_amount = root.findViewById(R.id.total_amount);

        bill_number.setText(data.getTransactionid());
        tv_date.setText(data.getDate());
        tv_time.setText(data.getTime());
        total_amount.setText(data.getTotalamount());

        for (int i = 0; i < data.getStocksData().size(); i++) {
            StocksDatum item = data.getStocksData().get(i);

            LinearLayout a = new LinearLayout(getActivity());
            a.setOrientation(LinearLayout.HORIZONTAL);


            TextView itemName = new TextView(getActivity());
            TextView itemQty = new TextView(getActivity());
            TextView itemPrice = new TextView(getActivity());

            itemName.setPadding(5,5,5,5);
            itemQty.setPadding(5,5,5,5);
            itemPrice.setPadding(5,5,5,5);

            itemName.setText(item.getItemname());
            itemQty.setText(item.getQuantity());
            itemPrice.setText(item.getPrice());

            a.addView(itemName);
            a.addView(itemQty);
            a.addView(itemPrice);

            lnr_items.addView(a);
        }

        ((MainActivity)getActivity()).fromFragment(FragmentType.BillDetailsFragment,data,root);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}