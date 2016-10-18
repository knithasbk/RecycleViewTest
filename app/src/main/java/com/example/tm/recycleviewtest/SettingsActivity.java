package com.example.tm.recycleviewtest;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v7.widget.Toolbar;

import java.util.List;


/**
 * Created by TM on 10/10/2016.
 */

public class SettingsActivity extends PreferenceActivity {
    Toolbar mToolbar;

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.settings_preference_header, target);
    }

    public static class Fragment1 extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_preference);
        }
    }
}
