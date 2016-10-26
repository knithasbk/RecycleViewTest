

package com.example.tm.recycleviewtest;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.Log;

/**
 * Created by TM on 10/10/2016.
 */

public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("TEST_TRACE", "Start onCreate at SettingsActivity class ");
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
        Log.i("TEST_TRACE", "End onCreate at SettingsActivity class ");
    }

    public static class MyPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            Log.i("TEST_TRACE", "Start onCreate at MyPreferenceFragment class ");
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_preference);
            Log.i("TEST_TRACE", "End onCreate at MyPreferenceFragment class ");
        }

    }





 /*   public String getMetricUnit() {
        String unit = sharedPreferences.getString("downloadType", "1");
        return unit;
    }

    public boolean getNotification() {
        boolean notify = sharedPreferences.getBoolean("applicationUpdates", false);
        return notify;
    }
*/
}






