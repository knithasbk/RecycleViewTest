package com.example.tm.recycleviewtest.DataWeatherAPI;

import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherDataSource;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherListData;
import com.example.tm.recycleviewtest.WeatherData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by TM on 08/10/2016.
 */
// get needed data from JSON String - WeatherConnection class
// Send data to

public class ParseWeatherDataDetailsFromJSONObject {

    private WeatherData weatherData;
    private JSONObject jsonObject;
    GetJSONObjectFromWeatherAPIConnection weatherConnection;
    WeatherDataSource weatherDataSource;
    WeatherListData weatherListData;


    /*
    * Get details data from JSON String then store to SQLite DB
    * 
    *
    * */
    public void ParseWeatherDataDetailsFromJSONObject(JSONObject jsonObject1) {
        try {

            String cityName = jsonObject1.getString(weatherData.CITY_NAME);
            String countryName = jsonObject1.getString(weatherData.COUNTRY_NAME);
            JSONObject jsonObjectCoord = jsonObject1.getJSONObject("coord");
            double cityLon = jsonObjectCoord.getDouble(weatherData.COORD_LON);
            double cityLat = jsonObjectCoord.getDouble(weatherData.COORD_LAT);


            // From JSON String, get JSON array "list"
            JSONArray jsonArray = jsonObject1.getJSONArray(weatherData.JSON_WEATHER_LIST_PARAMETERS);
            // Handle for each list[i] item
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                double mDateWindSpeed = jsonObject.getDouble(weatherData.JSON_WIND_SPEED);
                double mDateHumidity = jsonObject.getDouble(weatherData.JSON_HUMIDITY_DAY);
                double mDatePressure = jsonObject.getDouble(weatherData.JSON_PRESSURE_DATE);
                // Get data from weather key
                JSONObject jsonArrayTemp = jsonObject.getJSONObject(weatherData.JSON_TEMPRATURE_DAY);
                double mMaxTemperure = jsonArrayTemp.getDouble(weatherData.JSON_WEATHER_LIST_PARAMETERS_MAX);
                double mMinTemperure = jsonArrayTemp.getDouble(weatherData.JSON_WEATHER_LIST_PARAMETERS_MIN);
                //   JSONObject jsonArrayTempObject = jsonArrayTemp.getJSONObject(0);
                JSONArray jsonArray1 = jsonObject.getJSONArray(weatherData.JSON_WEATHER_LIST_STATUS);
                JSONObject jsonObject2 = jsonArray1.getJSONObject(0);
                String mDateStatusMain = jsonObject2.getString(weatherData.JSON_WEATHER_LIST_STATUS_MAIN);
                String mDateStatusDescription = jsonObject2.getString(weatherData.JSON_WEATHER_LIST_STATUS_DESCRIPTION);
                int mImageItem = Integer.parseInt(jsonObject2.getString(weatherData.JSON_WEATHER_LIST_STATUS_ICON));

                weatherListData = new WeatherListData(1,"Tuesday","18 Oct",mMaxTemperure,mMinTemperure,mDatePressure,
                mDateHumidity,mDateStatusMain,mDateStatusDescription,mDateWindSpeed,mImageItem);
                weatherDataSource.addWeatherRow(weatherListData);
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
    }


}
