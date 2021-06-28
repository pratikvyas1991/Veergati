package com.veergati.veergati.thermalprinting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.veergati.veergati.R;
import com.veergati.veergati.data.Ticket;
import com.veergati.veergati.data.TicketItem;

import java.util.ArrayList;
import java.util.List;

public class PrintingUtilsScreen extends Activity {
    private String TAG = "@@@#PrintingUtils";
    EditText message;
    Button btnPrint, btnBill;
    PrintingUtility utility;
    Ticket ticket;
    List<TicketItem> ticketItems;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printing_utils);
        message = (EditText)findViewById(R.id.txtMessage);
        btnPrint = (Button)findViewById(R.id.btnPrint);
        btnBill = (Button)findViewById(R.id.btnBill);
        utility = new PrintingUtility(PrintingUtilsScreen.this);
        ticketItems = new ArrayList<>();
        ticketItems.add(new TicketItem("1","Baans","4","100","Pieces"));
        ticketItems.add(new TicketItem("2","Kafan","1","200","Pieces"));

        ticket = new Ticket("GauravTrading",
                "23049809",
                "12-2-2098","",ticketItems);

        btnPrint.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                utility.print_ticket(ticket);
            }
        });
        btnBill.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}