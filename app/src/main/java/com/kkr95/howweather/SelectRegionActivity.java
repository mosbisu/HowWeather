package com.kkr95.howweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class SelectRegionActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);



        Toolbar toolbar = (Toolbar) findViewById(R.id.select_region_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickSeoul(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickDaegeon(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickDaegu(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickIncheon(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickGwangju(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickUlsan(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickBusan(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickJeju(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
