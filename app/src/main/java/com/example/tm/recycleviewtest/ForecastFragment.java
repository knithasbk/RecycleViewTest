package com.example.tm.recycleviewtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tm.recycleviewtest.AdapterRecycleViewMainActivity.RecyclerViewClickListener;
import com.example.tm.recycleviewtest.AdapterRecycleViewMainActivity.WeatherAdapterRecycleView;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherCreateDatabaseHelper;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherListData;
import com.example.tm.recycleviewtest.SyncData.SyncDataFromWeatherAPI;

import java.util.ArrayList;

/**
 * Created by TM on 26/10/2016.
 */

public class ForecastFragment extends Fragment implements RecyclerViewClickListener {
    private WeatherAdapterRecycleView myAdapter;
    WeatherCreateDatabaseHelper weatherCreateDatabaseHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a = new Activity();

        if (context instanceof Activity){
            a =(Activity) context;
        }
        weatherCreateDatabaseHelper = new WeatherCreateDatabaseHelper(a);

        ArrayList<WeatherListData> weatherListItemArray = new ArrayList<>();
        ArrayDataTest arrayDataTest;
        try {
            weatherListItemArray = weatherCreateDatabaseHelper.getAllWeartherData();
        } catch (CursorIndexOutOfBoundsException e) {
            arrayDataTest = new ArrayDataTest();
            weatherListItemArray = arrayDataTest.buildDataTest();
        }
        int newCityId = getNewCityId();
        int oldCityId = getOldCityId();
        if (newCityId != oldCityId) {
            SyncDataFromWeatherAPI syncDataFromWeatherAPI = new SyncDataFromWeatherAPI(getActivity(), newCityId);
            syncDataFromWeatherAPI.SyncData();
        }
        RecyclerView recyclerView = (RecyclerView) a.findViewById(R.id.weather_recycler_view);
        myAdapter = new WeatherAdapterRecycleView(weatherListItemArray, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
    }

    public ForecastFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_forecast_fragment, container, false);
        Log.d("TEST_TRACE", "End OnCreateView in ForecastFragment.class");



        Log.i("TEST_TRACE", "End OnCreate function of MainActivity.class");
        return view;

    }

    @Override
    public void recyclerViewListClicked(View view, int position) {
        Log.i("TEST_TRACE", "Start recyclerViewListClicked function of MainActivity.class");
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("POSITION", position);
        Log.i("TEST_TRACE", "Position at MainActivity.class: " + position);
        startActivity(intent);
        Log.i("TEST_TRACE", "End recyclerViewListClicked function of MainActivity.class");
    }

    public int getOldCityId() {
        int oldCityId = 1269750;
        /*
        * Using settingsData.class
        *
        * */
        Log.i("TEST_TRACE", "Start getOldCityId() from SyncDataFromWeatherAPI class");
        try {
            WeatherCreateDatabaseHelper weatherCreateDatabaseHelper = new WeatherCreateDatabaseHelper(getActivity());
            oldCityId = weatherCreateDatabaseHelper.getLocationId();
            Log.i("TEST_TRACE", "End getOldCityId() from SyncDataFromWeatherAPI class");
        } catch (CursorIndexOutOfBoundsException e) {
            System.out.print(e);
            return oldCityId;
        }
        return oldCityId;
    }

    public int getNewCityId() {
        int newCityId = 1269750;
        /*
        * Using settingsData.class
        *
        * */
        try {

            SettingsData settingsData = new SettingsData();
            newCityId = Integer.parseInt(settingsData.getLocation(getActivity()));
        } catch (CursorIndexOutOfBoundsException e) {
            System.out.print(e);
            return newCityId;
        }
        return newCityId;

    }

}

