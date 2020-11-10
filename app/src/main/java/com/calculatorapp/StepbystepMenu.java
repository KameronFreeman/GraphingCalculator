package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.calculatorapp.QuadraticActivity;
import com.example.calculatorapp.R;

import android.os.Bundle;

public class StepbystepMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_stepbystep);

        //Initializes buttons.
        Button backButton = (Button) findViewById(R.id.backButtonSBS);
        Button sampleMeanButton = (Button) findViewById(R.id.sampleMeanButton);
        final Button standardDevButton = (Button) findViewById(R.id.standardDevButton);
        Button correlationCoeffButton = (Button) findViewById(R.id.correlationCoeffButton);
        Button popMeanButton = (Button) findViewById(R.id.popMeanButton);
        Button popPropButton = (Button) findViewById(R.id.popPropButton);
        Button twoMeanDiffButton = (Button) findViewById(R.id.twoMeanDiffButton);
        Button quadraticButton = (Button) findViewById(R.id.quadraticButton);

        //Goes back to the main page.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });

        //Enters sample mean view.
        sampleMeanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meanIntent = new Intent(getApplicationContext(), SampleMean.class);
                startActivity(meanIntent);
            }
        });

        //Enters standard deviation view.
        standardDevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent devIntent = new Intent(getApplicationContext(), SampleStdDev.class);
                startActivity(devIntent);
            }
        });

        //Enters correlation coefficient view.
        correlationCoeffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coeffIntent = new Intent(getApplicationContext(), CorrelationCoeff.class);
                startActivity(coeffIntent);
            }
        });

        //Enters population mean view.
        popMeanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent meanIntent = new Intent(getApplicationContext(), PopMean.class);
                startActivity(meanIntent);
            }
        });

        //Enters population proportion view.
        popPropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent propIntent = new Intent(getApplicationContext(), PopProp.class);
                startActivity(propIntent);
            }
        });

        //Enters difference of two means view.
        twoMeanDiffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diffIntent = new Intent(getApplicationContext(), Mean2.class);
                startActivity(diffIntent);
            }
        });

        //Enters the Quadratic Formula view.
        quadraticButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quadIntent = new Intent(getApplicationContext(), QuadraticActivity.class);
                startActivity(quadIntent);
            }
        }) ;
    }
}