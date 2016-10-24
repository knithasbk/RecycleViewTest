

package com.example.tm.recycleviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;


/**
 * Created by TM on 10/10/2016.
 */

public class SettingsActivity extends Activity {
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("TEST_TRACE", " Start onCreate() at SettingsActivity.class");
        super.onCreate(savedInstanceState);
  //      setContentView(R.layout.setting_layout);

//        mToolbar = (Toolbar) findViewById(R.id.settings_layout_toolbar);

//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        SettingsFragment settingsFragment = new SettingsFragment();
        super.onCreate(savedInstanceState);
        Log.i("TEST_TRACE", "Start commit fragment");
        getFragmentManager().beginTransaction()
                .replace(R.id.settings_fragment_id, settingsFragment)
                .commit();
     //   Log.i("TEST_TRACE", " End onCreate() at SettingsActivity.class");

    }
}
