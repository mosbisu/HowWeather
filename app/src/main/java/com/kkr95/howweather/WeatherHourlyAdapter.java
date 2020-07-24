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

public class WeatherHourlyAdapter extends RecyclerView.Adapter<WeatherHourlyAdapter.HourlyViewHolder> {
    List<Hourly> hourlies= new ArrayList<>();
    Context context;

    public WeatherHourlyAdapter(Context context, List<Hourly> hourlies){
        this.context= context;
        this.hourlies= hourlies;
    }

    @NonNull
    @Override
    public HourlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view= inflater.inflate(R.layout.recyclerview_item_time, parent, false);
        HourlyViewHolder hourlyViewHolder= new HourlyViewHolder(view);
        return hourlyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyViewHolder hourlyViewholder, int position) {
        if(hourlies.size()!=0){
            Hourly hourly= hourlies.get(position);
            hourlyViewholder.tvTime.setText("");
            hourlyViewholder.tvTime_temp.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class HourlyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTime;
        TextView tvTime_temp;
        ImageView ivTime;

        public HourlyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTime= itemView.findViewById(R.id.tv_recycler_time);
            tvTime_temp= itemView.findViewById(R.id.tv_recycler_time_temp);
            ivTime= itemView.findViewById(R.id.iv_recycler_time);
        }
    }
}
