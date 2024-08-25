package com.calculatorapp;

//import all required libraries
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculatorapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class GraphingCalcInputsActivity extends AppCompatActivity {

    //create variables to hold equation
    public static ArrayList<Double> m = new ArrayList<>();
    public static ArrayList<Double> b = new ArrayList<>();
    public static ArrayList<String> trig = new ArrayList<>();
    public static ArrayList<Double> trigb = new ArrayList<>();
    int i = 0;

    //create userInterface
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphing_calc_inputs);


        Button graphButton = findViewById(R.id.graphButton);
        Button extraEquation = findViewById(R.id.extraEquation);
        final EditText linearEquation = findViewById(R.id.linearEquationEditText);

        Button backButtonGC = findViewById(R.id.backButtonGC);
        //if back button is clicked
        backButtonGC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to main screen
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });




        extraEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int trigornot = 1;

                    //Get first equation
                    String equation = linearEquation.getText().toString();
                    int indOfX = equation.indexOf('x');
                    if (equation.contains("sin") || equation.contains("Sin")) {
                        trig.add(equation.substring(0, indOfX + 2));
                        trigornot = 2;
                    } else if (equation.contains("cos") || equation.contains("Cos")) {
                        trig.add(equation.substring(0, indOfX + 2));
                        trigornot = 2;
                    } else if (equation.contains("tan") || equation.contains("Tan")) {
                        trig.add(equation.substring(0, indOfX + 2));
                        trigornot = 2;
                    } else {

                        if (Character.isDigit(equation.charAt(0)) || equation.charAt(0) == '.') {
                            //m[i] = Double.parseDouble(equation.substring(0, indOfX));
                            m.add(Double.parseDouble(equation.substring(0, indOfX)));
                        }
                        if (equation.charAt(0) == '-') {
                            //m[i] = -(Double.parseDouble(equation.substring(1, indOfX)));
                            if (equation.charAt(1) == 'x')
                                m.add(-1.0);
                            else
                                m.add(-(Double.parseDouble(equation.substring(1, indOfX))));

                        }
                        if (equation.charAt(0) == 'x') {
                            m.add(1.0);
                        }
                    }


                    int length = equation.length();
                    if (equation.substring(indOfX).indexOf('+') == -1 && equation.substring(indOfX).indexOf('-') == -1) {
                        if (trigornot == 2) {
                            trigb.add(0.0);
                        } else {
                            b.add(0.0);
                        }
                    } else {
                        if (equation.substring(indOfX).indexOf('+') == -1) {
                            int mid = equation.substring(indOfX).indexOf('-') + indOfX;
                            if (Character.isDigit(equation.charAt(mid + 1)) || equation.charAt(mid + 1) == '.') {
                                //b[i] = -(Double.parseDouble(equation.substring(mid + 1)));
                                if (trigornot == 2) {
                                    trigb.add(-(Double.parseDouble(equation.substring(mid + 1))));
                                } else {
                                    b.add(-(Double.parseDouble(equation.substring(mid + 1))));
                                }
                            } else {
                                //b[i] = -(Double.parseDouble(equation.substring(mid + 2)));
                                if (trigornot == 2) {
                                    trigb.add(-(Double.parseDouble(equation.substring(mid + 2))));
                                } else {
                                    b.add(-(Double.parseDouble(equation.substring(mid + 2))));
                                }
                            }
                        } else {
                            int mid = equation.substring(indOfX).indexOf('+') + indOfX;
                            if (Character.isDigit(equation.charAt(mid + 1)) || equation.charAt(mid + 1) == '.') {
                                //b[i] = Double.parseDouble(equation.substring(mid + 1));
                                if (trigornot == 2) {
                                    trigb.add(Double.parseDouble(equation.substring(mid + 1)));
                                } else {
                                    b.add(Double.parseDouble(equation.substring(mid + 1)));
                                }
                            } else {
                                //b[i] = Double.parseDouble(equation.substring(mid + 2));
                                if (trigornot == 2) {
                                    trigb.add(Double.parseDouble(equation.substring(mid + 2)));
                                } else {
                                    b.add(Double.parseDouble(equation.substring(mid + 2)));
                                }
                            }
                        }
                    }


                    linearEquation.clearComposingText();
                }catch(Exception e){
                    //Snackbar.make(findViewById(R.id.extraEquation), "INVALID INPUT/FORMAT", Snackbar.LENGTH_LONG).show().;
                    Toast toast = Toast.makeText(GraphingCalcInputsActivity.this, "INVALID INPUT/FORMAT\nClearing functions", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    m.clear();
                    b.clear();
                    trig.clear();
                    trigb.clear();
                    //AlertDialogtrig.Builder builer = new AlertDialog.Builder(AlertDialogActivity.this).create();
                }
            }


        });

        //When graph button is clicked
        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Displays graph
                Intent graphingCalculatorScreen = new Intent(GraphingCalcInputsActivity.this,
                        graphingActivity.class);
                startActivity(graphingCalculatorScreen);
            }
        });

    }
}