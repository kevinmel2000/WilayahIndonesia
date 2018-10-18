package com.example.windows.wilayahindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.windows.wilayahindonesia.API.ApiService;
import com.example.windows.wilayahindonesia.API.JSONResponse;
import com.example.windows.wilayahindonesia.Adapter.DataAdapter;
import com.example.windows.wilayahindonesia.Model.ModelProvinsi;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    /*private String URL = "https://x.rajaapi.com/MeP7c5neASQXotVupbf4KUpKdXRLwrZ13nYLc000JEoz3tegrfFvlrpiCo/m/wilayah/provinsi";
    String ID_WILAYAH;

    ApiService service;
    private RecyclerView recyclerView;
    private ListArrayAdapter listArrayAdapter;*/

    private ArrayList<ModelProvinsi> data;
    private RecyclerView recyclerView;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        service = ApiClient.getClient().create(ApiService.class);*/
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        initSetup();
    }

    public void initSetup() {

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ApiService.BASE_URL)
                .baseUrl("https://x.rajaapi.com/MeP7c5neASQXotVupbf4KUpKdXRLwrZ13nYLc000JEoz3tegrfFvlrpiCo/m/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        final Call<JSONResponse> call = apiService.getDataProvinsi();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                call.enqueue(new Callback<JSONResponse>() {

                    @Override
                    public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                        JSONResponse jsonResponse = response.body();
                        data = new ArrayList<>(Arrays.asList(jsonResponse.getDataProvinsi()));
//                Log.d("TAG", "onResponse: " + jsonResponse.getDataProvinsi());
                        adapter = new DataAdapter(data);
                        adapter.setModelProvinsiArrayList(data);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<JSONResponse> call, Throwable t) {
                        Log.d("Error",t.getMessage());
                    }


                });
            }
        });


    }

}
