package com.example.tm.recycleviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tm.recycleviewtest.AdapterRecycleViewMainActivity.RecyclerViewClickListener;
import com.example.tm.recycleviewtest.AdapterRecycleViewMainActivity.WeatherAdapterRecycleView;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherCreateDatabaseHelper;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherListData;

import java.util.ArrayList;
import android.content.Context;



public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {
    WeatherAdapterRecycleView myAdapter;
    ArrayList<WeatherListData> weatherListItemArray = new ArrayList<>();
    WeatherListItemContentTest weatherListItemContentTest = new WeatherListItemContentTest();


    private Toolbar mToolbar;
    WeatherCreateDatabaseHelper weatherCreateDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Toolbar
        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Set show RecycleView
        // Test for weather data


        weatherListItemArray = weatherListItemContentTest.createWethearContentData();


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.weather_recycler_view);
        myAdapter = new WeatherAdapterRecycleView(weatherListItemArray, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.activity_main_action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void recyclerViewListClicked(View view, int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

}