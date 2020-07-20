package com.kkr95.howweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    List<Daily> dailies = new ArrayList<>();
    Context context;

    public WeatherAdapter(List<Daily> dailies, Context context){
        this.dailies = dailies;
        this.context= context;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_day, parent, false);
        WeatherViewHolder weatherViewHolder= new WeatherViewHolder(view);
        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int position) {
        Daily daily = dailies.get(position);
        weatherViewHolder.tvDay.setText(weatherViewHolder.get);
    }

    @Override
    public int getItemCount() {
        return currents.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder{

        TextView tvDay;
        TextView tvDay_temp;
        ImageView ivDay;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay= itemView.findViewById(R.id.tv_recycler_time);
            tvDay_temp= itemView.findViewById(R.id.tv_recycler_temp);
            ivDay= itemView.findViewById(R.id.iv_recycler_time);
        }
    }

}
