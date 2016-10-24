package com.example.tm.recycleviewtest.SyncData;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.tm.recycleviewtest.DataWeatherAPI.GetWeatherDataDetailsFromJSONObjectAndStore;

/**
 * Created by TM on 19/10/2016.
 */

public class SyncDataFromWeatherAPI {
    int oldCityId = 707860;
    int newCityId = 519188;
    Context context;

    public SyncDataFromWeatherAPI(Context context) {
        this.context = context;
    }

    /*Get oldCityId from SQLite Database*/
    public int getOldCityId() {
        /*
        * Using settingsData.class
        * */
        return oldCityId;
    }

    /* Get newCityId from Settings reference */
    public int getNewCityId() {
        /*
        * Using getCityId in WeatherCreateDatabaseHelper
        * */
        return newCityId;
    }

    /*Check network information*/
    public boolean isConnected() {
        boolean networkStatus;
            /*
    * Check network connection
    * return status in boolen type
    * True if have a connection
    * */
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        networkStatus = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
        return networkStatus;
    }

    /*Refresh data if have any change */
    public void refreshData(int newCityId) {
        GetWeatherDataDetailsFromJSONObjectAndStore getWeatherDataDetailsFromJSONObjectAndStore = new GetWeatherDataDetailsFromJSONObjectAndStore(newCityId, context);
        getWeatherDataDetailsFromJSONObjectAndStore.execute();
            /*
            * Get data from network
            * Dele SQLite Database then re-OnCreat();
            * */
    }

    public void SyncData() {
        if (isConnected()) {
            newCityId = getNewCityId();
            oldCityId = getOldCityId();
            if (newCityId != oldCityId) {
                refreshData(newCityId);
            }
         /*   context.deleteDatabase(WeatherData.LocationEntry.DATABASE_NAME);
            context.deleteDatabase(WeatherData.WeatherEntry.DATABASE_NAME);
           */
        }


    }
}



