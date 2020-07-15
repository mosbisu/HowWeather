package com.kkr95.howweather;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvCity, tvDate, tvTemp, tvTempHi, tvTempLow;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCity= findViewById(R.id.tv_city);
        tvDate= findViewById(R.id.tv_date);
        tvTemp= findViewById(R.id.tv_temp);
        tvTempHi= findViewById(R.id.tv_weather_hi);
        tvTempLow= findViewById(R.id.tv_weather_low);

        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fm.beginTransaction();
        fragmentTransaction.add(R.id.fragment, new DaegeonFragment());
        fragmentTransaction.commit();

        initLayout();

        getJsonString();

        String json= "Weather.json";
        try {
            JSONObject jsonObject= new JSONObject(json);

            String object= jsonObject.getString("object");
            JSONArray weatherArray= new JSONArray(object);

            for(int i=0; i<weatherArray.length(); i++){
                JSONObject weatherObject= weatherArray.getJSONObject(i);

                int temp_min= weatherObject.getInt("temp_min");
                int temp_max= weatherObject.getInt("temp_max");
                int temp= weatherObject.getInt("temp");
                String name= weatherObject.getString("name");

                tvCity.setText(name);
                tvTemp.setText(temp);
                tvTempHi.setText(temp_max);
                tvTempLow.setText(temp_min);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    void initLayout(){
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout= findViewById(R.id.drawer_layout);
        navigationView= findViewById(R.id.nav); 

        drawerToggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
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
    }

    public void clickDay(View view) {
    }

    String getJsonString(){
        String json= "Weather.json";

        try {
            InputStream is= getAssets().open("Weather.json");
            int fileSize= is.available();

            byte[] buffer= new byte[fileSize];
            is.read(buffer);
            is.close();

            json= new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }


}
