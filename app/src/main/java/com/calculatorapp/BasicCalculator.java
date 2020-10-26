package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatorapp.R;

public class BasicCalculator extends AppCompatActivity {
    // Logic: create a string of input characters based on button clicks for computations
    // if 0-9 or decimal pressed, add them to screen
    // if


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);

        //button variables
        Button oneButtonBC = (Button) findViewById(R.id.zeroButtonBC);
        Button twoButtonBC = (Button) findViewById(R.id.twoButtonBC);
        Button threeButtonBC = (Button) findViewById(R.id.threeButtonBC);
        Button fourButtonBC = (Button) findViewById(R.id.fourButtonBC);
        Button fiveButtonBC = (Button) findViewById(R.id.fiveButtonBC);
        Button sixButtonBC = (Button) findViewById(R.id.sixButtonBC);
        Button sevenButtonBC = (Button) findViewById(R.id.sevenButtonBC);
        Button eightButtonBC = (Button) findViewById(R.id.eightButtonBC);
        Button nineButtonBC = (Button) findViewById(R.id.nineButtonBC);
        Button zeroButtonBC = (Button) findViewById(R.id.zeroButtonBC);
        Button decimalButtonBC = (Button) findViewById(R.id.decimalButtonBC);
        Button backButtonBC = (Button) findViewById(R.id.backButtonBC);
        Button clearButtonBC = (Button) findViewById(R.id.clearButtonBC);
        Button totalButtonBC = (Button) findViewById(R.id.totalButtonBC);
        Button addButtonBC = (Button) findViewById(R.id.addButtonBC);
        Button subtractButtonBC = (Button) findViewById(R.id.subtractButtonBC);
        Button multiplyButtonBC = (Button) findViewById(R.id.multiplyButtonBC);
        Button divideButtonBC = (Button) findViewById(R.id.divideButtonBC);

        //initialize text box
        final TextView textOutputBC = (TextView) findViewById(R.id.textOutputBC);

        //if back button pressed ... return to main menu
        backButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });

        //if one button pressed ...
        oneButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText("1");
            }
        });

        //if two button pressed ...
        twoButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if three button pressed ...
        threeButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if four button pressed ...
        fourButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if five button pressed ...
        fiveButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if six button pressed ...
        sixButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if seven button pressed ...
        sevenButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if eight button pressed ...
        eightButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if nine button pressed ...
        nineButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if zero button pressed ...
        zeroButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if decimal button pressed ...
        decimalButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if clear button pressed ... clear screen
        clearButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if total button pressed ...
        totalButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if add button pressed ...
        addButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if subtract button pressed ...
        subtractButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if multiply button pressed ...
        multiplyButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //if divide button pressed ...
        divideButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}