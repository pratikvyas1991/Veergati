package com.veergati.veergati.thermalprinting;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.util.Base64;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.veergati.veergati.R;
import com.veergati.veergati.data.Ticket;
import com.veergati.veergati.data.TicketItem;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class PrintingUtility {
    Context mContext;

    PrintingUtility(Context context){
        this.mContext = context;
    }

    public void print_ticket(Ticket ticket) {
        double totalAmount = 0.0;
        try {
            // assign output into memory
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            EscPos escpos = new EscPos(buf);

            // ------------------ DO ----------------

            Style title = new Style()
                    .setFontSize(Style.FontSize._2, Style.FontSize._2)
                    .setJustification(EscPosConst.Justification.Center);

            Style subtitle = new Style(escpos.getStyle())
                    .setBold(true)
                    .setUnderline(Style.Underline.OneDotThick);
            Style total = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._2).setBold(true);

            escpos.writeLF(title, ticket.getCompanyTitle())
                    .feed(2)
                    .write("Bill Number: ")
                    .writeLF(subtitle, ticket.getBillNumber())
                    .feed(1)
                    .write("Date: ")
                    .writeLF(subtitle, ticket.getSystemDate())
                    .feed(2);

            for (int i=0;i<ticket.getItemList().size();i++){
                TicketItem item = ticket.getItemList().get(i);
                totalAmount = totalAmount+(Double.parseDouble(item.getItemQty())*Double.parseDouble(item.getItemPrice()));
                escpos
                        .feed(2)
                        .writeLF(item.getItemName()+"     "+item.getItemQty()+" Rs "+item.getItemPrice());

            }

            escpos.writeLF("--------------------------------")
                    .writeLF(total,
                            "TOTAL    "+totalAmount)
                    .writeLF("--------------------------------");

            escpos
                    .feed(2)
                    .write("Contact Number: ")
                    .writeLF(subtitle, "7405235056")
                    .feed(1)
                    .writeLF("--------------------------------")
                    .feed(5)
                    .cut(EscPos.CutMode.FULL);

            // ------------------ /DO ----------------

            escpos.close();
            // take output and encode to base64
            String base64ToPrint = Base64.encodeToString(buf.toByteArray(), Base64.DEFAULT);

            // call intent with rawbt:base64,
            String url = "rawbt:base64," + base64ToPrint;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            sendToPrint(intent);

            // it's all
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Checks and if the application is not installed, then offers to download it from the Play Market
     */
    protected void sendToPrint(Intent intent) {
        final String appPackageName = "ru.a402d.rawbtprinter";
        PackageManager pm = mContext.getPackageManager();
        // check app installed
        PackageInfo pi = null;
        if (pm != null) {
            try {
                pi = pm.getPackageInfo(appPackageName, 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (pi == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            TextView title = new TextView(mContext);
            title.setText(R.string.dialog_title);
            title.setBackgroundColor(Color.DKGRAY);
            title.setPadding(10, 10, 10, 10);
            title.setGravity(Gravity.CENTER);
            title.setTextColor(Color.WHITE);
            title.setTextSize(14);
            ImageView image = new ImageView(mContext);
            image.setImageResource(R.drawable.ic_add_bills_background);
            builder.setMessage(R.string.dialog_message)
                    .setView(image).setCustomTitle(title);
            builder.setPositiveButton(R.string.btn_install, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    try {
                        mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            // send to print
            intent.setPackage(appPackageName);
            mContext.startActivity(intent);

        }
    }

    private String[] getDateTime() {
        final Calendar c = Calendar.getInstance();
        String dateTime [] = new String[2];
        dateTime[0] = c.get(Calendar.DAY_OF_MONTH) +"/"+ c.get(Calendar.MONTH) +"/"+ c.get(Calendar.YEAR);
        dateTime[1] = c.get(Calendar.HOUR_OF_DAY) +":"+ c.get(Calendar.MINUTE);
        return dateTime;
    }

}
