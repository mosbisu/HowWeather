package com.kkr95.howweather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public static Retrofit getRetrofitInstance(){
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("https://api.openweathermap.org/");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();

        return retrofit;
    }
}
