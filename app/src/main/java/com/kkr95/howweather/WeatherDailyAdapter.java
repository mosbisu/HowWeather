package com.kkr95.howweather;

import android.content.Context;
import android.util.Log;
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

public class WeatherDailyAdapter extends RecyclerView.Adapter<WeatherDailyAdapter.DailyViewHolder> {
    List<Daily> dailies= new ArrayList<>();
    List<Temp> temps= new ArrayList<>();
    Context context;

    public WeatherDailyAdapter(Context context, List<Temp> temps){
        this.temps = temps;
        this.context= context;
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view= inflater.inflate(R.layout.recyclerview_item_day, parent, false);
        DailyViewHolder dailyViewHolder = new DailyViewHolder(view);
        return dailyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder dailyViewHolder, int position) {

        if(temps.size()!=0){
            Temp temp= temps.get(position);
            for(int i=1; i<8; i++){
                Date today= new Date();
                Date week= new Date(today.getTime()+(long)(1000*60*60*24*i));
                dailyViewHolder.tvDay.setText(week+"");
            }
            dailyViewHolder.tvDay_temp.setText(temp.getDay());
            dailyViewHolder.tvDay.setText("za");
        }else{
            dailyViewHolder.tvDay.setText("aa");
            dailyViewHolder.tvDay_temp.setText("11");
        }

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder{

        TextView tvDay;
        TextView tvDay_temp;
        ImageView ivDay;

        public DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay= itemView.findViewById(R.id.tv_recycler_day);
            tvDay_temp= itemView.findViewById(R.id.tv_recycler_day_temp);
            ivDay= itemView.findViewById(R.id.iv_recycler_day);
        }
    }

}
