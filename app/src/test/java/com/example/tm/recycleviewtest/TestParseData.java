package com.example.tm.recycleviewtest;

import android.util.Log;

import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherListData;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherLocationData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static com.example.tm.recycleviewtest.DataWeatherAPI.parseAPIDataToReadableData.getArtResourceForWeatherCondition;

/**
 * Created by TM on 21/10/2016.
 */

public class TestParseData {
    WeatherData weatherData;
    WeatherLocationData weatherLocationData;
    WeatherListData weatherListData;
    final public static String JSON_STRING1 = "{\"city\":{\"id\":524901,\"name\":\"Moscow\",\"coord\":{\"lon\":37.615555,\"lat\":55.75222},\"country\":\"RU\",\"population\":0},\"cod\":\"200\",\"message\":0.0254,\"cnt\":15,\"list\":[{\"dt\":1476867600,\"temp\":{\"day\":275.16,\"min\":270.38,\"max\":275.95,\"night\":272.82,\"eve\":273.55,\"morn\":270.38},\"pressure\":1026.9,\"humidity\":86,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":1.73,\"deg\":244,\"clouds\":80,\"snow\":0.11},{\"dt\":1476954000,\"temp\":{\"day\":274.66,\"min\":271.91,\"max\":274.84,\"night\":271.91,\"eve\":273.65,\"morn\":272.44},\"pressure\":1029.24,\"humidity\":82,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":1.82,\"deg\":228,\"clouds\":80,\"snow\":0.33},{\"dt\":1477040400,\"temp\":{\"day\":275.29,\"min\":269.74,\"max\":275.29,\"night\":271.23,\"eve\":269.74,\"morn\":271.46},\"pressure\":1028.65,\"humidity\":0,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":2.19,\"deg\":47,\"clouds\":34,\"snow\":0.21},{\"dt\":1477126800,\"temp\":{\"day\":274.99,\"min\":272.01,\"max\":274.99,\"night\":272.24,\"eve\":272.01,\"morn\":272.64},\"pressure\":1033.88,\"humidity\":0,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":2.63,\"deg\":116,\"clouds\":45,\"snow\":0.44},{\"dt\":1477213200,\"temp\":{\"day\":273.21,\"min\":268.73,\"max\":273.21,\"night\":268.73,\"eve\":270.53,\"morn\":271.26},\"pressure\":1042.17,\"humidity\":0,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":7.88,\"deg\":111,\"clouds\":37,\"snow\":0.09},{\"dt\":1477299600,\"temp\":{\"day\":274.03,\"min\":265.64,\"max\":274.03,\"night\":265.64,\"eve\":268.85,\"morn\":267.51},\"pressure\":1042.98,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"speed\":5.95,\"deg\":106,\"clouds\":0},{\"dt\":1477386000,\"temp\":{\"day\":274.16,\"min\":265.95,\"max\":274.16,\"night\":265.95,\"eve\":267.62,\"morn\":266.8},\"pressure\":1039.37,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"speed\":3.64,\"deg\":88,\"clouds\":0},{\"dt\":1477472400,\"temp\":{\"day\":274.97,\"min\":266.99,\"max\":274.97,\"night\":266.99,\"eve\":269.28,\"morn\":268.33},\"pressure\":1038.3,\"humidity\":0,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":3.79,\"deg\":105,\"clouds\":3,\"snow\":0.03},{\"dt\":1477558800,\"temp\":{\"day\":275.77,\"min\":268.45,\"max\":275.77,\"night\":268.94,\"eve\":270.78,\"morn\":268.45},\"pressure\":1038.52,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"speed\":5.11,\"deg\":109,\"clouds\":5},{\"dt\":1477645200,\"temp\":{\"day\":276.84,\"min\":268.51,\"max\":276.84,\"night\":268.51,\"eve\":270.44,\"morn\":269.58},\"pressure\":1034.12,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"speed\":4.13,\"deg\":110,\"clouds\":1},{\"dt\":1477731600,\"temp\":{\"day\":276.98,\"min\":269.73,\"max\":276.98,\"night\":272.71,\"eve\":274.15,\"morn\":269.73},\"pressure\":1026.53,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"speed\":6.75,\"deg\":118,\"clouds\":35},{\"dt\":1477818000,\"temp\":{\"day\":274.99,\"min\":272.37,\"max\":274.99,\"night\":273.5,\"eve\":273.94,\"morn\":272.37},\"pressure\":1014.86,\"humidity\":0,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":5.81,\"deg\":110,\"clouds\":77,\"snow\":0.93},{\"dt\":1477904400,\"temp\":{\"day\":275.57,\"min\":270.8,\"max\":275.57,\"night\":270.8,\"eve\":273.25,\"morn\":273.51},\"pressure\":1007.77,\"humidity\":0,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":4.18,\"deg\":354,\"clouds\":98,\"rain\":0.27,\"snow\":0.25},{\"dt\":1477990800,\"temp\":{\"day\":272.26,\"min\":268.42,\"max\":272.26,\"night\":269.57,\"eve\":268.42,\"morn\":269.63},\"pressure\":1018.02,\"humidity\":0,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":1.84,\"deg\":31,\"clouds\":7,\"snow\":0.04},{\"dt\":1478077200,\"temp\":{\"day\":269.57,\"min\":269.57,\"max\":269.57,\"night\":269.57,\"eve\":269.57,\"morn\":269.57},\"pressure\":1014.52,\"humidity\":0,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":4.49,\"deg\":206,\"clouds\":86,\"snow\":0.03}]}";
    @Test
    public void Test() {
        try {
            JSONObject jsonObjectMain = new JSONObject(JSON_STRING1);
            JSONObject jsonObjectCity = jsonObjectMain.getJSONObject("city");
            String cityName = jsonObjectCity.getString(weatherData.CITY_NAME);
            String countryName = jsonObjectCity.getString(weatherData.COUNTRY_NAME);
            JSONObject jsonObjectCoord = jsonObjectCity.getJSONObject("coord");
            double cityLon = jsonObjectCoord.getDouble(weatherData.COORD_LON);
            double cityLat = jsonObjectCoord.getDouble(weatherData.COORD_LAT);
            weatherLocationData = new WeatherLocationData(cityName, countryName, cityLon, cityLat);
            Log.d("TEST_TRACE", cityName + countryName + cityLon + cityLat);



            /*BUG*/
            //  weatherDataSource.addLocationRow(weatherLocationData);
            Log.d("TEST_TRACE", " ParseWeatherDataFromJSONObject : 2 ");
        /*Get Weather data and store to Database*/
            JSONArray jsonArray = jsonObjectMain.getJSONArray(weatherData.JSON_WEATHER_LIST_PARAMETERS);
            Log.d("TEST_TRACE", " ParseWeatherDataFromJSONObject : 3 ");
            /*Get weather item data and add to WeatherItemData*/
            Log.d("TEST_TRACE", String.valueOf(jsonArray.length()));

            for (int i = 0; i < jsonArray.length(); i++) {
                System.out.println(i);
                Log.d("TRACE_TEST", String.valueOf(i));
                JSONObject jsonObjectWeatherDetails = jsonArray.getJSONObject(i);
                double mDateWindSpeed = jsonObjectWeatherDetails.getDouble(weatherData.JSON_WIND_SPEED);
                double mDateHumidity = jsonObjectWeatherDetails.getDouble(weatherData.JSON_HUMIDITY_DAY);
                double mDatePressure = jsonObjectWeatherDetails.getDouble(weatherData.JSON_PRESSURE_DATE);
                // Get data from weather key
                JSONObject jsonArrayTemp = jsonObjectWeatherDetails.getJSONObject(weatherData.JSON_TEMPRATURE_DAY);
                double mMaxTemperure = jsonArrayTemp.getDouble(weatherData.JSON_WEATHER_LIST_PARAMETERS_MAX);
                double mMinTemperure = jsonArrayTemp.getDouble(weatherData.JSON_WEATHER_LIST_PARAMETERS_MIN);
                //   JSONObject jsonArrayTempObject = jsonArrayTemp.getJSONObject(0);
                JSONArray jsonArray1 = jsonObjectWeatherDetails.getJSONArray(weatherData.JSON_WEATHER_LIST_STATUS);
                JSONObject jsonObjectWeatherStatus = jsonArray1.getJSONObject(0);
                String mDateStatusMain = jsonObjectWeatherStatus.getString(weatherData.JSON_WEATHER_LIST_STATUS_MAIN);
                String mDateStatusDescription = jsonObjectWeatherStatus.getString(weatherData.JSON_WEATHER_LIST_STATUS_DESCRIPTION);
                int mImageItemAPI = Integer.parseInt(jsonObjectWeatherStatus.getString(weatherData.JSON_WEATHER_LIST_STATUS_ICON));
                int mImageItem = getArtResourceForWeatherCondition(mImageItemAPI);

     /*    weatherListData = new WeatherListData(i, "dayOfWeek", "dayOfMonth", mMaxTemperure, mMinTemperure, mDatePressure,
                        mDateHumidity, mDateStatusMain, mDateStatusDescription, mDateWindSpeed, mImageItem);
                Log.d("TRACE_TEST", "");



                */
                 /*Add weather item data to SQLite Database */
                Log.d("TEST_TRACE", "1 - 1 ");
                Log.d("TEST_TRACE", "1 - 2");

                /* Function for unitest
                System.out.println("ID" + weatherListData.getId());
                System.out.println("DAY OF WEEK " + weatherListData.getmDayofWeek());
                System.out.println("DAY OF MONTH" + weatherListData.getmDayofMonth());
                System.out.println("MAX TEMP "+ weatherListData.getmMaxTemperure());
                System.out.println("MIN TEMP" + weatherListData.getmMinTemperure());
                System.out.println("PRESSURE" + weatherListData.getmDatePressure());
                System.out.println("HUMIDITY " + weatherListData.getmDateHumidity());
                System.out.println("STATUS MAIN " + weatherListData.getmDateStatusMain());
                System.out.println("STATUS DESCRIPTION"+ weatherListData.getmDateStatusDescription());
                System.out.println("WIND SPEED"+weatherListData.getmDateWindSpeed());
                System.out.println("IMAGE ITEM "+weatherListData.getmImageItem());
                /*Finish function*/
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
        Log.d("TEST_TRACE", "End ParseWeatherDataFromJSONObject at ParseWeatherDataDetailsFromJSONObject");

    }
}