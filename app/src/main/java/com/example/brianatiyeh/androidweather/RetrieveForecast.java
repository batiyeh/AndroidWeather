package com.example.brianatiyeh.androidweather;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Brian Atiyeh on 10/4/2016.
 */

public class RetrieveForecast extends AsyncTask<Double, Void, ArrayList<Weather>>{

    @Override
    protected ArrayList<Weather> doInBackground(Double... params) {
        ArrayList<Weather> list = new ArrayList<Weather>();

        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?lat=" + params[0] + "&lon=" + params[1] + "&units=imperial&cnt=7");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    private ArrayList<Weather> parseJSON(String json) throws JSONException {
        ArrayList<Weather> forecast = new ArrayList<Weather>();
        JSONArray jsonArray = new JSONObject(json).getJSONArray("list");

        for(int i = 0; i < jsonArray.length(); i++) {
            Weather weather = new Weather();

            // Make a new JSONObject called jsonDay which is our returned data
            JSONObject jsonDay = jsonArray.getJSONObject(i);
            weather.setTimestamp(jsonDay.getInt("dt"));
            weather.setHigh(jsonDay.getJSONObject("temp").getDouble("max"));
            weather.setLow(jsonDay.getJSONObject("temp").getDouble("min"));

            JSONObject jsonWeather = jsonDay.getJSONArray("weather").getJSONObject(0);
            weather.setWeather(jsonWeather.getString("main"));
            forecast.add(weather);
        }

        return forecast;
    }

    private String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null) {
            builder.append(line);
        }

        return builder.toString();
    }

}
