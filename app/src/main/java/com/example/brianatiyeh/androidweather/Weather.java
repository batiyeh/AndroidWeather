package com.example.brianatiyeh.androidweather;

/**
 * Created by Brian Atiyeh on 10/4/2016.
 */

public class Weather {
    private double high;
    private double low;
    private String weather;
    private long timestamp;

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
