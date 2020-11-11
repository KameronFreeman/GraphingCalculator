package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatorapp.R;

import java.text.DecimalFormat;

public class HyperGeoCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyper_geo_calc);

        //Initializes Buttons.
        Button backButton = (Button) findViewById(R.id.backButtonHgc);
        Button calculateButton = (Button) findViewById(R.id.hgcCalculateButton);

        //Initializes Text Boxes.
        final TextView deckInput = (TextView) findViewById(R.id.hgcDeckSizeInput);
        final TextView copiesInput = (TextView) findViewById(R.id.hgcNumCopiesInput);
        final TextView turnsInput = (TextView) findViewById(R.id.hgcNumTurnsInput);
        final TextView outputText = (TextView) findViewById(R.id.hgcOutputText);

        //Returns to the main menu.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Enters Main Menu screen.
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });

        //Calculates the answer.
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //Creates proper decimal format.
                DecimalFormat df = new DecimalFormat("0.00");

                //Checks for no input.
                if (!deckInput.getText().toString().equals("") &&
                        !copiesInput.getText().toString().equals("") &&
                        !turnsInput.getText().toString().equals("")) {
                    //Gets the values from the input boxes.
                    String deckString = deckInput.getText().toString();
                    String copyString = copiesInput.getText().toString();
                    String turnString = turnsInput.getText().toString();
                    //Clears the input boxes.
                    deckInput.setText("");
                    copiesInput.setText("");
                    turnsInput.setText("");
                    //Converts inputs into calculable values and initializes other variables.
                    double deckValue = Double.parseDouble(deckString);
                    double copyValue = Double.parseDouble(copyString);
                    double turnValue = Double.parseDouble(turnString);
                    double percentage;
                    double numerator = deckValue - copyValue;
                    double denominator = deckValue;

                    //Calculates the answer.
                    for (int i = 1; i < turnValue; i++) {
                        numerator *= deckValue - copyValue - i;
                        denominator *= deckValue - i;
                    }
                    percentage = numerator / denominator;
                    percentage = (1 - percentage) * 100;

                    //Outputs the answer.
                    String outputString = df.format(percentage);
                    outputText.setText(outputString + "%");
                } else {
                    outputText.setText("Please enter a number into all input boxes.");
                }
            }
        });
    }
}