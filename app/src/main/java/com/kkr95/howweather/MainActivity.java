package com.kkr95.howweather;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvCity, tvDate, tvTemp, tvTempHi, tvTempLow;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    Retrofit retrofit;
    RetrofitService retrofitService;

    List<Daily> dailies= new ArrayList<>();
    WeatherDailyAdapter weatherDailyAdapter;
    WeatherAdapter weatherAdapter;
    List<Hourly> hourlies= new ArrayList<>();
    WeatherHourlyAdapter weatherHourlyAdapter;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCity= findViewById(R.id.tv_city);
        tvDate= findViewById(R.id.tv_date);
        tvTemp= findViewById(R.id.tv_temp);
        tvTempHi= findViewById(R.id.tv_weather_hi);
        tvTempLow= findViewById(R.id.tv_weather_low);

        locationManager= (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);


        retrofit= new Retrofit.Builder()
                .baseUrl(RetrofitService.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitService= retrofit.create(RetrofitService.class);
        retrofitService.getWeather(37, 126, "metric", RetrofitService.APIKEY).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    Log.d("retro", 1+"");
                    Result result = response.body();

                    List<Daily> dailies2= result.getDaily();
                    for(Daily daily : dailies2){
                        dailies.add(daily);
                    }
                }
                else{
                    Log.d("retro", 2+"Error");
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        Retrofit retrofit= new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(RetrofitService.BASEURL).build();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<JsonObject> call= retrofitService.getWeather2(37, 126, "metric", RetrofitService.APIKEY);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){
                    JsonObject object= response.body();
                    if(object != null){
                        tvTemp.setText(object.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

        initLayout();
        setDay();
    }

    void requestLocation(){
        
    }

    void setDay(){
        RecyclerView weather_recycler;
        weather_recycler= findViewById(R.id.weather_recycler);

        weatherDailyAdapter = new WeatherDailyAdapter(MainActivity.this, dailies);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        weather_recycler.setLayoutManager(linearLayoutManager);
        weather_recycler.setAdapter(weatherDailyAdapter);
        weatherDailyAdapter.notifyDataSetChanged();
    }

    void setTime(){
        RecyclerView weather_recycler;
        weather_recycler= findViewById(R.id.weather_recycler);

        weatherHourlyAdapter= new WeatherHourlyAdapter(MainActivity.this, hourlies);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        weather_recycler.setLayoutManager(linearLayoutManager);
        weather_recycler.setAdapter(weatherHourlyAdapter);
        weatherHourlyAdapter.notifyDataSetChanged();
    }

    void initLayout() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menu_search:
                Intent intent= new Intent(this, SelectRegionActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void clickTime(View view) {
        setTime();
    }

    public void clickDay(View view) {
        setDay();
    }

}
