package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculatorapp.R;

public class Mean2 extends AppCompatActivity {

    //Initializes variables.
    private Double x1 = 0.0;
    private Double x2 = 0.0;
    private Double stdDev1 = 0.0;
    private Double stdDev2 = 0.0;
    private int count1 = 0;
    private int count2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mean2);

        //Prevents keyboard from pushing layout up regardless of constraints
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //Initialize Buttons.
        Button backButton = (Button) findViewById(R.id.backButtonTM2);
        Button addButton = (Button) findViewById(R.id.addButtonTM2);
        Button clearButton = (Button) findViewById(R.id.clearButtonTM2);

        Button negativeButton1 = (Button) findViewById(R.id.negativeButtonTM9);
        Button negativeButton2 = (Button) findViewById(R.id.negativeButtonTM);
        Button negativeButton3 = (Button) findViewById(R.id.negativeButtonTM8);
        Button negativeButton4 = (Button) findViewById(R.id.negativeButtonTM7);
        Button negativeButton5 = (Button) findViewById(R.id.negativeButtonTM11);
        Button negativeButton6 = (Button) findViewById(R.id.negativeButtonTM10);

        //Initialize Text Boxes.
        final TextView outputText = (TextView) findViewById(R.id.outputTextTM2);

        final EditText inputTextX1 = (EditText) findViewById(R.id.inputX1TM3);
        final EditText inputTextX2 = (EditText) findViewById(R.id.inputX2TM2);
        final EditText inputTextStdDev1 = (EditText) findViewById(R.id.inputStdDevTM);
        final EditText inputTextStdDev2 = (EditText) findViewById(R.id.inputStdDevTM3);
        final EditText inputTextCount1 = (EditText) findViewById(R.id.inputCountTM);
        final EditText inputTextCount2 = (EditText) findViewById(R.id.inputCountTM3);

        //Returns to the step-by-step menu.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(getApplicationContext(), StepbystepMenu.class);
                startActivity(menuIntent);
            }
        });

        //Adds or removes a negative from the input box.
        negativeButton1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextX1.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextX1.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextX1.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButton2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextX2.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextX2.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextX2.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButton3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextStdDev1.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextStdDev1.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextStdDev1.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButton4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextStdDev2.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextStdDev2.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextStdDev2.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButton5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextCount1.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextCount1.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextCount1.setText(temp);
                    }
                } else {
                    outputText.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButton6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputTextCount2.getText().toString();
                if (!temp.matches("")) {
                    outputText.setText("");
                    if (temp.charAt(0) != '-') {
                        inputTextCount2.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputTextCount2.setText(temp);
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
                count1 = 0;
                count2 = 0;
                x1 = 0.0;
                x2 = 0.0;
                stdDev1 = 0.0;
                stdDev2 = 0.0;
                outputText.setText("");
                inputTextCount1.setText("");
                inputTextCount2.setText("");
                inputTextStdDev1.setText("");
                inputTextStdDev2.setText("");
                inputTextX1.setText("");
                inputTextX2.setText("");
            }
        });

        //Adds the value to the arraylist, calculates the answer, and provides a step-by-step
        //explanation of the process.
        addButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //Checks for invalid input.
                if (!inputTextX1.getText().toString().equals("") ||
                        !inputTextX1.getText().toString().equals(".") ||
                        !inputTextStdDev1.getText().toString().equals("") ||
                        !inputTextStdDev1.getText().toString().equals(".") ||
                        !inputTextCount1.getText().toString().equals("") ||
                        !inputTextCount1.getText().toString().equals(".") ||
                        !inputTextX2.getText().toString().equals("") ||
                        !inputTextX2.getText().toString().equals(".") ||
                        !inputTextStdDev2.getText().toString().equals(".") ||
                        !inputTextStdDev2.getText().toString().equals("") ||
                        !inputTextCount2.getText().toString().equals("") ||
                        !inputTextCount2.getText().toString().equals(".")) {
                    //Gets string values from input boxes.
                    String tempStringX1 = inputTextX1.getText().toString();
                    String tempStringX2 = inputTextX2.getText().toString();
                    String tempStringStdDev1 = inputTextStdDev1.getText().toString();
                    String tempStringStdDev2 = inputTextStdDev2.getText().toString();
                    String tempStringCount1 = inputTextCount1.getText().toString();
                    String tempStringCount2 = inputTextCount2.getText().toString();
                    //Converts string values into numbers.
                    x1 = Double.parseDouble(tempStringX1);
                    x2 = Double.parseDouble(tempStringX2);
                    stdDev1 = Double.parseDouble(tempStringStdDev1);
                    stdDev2 = Double.parseDouble(tempStringStdDev2);
                    count1 = Integer.parseInt(tempStringCount1);
                    count2 = Integer.parseInt(tempStringCount2);
                    //Calculates answer.
                    Double subtraction = x1 - x2;
                    Double divisionOne = Math.pow(stdDev1, 2) / count1;
                    Double divisionTwo = Math.pow(stdDev2, 2) / count2;
                    double addition = divisionOne + divisionTwo;
                    Double squareRoot = Math.sqrt(addition);
                    double answer = subtraction / squareRoot;
                    //Outputs answer.
                    outputText.setText("First, we must subtract the second mean from the first," +
                            " giving us: " + x1 + "-" + x2 + " = " + subtraction +
                            "\nNext, we must divide the two standard deviations from their " +
                            "respective number of values, giving us: (" + stdDev1 + "^2)/" +
                            count1 + " = " + divisionOne + "\nand\n(" + stdDev2 + "^2)/" + count2 +
                            " = " + divisionTwo + "\nThen, we must add these two values " +
                            "together, giving us: " + divisionOne + "+" + divisionTwo + " = " +
                            addition + "\nNext, we take the square root of this value, giving" +
                            " us: √" + addition + " = " + squareRoot + "\nFinally, we must" +
                            " divide our subtraction value from our square root value, giving us:" +
                            " " + subtraction + "/" + squareRoot + " = " + answer);
                } else {
                    //FIX:Crash somehow caused here
                    outputText.setText("");
                    inputTextX1.setText("");
                    inputTextX2.setText("");
                    inputTextStdDev1.setText("");
                    inputTextStdDev2.setText("");
                    inputTextCount1.setText("");
                    inputTextCount2.setText("");
                }
            }
        });

    }
}