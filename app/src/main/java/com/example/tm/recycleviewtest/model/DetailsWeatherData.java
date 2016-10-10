package com.example.tm.recycleviewtest.model;

/**
 * Created by TM on 10/10/2016.
 */

public class DetailsWeatherData {
    String mTextViewDetailsDayofWeek;
    String mTextViewDetailsDayofMonth;
    double mDetailsMaxTemperure;
    double mDetailMinTemperure;
    String mDetailDateStatus;
    double mDetailsDatePressure;
    double mDetailsDateWindSpeed;
    double mDetailDateHumidity;
    int mImageViewItemDetails;

    public DetailsWeatherData(String mTextViewDetailsDayofWeek, String mTextViewDetailsDayofMonth,
                              double mDetailsMaxTemperure, double mDetailMinTemperure, String mDetailDateStatus,
                              double mDetailsDatePressure, double mDetailsDateWindSpeed, double mDetailDateHumidity,
                              int mImageViewItemDetails) {
        this.mTextViewDetailsDayofWeek = mTextViewDetailsDayofWeek;
        this.mTextViewDetailsDayofMonth = mTextViewDetailsDayofMonth;
        this.mDetailsMaxTemperure = mDetailsMaxTemperure;
        this.mDetailMinTemperure = mDetailMinTemperure;
        this.mDetailDateStatus = mDetailDateStatus;
        this.mDetailsDatePressure = mDetailsDatePressure;
        this.mDetailsDateWindSpeed = mDetailsDateWindSpeed;
        this.mDetailDateHumidity = mDetailDateHumidity;
        this.mImageViewItemDetails = mImageViewItemDetails;
    }

    public String getmTextViewDetailsDayofWeek() {
        return mTextViewDetailsDayofWeek;
    }

    public void setmTextViewDetailsDayofWeek(String mTextViewDetailsDayofWeek) {
        this.mTextViewDetailsDayofWeek = mTextViewDetailsDayofWeek;
    }

    public String getmTextViewDetailsDayofMonth() {
        return mTextViewDetailsDayofMonth;
    }

    public void setmTextViewDetailsDayofMonth(String mTextViewDetailsDayofMonth) {
        this.mTextViewDetailsDayofMonth = mTextViewDetailsDayofMonth;
    }

    public double getmDetailsMaxTemperure() {
        return mDetailsMaxTemperure;
    }

    public void setmDetailsMaxTemperure(double mDetailsMaxTemperure) {
        this.mDetailsMaxTemperure = mDetailsMaxTemperure;
    }

    public double getmDetailMinTemperure() {
        return mDetailMinTemperure;
    }

    public void setmDetailMinTemperure(double mDetailMinTemperure) {
        this.mDetailMinTemperure = mDetailMinTemperure;
    }

    public String getmDetailDateStatus() {
        return mDetailDateStatus;
    }

    public void setmDetailDateStatus(String mDetailDateStatus) {
        this.mDetailDateStatus = mDetailDateStatus;
    }

    public double getmDetailsDatePressure() {
        return mDetailsDatePressure;
    }

    public void setmDetailsDatePressure(double mDetailsDatePressure) {
        this.mDetailsDatePressure = mDetailsDatePressure;
    }

    public double getmDetailsDateWindSpeed() {
        return mDetailsDateWindSpeed;
    }

    public void setmDetailsDateWindSpeed(double mDetailsDateWindSpeed) {
        this.mDetailsDateWindSpeed = mDetailsDateWindSpeed;
    }

    public double getmDetailDateHumidity() {
        return mDetailDateHumidity;
    }

    public void setmDetailDateHumidity(double mDetailDateHumidity) {
        this.mDetailDateHumidity = mDetailDateHumidity;
    }

    public int getmImageViewItemDetails() {
        return mImageViewItemDetails;
    }

    public void setmImageViewItemDetails(int mImageViewItemDetails) {
        this.mImageViewItemDetails = mImageViewItemDetails;
    }
}
