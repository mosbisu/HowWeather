package com.kkr95.howweather;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static final String APP_ID= "8a8143490a4dde9e491be8d5d214f355";
    public static Location current_location= null;

    public static String convertUnixToDate(long dt) {
        Date date= new Date(dt*1000L);
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MM. dd EE");
        String formatted= simpleDateFormat.format(date);
        return formatted;
    }

    public static String convertUnixToHour(long dt) {
        Date date= new Date(dt*1000L);
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm");
        String formatted= simpleDateFormat.format(date);
        return formatted;
    }
}
