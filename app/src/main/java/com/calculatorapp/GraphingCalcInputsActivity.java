package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculatorapp.R;

public class GraphingCalcInputsActivity extends AppCompatActivity {
    public static double m;
    public static double b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphing_calc_inputs);


        Button graphButton = (Button) findViewById(R.id.graphButton);
        final EditText linearEquation = (EditText) findViewById(R.id.linearEquationEditText);

        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String equation = linearEquation.getText().toString();
                int indOfX = equation.indexOf('x');
                if (Character.isDigit(equation.charAt(0)) || equation.charAt(0) == '.'){
                    m = Double.parseDouble(equation.substring(0,indOfX));
                }
                if (equation.charAt(0) == '-'){
                    m = -(Double.parseDouble(equation.substring(1,indOfX)));
                }



                int length = equation.length();

                if (equation.substring(indOfX).indexOf('+') == -1){
                    int mid = equation.substring(indOfX).indexOf('-') + indOfX;
                    if (Character.isDigit(equation.charAt(mid +1)) || equation.charAt(mid + 1) == '.'){
                        b = -(Double.parseDouble(equation.substring(mid+1)));
                    }else{
                        b = -(Double.parseDouble(equation.substring(mid+2)));
                    }
                }else{
                    int mid = equation.substring(indOfX).indexOf('+') + indOfX;
                    if (Character.isDigit(equation.charAt(mid+1)) || equation.charAt(mid+1) == '.'){
                        b = Double.parseDouble(equation.substring(mid+1));
                    }else{
                        b = Double.parseDouble(equation.substring(mid+2));
                    }
                }


                //b = Integer.parseInt(linearEquation.getText().toString().substring(length - 1));


                Intent graphingCalculatorScreen = new Intent(GraphingCalcInputsActivity.this,
                        graphingActivity.class);
                startActivity(graphingCalculatorScreen);

                //enter graphing calculator screen
            }
        });

    }
}