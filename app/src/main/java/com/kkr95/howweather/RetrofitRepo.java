package com.kkr95.howweather;

import java.util.List;

public class RetrofitRepo {
    List<currentItem> current;
    List<dailyItem> daily;
    List<hourlyItem> hourly;

    public List<currentItem> getCurrent() {
        return current;
    }

    public List<dailyItem> getDaily() {
        return daily;
    }

    public List<hourlyItem> getHourly() {
        return hourly;
    }
}
