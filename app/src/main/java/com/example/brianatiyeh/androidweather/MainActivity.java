package com.example.brianatiyeh.androidweather;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import static com.example.brianatiyeh.androidweather.R.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(Color.WHITE);
        ListView listView = (ListView) findViewById(id.listView);

        RetrieveForecast task = new RetrieveForecast(this);
        task.execute(51.5072, -0.1275);

    }
}
