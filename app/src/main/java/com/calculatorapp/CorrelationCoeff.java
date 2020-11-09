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

import java.util.ArrayList;

public class CorrelationCoeff extends AppCompatActivity {

    //Initializes variables.
    private ArrayList<Double> xValues = new ArrayList<>();
    private ArrayList<Double> yValues = new ArrayList<>();
    private int count = 0;
    private Double sX = 0.0;
    private Double sY = 0.0;
    private Double meanX = 0.0;
    private Double meanY = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correlation_coeff);

        //Prevents keyboard from pushing layout up regardless of constraints
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //Initialize Buttons.
        Button backButtonCC = (Button) findViewById(R.id.backButtonCC);
        Button negativeButtonCC1 = (Button) findViewById(R.id.negativeButtonCC1);
        Button negativeButtonCC2 = (Button) findViewById(R.id.negativeButtonCC2);
        Button negativeButtonCC3 = (Button) findViewById(R.id.negativeButtonCC3);
        Button negativeButtonCC4 = (Button) findViewById(R.id.negativeButtonCC4);
        Button negativeButtonCC5 = (Button) findViewById(R.id.negativeButtonCC5);
        Button negativeButtonCC6 = (Button) findViewById(R.id.negativeButtonCC6);
        Button clearButtonCC = (Button) findViewById(R.id.clearButtonCC);
        Button addButtonCC = (Button) findViewById(R.id.addButtonCC);

        //Initializes Text Boxes.
        final TextView inputXValueCC = (TextView) findViewById(R.id.inputXValueCC);
        final TextView inputYValueCC = (TextView) findViewById(R.id.inputYValueCC);
        final TextView inputXMeanCC = (TextView) findViewById(R.id.inputXMeanCC);
        final TextView inputYMeanCC = (TextView) findViewById(R.id.inputYMeanCC);
        final TextView inputSXCC = (TextView) findViewById(R.id.inputSXCC);
        final TextView inputSYCC = (TextView) findViewById(R.id.inputSYCC);
        final TextView outputTextCC = (TextView) findViewById(R.id.outputTextCC);

        //Returns to the step-by-step menu.
        backButtonCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(getApplicationContext(), StepbystepMenu.class);
                startActivity(menuIntent);
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonCC1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputXValueCC.getText().toString();
                if (!temp.matches("")) {
                    outputTextCC.setText("");
                    if (temp.charAt(0) != '-') {
                        inputXValueCC.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputXValueCC.setText(temp);
                    }
                } else {
                    outputTextCC.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonCC2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputXMeanCC.getText().toString();
                if (!temp.matches("")) {
                    outputTextCC.setText("");
                    if (temp.charAt(0) != '-') {
                        inputXMeanCC.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputXMeanCC.setText(temp);
                    }
                } else {
                    outputTextCC.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonCC3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputSXCC.getText().toString();
                if (!temp.matches("")) {
                    outputTextCC.setText("");
                    if (temp.charAt(0) != '-') {
                        inputSXCC.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputSXCC.setText(temp);
                    }
                } else {
                    outputTextCC.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonCC4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputYValueCC.getText().toString();
                if (!temp.matches("")) {
                    outputTextCC.setText("");
                    if (temp.charAt(0) != '-') {
                        inputYValueCC.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputYValueCC.setText(temp);
                    }
                } else {
                    outputTextCC.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonCC5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputYMeanCC.getText().toString();
                if (!temp.matches("")) {
                    outputTextCC.setText("");
                    if (temp.charAt(0) != '-') {
                        inputYMeanCC.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputYMeanCC.setText(temp);
                    }
                } else {
                    outputTextCC.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negativeButtonCC6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputSYCC.getText().toString();
                if (!temp.matches("")) {
                    outputTextCC.setText("");
                    if (temp.charAt(0) != '-') {
                        inputSYCC.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputSYCC.setText(temp);
                    }
                } else {
                    outputTextCC.setText("Enter a value before making it negative");
                }
            }
        });

        //Clears the screen and all inputs.
        clearButtonCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xValues.clear();
                yValues.clear();
                count = 0;
                meanX = 0.0;
                meanY = 0.0;
                sX = 0.0;
                sY = 0.0;
                outputTextCC.setText("");
                inputXValueCC.setText("");
                inputXMeanCC.setText("");
                inputSXCC.setText("");
                inputYValueCC.setText("");
                inputYMeanCC.setText("");
                inputSYCC.setText("");
            }
        });

        //Adds the value to the arraylist, calculates the answer, and provides a step-by-step
        //explanation of the process.
        //FIX:Causes major crash somewhere.
        addButtonCC.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //Gets all values from the text boxes.
                String tempStringValueX = inputXValueCC.getText().toString();
                inputXValueCC.setText("");
                String tempStringMeanX = inputXMeanCC.getText().toString();
                String tempStringSX = inputSXCC.getText().toString();
                String tempStringValueY = inputYValueCC.getText().toString();
                inputYValueCC.setText("");
                String tempStringMeanY = inputYMeanCC.getText().toString();
                String tempStringSY = inputSYCC.getText().toString();

                //Checks for invalid input.
                if (tempStringValueX.equals("") == false ||
                        tempStringValueX.equals(".") == false ||
                        tempStringMeanX.equals("") == false ||
                        tempStringMeanX.equals(".") == false ||
                        tempStringSX.equals("") == false ||
                        tempStringSX.equals(".") == false ||
                        tempStringValueY.equals("") == false ||
                        tempStringValueY.equals(".") == false ||
                        tempStringMeanY.equals(".") == false ||
                        tempStringMeanY.equals("") == false ||
                        tempStringSY.equals("") == false ||
                        tempStringSY.equals(".") == false) {
                    //Converts inputs to numbers.
                    Double tempValueValueX = Double.parseDouble(tempStringValueX);
                    meanX = Double.parseDouble(tempStringMeanX);
                    sX = Double.parseDouble(tempStringSX);
                    Double tempValueValueY = Double.parseDouble(tempStringValueY);
                    meanY = Double.parseDouble(tempStringMeanY);
                    sY = Double.parseDouble(tempStringSY);
                    xValues.add(tempValueValueX);
                    yValues.add(tempValueValueY);
                    count++;
                    String formulaString = "";
                    Double sum = 0.0;
                    //Creates repeatable string and calculates the answer.
                    for (int i = 0; i < count; i++) {
                        if (i == count - 1) {
                            formulaString = formulaString + "((" + xValues.get(i) + "-" +
                                    meanX + ")*("+ yValues.get(i) + "-"+ meanY +
                                    "))/(" + sX + "*" + sY + ")";
                        } else {
                            formulaString = formulaString + "((" + xValues.get(i) + "-" +
                                    meanX + ")*("+ yValues.get(i) + "-"+ meanY +
                                    "))/(" + sX + "*" + sY + ")" + " + ";
                        }
                        sum += ((xValues.get(i) - meanX) * (yValues.get(i) -
                                meanY)) / (sX * sY);
                    }

                    double answer = sum * (1 / ((double) count - 1));

                    //Outputs the answer.
                    outputTextCC.setText("First, we must take the sum of all of the values of x and" +
                            " y subtracted by their respective means, and then divided by sx X" +
                            " sy, which gives us: " + formulaString + " = " + sum +
                            "\nNext, we must multiply this by one divided by the number of values" +
                            " minus one, which gives us: " + sum + "*(1/(" + count + "-1)) = " +
                            answer);
                } else {
                    //FIX:Crash somehow caused here
                    outputTextCC.setText("");
                    inputXValueCC.setText("");
                    inputXMeanCC.setText("");
                    inputSXCC.setText("");
                    inputYValueCC.setText("");
                    inputYMeanCC.setText("");
                    inputSYCC.setText("");
                }
            }
        });
    }
}