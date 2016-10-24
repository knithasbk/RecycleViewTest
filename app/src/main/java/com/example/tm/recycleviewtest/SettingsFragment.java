package com.example.tm.recycleviewtest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;

/**
 * Created by TM on 19/10/2016.
 */

public class SettingsFragment  extends PreferenceFragment  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TEST_TRACE", "Start addPreferencesFromResource() at  SettingsFragment.class ");
        addPreferencesFromResource(R.xml.settings_preference);
    }



}
