package com.example.tm.recycleviewtest.model;


/**
 * Created by TM on 03/10/2016.
 */

public class WeatherListItemData {

    int id;
    String mCityName;
    Double mCityLon;
    Double mCityLat;
    String mDayofWeek;
    String mDayofMonth;
    double mMaxTemperure;
    double mMinTemperure;
    double mDatePressure;
    double mDateHumidity;
    String mDateStatusMain;
    String mDateStatusDescription;
    double mDateWindSpeed;
    int mImageItem;

    public WeatherListItemData(int id, String mCityName, Double mCityLon, Double mCityLat, String mDayofWeek,
                               String mDayofMonth, double mMaxTemperure, double mMinTemperure, double mDatePressure,
                               double mDateHumidity, String mDateStatusMain, String mDateStatusDescription,
                               double mDateWindSpeed, int mImageItem) {
        this.id = id;
        this.mCityName = mCityName;
        this.mCityLon = mCityLon;
        this.mCityLat = mCityLat;
        this.mDayofWeek = mDayofWeek;
        this.mDayofMonth = mDayofMonth;
        this.mMaxTemperure = mMaxTemperure;
        this.mMinTemperure = mMinTemperure;
        this.mDatePressure = mDatePressure;
        this.mDateHumidity = mDateHumidity;
        this.mDateStatusMain = mDateStatusMain;
        this.mDateStatusDescription = mDateStatusDescription;
        this.mDateWindSpeed = mDateWindSpeed;
        this.mImageItem = mImageItem;
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

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

    public String getmDayofWeek() {
        return mDayofWeek;
    }

    public void setmDayofWeek(String mDayofWeek) {
        this.mDayofWeek = mDayofWeek;
    }

    public String getmDayofMonth() {
        return mDayofMonth;
    }

    public void setmDayofMonth(String mDayofMonth) {
        this.mDayofMonth = mDayofMonth;
    }

    public double getmMaxTemperure() {
        return mMaxTemperure;
    }

    public void setmMaxTemperure(double mMaxTemperure) {
        this.mMaxTemperure = mMaxTemperure;
    }

    public double getmMinTemperure() {
        return mMinTemperure;
    }

    public void setmMinTemperure(double mMinTemperure) {
        this.mMinTemperure = mMinTemperure;
    }

    public double getmDatePressure() {
        return mDatePressure;
    }

    public void setmDatePressure(double mDatePressure) {
        this.mDatePressure = mDatePressure;
    }

    public double getmDateHumidity() {
        return mDateHumidity;
    }

    public void setmDateHumidity(double mDateHumidity) {
        this.mDateHumidity = mDateHumidity;
    }

    public String getmDateStatusMain() {
        return mDateStatusMain;
    }

    public void setmDateStatusMain(String mDateStatusMain) {
        this.mDateStatusMain = mDateStatusMain;
    }

    public String getmDateStatusDescription() {
        return mDateStatusDescription;
    }

    public void setGetmDateStatusDescription(String mDateStatusDescription) {
        this.mDateStatusDescription = mDateStatusDescription;
    }

    public double getmDateWindSpeed() {
        return mDateWindSpeed;
    }

    public void setmDateWindSpeed(double mDateWindSpeed) {
        this.mDateWindSpeed = mDateWindSpeed;
    }

    public int getmImageItem() {
        return mImageItem;
    }

    public void setmImageItem(int mImageItem) {
        this.mImageItem = mImageItem;
    }
}

