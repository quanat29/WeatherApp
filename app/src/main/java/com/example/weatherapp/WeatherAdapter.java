package com.example.weatherapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {
    //Ngữ cảnh của ứng dụng sử dụng Adapter
    private Activity activity;
    //Nguồn dữ liệu cho Adapter
    private ArrayList<Weather> data;
    //Sao lưu nguồn dữ liệu cho Adapter
    private ArrayList<Weather> databackup;
    //Đối tượng inflater để tách layout

    public ArrayList<Weather> getDatabackup() {
        return databackup;
    }

    private LayoutInflater inflater;

    public void setData(ArrayList<Weather> data) {
        this.data = data;
    }

    public WeatherAdapter(Activity activity, ArrayList<Weather> data) {
        this.activity = activity;
        this.data = data;
        inflater = (LayoutInflater)activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null)
            v=inflater.inflate(R.layout.item_city,null);
        TextView tvCity=v.findViewById(R.id.tv_city);
        tvCity.setText(data.get(i).getCity());
        TextView tvDt=v.findViewById(R.id.tv_detail);
        tvDt.setText(data.get(i).getDetail());
        TextView tvTemp=v.findViewById(R.id.tv_temp);
        tvTemp.setText(data.get(i).getTemp());
        return v;
    }
}
