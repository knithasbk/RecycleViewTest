package com.example.tm.recycleviewtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tm.recycleviewtest.R;
import com.example.tm.recycleviewtest.model.WeatherListItem;

import java.util.ArrayList;

/*Get data from data - WeatherData and flate to view  */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyRecycleViewHolder> {

    ArrayList<WeatherListItem> weatherListItemList;


    public MyAdapter(ArrayList<WeatherListItem> weatherListItemList) {
        this.weatherListItemList = weatherListItemList;
    }




    // call view item
    public class MyRecycleViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDay;
        TextView textViewTemperature;
        TextView textViewDayStatus;
        ImageView imageViewItem;

        //Constructor, without void or type of variables
        public MyRecycleViewHolder(View view) {
            super(view);
            textViewDay = (TextView) view.findViewById(R.id.text_view_day_item);
            textViewDayStatus = (TextView) view.findViewById(R.id.text_view_day_status_item);
            textViewTemperature = (TextView) view.findViewById(R.id.text_view_temperature_item);
            imageViewItem = (ImageView) view.findViewById(R.id.image_view_item);
        }
    }

    //Constructor for declare the class, initial class
    // call onCreateViewHolder return a instance of ViewHolder for  onBindViewHolder
    @Override
    public MyRecycleViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main_recycle_item_today_view, viewGroup, false);
        MyRecycleViewHolder holder = new MyRecycleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecycleViewHolder holder, int position) {
        WeatherListItem weatherListItem = weatherListItemList.get(position);
        holder.textViewDayStatus.setText(weatherListItem.getTextViewDayStatus());
        holder.textViewDay.setText(weatherListItem.getTextViewDay());
        holder.textViewTemperature.setText(weatherListItem.getTextViewtemperature());
        holder.imageViewItem.setImageResource(weatherListItem.getImageViewItem());
    }

    @Override
    public int getItemCount() {
        return weatherListItemList.size();
    }

}




