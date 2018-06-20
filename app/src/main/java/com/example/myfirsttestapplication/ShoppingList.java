package com.example.myfirsttestapplication;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ShoppingList extends AppCompatActivity {

    ListView myShoppingList;
    String[] shoppingItems;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        Resources res = getResources();

        myShoppingList = (ListView) findViewById(R.id.shoppingListView);
        shoppingItems = res.getStringArray(R.array.shoppingItems);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this, shoppingItems, prices, descriptions);
        myShoppingList.setAdapter(itemAdapter);

    }
}
