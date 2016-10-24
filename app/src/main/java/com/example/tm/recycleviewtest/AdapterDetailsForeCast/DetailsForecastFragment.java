package com.example.tm.recycleviewtest.AdapterDetailsForeCast;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tm.recycleviewtest.ArrayDataTest;
import com.example.tm.recycleviewtest.R;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherCreateDatabaseHelper;
import com.example.tm.recycleviewtest.SQLiteDatabase.WeatherListData;

import java.util.ArrayList;

/**
 * Created by TM on 18/10/2016.
 */

public class DetailsForecastFragment extends Fragment {

    int position;
    WeatherListData weatherListData;
    ArrayList<WeatherListData> weatherListDataArrayList = new ArrayList<>();
    WeatherCreateDatabaseHelper weatherCreateDatabaseHelper;
    ArrayDataTest arrayDataTest;

    public DetailsForecastFragment() {
        Log.i("TEST_TRACE", "DetailsForecastFragment() constructor at DetailsForecastFragment.class ");
    }

    public static DetailsForecastFragment getInstance(int position) {
        Bundle args = new Bundle();
        DetailsForecastFragment detailsForecastFragment = new DetailsForecastFragment();
        Log.d("TEST_TRACE", "Position DetailsForecastFragment at Constructor: " + String.valueOf(position));
        args.putInt("POSITION", position);
        detailsForecastFragment.setArguments(args);
        return detailsForecastFragment;
    }

    public void setPosition(int position) {
        this.position = position;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Context context = getActivity().getApplicationContext();
        weatherCreateDatabaseHelper = new WeatherCreateDatabaseHelper(context);

        //   position = args.getInt("POSITION");
        Log.i("TEST_TRACE", "Start OnCreateView in DetailsForecastFragment.class");
        Log.i("TEST_TRACE", "Position DetailsForecastFragment onCreateView " + String.valueOf(position));

        //arrayDataTest = new ArrayDataTest();
        //weatherListDataArrayList = arrayDataTest.buildDataTest();

        weatherListDataArrayList = weatherCreateDatabaseHelper.getAllWeartherData();
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        GetWeatherRecycleListDataConvertToDeatailView(view, weatherListDataArrayList.get(position));
        Log.d("TEST_TRACE", "End OnCreateView in DetailsForecastFragment.class");
        return view;
    }

    public void GetWeatherRecycleListDataConvertToDeatailView(View view, WeatherListData weatherListData) {
        Log.d("TEST_TRACE", " Start GetWeatherRecycleListDataConvertToDeatailView function on DetailsForecastAdapter.class");
        //  view = new View();
        TextView mtvDayOfWeek = (TextView) view.findViewById(R.id.detail_day_of_week);
        TextView mtvDayOfMonth = (TextView) view.findViewById(R.id.detail_day_of_month);
        TextView mtvHumidity = (TextView) view.findViewById(R.id.detail_humidity);
        ImageView mtvImage = (ImageView) view.findViewById(R.id.detail_image);
        TextView mtvMaxTemp = (TextView) view.findViewById(R.id.detail_max_temp);
        TextView mtvMinTemp = (TextView) view.findViewById(R.id.detail_min_temp);
        TextView mtvPressue = (TextView) view.findViewById(R.id.detail_pressue);
        TextView mtvWeatherStatus = (TextView) view.findViewById(R.id.detail_weather_status);
        TextView mtvWindSpeed = (TextView) view.findViewById(R.id.details_wind_speed);
        Log.d("TEST_TRACE", weatherListData.getmDayofMonth());
        mtvDayOfWeek.setText(weatherListData.getmDayofWeek());


        mtvDayOfMonth.setText(weatherListData.getmDayofMonth());
        mtvHumidity.setText("Humnidity: " + String.valueOf(weatherListData.getmDateHumidity()));
        mtvWindSpeed.setText("Wind Speed: " + String.valueOf(weatherListData.getmDateWindSpeed()));
        mtvImage.setImageResource(weatherListData.getmImageItem());
        mtvMaxTemp.setText(String.valueOf(weatherListData.getmMaxTemperure()));
        mtvMinTemp.setText(String.valueOf(weatherListData.getmMinTemperure()));
        mtvPressue.setText("Pressure: " + String.valueOf(weatherListData.getmDatePressure()));
        mtvWeatherStatus.setText(weatherListData.getmDateStatusDescription());
        Log.d("TEST_TRACE", " Finish GetWeatherRecycleListDataConvertToDeatailView function on DetailsForecastAdapter.class");

    }
}
