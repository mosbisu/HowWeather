package com.kkr95.howweather;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter {

    List<Current> currents= new ArrayList<>();
    Context context;

    SimpleDateFormat dateFormat= new SimpleDateFormat("MM월 dd일 EE요일");
}
