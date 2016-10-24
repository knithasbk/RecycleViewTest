package com.example.tm.recycleviewtest.SQLiteDatabase;

/**
 * Created by TM on 18/10/2016.
 */

public class WeatherLocationData {
    int CityId;
    String mCityName;
    Double mCityLon;
    Double mCityLat;
    String mContryName;

    public WeatherLocationData() {

    }

    public WeatherLocationData(String mCityName, String mContryName, Double mCityLon, Double mCityLat) {
        this.mCityName = mCityName;
        this.mCityLon = mCityLon;
        this.mCityLat = mCityLat;
        this.mContryName = mContryName;
    }

    public WeatherLocationData(int  CityId, String mCityName, String mContryName, Double mCityLon, Double mCityLat) {
        this.CityId = CityId;
        this.mCityName = mCityName;
        this.mCityLon = mCityLon;
        this.mCityLat = mCityLat;
        this.mContryName = mContryName;
    }
    public int getCityId(){
        return CityId;
    }
    public void setCityId(int CityId){
        this.CityId = CityId;
    }

    public String getmCityName() {
        return mCityName;
    }

    public void setmCityName(String mCityName) {
        this.mCityName = mCityName;
    }

    public Double getmCityLon() {
        return mCityLon;
    }

    public void setmCityLon(Double mCityLon) {
        this.mCityLon = mCityLon;
    }

    public Double getmCityLat() {
        return mCityLat;
    }

    public void setmCityLat(Double mCityLat) {
        this.mCityLat = mCityLat;
    }

    public String getmContryName() {
        return mContryName;
    }

    public void setmContryName(String mContryName) {
        this.mContryName = mContryName;
    }
}
