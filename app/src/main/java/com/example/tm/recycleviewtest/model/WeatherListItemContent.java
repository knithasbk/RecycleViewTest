package com.example.tm.recycleviewtest.model;

import com.example.tm.recycleviewtest.R;

import java.util.ArrayList;

/**
 * Created by TM on 03/10/2016.
 */

public class WeatherListItemContent {
    final static ArrayList<WeatherListItem> data = new ArrayList<>();
  /**   public WeatherListItem createWetherListItemData(String textViewDayStatus, String textViewDay,
                                                    String textViewtemperature, int imageViewItem) {
        mWeatherListItem.setImageViewItem(imageViewItem);
        mWeatherListItem.setTextViewDay(textViewDay);
        mWeatherListItem.setTextViewDayStatus(textViewDayStatus);
        mWeatherListItem.setTextViewtemperature(textViewtemperature);
        return mWeatherListItem;
    }
*/
    public ArrayList<WeatherListItem> createWethearContentData() {
        WeatherListItem weatherListItem;

        String textViewDayStatus;
        String textViewDay;
        String textViewtemperature;
        int imageViewItem;
        int i;

            switch (i % 5) {
                case 0:
                    imageViewItem = R.drawable.art_clear;
                    break;
                case 1:
                    imageViewItem = R.drawable.art_clouds;
                    break;

                case 2:
                    imageViewItem = R.drawable.art_fog;
                    break;
                case 3:
                    imageViewItem = R.drawable.art_light_rain;
                    break;
                case 4:
                    imageViewItem = R.drawable.art_storm;
                    break;
                default:
                    imageViewItem = R.drawable.art_snow;
                    break;
            }
            weatherListItem = new WeatherListItem(textViewDayStatus, textViewDay,
                    textViewtemperature, imageViewItem);
            data.add(weatherListItem);
        }
        return data;
    }
}
