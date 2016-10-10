package com.example.tm.recycleviewtest.WeatherData;

/**
 * Created by TM on 04/10/2016.
 */

public class WeatherData {
    final public String WEATHER_ID = "1f9ed645ac85d117e32bdc1492a7cef6";

    package com.example.tm.recycleviewtest.model;

    /**
     * Created by TM on 03/10/2016.
     */

    public class WeatherListItem {
        public String textViewDayStatus;
        public String textViewDay;
        public String textViewtemperature;
        public int imageViewItem;
        public WeatherListItem(String textViewDayStatus,String textViewDay,String textViewtemperature,int imageViewItem){
            this.textViewDay = textViewDay;
            this.textViewDayStatus = textViewDayStatus;
            this.textViewtemperature =textViewtemperature;
            this.imageViewItem = imageViewItem;

        }

        public String getTextViewDayStatus() {
            return textViewDayStatus;
        }

        public void setTextViewDayStatus(String textViewDayStatus) {
            this.textViewDayStatus = textViewDayStatus;
        }

        public String getTextViewDay() {
            return textViewDay;
        }

        public void setTextViewDay(String textViewDay) {
            this.textViewDay = textViewDay;
        }

        public String getTextViewtemperature() {
            return textViewtemperature;
        }

        public void setTextViewtemperature(String textViewtemperature) {
            this.textViewtemperature = textViewtemperature;
        }

        public int getImageViewItem() {
            return imageViewItem;
        }

        public void setImageViewItem(int imageViewItem) {
            this.imageViewItem = imageViewItem;
        }
    }
     */
}