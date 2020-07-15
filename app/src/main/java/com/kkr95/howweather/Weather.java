package com.kkr95.howweather;

public class Weather {
    int temp_min;
    int temp_max;
    int temp;
    String name;

    public int getTempMin(){
        return temp_min;
    }

    public int getTempMax(){
        return temp_max;
    }

    public int getTemp(){
        return temp;
    }

    public String getName(){
        return name;
    }

    public void setTempMin(int tempMin){
        this.temp_min= tempMin;
    }

    public void setTempMax(int tempMax){
        this.temp_max= tempMax;
    }

    public void setTemp(int temp){
        this.temp= temp;
    }

    public void setName(String name){
        this.name= name;
    }
}
