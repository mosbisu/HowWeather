package com.kkr95.howweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrofitRepo {
    @SerializedName("current")
    @Expose
    List<Current> current= null;
    @SerializedName("daily")
    @Expose
    List<Daily> daily= null;
    @SerializedName("hourly")
    @Expose
    List<Houlry> hourly= null;

    public List<Current> getCurrent() {
        return current;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public List<Houlry> getHourly() {
        return hourly;
    }

    public void setCurrent(List<Current> current) {
        this.current = current;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    public void setHourly(List<Houlry> hourly) {
        this.hourly = hourly;
    }
}
