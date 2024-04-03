package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class CityActivity extends AppCompatActivity {

        SearchView searchView;
        private WeatherAdapter wadap;
        private ArrayList<Weather> listWeather;
        private ListView lvWeather;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_city);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");


            //searchview
            searchView = (SearchView) findViewById(R.id.search_bar_1);
            searchView.setOnSearchClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(CityActivity.this, SearchActivity.class));
                }
            });
            //listCityWeather
            lvWeather = findViewById(R.id.lst_city);
            wadap = new WeatherAdapter(this, getListWeather());
            lvWeather.setAdapter(wadap);

        }

        private ArrayList<Weather> getListWeather() {
            ArrayList<Weather> list = new ArrayList<>();
            list.add(new Weather("Hanoi", "20-27", "24"));
            list.add(new Weather("Hanoi", "20-27", "24"));
            list.add(new Weather("Hanoi", "20-27", "24"));
            return list;
        }

    }