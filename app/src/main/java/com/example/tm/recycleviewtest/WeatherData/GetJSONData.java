package com.example.tm.recycleviewtest.WeatherData;

import com.example.tm.recycleviewtest.R;
import com.example.tm.recycleviewtest.model.DetailsWeatherData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



/**
 * Created by TM on 08/10/2016.
 */
// get needed data from JSON String - WeatherConnection class
// Send data to

public class GetJSONData {
    WeatherData weatherData;
    JSONObject jsonObject;
    DetailsWeatherData detailsWeatherData;
    ArrayList<DetailsWeatherData> detailsWeatherDataArrayList;

    //JSONArray jsonArray = jsonObject.getJSONArray(weatherData.JSON_WEATHER_LIST_PARAMETERS);


    public ArrayList<DetailsWeatherData> GetWeatherDetailsListData(JSONArray jsonArray) {
        String mTextViewDetailsDayofWeek;
        String mTextViewDetailsDayofMonth;
        detailsWeatherDataArrayList = new ArrayList<DetailsWeatherData>;
        try {

            for (int i = 0; i < jsonArray.length(); i++) {


                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONArray jsonArrayTemp = jsonObject.getJSONArray(weatherData.JSON_TEMPRATURE_DAY);
                double mDetailsDateWindSpeed = jsonObject.getDouble(weatherData.JSON_WIND_SPEED);
                double mDetailDateHumidity = jsonObject.getDouble(weatherData.JSON_HUMIDITY_DAY);
                double mDetailsDatePressure = jsonObject.getDouble(weatherData.JSON_PRESSURE_DATE);
                String weatherMain = jsonObject.getString(weatherData.JSON_WEATHER_LIST_STATUS_MAIN);
                String mDetailDateStatus = jsonObject.getString(weatherData.JSON_WEATHER_LIST_STATUS_DESCRIPTION);
                String mImageViewItemDetailsString = jsonObject.getString(weatherData.JSON_WEATHER_LIST_STATUS_ICON);
                JSONObject jsonArrayTempObject = jsonArrayTemp.getJSONObject(0);
                double mDetailsMaxTemperure = jsonArrayTempObject.getDouble(weatherData.JSON_WEATHER_LIST_PARAMETERS_MAX);
                double mDetailMinTemperure = jsonArrayTempObject.getDouble(weatherData.JSON_WEATHER_LIST_PARAMETERS_MIN);


            }
        } catch (JSONException e) {
            System.out.println(e);
        }
        return detailsWeatherDataArrayList;
    }



    public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateString = date.toString();
        return dateString;
    }
    public  String getGetCurrentDayofWeek(){
        String dateOfWeek =  getCurrentDate().substring(0,2);
        return dateOfWeek;
    }
    public String getCurrentDayofMonth(){
        String dateOfMonth = getCurrentDate().substring(3,9);
        return dateOfMonth;
    }


    //Get icon from weather data -> convert to image Id

    public int ConvertImageWeatherToId(String mImageViewItemDetailsString) {
        int mImageViewItemDetails = null;
        switch (mImageViewItemDetailsString) {
            case "a":
                mImageViewItemDetails = R.drawable.art_clear;
                break;
            case "b":
                break;
            default:
                return  0 ;


        }
        return mImageViewItemDetails;

    }

}
