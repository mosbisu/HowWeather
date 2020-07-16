package com.kkr95.howweather;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RetrofitService {

    static final String BASEURL= "https://api.openweathermap.org/";
    static final String APIKEY= "8a8143490a4dde9e491be8d5d214f355";

    @GET("data/2.5/onecall")
    Call<JsonObject> getItem(
            @Header("apiKey") String apiKey,
            @Query("lat") double lat,
            @Query("lon") double lon);

}
