package com.example.tm.recycleviewtest.AdapterRecycleViewMainActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tm.recycleviewtest.R;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherListData;

import java.util.ArrayList;

/*Get data from data - WeatherData and flate to view  */
public class WeatherAdapterRecycleView extends RecyclerView.Adapter<WeatherAdapterRecycleView.MyRecycleViewHolder> {

    private ArrayList<WeatherListData> weatherListItemList = null;
    private static RecyclerViewClickListener itemListener;


    public WeatherAdapterRecycleView(ArrayList<WeatherListData> weatherListItemList, RecyclerViewClickListener itemListener) {
        this.weatherListItemList = weatherListItemList;
        this.itemListener = itemListener;
    }


    // call view item
    public static class MyRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextViewItemTimeDayofWeek;
        TextView mTextViewItemTemperature;
        TextView mTextViewItemDayStatus;
        TextView mTextViewItemDayOfMonth;
        ImageView mImageViewItem;


        //Constructor, without void or type of variables
        public MyRecycleViewHolder(View view) {
            super(view);
            mTextViewItemTimeDayofWeek = (TextView) view.findViewById(R.id.text_view_day_of_week_item);
            mTextViewItemDayStatus = (TextView) view.findViewById(R.id.text_view_day_status_item);
            mTextViewItemTemperature = (TextView) view.findViewById(R.id.text_view_max_temperature_item);
            mTextViewItemDayOfMonth = (TextView) view.findViewById(R.id.text_view_day_of_month_item);
            mImageViewItem = (ImageView) view.findViewById(R.id.image_view_item);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemListener.recyclerViewListClicked(view, this.getLayoutPosition());

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
        WeatherListData weatherListItem = weatherListItemList.get(position);
        holder.mTextViewItemDayStatus.setText(weatherListItem.getmDateStatusMain());
        holder.mTextViewItemTimeDayofWeek.setText(weatherListItem.getmDayofWeek());
        holder.mTextViewItemTemperature.setText(String.valueOf(weatherListItem.getmMaxTemperure()));
        holder.mTextViewItemDayOfMonth.setText(weatherListItem.getmDayofMonth());
        holder.mImageViewItem.setImageResource(weatherListItem.getmImageItem());
    }

    @Override
    public int getItemCount() {
        return weatherListItemList.size();
    }
}




