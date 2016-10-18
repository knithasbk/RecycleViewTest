package com.example.tm.recycleviewtest.DataWeatherAPI;

import com.example.tm.recycleviewtest.WeatherData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by TM on 05/10/2016.
 * Start a connect with weather API - Then get JSON String from Weather API
 * <p>
 * Input : int cityId
 * Output: JSONObject jsonObject
 */


public class GetJSONObjectFromWeatherAPIConnection {
    private WeatherData weatherData;
    private JSONObject jsonObject;

    //http://api.openweathermap.org/data/2.5/forecast/daily?id=524901&cnt=16&APPID=1f9ed645ac85d117e32bdc1492a7cef6

    public JSONObject getWeatherJSONStringByCityId(int cityId) {
        weatherData = new WeatherData();
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        StringBuffer stringBuffer = null;

        StringBuilder sb = new StringBuilder(weatherData.BASIC_URL);
        StringBuilder urlBuilt = sb.append(String.valueOf(cityId)).append(weatherData.DATE_QUERY)
                .append(weatherData.DATE_NUMBER).append(weatherData.APPID).append(weatherData.USER_ID);
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
        jsonObject = ParseStringToJSONObject(stringBuffer.toString());
        return jsonObject;
    }


    public JSONObject ParseStringToJSONObject(String jsonString) {
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            System.out.print(e);
        }
        return jsonObject;
    }


}


