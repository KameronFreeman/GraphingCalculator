package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatorapp.R;

import java.util.ArrayList;

public class SampleStdDev extends AppCompatActivity {

    //Initializes variables.
    private ArrayList<Double> values = new ArrayList();
    private int count = 0;
    private double mean = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_std_dev);

        //Initialize buttons.
        Button backButtonSD = (Button) findViewById(R.id.backButtonSD);
        Button negativeButtonSD1 = (Button) findViewById(R.id.negativeButtonSD1);
        Button negativeButtonSD2 = (Button) findViewById(R.id.negativeButtonSD2);
        Button clearButtonSD = (Button) findViewById(R.id.clearButtonSD);
        Button addButtonSD = (Button) findViewById(R.id.addButtonSD);

        //Initializes text boxes.
        final TextView inputTextValue = (TextView) findViewById(R.id.inputTextValueSD);
        final TextView inputTextMean = (TextView) findViewById(R.id.inputTextMeanSD);
        final TextView outputTextSD = (TextView) findViewById(R.id.outputTextSD);

        //Returns to the step-by-step menu.
        backButtonSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(getApplicationContext(), StepbystepMenu.class);
                startActivity(menuIntent);
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonSD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = inputTextValue.getText().toString();
                if (temp.matches("") == false) {
                    outputTextSD.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextValue.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextValue.setText(temp);
                    }
                } else {
                    outputTextSD.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonSD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = inputTextMean.getText().toString();
                if (temp.matches("") == false) {
                    outputTextSD.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextMean.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextMean.setText(temp);
                    }
                } else {
                    outputTextSD.setText("Enter a value before making it negative");
                }
            }
        });

        //Clears the screen and all inputs.
        clearButtonSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.clear();
                count = 0;
                mean = 0.0;
                outputTextSD.setText("");
                inputTextMean.setText("");
                inputTextValue.setText("");
            }
        });

        //Adds the value to the arraylist, calculates the answer, and provides a step-by-step
        //explanation of the process.
        addButtonSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempStringValue = inputTextValue.getText().toString();
                inputTextValue.setText("");
                String tempStringMean = inputTextMean.getText().toString();
                if (tempStringValue.matches("") == false ||
                        tempStringValue.matches(".") == false ||
                            tempStringMean.matches("") == false ||
                                tempStringMean.matches(".") == false) {
                    Double tempValueValue = Double.parseDouble(tempStringValue);
                    Double tempValueMean = Double.parseDouble(tempStringMean);
                    values.add(tempValueValue);
                    count++;
                    String formulaString = "";
                    Double sum = 0.0;
                    for (int i = 0; i < count; i++) {
                        if (i == count - 1) {
                            formulaString = formulaString + "(" + values.get(i) + "-" +
                            tempValueMean + ")^2";
                        } else {
                            formulaString = formulaString + "(" + values.get(i)
                                    + "-" + tempValueMean + ")^2" + " + ";
                        }
                        sum += Math.pow((values.get(i) - tempValueMean), 2);
                    }

                    Double preSquareRoot = sum / (count - 1);
                    Double answer = Math.sqrt(preSquareRoot);

                    outputTextSD.setText("First, we must take the sum of the answer to every" +
                            " value minus the mean squared. This gives us: " + formulaString +
                            "\nThen we must take the value taken from this (" + sum + ") " +
                            "and divide it by the number of values minus one which gives us : " +
                            sum + "/(" + count + "-1) = " + preSquareRoot + "\nThen we take the " +
                            "square root to get our answer: √" + preSquareRoot + " = " + answer);
                } else {
                    //FIX:Crash somehow caused here
                    outputTextSD.setText("Please enter a valid number.");
                    inputTextValue.setText("");
                    inputTextMean.setText("");
                }
            }
        });
    }
}