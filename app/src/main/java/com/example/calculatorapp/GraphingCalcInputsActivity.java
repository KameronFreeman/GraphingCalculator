package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.calculatorapp.graphingActivity;

public class GraphingCalcInputsActivity extends AppCompatActivity {
    public static int m;
    public static int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphing_calc_inputs);


        Button graphButton = (Button) findViewById(R.id.graphButton);
        final EditText linearEquation = (EditText) findViewById(R.id.linearEquationEditText);

        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                m = Integer.parseInt(linearEquation.getText().toString().substring(0,1));
                int length = linearEquation.getText().toString().length();
                b = Integer.parseInt(linearEquation.getText().toString().substring(length - 1));


                Intent graphingCalculatorScreen = new Intent(GraphingCalcInputsActivity.this,
                        graphingActivity.class);
                startActivity(graphingCalculatorScreen);

                //enter graphing calculator screen
            }
        });

    }
}