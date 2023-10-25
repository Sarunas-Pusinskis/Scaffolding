package com.example.scaffolding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scaffolding.activities.LengthInputActivity;
import com.example.scaffolding.activities.PartInputActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Mygtukas paspaustas!", Toast.LENGTH_SHORT).show();
            }
        });

        Button lengthInputButton = findViewById(R.id.lengthInputButton);
        lengthInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LengthInputActivity.class);
                startActivity(intent);
            }
        });

            // Čia pridedame kodą, kuris inicializuoja naują mygtuką ir nustato jo paspaudimo veiksmus.
        Button addToDatabaseButton = findViewById(R.id.addToDatabaseButton);
        addToDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PartInputActivity.class);
                startActivity(intent);
                }
            });





    }
}
