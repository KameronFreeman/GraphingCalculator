package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculatorapp.R;

public class calculusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculus);

        Button backBtn =(Button) findViewById(R.id.backBtn);
        Button graphBtn =(Button) findViewById(R.id.graphBtn);

        Button dervBtn =(Button) findViewById(R.id.dervBtn);
        Button dervNBtn =(Button) findViewById(R.id.dervNBtn);

        TextView solutionView = (TextView) findViewById(R.id.solutionTextView);
        EditText inputText = (EditText) findViewById(R.id.InputEditText);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainMenu);
            }
        });


    }
}