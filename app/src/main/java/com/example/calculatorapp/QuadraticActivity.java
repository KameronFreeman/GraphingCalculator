package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.calculatorapp.StepbystepMenu;

public class QuadraticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);

        //Initializes buttons.
        Button backButton = (Button) findViewById(R.id.backButtonQF);
        Button negBtn1 = (Button) findViewById(R.id.negativeButtonQF1);
        Button negBtn2 = (Button) findViewById(R.id.negativeButtonQF2);
        Button negBtn3 = (Button) findViewById(R.id.negativeButtonQF3);
        Button clearBtn = (Button) findViewById(R.id.clearButtonQF);
        final Button addBtn = (Button) findViewById(R.id.addButtonQF);

        //Initializes changing text boxes.
        final TextView inputA = (TextView) findViewById(R.id.inputTextQFA);
        final TextView inputB = (TextView) findViewById(R.id.inputTextQFB);
        final TextView inputC = (TextView) findViewById(R.id.inputTextQFC);
        final TextView output = (TextView) findViewById(R.id.outputQF);

        //Goes back to the SBS menu.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sbsIntent = new Intent(getApplicationContext(), StepbystepMenu.class);
                startActivity(sbsIntent);
            }
        });

        //Adds or removes a negative from the input box.
        negBtn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputA.getText().toString();
                if (!temp.matches("")) {
                    output.setText("");
                    if (temp.charAt(0) != '-') {
                        inputA.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputA.setText(temp);
                    }
                } else {
                    output.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negBtn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputB.getText().toString();
                if (!temp.matches("")) {
                    output.setText("");
                    if (temp.charAt(0) != '-') {
                        inputB.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputB.setText(temp);
                    }
                } else {
                    output.setText("Enter a value before making it negative");
                }
            }
        });

        //Adds or removes a negative from the input box.
        negBtn3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String temp = inputC.getText().toString();
                if (!temp.matches("")) {
                    output.setText("");
                    if (temp.charAt(0) != '-') {
                        inputC.setText("-" + temp);
                    } else {
                        temp = temp.substring(1);
                        inputC.setText(temp);
                    }
                } else {
                    output.setText("Enter a value before making it negative");
                }
            }
        });

        //Clears all relevant text boxes.
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputA.setText("");
                inputB.setText("");
                inputC.setText("");
                output.setText("");
            }
        });

        //Calculates the answer and provides an explanation.
        addBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (!inputA.getText().toString().equals("") ||
                        !inputA.getText().toString().equals(".") ||
                        !inputB.getText().toString().equals("") ||
                        !inputB.getText().toString().equals(".") ||
                        !inputC.getText().toString().equals("") ||
                        !inputC.getText().toString().equals(".")) {
                    //Gets string values from input boxes.
                    String tempStringA = inputA.getText().toString();
                    String tempStringB = inputB.getText().toString();
                    String tempStringC = inputC.getText().toString();
                    //Converts string to numbers.
                    double valA = Double.parseDouble(tempStringA);
                    double valB = Double.parseDouble(tempStringB);
                    double valC = Double.parseDouble(tempStringC);

                    //Calculates answers.
                    Double val4ac = 4 * valA * valC;
                    Double valbex2 = Math.pow(valB, 2);
                    double subtractionRoot = valbex2 - val4ac;
                    double squareRootVal = Math.sqrt(subtractionRoot);
                    Double val2a = 2 * valA;
                    Double subtractionVal = -valB - squareRootVal;
                    Double additionVal = -valB + squareRootVal;
                    double answerOne = additionVal / val2a;
                    double answerTwo = subtractionVal / val2a;

                    //Outputs an explanation of the answer.
                    output.setText("First, we must get the value of the equation within the" +
                            " square root symbol, giving us: " + valB + "^2-(4*" + valA + "*" + valC
                            + ") = " + subtractionRoot + "\nNext, we must take the square root" +
                            " of that value which equals: " + squareRootVal + "\nThen, we must " +
                            "Then, we must simultaneously add and subtract that value from -b, " +
                            "which gives us: -(" + valB + ")+" + squareRootVal + " = " + additionVal
                            + "\nand: -(" + valB + ")-" + squareRootVal + " = " + subtractionVal +
                            "\nFinally, we must divide both of these by the denominator, giving" +
                            " us: " + additionVal + "/" + val2a + " = x = " + answerOne + "\n and: "
                            + subtractionVal + "/" + val2a + " = x = " + answerTwo);

                } else {
                    inputA.setText("");
                    inputB.setText("");
                    inputC.setText("");
                    output.setText("Please input a valid number.");
                }
            }
        });
    }
}