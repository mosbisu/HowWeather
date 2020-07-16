package com.kkr95.howweather;

import java.util.List;

public class dailyItem {
    double day;
    double min;
    double max;
    List<weatherItem> weather;

    public double getDay() {
        return day;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public List<weatherItem> getWeather() {
        return weather;
    }
}
