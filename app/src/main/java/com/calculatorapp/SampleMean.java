package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatorapp.R;

import java.util.ArrayList;

public class SampleMean extends AppCompatActivity {

    //Initializes variables.
    private ArrayList<Double> values = new ArrayList<>();
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_mean);

        //Initialize Buttons.
        Button backButtonSM = (Button) findViewById(R.id.backButtonSM);
        Button negativeButtonSM = (Button) findViewById(R.id.negativeButtonSM);
        Button clearButtonSM = (Button) findViewById(R.id.clearButtonSM);
        Button addButtonSM = (Button) findViewById(R.id.addButtonSM);

        //Initializes Text Boxes.
        final TextView inputTextSM = (TextView) findViewById(R.id.inputTextSM);
        final TextView outputTextSM = (TextView) findViewById(R.id.outputTextSD);

        //Returns to the step-by-step menu.
        backButtonSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(getApplicationContext(), StepbystepMenu.class);
                startActivity(menuIntent);
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = inputTextSM.getText().toString();
                if (temp.matches("") == false) {
                    outputTextSM.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextSM.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextSM.setText(temp);
                    }
                } else {
                    outputTextSM.setText("Enter a value before making it negative");
                }
            }
        });

        //Clears the screen and all inputs.
        clearButtonSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.clear();
                count = 0;
                outputTextSM.setText("");
                inputTextSM.setText("");
            }
        });

        //Adds the value to the arraylist, calculates the answer, and provides a step-by-step
        //explanation of the process.
        addButtonSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempString = inputTextSM.getText().toString();
                inputTextSM.setText("");
                if (tempString.matches("") == false ||
                        tempString.matches(".") == false) {
                    Double tempValue = Double.parseDouble(tempString);
                    values.add(tempValue);
                    count++;
                    String formulaString = "";
                    Double sum = 0.0;
                    for (int i = 0; i < count; i++) {
                        if (i == count - 1) {
                            formulaString = formulaString + values.get(i);
                        } else {
                            formulaString = formulaString + values.get(i) + " + ";
                        }
                        sum += values.get(i);
                    }
                    Double mean = sum / count;
                    outputTextSM.setText("First, we must add all of the given values together, " +
                            "which looks like: " + formulaString + "\nThen, we must divide it by" +
                            " the total number of values, which gives us: " + sum + "/" + count +
                            "\n Which gives us our answer: " + mean);
                } else {
                    //FIX:Crash somehow caused here
                    outputTextSM.setText("Please enter a valid number.");
                    inputTextSM.setText("");
                }
            }
        });
    }
}