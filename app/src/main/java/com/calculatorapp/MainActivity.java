package com.calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.example.calculatorapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button variables
        Button basicCalc_Button = (Button) findViewById(R.id.basicCalc_Button);
        Button stepByStep_Button = (Button) findViewById(R.id.stepByStep_Button);
        Button graphingCalc_Button = (Button) findViewById(R.id.graphingCalc_Button);
        Button hgcButton = (Button) findViewById(R.id.hgcButton);

        //if Basic Calc Button pressed ...
        basicCalc_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enter the basic calculator screen
                Intent bcIntent = new Intent(getApplicationContext(), BasicCalculator.class );
                startActivity(bcIntent);
            }
        });

        //if Step by Step Button pressed ...
        stepByStep_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enter the step by step screen
                Intent sbsIntent = new Intent(getApplicationContext(), StepbystepMenu.class);
                startActivity(sbsIntent);
            }
        });

        //if Graphing Calculator Button pressed...
        graphingCalc_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent graphingCalculatorInputScreen = new Intent(MainActivity.this,
                                                GraphingCalcInputsActivity.class);
                startActivity(graphingCalculatorInputScreen);

                //enter graphing calculator screen
            }
        });

        //if Hypergeometric Calculator Button pressed...
        hgcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Enter hypergeometric calculator screen.
                Intent hgcIntent = new Intent(getApplicationContext(), HyperGeoCalc.class);
                startActivity(hgcIntent);
            }
        });
    }
}
