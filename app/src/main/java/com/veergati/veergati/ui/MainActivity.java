package com.veergati.veergati.ui;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.veergati.veergati.R;
import com.veergati.veergati.data.BillData;
import com.veergati.veergati.data.TransactionDatum;
import com.veergati.veergati.ui.auth.LoginScreen;
import com.veergati.veergati.ui.bills.BillsFragment;
import com.veergati.veergati.utils.FragmentType;
import com.veergati.veergati.utils.SharedPreferenceUtils;

import androidx.annotation.NonNull;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public FloatingActionButton fab;
    public String mcurrentFragment = "";
    private static BluetoothSocket btsocket;
    private static OutputStream outputStream;
    private BillData mPrintingBillData;
    NavigationView navigationView;
    NavController navController;
    View mView;
    BillsFragment billsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);
        billsFragment =new BillsFragment();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mcurrentFragment.equals(FragmentType.BillFragment)){
                    if(mView!=null){
                        Intent intent = new Intent(MainActivity.this,BillStockFormScreen.class);
                        ActivityNavigator activityNavigator = new ActivityNavigator(MainActivity.this);
                        activityNavigator.navigate(activityNavigator.createDestination().setIntent(intent), null, null, null);
                    }
                }else {
                    Snackbar.make(view, "Bill Details", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_bills, R.id.nav_stocks)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(MainActivity.this,DatabaseManagerActivity.class);
                ActivityNavigator activityNavigator = new ActivityNavigator(MainActivity.this);
                activityNavigator.navigate(activityNavigator.createDestination().setIntent(intent), null, null, null);
                return true;
            case R.id.action_logout:
                SharedPreferenceUtils.getInstance().setAuth(null);
                Intent intLoout = new Intent(MainActivity.this, LoginScreen.class);
                intLoout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intLoout);
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void fromFragment(String fragmentType, TransactionDatum data, View view) {
        Log.v("@@@", " fromFragment() fragmentType " + fragmentType);
        if(view!=null){
            mView = view;
        }
//        TODO create mPrintingBillData same for TransactionDatum
//        if(mPrintingBillData ==null){
//            mPrintingBillData = data;
//        }else {
//            mPrintingBillData = null;
//            mPrintingBillData = data;
//        }
        mcurrentFragment = fragmentType;
        if (mcurrentFragment.equals(FragmentType.BillFragment)) {
            fab.setImageDrawable(getDrawable(R.drawable.ic_bills_menus));
            fab.setVisibility(View.VISIBLE);
        } else {
            fab.setImageDrawable(getDrawable(R.drawable.ic_stocks_menu));
            fab.setVisibility(View.GONE);
        }
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