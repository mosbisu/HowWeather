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

public class TimeWeatherAdapter extends RecyclerView.Adapter<TimeWeatherAdapter.ViewHolder> {

    ArrayList<String> tData= null;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTimeTime, tvTimeTemp;
        ImageView ivTime;

        ViewHolder(View itemView){
            super(itemView);

            tvTimeTime= itemView.findViewById(R.id.tv_time_time);
            tvTimeTemp= itemView.findViewById(R.id.tv_time_temp);
            ivTime= itemView.findViewById(R.id.iv_time);
        }
    }

    TimeWeatherAdapter(ArrayList<String> list){
        tData= list;
    }

    @NonNull
    @Override
    public TimeWeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view= inflater.inflate(R.layout.recyclerview_item_time, parent, false);
        TimeWeatherAdapter.ViewHolder vh= new TimeWeatherAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TimeWeatherAdapter.ViewHolder holder, int position) {
        String text= tData.get(position);
        holder.tvTimeTime.setText(text);
        holder.tvTimeTemp.setText(Integer.parseInt(text));
        holder.ivTime.setImageResource(Integer.parseInt(text));
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
