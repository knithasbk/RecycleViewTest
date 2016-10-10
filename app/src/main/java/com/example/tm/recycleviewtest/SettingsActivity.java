package com.example.tm.recycleviewtest;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by TM on 10/10/2016.
 */

public class SettingsActivity extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_preference);
    }

}
