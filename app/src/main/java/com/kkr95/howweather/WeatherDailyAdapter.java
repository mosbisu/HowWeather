package com.kkr95.howweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeatherDailyAdapter extends RecyclerView.Adapter<WeatherDailyAdapter.WeatherViewHolder> {
    List<Daily> dailies = new ArrayList<>();
    Context context;

    Date currentTime= Calendar.getInstance().getTime();
    SimpleDateFormat dateFormat= new SimpleDateFormat("EE");
    String day= dateFormat.format(currentTime);

    public WeatherDailyAdapter(List<Daily> dailies, Context context){
        this.dailies = dailies;
        this.context= context;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view= inflater.inflate(R.layout.recyclerview_item_day, parent, false);
        WeatherViewHolder weatherViewHolder= new WeatherViewHolder(view);
        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int position) {
        Daily daily = dailies.get(position);
        weatherViewHolder.tvDay.setText(day+"");
        weatherViewHolder.tvDay_temp.setText(daily.getTemp().getDay());
    }

    @Override
    public int getItemCount() {
        return 7;
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
