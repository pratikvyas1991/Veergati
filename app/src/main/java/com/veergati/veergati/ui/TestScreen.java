package com.veergati.veergati.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.veergati.veergati.R;
import com.veergati.veergati.data.ApiRequest;
import com.veergati.veergati.data.ApiResponse;
import com.veergati.veergati.data.ApiV3Response;
import com.veergati.veergati.networking.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestScreen extends AppCompatActivity {
    Button btn_fetch_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        btn_fetch_data = (Button) findViewById(R.id.btn_fetch_data);
        btn_fetch_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestScreen.this, "Hello !!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    void getStocks() {
        Log.v("@@@", " getStocks()");
        ApiRequest apiRequest = new ApiRequest();

        apiRequest.setTask("getStock");

        JSONObject obj =new JSONObject();
        JSONObject taskData =new JSONObject();
        try {
            obj.put("task","getStock");
            obj.put("taskData",taskData);
        } catch (JSONException e) {
            Log.v("@@@","Exception "+e.getMessage());
        }

        Log.v("@@@"," obje "+obj);

        Call<ApiResponse> call = RetrofitClient.getInstance().getMyApi().getStocks(apiRequest);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.v("@@@", " onResponse " + response.toString());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.v("@@@", " onFailure " + call.toString());
            }
        });
    }
}
