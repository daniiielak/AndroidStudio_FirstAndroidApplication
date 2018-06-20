package com.example.myfirsttestapplication;

import android.content.Intent;
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


        // (this, CalculatorMain.class);
        Button calculatorButton = (Button) findViewById(R.id.calculatorButton);
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calcSwitchIntent = new Intent(getApplicationContext(), CalculatorMain.class);
                startActivity(calcSwitchIntent);
            }
        });
    }
}
