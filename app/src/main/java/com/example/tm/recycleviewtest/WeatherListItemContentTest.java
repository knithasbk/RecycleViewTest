package com.example.tm.recycleviewtest;

import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherListData;

import java.util.ArrayList;

/**
 * Created by TM on 03/10/2016.
 */

public class WeatherListItemContentTest {
    final static ArrayList<WeatherListData> data = new ArrayList<>();

    /**
     * public WeatherListItem createWetherListItemData(String textViewDayStatus, String textViewDay,
     * String textViewtemperature, int imageViewItem) {
     * mWeatherListItem.setImageViewItem(imageViewItem);
     * mWeatherListItem.setTextViewDay(textViewDay);
     * mWeatherListItem.setTextViewDayStatus(textViewDayStatus);
     * mWeatherListItem.setTextViewtemperature(textViewtemperature);
     * return mWeatherListItem;
     * }
     */
    public WeatherListItemContentTest(){

    }
    public ArrayList<WeatherListData> createWethearContentData() {
        WeatherListData weatherListItemData;
        int id =1;
        String mCityName = "0";
        Double mCityLon = 0.1;
        Double mCityLat = 1.0;
        String mDayofWeek = "Tuesday";
        String mDayofMonth = "10 Oct ";
        double mMaxTemperure = 1;
        double mMinTemperure = 2;
        double mDatePressur = 3;
        double mDateHumidity = 4;
        String mDateStatusMain = "Today is raining day ";
        String mDateStatusDescription = "f";
        double mDateWindSpeed = 1;
        int mImageItem = 1;
        int mDatePressure = 1;


        int i = 0;
        for (i = 0; i <= 16; i++) {
            switch (i % 5) {
                case 0:
                    mImageItem = R.drawable.art_clear;
                    break;
                case 1:
                    mImageItem = R.drawable.art_clouds;
                    break;

                case 2:
                    mImageItem = R.drawable.art_fog;
                    break;
                case 3:
                    mImageItem = R.drawable.art_light_rain;
                    break;
                case 4:
                    mImageItem = R.drawable.art_storm;
                    break;
                default:
                    mImageItem = R.drawable.art_snow;
                    break;
            }
            weatherListItemData = new WeatherListData(id, mDayofWeek,
                    mDayofMonth, mMaxTemperure, mMinTemperure, mDatePressure,
                    mDateHumidity, mDateStatusMain, mDateStatusDescription,
                    mDateWindSpeed, mImageItem) {};
                data.add(weatherListItemData);

        }
        return data;
    }
}