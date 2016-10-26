package com.example.tm.recycleviewtest;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by TM on 25/10/2016.
 */

public class SettingsData {
    public String getLocation(Context context) {
        SharedPreferences spfs = PreferenceManager.getDefaultSharedPreferences(context);
        return spfs.getString("location_multi", "1568738");

    }

    public String getWeatherUnit(Context context) {
        SharedPreferences spfs = PreferenceManager.getDefaultSharedPreferences(context);
        return spfs.getString("weatherUnit", null);
    }

    public boolean isNotified(Context context) {
        SharedPreferences spfs = PreferenceManager.getDefaultSharedPreferences(context);
        return spfs.getBoolean("weatherUnit", false);
    }
}
