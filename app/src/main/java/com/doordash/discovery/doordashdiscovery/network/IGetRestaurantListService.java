package com.doordash.discovery.doordashdiscovery.network;

import com.doordash.discovery.doordashdiscovery.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IGetRestaurantListService {
    int DEFAULT_OFFSET = 0;
    int DEFAULT_LIMIT = 50;

    @GET("/v2/restaurant/?")
    Call<List<Restaurant>> getRestaurantList(@Query("lat") double lat, @Query("lng") double lng, @Query("offset") int offset, @Query("limit") int limit);
}
