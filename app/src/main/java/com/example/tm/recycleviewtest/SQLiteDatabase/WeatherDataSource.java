package com.example.tm.recycleviewtest.SQLiteDatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.tm.recycleviewtest.WeatherData;

import java.util.ArrayList;

/**
 * Created by TM on 18/10/2016.
 */

public class WeatherDataSource {
    private String[] weatherColums = {
            WeatherData.WeatherEntry.COLUMN_DATE_OF_WEEK,
            WeatherData.WeatherEntry.COLUMN_DATE_OF_MONTH,
            WeatherData.WeatherEntry.COLUMN_HUMIDITY,
            WeatherData.WeatherEntry.COLUMN_MAX_TEMP,
            WeatherData.WeatherEntry.COLUMN_IMGATE_ID,
            WeatherData.WeatherEntry.COLUMN_PRESSURE,
            WeatherData.WeatherEntry.COLUMN_STATUS_MAIN,
            WeatherData.WeatherEntry.COLUMN_WIN_SPEED,
            WeatherData.WeatherEntry.COLUMN_STATUS_DESCRIPTION,
    };
    private String[] locationColums = {
            WeatherData.LocationEntry.COLUMN_CITY_LAT,
            WeatherData.LocationEntry.COLUMN_CITY_LON,
            WeatherData.LocationEntry.COLUMN_CITY_NAME,
            WeatherData.LocationEntry.COLUMN_COUNTRY_NAME

    };
    private SQLiteDatabase database;
    private WeatherCreateDatabaseHelper weatherCreateDatabaseHelper;

    public void open() throws SQLException {
        database = weatherCreateDatabaseHelper.getWritableDatabase();
    }

    public void close() {
        weatherCreateDatabaseHelper.close();
    }

    public void addWeatherRow(WeatherListData weatherListData) {
        open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WeatherData.WeatherEntry.COLUMN_DATE_OF_WEEK, weatherListData.getmDayofWeek());
        contentValues.put(WeatherData.WeatherEntry.COLUMN_DATE_OF_MONTH, weatherListData.getmDayofMonth());
        contentValues.put(WeatherData.WeatherEntry.COLUMN_HUMIDITY, weatherListData.getmDateHumidity());
        contentValues.put(WeatherData.WeatherEntry.COLUMN_MAX_TEMP, weatherListData.getmMaxTemperure());
        contentValues.put(WeatherData.WeatherEntry.COLUMN_MIN_TEMP, weatherListData.getmMinTemperure());
        contentValues.put(WeatherData.WeatherEntry.COLUMN_IMGATE_ID, weatherListData.getmImageItem());
        contentValues.put(WeatherData.WeatherEntry.COLUMN_PRESSURE, weatherListData.getmDatePressure());
        contentValues.put(WeatherData.WeatherEntry.COLUMN_WIN_SPEED, weatherListData.getmDateWindSpeed());
        contentValues.put(WeatherData.WeatherEntry.COLUMN_STATUS_DESCRIPTION, weatherListData.getmDateStatusDescription());
        contentValues.put(WeatherData.WeatherEntry.COLUMN_STATUS_MAIN, weatherListData.getmDateStatusMain());

        database.insert(WeatherData.WeatherEntry.DATABASE_NAME, null, contentValues);
        close();
    }

    public void addLocationRow(WeatherLocationData weatherLocationData) {
        open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WeatherData.LocationEntry.COLUMN_CITY_LAT, weatherLocationData.getmCityLat());
        contentValues.put(WeatherData.LocationEntry.COLUMN_CITY_LON, weatherLocationData.getmCityLon());
        contentValues.put(WeatherData.LocationEntry.COLUMN_CITY_NAME, weatherLocationData.getmCityName());
        contentValues.put(WeatherData.LocationEntry.COLUMN_COUNTRY_NAME, weatherLocationData.getmContryName());

        database.insert(WeatherData.LocationEntry.DATABASE_NAME, null, contentValues);
        close();
    }

    public WeatherListData getWeatherDetails(int id) {
        WeatherListData weatherListData;
        open(); // Open database connection.
        Cursor cursor = database.query(WeatherData.WeatherEntry.DATABASE_NAME, weatherColums, WeatherData.WeatherEntry.WEATHER_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        weatherListData = new WeatherListData(Integer.parseInt(cursor.getString(WeatherData.WeatherColumnID.WEATHER_ID_COLUMN_ID)),
                cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_DATE_OF_WEEK),
                cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_DATE_OF_MONTH),
                cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_MAX_TEMP),
                cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_MIN_TEMP),
                cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_PRESSURE),
                cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_HUMIDITY),
                cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_STATUS_MAIN),
                cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_STATUS_DESCRIPTION),
                cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_WIN_SPEED),
                cursor.getInt(WeatherData.WeatherColumnID.COLUMN_ID_IMGATE_ID));
        return weatherListData;
    }

    public ArrayList<WeatherListData> getAllWeartherData() {
        ArrayList<WeatherListData> weatherListDataArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + WeatherData.WeatherEntry.DATABASE_NAME;
        open();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                WeatherListData weatherListData = new WeatherListData(Integer.parseInt(cursor.getString(WeatherData.WeatherColumnID.WEATHER_ID_COLUMN_ID)),
                        cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_DATE_OF_WEEK),
                        cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_DATE_OF_MONTH),
                        cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_MAX_TEMP),
                        cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_MIN_TEMP),
                        cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_PRESSURE),
                        cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_HUMIDITY),
                        cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_STATUS_MAIN),
                        cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_STATUS_DESCRIPTION),
                        cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_WIN_SPEED),
                        cursor.getInt(WeatherData.WeatherColumnID.COLUMN_ID_IMGATE_ID));
                weatherListDataArrayList.add(weatherListData);
            } while (cursor.moveToNext());
        }
        close();
        return weatherListDataArrayList;

    }

    public int getNumberWeatherItem() {
        open();
        ArrayList<WeatherListData> weatherListDataArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + WeatherData.WeatherEntry.DATABASE_NAME;
        Cursor cursor = database.rawQuery(selectQuery, null);
        close();
        return cursor.getCount();

    }

}
