package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculatorapp.R;

import java.util.ArrayList;

public class GraphingCalcInputsActivity extends AppCompatActivity {

    //public static double m[] = new double[4];
    //public static double b[] = new double[4];

    public static ArrayList<Double> m = new ArrayList<>();
    public static ArrayList<Double> b = new ArrayList<>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphing_calc_inputs);


        Button graphButton = (Button) findViewById(R.id.graphButton);
        Button extraEquation = (Button) findViewById(R.id.extraEquation);
        final EditText linearEquation = (EditText) findViewById(R.id.linearEquationEditText);


        extraEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    //Get first equation
                    String equation = linearEquation.getText().toString();
                    int indOfX = equation.indexOf('x');
                    if (Character.isDigit(equation.charAt(0)) || equation.charAt(0) == '.') {
                        //m[i] = Double.parseDouble(equation.substring(0, indOfX));
                        m.add(Double.parseDouble(equation.substring(0, indOfX)));
                    }
                    if (equation.charAt(0) == '-') {
                        //m[i] = -(Double.parseDouble(equation.substring(1, indOfX)));
                        m.add(-(Double.parseDouble(equation.substring(1, indOfX))));
                    }


                    int length = equation.length();
                    if (equation.substring(indOfX).indexOf('+') == -1) {
                        int mid = equation.substring(indOfX).indexOf('-') + indOfX;
                        if (Character.isDigit(equation.charAt(mid + 1)) || equation.charAt(mid + 1) == '.') {
                            //b[i] = -(Double.parseDouble(equation.substring(mid + 1)));
                            b.add(-(Double.parseDouble(equation.substring(mid + 1))));
                        } else {
                            //b[i] = -(Double.parseDouble(equation.substring(mid + 2)));
                            b.add(-(Double.parseDouble(equation.substring(mid + 2))));
                        }
                    } else {
                        int mid = equation.substring(indOfX).indexOf('+') + indOfX;
                        if (Character.isDigit(equation.charAt(mid + 1)) || equation.charAt(mid + 1) == '.') {
                            //b[i] = Double.parseDouble(equation.substring(mid + 1));
                            b.add(Double.parseDouble(equation.substring(mid + 1)));
                        } else {
                            //b[i] = Double.parseDouble(equation.substring(mid + 2));
                            b.add(Double.parseDouble(equation.substring(mid + 2)));
                        }
                    }

                    linearEquation.clearComposingText();
                    //System.out.println("m[" + i + "] equals " + m[i] +  " b[" + i + "] equals " + b[i]);
                    i++;
                }

        });

        //When graph button is clicked
        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Get first equation
               /* String equation = linearEquation.getText().toString();
                int indOfX = equation.indexOf('x');
                if (Character.isDigit(equation.charAt(0)) || equation.charAt(0) == '.'){
                    m[0] = Double.parseDouble(equation.substring(0,indOfX));
                }
                if (equation.charAt(0) == '-'){
                    m[0] = -(Double.parseDouble(equation.substring(1,indOfX)));
                }


                int length = equation.length();
                if (equation.substring(indOfX).indexOf('+') == -1){
                    int mid = equation.substring(indOfX).indexOf('-') + indOfX;
                    if (Character.isDigit(equation.charAt(mid +1)) || equation.charAt(mid + 1) == '.'){
                        b[0] = -(Double.parseDouble(equation.substring(mid+1)));
                    }else{
                        b[0] = -(Double.parseDouble(equation.substring(mid+2)));
                    }
                }else{
                    int mid = equation.substring(indOfX).indexOf('+') + indOfX;
                    if (Character.isDigit(equation.charAt(mid+1)) || equation.charAt(mid+1) == '.'){
                        b[0] = Double.parseDouble(equation.substring(mid+1));
                    }else{
                        b[0] = Double.parseDouble(equation.substring(mid+2));
                    }
                }

                */


                //for (int j = 0; j < 4; j++){
                  //  System.out.println("m[" + j + "] = " + m[j] + "b[" + j + "] = " + b[j]);
                //}

                //Displays graph
                Intent graphingCalculatorScreen = new Intent(GraphingCalcInputsActivity.this,
                        graphingActivity.class);
                startActivity(graphingCalculatorScreen);

                //enter graphing calculator screen
            }
        });

    }
}