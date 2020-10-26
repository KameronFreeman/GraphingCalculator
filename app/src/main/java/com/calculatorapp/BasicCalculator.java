package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatorapp.R;

public class BasicCalculator extends AppCompatActivity {

    //NEXT UPDATE: Revamp xml screen, fix leading zeros

    float one, two;
    boolean Add, Sub, Multi, Div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);


        //button variables
        Button oneButtonBC = (Button) findViewById(R.id.oneButtonBC);
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
                textOutputBC.setText(textOutputBC.getText()+"1");
            }
        });

        //if two button pressed ...
        twoButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText(textOutputBC.getText()+"2");
            }
        });

        //if three button pressed ...
        threeButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText(textOutputBC.getText()+"3");
            }
        });

        //if four button pressed ...
        fourButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText(textOutputBC.getText()+"4");
            }
        });

        //if five button pressed ...
        fiveButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText(textOutputBC.getText()+"5");
            }
        });

        //if six button pressed ...
        sixButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText(textOutputBC.getText()+"6");
            }
        });

        //if seven button pressed ...
        sevenButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText(textOutputBC.getText()+"7");
            }
        });

        //if eight button pressed ...
        eightButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText(textOutputBC.getText()+"8");
            }
        });

        //if nine button pressed ...
        nineButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText(textOutputBC.getText()+"9");
            }
        });

        //if zero button pressed ...
        zeroButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textOutputBC.getText() == "0"); //no repeating zeros
                else textOutputBC.setText(textOutputBC.getText()+"0");
            }
        });

        //if decimal button pressed ...
        decimalButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText(textOutputBC.getText()+".");
            }
        });

        //if clear button pressed ...
        clearButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOutputBC.setText("");
            }
        });

        //if add button pressed ...
        addButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textOutputBC == null) textOutputBC.setText("");
                else {
                    one = Float.parseFloat(textOutputBC.getText()+"");
                    Add = true;
                    textOutputBC.setText(null);
                }
            }
        });

        //if subtract button pressed ...
        subtractButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one = Float.parseFloat(textOutputBC.getText() + "");
                Sub = true;
                textOutputBC.setText(null);
            }
        });

        //if multiply button pressed ...
        multiplyButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one = Float.parseFloat(textOutputBC.getText() + "");
                Multi = true;
                textOutputBC.setText(null);
            }
        });

        //if divide button pressed ...
        divideButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one = Float.parseFloat(textOutputBC.getText() + "");
                Div = true;
                textOutputBC.setText(null);
            }
        });

        //if total button pressed ...
        totalButtonBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                two = Float.parseFloat(textOutputBC.getText() + "");

                if(Add == true){
                    textOutputBC.setText(one + two + "");
                    Add = false;
                }
                if(Sub == true){
                    textOutputBC.setText(one - two + "");
                    Sub = false;
                }
                if(Multi == true){
                    textOutputBC.setText(one * two + "");
                    Multi = false;
                }
                if(Div == true){
                    textOutputBC.setText(one / two + "");
                    Div = false;
                }
            }
        });
    }
}