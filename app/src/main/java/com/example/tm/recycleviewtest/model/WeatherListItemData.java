package com.example.tm.recycleviewtest.model;


/**
 * Created by TM on 03/10/2016.
 */

public class WeatherListItemData {
    String mTextViewItemTimeDayofWeek;
    float mTextViewItemTemperature;
    String mTextViewItemDayStatus;
    int mTextViewItemDayOfMonth;
    int mImageViewItem;


    public WeatherListItemData(String mTextViewItemTimeDayofWeek, float mTextViewItemTemperature,
                               String mTextViewItemDayStatus, int mTextViewItemDayOfMonth, int mImageViewItem) {
        this.mTextViewItemTimeDayofWeek = mTextViewItemTimeDayofWeek;
        this.mTextViewItemTemperature = mTextViewItemTemperature;
        this.mTextViewItemDayStatus = mTextViewItemDayStatus;
        this.mTextViewItemDayOfMonth = mTextViewItemDayOfMonth;
        this.mImageViewItem = mImageViewItem;

            }

    public String getmTextViewItemTimeDayofWeek() {
        return mTextViewItemTimeDayofWeek;
    }

    public void setmTextViewItemTimeDayofWeek(String mTextViewItemTimeDayofWeek) {
        this.mTextViewItemTimeDayofWeek = mTextViewItemTimeDayofWeek;
    }

    public float getmTextViewItemTemperature() {
        return mTextViewItemTemperature;
    }

    public void setmTextViewItemTemperature(float mTextViewItemTemperature) {
        this.mTextViewItemTemperature = mTextViewItemTemperature;
    }

    public String getmTextViewItemDayStatus() {
        return mTextViewItemDayStatus;
    }

    public void setmTextViewItemDayStatus(String mTextViewItemDayStatus) {
        this.mTextViewItemDayStatus = mTextViewItemDayStatus;
    }

    public int getmTextViewItemDayOfMonth() {
        return mTextViewItemDayOfMonth;
    }

    public void setmTextViewItemDayOfMonth(int mTextViewItemDayOfMonth) {
        this.mTextViewItemDayOfMonth = mTextViewItemDayOfMonth;
    }

    public int getmImageViewItem() {
        return mImageViewItem;
    }

    public void setmImageViewItem(int mImageViewItem) {
        this.mImageViewItem = mImageViewItem;
    }
}
