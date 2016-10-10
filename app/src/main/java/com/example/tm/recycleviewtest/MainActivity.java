package com.example.tm.recycleviewtest;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.LinearLayoutManager;

import com.example.tm.recycleviewtest.adapter.WeatherAdapterRecycleView;
import com.example.tm.recycleviewtest.model.WeatherListItemData;
import com.example.tm.recycleviewtest.model.WeatherListItemContent;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    WeatherAdapterRecycleView myAdapter;
    WeatherListItemContent weatherListItemContent = new WeatherListItemContent();
    ArrayList<WeatherListItemData> weatherListItemArray = new ArrayList<>();



    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // Set show RecycleView

        weatherListItemArray = weatherListItemContent.createWethearContentData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.weather_recycler_view);
        myAdapter = new WeatherAdapterRecycleView(weatherListItemArray);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(myAdapter);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.activity_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.activity_main_action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}