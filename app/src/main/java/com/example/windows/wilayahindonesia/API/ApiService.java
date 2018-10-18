package com.example.windows.wilayahindonesia.API;

import com.example.windows.wilayahindonesia.Model.ModelProvinsi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("wilayah/provinsi")
    Call<JSONResponse> getDataProvinsi();

   /* @GET("single_data")
    Call<List<DataItem>> getSingleData(@Query("id_wilayah") String id);*/
}
