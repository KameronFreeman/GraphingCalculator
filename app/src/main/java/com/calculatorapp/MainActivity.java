package com.calculatorapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import com.example.calculatorapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button variables
        Button basicCalc_Button = (Button) findViewById(R.id.basicCalc_Button);
        Button stepByStep_Button = (Button) findViewById(R.id.stepByStep_Button);

        //if Basic Calc Button pressed ...
        basicCalc_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enter the basic calculator screen
            }
        });

        //if Step by Step Button pressed ...
        stepByStep_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enter the step by step screen
            }
        });
    }
}