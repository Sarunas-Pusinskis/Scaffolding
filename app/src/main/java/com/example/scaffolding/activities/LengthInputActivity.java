package com.example.scaffolding.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scaffolding.R;

public class LengthInputActivity extends AppCompatActivity {

    private EditText widthEditText;
    private EditText heightEditText;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_input_activity);

        widthEditText = findViewById(R.id.widthEditText);
        heightEditText = findViewById(R.id.heightEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String widthText = widthEditText.getText().toString();
                String heightText = heightEditText.getText().toString();
                double width = Double.parseDouble(widthText);
                double height = Double.parseDouble(heightText);

                double area = width * height;

                resultTextView.setText("Plotas: " + area + " m2");
            }
        });
    }
}
