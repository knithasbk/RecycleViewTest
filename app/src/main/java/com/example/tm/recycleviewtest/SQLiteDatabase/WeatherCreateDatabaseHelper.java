package com.example.tm.recycleviewtest.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tm.recycleviewtest.WeatherData;
import com.example.tm.recycleviewtest.WeatherData.LocationEntry;
import com.example.tm.recycleviewtest.WeatherData.WeatherEntry;

import java.util.ArrayList;

/**
 * Created by TM on 12/10/2016.
 */

public class WeatherCreateDatabaseHelper extends SQLiteOpenHelper {

    private String[] weatherColums = {
            WeatherEntry.WEATHER_ID,
            WeatherEntry.COLUMN_DATE_OF_WEEK,
            WeatherEntry.COLUMN_DATE_OF_MONTH,
            WeatherEntry.COLUMN_HUMIDITY,
            WeatherEntry.COLUMN_MAX_TEMP,
            WeatherEntry.COLUMN_MIN_TEMP,
            WeatherEntry.COLUMN_IMGATE_ID,
            WeatherEntry.COLUMN_PRESSURE,
            WeatherEntry.COLUMN_WIN_SPEED,
            WeatherEntry.COLUMN_STATUS_DESCRIPTION,
            WeatherEntry.COLUMN_STATUS_MAIN,
            WeatherEntry.COLUMN_LOC_ID_SYNC
    };

    private String[] locationColums = {
            LocationEntry.ID,
            LocationEntry.COLUMN_CITY_ID,
            LocationEntry.COLUMN_CITY_LAT,
            LocationEntry.COLUMN_CITY_LON,
            LocationEntry.COLUMN_CITY_NAME,
            LocationEntry.COLUMN_COUNTRY_NAME
    };

    public WeatherCreateDatabaseHelper(Context context) {
        super(context, WeatherEntry.DATABASE_NAME, null, WeatherEntry.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_LOCATION_DATABASE = "create table " + LocationEntry.DATABASE_NAME + " ( "
                + LocationEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LocationEntry.COLUMN_CITY_ID + " INTEGER NOT NULL, "
                + LocationEntry.COLUMN_CITY_LAT + " REAL NOT NULL, "
                + LocationEntry.COLUMN_CITY_LON + " REAL NOT NULL, "
                + LocationEntry.COLUMN_CITY_NAME + " TEXT, "
                + LocationEntry.COLUMN_COUNTRY_NAME + " TEXT "
                + " ); ";

        final String CREATE_WEATHER_DATABASE = "create table " + WeatherEntry.DATABASE_NAME + " ( "
                + WeatherEntry.WEATHER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WeatherEntry.COLUMN_DATE_OF_WEEK + " TEXT NOT NULL, "
                + WeatherEntry.COLUMN_DATE_OF_MONTH + " TEXT NOT NULL, "
                + WeatherEntry.COLUMN_HUMIDITY + " REAL , "
                + WeatherEntry.COLUMN_MAX_TEMP + " REAL , "
                + WeatherEntry.COLUMN_MIN_TEMP + " REAL , "
                + WeatherEntry.COLUMN_IMGATE_ID + " INTEGER , "
                + WeatherEntry.COLUMN_PRESSURE + " REAL, "
                + WeatherEntry.COLUMN_WIN_SPEED + " REAL NOT NULL, "
                + WeatherEntry.COLUMN_STATUS_DESCRIPTION + " TEXT NOT NULL, "
                + WeatherEntry.COLUMN_STATUS_MAIN + " TEXT NOT NULL, "
                + WeatherEntry.COLUMN_LOC_ID_SYNC + " INTEGER, "
                + "FOREIGN KEY ( " + WeatherEntry.COLUMN_LOC_ID_SYNC + " ) REFERENCES " + LocationEntry.DATABASE_NAME +
                "( " + LocationEntry.ID + " ), UNIQUE (" +WeatherEntry.COLUMN_LOC_ID_SYNC+ ") ON CONFLICT REPLACE);";


        db.execSQL(CREATE_WEATHER_DATABASE);
        Log.d("TEST_TRACE", "onCreate() at WeatherCreateDatabaseHelper : Creater Location");
        db.execSQL(CREATE_LOCATION_DATABASE);
        Log.d("TEST_TRACE", "onCreate() at WeatherCreateDatabaseHelper : Creater Weather");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.e("EXECUTE", " Delete old DB version " + oldVersion + "create a new DB  version " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS " + WeatherEntry.DATABASE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + LocationEntry.DATABASE_NAME);
            onCreate(db);
        }
    /**
     * open database
     */

    public void addWeatherRow(WeatherListData weatherListData) {
        SQLiteDatabase database = this.getWritableDatabase();
        Log.d("TEST_TRACE", "Start addWeatherRow() at WeatherDataSource() class");
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
        Log.d("TEST_TRACE", "End addWeatherRow() at WeatherDataSource()class");
        database.close();

    }

    public void addLocationRow(WeatherLocationData weatherLocationData) {
        Log.d("TEST_TRACE", "End addLocationRow() at WeatherDataSource()class");
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        /*Insert cityId row*/
        contentValues.put(WeatherData.LocationEntry.COLUMN_CITY_ID, weatherLocationData.getCityId());
        contentValues.put(WeatherData.LocationEntry.COLUMN_CITY_LAT, weatherLocationData.getmCityLat());
        contentValues.put(WeatherData.LocationEntry.COLUMN_CITY_LON, weatherLocationData.getmCityLon());
        contentValues.put(WeatherData.LocationEntry.COLUMN_CITY_NAME, weatherLocationData.getmCityName());
        contentValues.put(WeatherData.LocationEntry.COLUMN_COUNTRY_NAME, weatherLocationData.getmContryName());
        database.insert(WeatherData.LocationEntry.DATABASE_NAME, null, contentValues);
        Log.d("TEST_TRACE", "End addLocationRow() at WeatherDataSource()class");
        database.close();
    }

    public WeatherLocationData getWeatherLocationDetails(int CityId) {
        WeatherLocationData weatherLocationData = new WeatherLocationData();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.query(LocationEntry.DATABASE_NAME, locationColums, LocationEntry.COLUMN_CITY_ID + "=?",
                new String[]{String.valueOf(CityId)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            weatherLocationData = new WeatherLocationData(
                    cursor.getInt(WeatherData.LocationColumnID.COLUMN_CITY_ID),
                    cursor.getString(WeatherData.LocationColumnID.COLUMN_CITY_LAT),
                    cursor.getString(WeatherData.LocationColumnID.COLUMN_CITY_LON),
                    cursor.getDouble(WeatherData.LocationColumnID.COLUMN_CITY_NAME),
                    cursor.getDouble(WeatherData.LocationColumnID.COLUMN_COUNTRY_NAME));
        }
        database.close();
        return weatherLocationData;
    }

    public WeatherListData getWeatherDetails(int id) {
        WeatherListData weatherListData = new WeatherListData(); // Open database connection.
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.query(WeatherData.WeatherEntry.DATABASE_NAME, weatherColums, WeatherData.WeatherEntry.WEATHER_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            weatherListData = new WeatherListData(
                    Integer.parseInt(cursor.getString(WeatherData.WeatherColumnID.WEATHER_ID_COLUMN_ID)),
                    cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_DATE_OF_WEEK),
                    cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_DATE_OF_MONTH),
                    cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_MAX_TEMP),
                    cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_MIN_TEMP),
                    cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_PRESSURE),
                    cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_HUMIDITY),
                    cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_STATUS_MAIN),
                    cursor.getString(WeatherData.WeatherColumnID.COLUMN_ID_STATUS_DESCRIPTION),
                    cursor.getDouble(WeatherData.WeatherColumnID.COLUMN_ID_WIN_SPEED),
                    cursor.getInt(WeatherData.WeatherColumnID.COLUMN_ID_IMGATE_ID),
                    cursor.getInt(WeatherData.WeatherColumnID.COLUMN_ID_LOCATION));
        }

        database.close();
        return weatherListData;
    }

    public int getNumberWeatherItem() {
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<WeatherListData> weatherListDataArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + WeatherData.WeatherEntry.DATABASE_NAME;
        Cursor cursor = database.rawQuery(selectQuery, null);
        database.close();
        return cursor.getCount();

    }

    public ArrayList<WeatherListData> getAllWeartherData() {

        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<WeatherListData> weatherListDataArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + WeatherData.WeatherEntry.DATABASE_NAME;
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
                        cursor.getInt(WeatherData.WeatherColumnID.COLUMN_ID_IMGATE_ID),
                        cursor.getInt(WeatherData.WeatherColumnID.COLUMN_ID_LOCATION));
                weatherListDataArrayList.add(weatherListData);
            } while (cursor.moveToNext());
        }
        database.close();
        return weatherListDataArrayList;

    }

}

