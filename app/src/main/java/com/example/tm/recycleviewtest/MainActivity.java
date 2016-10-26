package com.example.tm.recycleviewtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherCreateDatabaseHelper;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherListData;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    Context context;
    WeatherCreateDatabaseHelper weatherCreateDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("TEST_TRACE", "Start OnCreate function of MainActivity.class");
        ArrayDataTest arrayDataTest;
        ArrayList<WeatherListData> weatherListItemArray = new ArrayList<>();
        weatherCreateDatabaseHelper = new WeatherCreateDatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Handle for Toolbar */
        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        ForecastFragment forecastFragment = new ForecastFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.activity_fragment_forecast ,forecastFragment);
        fragmentTransaction.commit();


        /*Handle for recycleView: Data are queried from SQLite and using setAdapter to binding data to Adapter */
        Log.i("TEST_TRACE", "Testing MainActivity.class");


        /**/
        /*Create a local database first*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("TEST_TRACE", "Start onCreateOptionsMenu function of MainActivity.class");
        getMenuInflater().inflate(R.menu.activity_main, menu);
        System.out.print("TEST_TRACE:  End onCreateOptionsMenu function of MainActivity.class");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("TEST_TRACE", "Start onOptionsItemSelected function of MainActivity.class")
        ;
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so
        // long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.activity_main_action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        Log.d("TEST_TRACE", "End onOptionsItemSelected function of MainActivity.class");

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {

        super.onRestart();
    }


}