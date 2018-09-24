package com.doordash.discovery.doordashdiscovery.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantListClientInstance {
    private static Retrofit sRetrofit;
    private static final String RESTAURANT_LIST_BASE_URL = "https://api.doordash.com";

    public static Retrofit getRetrofitInstance() {
        if (null == sRetrofit) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(RESTAURANT_LIST_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
