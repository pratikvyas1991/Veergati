package com.veergati.veergati;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.veergati.veergati.data.Stocks;

import java.util.ArrayList;
import java.util.List;

class ScrollingFragment extends Fragment {
    LinearLayout lnr_form_layout;
    List<Stocks> stocksList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scrolling, container, false);

        stocksList = new ArrayList<>();
        Stocks stocks1 = new Stocks("1", "Baans", "single", "34", "150", "gt");
        Stocks stocks2 = new Stocks("2", "Chipta", "single", "34", "350", "gt");
        lnr_form_layout = root.findViewById(R.id.lnr_form_layout);


        return root;
    }

    public void refreshForm(List<Stocks> stocksList) {
        if (stocksList != null) {

        }
    }
}