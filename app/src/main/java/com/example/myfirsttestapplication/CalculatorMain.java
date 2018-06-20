package com.example.myfirsttestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);


        Button addbtn = (Button) findViewById(R.id.addbtn);
        addbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputNum1EditText = (EditText) findViewById(R.id.inputNum1EditText);
                EditText inputNum2EditText = (EditText) findViewById(R.id.inputNum2EditText);
                TextView resultView = (TextView) findViewById(R.id.resultView);

                int num1, num2, result;
                num1 = Integer.parseInt(inputNum1EditText.getText().toString());
                num2 = Integer.parseInt(inputNum2EditText.getText().toString());

                result = num1 + num2;

                resultView.setText(result + "");


            }
        });
/*
        Button backButton = (Button) findViewById(R.id.backButtonCalc);
        backButton.setOnClickListener(new View.OnClickListener() {
               Intent choiceSwitchIntent = new Intent(this, ChoiceActivity.class);
                startActivity(choiceSwitchIntent);
        }); */

        }

        public void goBack(View view){
            Intent choiceSwitchIntent = new Intent(this, ChoiceActivity.class);
            startActivity(choiceSwitchIntent);
        }

    }
