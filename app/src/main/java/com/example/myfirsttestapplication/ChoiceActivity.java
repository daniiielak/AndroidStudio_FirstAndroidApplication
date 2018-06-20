package com.example.myfirsttestapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        final String USER_NAME = "dear user";

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        System.out.println("passed 1");

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        System.out.println("passed 2");
        System.out.println(message);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView6);
        System.out.println("passed 3");

        textView.setText(message);
        System.out.println("passed 4");


        // Button to launch calculator.
        Button calculatorButton = (Button) findViewById(R.id.calculatorButton);
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calcSwitchIntent = new Intent(getApplicationContext(), CalculatorMain.class);
                startActivity(calcSwitchIntent);
            }
        });

        // Button to launch Google Search outside of the app within a browser
        Button googleSearchButton = (Button) findViewById(R.id.googleSearchButton);
        googleSearchButton.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                String googleSite = "https://www.google.ie/";
                Uri googleSiteUri = Uri.parse(googleSite);
                Intent googleSearchSwitchIntent = new Intent(Intent.ACTION_VIEW, googleSiteUri);

                if(googleSearchSwitchIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(googleSearchSwitchIntent);
                }

            }

        });

        // Button to launch Shopping List
        Button shoppingListButton = (Button) findViewById(R.id.shoppingListButton);
        shoppingListButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent shoppingListSwitchIntent = new Intent(getApplicationContext(), ShoppingList.class);
                startActivity(shoppingListSwitchIntent);
            }

        });
    }
}
