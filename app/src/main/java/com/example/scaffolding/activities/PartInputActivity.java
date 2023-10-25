package com.example.scaffolding.activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scaffolding.R;
import com.example.scaffolding.models.SavedData;
import com.example.scaffolding.data.database.PartContract;
import com.example.scaffolding.data.database.PartDbHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PartInputActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_SAVED_DATA = "savedData";

    private EditText nameEditText;
    private EditText lengthEditText;
    private EditText weightEditText;

    private List<SavedData> savedDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_input);

        nameEditText = findViewById(R.id.nameEditText);
        lengthEditText = findViewById(R.id.lengthEditText);
        weightEditText = findViewById(R.id.weightEditText);
        Button clickMeButton = findViewById(R.id.clickMeButton);

        Button viewDataButton = findViewById(R.id.viewDataButton);
        viewDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent and pass the savedDataList as a JSON string
                Intent intent = new Intent(PartInputActivity.this, ViewDataActivity.class);
                intent.putExtra("savedDataList", new Gson().toJson(savedDataList));
                startActivity(intent);
            }
        });

        loadSavedData();

        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                double length = Double.parseDouble(lengthEditText.getText().toString());
                double weight = Double.parseDouble(weightEditText.getText().toString());

                ContentValues values = new ContentValues();
                values.put(PartContract.PartEntry.COLUMN_NAME, name);
                values.put(PartContract.PartEntry.COLUMN_LENGTH, length);
                values.put(PartContract.PartEntry.COLUMN_WEIGHT, weight);

                PartDbHelper dbHelper = new PartDbHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                long newRowId = db.insert(PartContract.PartEntry.TABLE_NAME, null, values);

            }
        });
    }

    private void loadSavedData() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String json = prefs.getString(PREF_SAVED_DATA, null);

        if (json != null) {
            Type listType = new TypeToken<ArrayList<SavedData>>() {
            }.getType();
            savedDataList = new Gson().fromJson(json, listType);
        } else {
            savedDataList = new ArrayList<>();
        }
    }
}
