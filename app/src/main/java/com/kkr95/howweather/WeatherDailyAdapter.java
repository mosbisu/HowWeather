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
    Context context;

    Date currentTime= Calendar.getInstance().getTime();
    SimpleDateFormat dateFormat= new SimpleDateFormat("EE");
    String day= dateFormat.format(currentTime);

    public WeatherDailyAdapter(Context context, List<Daily> dailies){
        this.dailies = dailies;
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


        if(dailies.size()!=0){
            Daily daily = dailies.get(position);
            dailyViewHolder.tvDay.setText(day+"");
            dailyViewHolder.tvDay_temp.setText("");
        }
        else dailyViewHolder.tvDay.setText(day);
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
