package com.kkr95.howweather;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
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

public class MainActivity extends AppCompatActivity implements LocationListener{

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

    double latitude;
    double longitude;
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

        initLayout();
        setDay();
        requestLocation();
    }
    void getWeather(double latitude, double longitude){
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
                        tvCity.setText(object.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    void requestLocation(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 1, (LocationListener) this);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 1, (LocationListener) this);
        }
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

    @Override
    public void onLocationChanged(Location location) {
        latitude= location.getLatitude();
        longitude= location.getLongitude();

        getWeather(latitude, longitude);
        locationManager.removeUpdates(MainActivity.this);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
