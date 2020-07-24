package com.kkr95.howweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class SelectRegionActivity extends AppCompatActivity {

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
    }

    public void clickDaegeon(View view){
    }

    public void clickDaegu(View view){
    }

    public void clickIncheon(View view){
    }

    public void clickGwangju(View view){
    }

    public void clickUlsan(View view){
    }

    public void clickBusan(View view){
    }

    public void clickJeju(View view){
    }
}
