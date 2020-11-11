package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatorapp.R;

public class PopMean extends AppCompatActivity {

    //Initialize variables.
    private Double mean = 0.0;
    private Double expected = 0.0;
    private Double stdDev = 0.0;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_mean);

        //Prevents keyboard from pushing layout up regardless of constraints
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //Initialize buttons.
        Button backButtonPM = (Button) findViewById(R.id.backButtonPM);
        Button negativeButtonPM1 = (Button) findViewById(R.id.negativeButtonPM1);
        Button negativeButtonPM2 = (Button) findViewById(R.id.negativeButtonPM2);
        Button negativeButtonPM3 = (Button) findViewById(R.id.negativeButtonPM3);
        Button negativeButtonPM4 = (Button) findViewById(R.id.negativeButtonPM4);
        Button clearButtonPM = (Button) findViewById(R.id.clearButtonPM);
        Button addButtonPM = (Button) findViewById(R.id.addButtonPM);

        //Initializes text boxes.
        final TextView inputTextMean = (TextView) findViewById(R.id.inputTextMeanPM);
        final TextView inputTextExpected = (TextView) findViewById(R.id.inputExpectedPM);
        final TextView inputStdDev = (TextView) findViewById(R.id.inputStdDevPM);
        final TextView inputCount = (TextView) findViewById(R.id.inputCountPM);
        final TextView outputText = (TextView) findViewById(R.id.outputTextPM);

        //Returns to the step-by-step menu.
        backButtonPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(getApplicationContext(), StepbystepMenu.class);
                startActivity(menuIntent);
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonPM1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextMean.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextMean.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextMean.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonPM2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextExpected.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextExpected.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextExpected.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonPM3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputStdDev.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputStdDev.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputStdDev.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonPM4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputCount.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputCount.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputCount.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Clears the screen and all inputs.
        clearButtonPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                expected = 0.0;
                stdDev = 0.0;
                mean = 0.0;
                outputText.setText("");
                inputTextMean.setText("");
                inputTextExpected.setText("");
                inputStdDev.setText("");
                inputCount.setText("");
            }
        });

        //Adds the value to the arraylist, calculates the answer, and provides a step-by-step
        //explanation of the process.
        addButtonPM.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //Checks for invalid input.
                if (!inputTextExpected.getText().toString().equals("") &&
                        !inputTextExpected.getText().toString().equals(".") &&
                        !inputTextExpected.getText().toString().equals("-.") &&
                        !inputTextMean.getText().toString().equals("") &&
                        !inputTextMean.getText().toString().equals(".") &&
                        !inputTextMean.getText().toString().equals("-.") &&
                        !inputStdDev.getText().toString().equals("") &&
                        !inputStdDev.getText().toString().equals(".") &&
                        !inputStdDev.getText().toString().equals("-.") &&
                        !inputCount.getText().toString().equals("") &&
                        !inputCount.getText().toString().equals(".") &&
                        !inputCount.getText().toString().equals("-.")) {
                    //Gets string values from input boxes.
                    String tempStringExpected = inputTextExpected.getText().toString();
                    String tempStringMean = inputTextMean.getText().toString();
                    String tempStringStdDev = inputStdDev.getText().toString();
                    String tempStringCount = inputCount.getText().toString();
                    //Converts strings to numbers.
                    expected = Double.parseDouble(tempStringExpected);
                    mean = Double.parseDouble(tempStringMean);
                    stdDev = Double.parseDouble(tempStringStdDev);
                    count = Integer.parseInt(tempStringCount);

                    //Calculates answer.
                    Double subtraction = mean - expected;
                    Double division = stdDev/((Double) Math.sqrt(count));
                    Double answer = subtraction / division;

                    //Outputs answer.
                    outputText.setText("First, we must subtract the expected value from the mean," +
                            " which gives us: " + mean + "-" + expected
                            + " = " + subtraction + "\nNext, we must divide the standard deviation" +
                            " from the square root of the number of values, which gives us: " +
                            stdDev + "/√" + count + " = " + division +
                            "\nFinally, we divide these two values together, giving us: " +
                            subtraction + "/" + division + " = " + answer);
                } else {
                    outputText.setText("Please enter a valid number in all text boxes.");
                }
            }
        });
    }
}