package com.example.myfirsttestapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    Map<String, Double> map;
    List<String> fruitNames;
    List<Double> fruitPrices;

    public SQLItemAdapter(Context c,Map map){
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.map = map;
        fruitNames = new ArrayList<String>(map.keySet());
        fruitPrices = new ArrayList<Double>(map.keySet());
    }

    @Override
    public int getCount(){
        return map.size();
    }

    @Override
    public Object getItem(int position){
        return fruitNames.get(position);

    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = mInflater.inflate(R.layout.sql_item_layout, null);
        TextView sqlItemNameTextView = (TextView) v.findViewById(R.id.SQLItemNameTextView);
        TextView sqlItemPriceTextView = (TextView) v.findViewById(R.id.SQLItemPriceTextView);

        sqlItemNameTextView.setText(fruitNames.get(position));
        sqlItemPriceTextView.setText("€ " + fruitPrices.get(position).toString());

        return v;
    }
}
