package com.example.tm.recycleviewtest.SettingsDatabase;

/**
 * Created by TM on 19/10/2016.
 */

public class SetttingsData {
    private String temperatureMetricType;
    private int CityId;

    public String getTemperatureMetricType() {
        return temperatureMetricType;
    }

    public void setTemperatureMetricType(String temperatureMetricType) {
        this.temperatureMetricType = temperatureMetricType;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }
}
