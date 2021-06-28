package com.veergati.veergati.ui.stocks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.veergati.veergati.R;
import com.veergati.veergati.data.StockTable;

import java.util.ArrayList;
import java.util.List;

interface StockClickedListener {
    void onStockClicked(StockTable StockDatum, View view,StockItemAction action);
}

enum StockItemAction {
    DELETE,
    SELECT
}

class ItemStockAdapter extends RecyclerView.Adapter<ItemStockAdapter.StockAdapterViewHolder> {
    List<StockTable> stockList =new ArrayList<>();
    Context mContext;
    StockClickedListener clickedListener;

    ItemStockAdapter(Context context, StockClickedListener listener) {
        this.mContext = context;
        this.clickedListener = listener;
    }

    @NonNull
    @Override
    public ItemStockAdapter.StockAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_stocks, parent, false);
        return new StockAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemStockAdapter.StockAdapterViewHolder holder, final int position) {
        holder.tv_itemname.setText(stockList.get(position).getItemname());
        holder.tv_qty.setText(stockList.get(position).getQuantity());
        holder.tv_price.setText(stockList.get(position).getPrice());
        holder.deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedListener.onStockClicked(stockList.get(position), v,StockItemAction.DELETE);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedListener.onStockClicked(stockList.get(position), v,StockItemAction.SELECT);
            }
        });
    }

    public void setData(List<StockTable> stockList){
        this.stockList = stockList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }

    static class StockAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tv_itemname,tv_qty,tv_price;
        ImageButton deleteItem;

        public StockAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_itemname = (TextView) itemView.findViewById(R.id.tv_itemname);
            tv_qty = (TextView) itemView.findViewById(R.id.tv_qty);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            deleteItem = (ImageButton) itemView.findViewById(R.id.delete_item);
        }
    }
}
