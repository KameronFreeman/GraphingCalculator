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

public class PopProp extends AppCompatActivity {

    //Initializes variables.
    private Double ratio = 0.0;
    private Double pNull = 0.00;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_prop);

        //Prevents keyboard from pushing layout up regardless of constraints
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //Initialize buttons.
        Button backButton = (Button) findViewById(R.id.backButtonPP);
        Button negativeButtonPP1 = (Button) findViewById(R.id.negativeButtonPP1);
        Button negativeButtonPP2 = (Button) findViewById(R.id.negativeButtonPP2);
        Button negativeButtonPP3 = (Button) findViewById(R.id.negativeButtonPP3);
        Button clearButton = (Button) findViewById(R.id.clearButtonPP);
        Button addButton = (Button) findViewById(R.id.addButtonPP);

        //Initializes text boxes.
        final TextView inputTextRatio = (TextView) findViewById(R.id.inputTextRatioPP);
        final TextView inputTextNull = (TextView) findViewById(R.id.inputNullPP);
        final TextView inputTextCount = (TextView) findViewById(R.id.inputCountPP);
        final TextView outputText = (TextView) findViewById(R.id.outputTextPP);

        //Returns to the step-by-step menu.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(getApplicationContext(), StepbystepMenu.class);
                startActivity(menuIntent);
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonPP1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextRatio.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextRatio.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextRatio.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonPP2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextNull.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextNull.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextNull.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonPP3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextCount.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextCount.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextCount.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Clears the screen and all inputs.
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                ratio = 0.0;
                pNull = 0.0;
                outputText.setText("");
                inputTextCount.setText("");
                inputTextNull.setText("");
                inputTextRatio.setText("");
            }
        });

        //Adds the value to the arraylist, calculates the answer, and provides a step-by-step
        //explanation of the process.
        addButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //Gets string values from text boxes.
                String tempStringRatio = inputTextRatio.getText().toString();
                String tempStringNull = inputTextNull.getText().toString();
                String tempStringCount = inputTextCount.getText().toString();
                //Checks for invalid input.
                if (!tempStringRatio.equals("") ||
                        !tempStringRatio.equals(".") ||
                        !tempStringNull.equals("") ||
                        !tempStringNull.equals(".") ||
                        !tempStringCount.equals("") ||
                        !tempStringCount.equals(".")) {
                    //Converts strings to values.
                    ratio = Double.parseDouble(tempStringRatio);
                    pNull = Double.parseDouble(tempStringNull);
                    count = Integer.parseInt(tempStringCount);

                    //Calculates answer.
                    Double subtraction = ratio - pNull;
                    Double multiplication = pNull * (1 - pNull);
                    Double divisionOne = multiplication / count;
                    Double squareRoot = Math.sqrt(divisionOne);
                    Double answer = subtraction / squareRoot;

                    //Outputs answer.
                    outputText.setText("First, we must subtract the null value from the ratio," +
                            " which gives us: " + ratio + "-" + pNull + " = " + subtraction +
                            "\nNext, we must multiply the null value by one minus the null value," +
                            " which gives us: " + pNull + "*(1-" + pNull + ") = " + multiplication +
                            "\nNext, we must divide the value we just got by the number of values" +
                            ", which gives us: " + multiplication + "/" + count + " = " +
                            divisionOne + "\nThen, we must take the square root of the value we" +
                            " got, giving us: " + "√" + divisionOne + " = " + squareRoot +
                            "\nFinally, we must take our first value and divide it by our last" +
                            " value, giving us: " + subtraction + "/" + squareRoot + " = " +
                            answer);
                } else {
                    //FIX:Crash somehow caused here
                    outputText.setText("Please enter a valid number.");
                    inputTextRatio.setText("");
                    inputTextNull.setText("");
                    inputTextCount.setText("");
                }
            }
        });
    }
}