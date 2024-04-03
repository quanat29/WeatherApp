package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    ListView lvCity;
    ArrayAdapter<String> adapter;
    SearchView searchView;
    ArrayList<String> dsCity= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        addControls();
        searchView=findViewById(R.id.search_bar_2);
        //filter tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void addControls() {
        lvCity=findViewById(R.id.lv_city);
        dsCity.addAll(Arrays.asList(getResources().getStringArray(R.array.arrtinhthanh)));
        adapter=new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,dsCity
        );
        lvCity.setAdapter(adapter);
    }
}