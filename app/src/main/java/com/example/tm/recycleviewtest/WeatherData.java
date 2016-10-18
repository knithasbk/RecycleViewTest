package com.example.tm.recycleviewtest;

/**
 * Created by TM on 10/10/2016.
 */

public class WeatherData {

    final public static String JSON_STRING = "{\"city\":{\"id\":524901,\"name\":\"Moscow\",\"coord\":{\"lon\":37.615555,\"lat\":55.75222},\"country\":\"RU\",\"population\":0},\"cod\":\"200\",\"message\":0.3251,\"cnt\":16,\"list\":[{\"dt\":1476090000,\"temp\":{\"day\":277.9,\"min\":273.64,\"max\":277.9,\"night\":273.64,\"eve\":276.26,\"morn\":277.9},\"pressure\":1020.12,\"humidity\":71,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"speed\":6.46,\"deg\":73,\"clouds\":0},{\"dt\":1476176400,\"temp\":{\"day\":276.36,\"min\":270.1,\"max\":277.22,\"night\":270.1,\"eve\":274.63,\"morn\":271.5},\"pressure\":1025.33,\"humidity\":81,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":3.41,\"deg\":73,\"clouds\":36},{\"dt\":1476262800,\"temp\":{\"day\":276.92,\"min\":273.11,\"max\":277.34,\"night\":273.42,\"eve\":274.9,\"morn\":273.21},\"pressure\":1026.64,\"humidity\":90,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":2.56,\"deg\":341,\"clouds\":68,\"rain\":0.24},{\"dt\":1476349200,\"temp\":{\"day\":276.06,\"min\":272.39,\"max\":277.04,\"night\":275.12,\"eve\":276.12,\"morn\":272.39},\"pressure\":1020.4,\"humidity\":95,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":2.61,\"deg\":326,\"clouds\":76,\"rain\":0.47},{\"dt\":1476435600,\"temp\":{\"day\":278.29,\"min\":274.58,\"max\":278.29,\"night\":277.86,\"eve\":277.81,\"morn\":274.58},\"pressure\":1010.52,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":5.54,\"deg\":318,\"clouds\":85,\"rain\":0.71},{\"dt\":1476522000,\"temp\":{\"day\":278.62,\"min\":275.81,\"max\":278.62,\"night\":275.81,\"eve\":276.82,\"morn\":277.72},\"pressure\":1008.97,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":9.58,\"deg\":352,\"clouds\":72,\"rain\":0.92},{\"dt\":1476608400,\"temp\":{\"day\":277.78,\"min\":270.37,\"max\":277.78,\"night\":270.37,\"eve\":274.47,\"morn\":275.72},\"pressure\":1015.87,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":6.83,\"deg\":350,\"clouds\":65,\"rain\":0.31},{\"dt\":1476694800,\"temp\":{\"day\":277.98,\"min\":272.53,\"max\":277.98,\"night\":276.67,\"eve\":276.13,\"morn\":272.53},\"pressure\":1016.36,\"humidity\":0,\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"speed\":6.34,\"deg\":274,\"clouds\":45,\"snow\":0.04},{\"dt\":1476781200,\"temp\":{\"day\":278.83,\"min\":276.16,\"max\":278.83,\"night\":278.41,\"eve\":278.01,\"morn\":276.16},\"pressure\":1008.96,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":6.92,\"deg\":272,\"clouds\":98,\"rain\":0.78},{\"dt\":1476867600,\"temp\":{\"day\":284.84,\"min\":278.19,\"max\":284.84,\"night\":282.71,\"eve\":283.9,\"morn\":278.19},\"pressure\":1004.87,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"speed\":7.19,\"deg\":241,\"clouds\":15},{\"dt\":1476954000,\"temp\":{\"day\":287.77,\"min\":283.55,\"max\":287.77,\"night\":283.55,\"eve\":285.08,\"morn\":283.66},\"pressure\":1004.15,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":7.04,\"deg\":224,\"clouds\":61},{\"dt\":1477040400,\"temp\":{\"day\":286.78,\"min\":282.74,\"max\":286.78,\"night\":284.72,\"eve\":284.76,\"morn\":282.74},\"pressure\":1005.96,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":5.48,\"deg\":176,\"clouds\":49},{\"dt\":1477126800,\"temp\":{\"day\":290.78,\"min\":286.76,\"max\":290.78,\"night\":288.59,\"eve\":289.83,\"morn\":286.76},\"pressure\":1001.93,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"speed\":6.96,\"deg\":177,\"clouds\":68,\"rain\":0.58,\"snow\":0.01},{\"dt\":1477213200,\"temp\":{\"day\":291.66,\"min\":286.62,\"max\":291.66,\"night\":286.62,\"eve\":288.7,\"morn\":288.91},\"pressure\":999.75,\"humidity\":0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":9.43,\"deg\":175,\"clouds\":6,\"rain\":3.54},{\"dt\":1477299600,\"temp\":{\"day\":281.8,\"min\":280.35,\"max\":282.12,\"night\":281.06,\"eve\":280.35,\"morn\":282.12},\"pressure\":1004.02,\"humidity\":0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":5.69,\"deg\":277,\"clouds\":38,\"rain\":6.35},{\"dt\":1477386000,\"temp\":{\"day\":281.06,\"min\":281.06,\"max\":281.06,\"night\":281.06,\"eve\":281.06,\"morn\":281.06},\"pressure\":1002.98,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":6.53,\"deg\":216,\"clouds\":98,\"rain\":0.42}]}";


    final int DATE_NUMBER = 16;
    final String BASIC_URL = "http://api.openweathermap.org/data/2.5/forecast/city?id=";
    final String APPID = "&APPID=";
    final String DATE_QUERY = "&cnt=";
    final String USER_ID = "1f9ed645ac85d117e32bdc1492a7cef6";

    // JSON Item list
    final String CITY_NAME = "name";
    final String CITY_ID = "id";
    final String COORD = "coord";
    final String COORD_LON = "lon";
    final String COORD_LAT = "lat";
    final String COUNTRY_NAME = "country";


    // JSON Weather parameters
    final String JSON_WEATHER_LIST_PARAMETERS = "list";
    final String JSON_WEATHER_LIST_PARAMETERS_MAX = "max";
    final String JSON_WEATHER_LIST_PARAMETERS_MIN = "min";
    final String JSON_TEMPRATURE_DAY = "temp";
    final String JSON_PRESSURE_DATE = "pressure";
    final String JSON_HUMIDITY_DAY = "humidity";
    final String JSON_WEATHER_LIST_STATUS = "weather";
    final String JSON_WIND_SPEED = "speed";
    final String JSON_WEATHER_LIST_STATUS_MAIN = "main";
    final String JSON_WEATHER_LIST_STATUS_DESCRIPTION = "description";
    final String JSON_WEATHER_LIST_STATUS_ICON = "icon";


    public static final class LocationEntry{
      public static final String DATABASE_NAME = "location_db";
        public static final String ID = "id";
        public static final String COLUMN_CITY_LON = "city_lon";
        public static final String COLUMN_CITY_LAT = "city_lat";
        public static final String COLUMN_CITY_NAME = "city_name";
        public static final String COLUMN_COUNTRY_NAME = "country_name";


    }

    // SQLite DATABASE Parameters Weather

    public static final  class WeatherEntry {
        public static final String WEATHER_ID = "_id";
        public static final String COLUMN_DATE = "weather_date";
        public static final String DATABASE_NAME = "weather_db";
        public static final String COLUMN_DATE_OF_WEEK = "day_of_week";
        public static final String COLUMN_DATE_OF_MONTH = "day_of_month";
        public static final String COLUMN_MAX_TEMP = "max_temp";
        public static final String COLUMN_MIN_TEMP = "min_temp";
        public static final String COLUMN_PRESSURE = "pressure";
        public static final String COLUMN_HUMIDITY = "humidity";
        public static final String COLUMN_STATUS_MAIN = "status_main";
        public static final String COLUMN_STATUS_DESCRIPTION = "status_description";
        public static final String COLUMN_WIN_SPEED = "wind_speed";
        public static final String COLUMN_IMGATE_ID = "image_id";
        public static final int DATABASE_VERSION = 1;
        public static final String COLUMN_LOC_ID_SYNC = "location_id";

    }


}
