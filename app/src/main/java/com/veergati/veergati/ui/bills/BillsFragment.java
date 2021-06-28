package com.veergati.veergati.ui.bills;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.veergati.veergati.R;
import com.veergati.veergati.data.BillData;
import com.veergati.veergati.data.GetBillResponse;
import com.veergati.veergati.data.TransactionTable;
import com.veergati.veergati.database.DatabaseManager;
import com.veergati.veergati.ui.MainActivity;
import com.veergati.veergati.utils.FragmentType;
import com.veergati.veergati.utils.TrasactionCallback;

import java.util.ArrayList;
import java.util.List;

public class BillsFragment extends Fragment implements BillClickedListener {

    private BillsViewModel billsViewModel;
    NavHostFragment finalHost;
    List<BillData> tempList;
    List<GetBillResponse> billList;
    View root;
    RecyclerView rvView;
    private DatabaseManager mDatabaseManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        billsViewModel =
                ViewModelProviders.of(this).get(BillsViewModel.class);
        root = inflater.inflate(R.layout.fragment_bills, container, false);
        rvView = root.findViewById(R.id.rv_bill_list);
        tempList = new ArrayList<>();
        billList = new ArrayList<>();
        ((MainActivity) getActivity()).fromFragment(FragmentType.BillFragment, null, root);
//        mDatabaseManager = DatabaseManager.getInstance(getActivity());
        return root;
    }

    public void fromActivity() {
        Log.v("@@@", " fromActivity() called !!! ");
        Navigation.findNavController(root).navigate(R.id.scrollingFragment);
    }

    @Override
    public void onBillClicked(TransactionTable billData, View view) {
        Log.v("@@@", "onBillClicked() called !!! " + billData.getTransactionid());
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("billdata", billData);
//        Navigation.findNavController(view).navigate(R.id.billsDetailsFragment, bundle);
    }


}

interface BillClickedListener {
    void onBillClicked(TransactionTable billData, View view);
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {
    List<TransactionTable> billDataList;
    Context mContext;
    BillClickedListener clickedListener;

    MyAdapter(List<TransactionTable> list, Context context, BillClickedListener listener) {
        billDataList = list;
        this.mContext = context;
        this.clickedListener = listener;
    }

    @NonNull
    @Override
    public MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_bills, parent, false);
        return new MyAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterViewHolder holder, final int position) {
        TransactionTable row = billDataList.get(position);

        holder.tv_bill_number.setText(String.valueOf(row.getTransactionid()));
        holder.tv_date.setText(row.getDate());
        holder.tv_time.setText(row.getTime());
        holder.tv_total.setText(row.getTotalamount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedListener.onBillClicked(billDataList.get(position), v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return billDataList.size();
    }

    class MyAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tv_bill_number, tv_date, tv_time, tv_total;

        public MyAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_bill_number = itemView.findViewById(R.id.tv_bill_number);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_total = itemView.findViewById(R.id.tv_total);
        }
    }
}