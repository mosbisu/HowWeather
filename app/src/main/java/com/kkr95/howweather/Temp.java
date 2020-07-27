package com.kkr95.howweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temp {
    @SerializedName("day")
    @Expose
    int day;
    @SerializedName("min")
    @Expose
    double min;
    @SerializedName("max")
    @Expose
    double max;
    @SerializedName("night")
    @Expose
    double night;
    @SerializedName("eve")
    @Expose
    double eve;
    @SerializedName("morn")
    @Expose
    double morn;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }
}
