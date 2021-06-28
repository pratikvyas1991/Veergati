package com.veergati.veergati.networking;

import com.veergati.veergati.data.AddBillReq;
import com.veergati.veergati.data.AddBillResp;
import com.veergati.veergati.data.AddBillV2Response;
import com.veergati.veergati.data.AddStock;
import com.veergati.veergati.data.ApiRequest;
import com.veergati.veergati.data.ApiResponse;
import com.veergati.veergati.data.ApiV3Response;
import com.veergati.veergati.data.GetBillResponse;
import com.veergati.veergati.data.UpdateStocks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
//    String BASE_URL = "https://veergatiapi.000webhostapp.com";
    String BASE_URL = "https://veergatiapi.000webhostapp.com/v3/";

    @POST("reqObject")
    Call<ApiResponse> getStocks(@Body ApiRequest request);

    @GET("getStocks.php")
    Call<ApiV3Response> getStockData();
    @GET("getBills.php")
    Call<GetBillResponse> getBillsData();

    @POST("addBillTransaction.php")
    @FormUrlEncoded
    Call addBillsData(@Field("transactionid") String transactionid, @Field("date") String date,
                      @Field("time") String time, @Field("totalamount") String totalamount,
                      @Body List<AddStock> addStock);

    @POST("addBillTransactionV3.php?billinformation=")
    Call<AddBillResp> addBillsDataV3(@Body AddBillReq transactionid);

    @POST("testApi.php")
    @FormUrlEncoded
    Call<String> test(@Field("transactionid") String transactionid);

    @GET("updateStocks.php")
    Call<UpdateStocks> updateStock(@Query("itemid") String itemid, @Query("quantity") String quantity, @Query("price") String price);

    @GET("addBillTransactionV2.php")
    Call<AddBillV2Response> addBillsDataV2(@Query("transactionid") String transactionid, @Query("currdate") String currdate, @Query("time") String time, @Query("totalamount") String totalamount);
}
