package com.kkr95.howweather;


import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    final String BASEURL= "https://api.openweathermap.org/";
    final String APIKEY= "8a8143490a4dde9e491be8d5d214f355";

    @GET("data/2.5/onecall?")
    Call<Result> getWeather(
            @Query("lat") int lat,
            @Query("lon") int lon,
            @Query("units") String units,
            @Query("appid") String appid);

}
