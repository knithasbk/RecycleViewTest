package com.example.tm.recycleviewtest.WeatherData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tm.recycleviewtest.WeatherData.WeatherData.WeatherEntry;

import com.example.tm.recycleviewtest.WeatherData.WeatherData.LocationEntry;
/**
 * Created by TM on 12/10/2016.
 */

public class WeatherDatabaseHelper extends SQLiteOpenHelper {



    public WeatherDatabaseHelper(Context context) {
        super(context, WeatherEntry.DATABASE_NAME, null, WeatherEntry.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_LOCATION_DATABASE =  "create tables " + LocationEntry.DATABASE_NAME + " ( "
                + LocationEntry.ID + " INTEGER PRIMARY KEY, "
                + LocationEntry.COLUMN_CITY_LAT + " REAL NOT NULL, "
                + LocationEntry.COLUMN_CITY_LON +" REAL NOT NULL, "
                + LocationEntry.COLUMN_CITY_NAME + "STRING"
                +LocationEntry.COLUMN_COUNTRY_NAME +"STRING"
                + " ) ";


        final String CREATE_WEATHER_DATABASE = "create tables " + WeatherEntry.DATABASE_NAME + " ( "
                + WeatherEntry.DATABASE_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WeatherEntry.COLUMN_DATE_OF_MONTH + " TEXT NOT NULL, "
                + WeatherEntry.COLUMN_DATE_OF_WEEK + " TEXT NOT NULL, "
                + WeatherEntry.COLUMN_HUMIDITY + " DOUBLE , "
                + WeatherEntry.COLUMN_MAX_TEMP + " DOUBLE , "
                + WeatherEntry.COLUMN_MIN_TEMP + " DOUBLE , "
                + WeatherEntry.COLUMN_IMGATE_ID + " INTEGER , "
                + WeatherEntry.COLUMN_DATE + " INTEGER , "
                + WeatherEntry.COLUMN_PRESSURE + " DOUBLE, "
                + WeatherEntry.COLUMN_WIN_SPEED + " DOUBLE NOT NULL, "
                + WeatherEntry.COLUMN_STATUS_DESCRIPTION + " TEXT NOT NULL, "
                + WeatherEntry.COLUMN_STATUS_MAIN + " TEXT NOT NULL, "
                + WeatherEntry.COLUMN_LOC_ID_SYNC + "INTEGER, "
                + "FOREIGN KEY ( " + WeatherEntry.COLUMN_LOC_ID_SYNC+ " ) REFERENCES " + LocationEntry.DATABASE_NAME +
                "( " + LocationEntry.ID +" ), UNIQUE ( " + WeatherEntry.COLUMN_DATE +","+ LocationEntry.ID+
                ") ON CONFLICT REPLACE);";


        db.execSQL(CREATE_WEATHER_DATABASE);
        db.execSQL(CREATE_LOCATION_DATABASE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.e ("EXECUTE"," Delete old DB version " + oldVersion + "create a new DB  version " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + WeatherEntry.DATABASE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LocationEntry.DATABASE_NAME);
        onCreate(db);
    }


}
