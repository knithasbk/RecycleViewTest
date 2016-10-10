package com.example.tm.recycleviewtest.WeatherData;

import com.example.tm.recycleviewtest.model.WeatherListItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by TM on 05/10/2016.
 */

public class WeatherConnection {
    final String BASIC_URL = "http://api.openweathermap.org/data/2.5/forecast/city?id=";
    final String URLAPPEND = "&APPID=";
    JSONObject jsonObject;
    JSONArray jsonData;


    public String getWeatherJSONString(String city) {
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        StringBuffer stringBuffer = null;

        StringBuilder sb = new StringBuilder(BASIC_URL);
        StringBuilder urlBuilt = sb.append(city).append(URLAPPEND).append(new WeatherData().WEATHER_ID);
        String urlString = urlBuilt.toString();

        try {
            url = new URL(urlString);

            //Create a connection to Weather API
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // Get InputStream from connection
            InputStream in = urlConnection.getInputStream();
            // Store input stream to buffer until input stream = null -> finish
            stringBuffer = new StringBuffer();
            if (in == null) {
                return null;
            }
            /* create a reader to read String from buffer
            * Insert enter key to string
            reader = new BufferedReader(new InputStreamReader(in));
            String line;
            if (line = reader.readLine() != null ) {
                stringBuffer.append(line+"\n");
            }
             */
            if (stringBuffer == null) {
                return null;
            }


        } catch (MalformedURLException e) {
            System.out.print(e);

        } catch (IOException e) {
            System.out.print(e);
        } finally {
            urlConnection.disconnect();
        }
        return stringBuffer.toString();
    }



    public JSONArray getDataFromJSONString(String city) {
        String jsonString = getWeatherJSONString(city)
        try {
            jsonObject = new JSONObject(jsonString);
            jsonData = jsonObject.getJSONArray("list");
        }catch ( JSONException e){
            System.out.print(e);
        }
    return jsonData;
    }


}


