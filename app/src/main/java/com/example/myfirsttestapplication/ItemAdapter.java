package com.example.myfirsttestapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    public ItemAdapter(Context c, String[] shoppingItems, String[] prices, String[] descriptions){
        this.shoppingItems = shoppingItems;
        this.prices = prices;
        this.descriptions = descriptions;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    LayoutInflater mInflater;
    String[] shoppingItems;
    String[] prices;
    String[] descriptions;

    @Override
    public int getCount() {
        return shoppingItems.length;
    }

    @Override
    public Object getItem(int i) {
        return shoppingItems[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

        String name = shoppingItems[i];
        String description = descriptions[i];
        String price = prices[i];

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        priceTextView.setText(price);

        return v;
    }
}
