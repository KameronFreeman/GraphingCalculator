package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


import com.example.calculatorapp.R;

public class calculusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculus);

        final boolean[] simp = {false};

        //Initialize Buttons
        Button backBtn = (Button) findViewById(R.id.backBtn);
        Button simplifyBtn = (Button) findViewById(R.id.simplifyBtn);

        Button dervBtn = (Button) findViewById(R.id.dervBtn);
        //Button dervNBtn = (Button) findViewById(R.id.dervNBtn);


        //Initialize TextView and EditText
        final TextView solutionView = (TextView) findViewById(R.id.solutionTextView);
        final EditText inputText = (EditText) findViewById(R.id.InputEditText);

        final Switch simpleSwitch = (Switch) findViewById(R.id.simplifySwitch);

        //If back button is pressed
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainMenu);
            }
        });

        //If simplify button is pressed
        simplifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //solutionView.setText("Hello");
                    if (!ValidInput.isValidInput(inputText.getText().toString())) {
                        solutionView.setText(ValidInput.getErrorMessage());

                    } else {
                        String input = inputText.getText().toString();
                        //simplify simp = new simplify(input);
                        solutionView.setText(simplify.simple(input));
                    }
                }catch(Exception e){
                    solutionView.setText("Enter an expression and then press simplify");

                }
            }
        });

        //If derivative button is pressed
        dervBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    //solutionView.setText("Hello");
                    if (!ValidInput.isValidInput(inputText.getText().toString())) {
                        solutionView.setText(ValidInput.getErrorMessage());

                    } else {
                        String input = inputText.getText().toString();
                        if(simp[0]){
                            solutionView.setText(simplify.simple(derivative.takeDerivative(input)));
                        }else {
                            solutionView.setText(derivative.takeDerivative(input));
                        }
                    }
                }catch(Exception e){
                    solutionView.setText("Enter an expression and then press derivative");

                }

            }

        });

        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    simp[0] = true;
                }else{
                    simp[0] = false;
                }
            }
        });



    }

}