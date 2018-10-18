package com.example.windows.wilayahindonesia.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    /********
     * URLS
     *******/
    private static final String ROOT_URL = "https://x.rajaapi.com/MeP7c5neASQXotVupbf4KUpKdXRLwrZ13nYLc000JEoz3tegrfFvlrpiCo/m/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
