package com.example.scaffolding.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scaffolding.R;
import com.example.scaffolding.data.database.PartContract;
import com.example.scaffolding.data.database.PartDbHelper;

public class ViewDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_data_activity);

        ListView listView = findViewById(R.id.listView);

        // Inicializuojame SQLite duomenų bazės helper'į
        SQLiteOpenHelper dbHelper = new PartDbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Atliekame užklausą, gauname visus įrašus iš duomenų bazės
        Cursor cursor = db.query(
                PartContract.PartEntry.TABLE_NAME,
                null, // Galite nurodyti stulpelių sąrašą, jei norite konkretų stulpelį
                null,
                null,
                null,
                null,
                null
        );

        // Nurodome, kurie stulpeliai turi būti atvaizduoti (COLUMN_NAME, COLUMN_LENGTH, COLUMN_WEIGHT)
        String[] fromColumns = {
                PartContract.PartEntry.COLUMN_NAME,
                PartContract.PartEntry.COLUMN_LENGTH,
                PartContract.PartEntry.COLUMN_WEIGHT
        };

        // Nurodome, į kurias laukus išdėlioti duomenis vaizde
        int[] toViews = {R.id.nameTextView, R.id.lengthTextView, R.id.weightTextView};

        // Sukuriame adapterį ir susiejame su ListView
        // Suderinamas elementų maketas su jūsų reikalavimais
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                R.layout.list_item_layout, // Suderinamas elementų maketas su jūsų reikalavimais
                cursor,
                fromColumns,
                toViews,
                0
        );

        listView.setAdapter(cursorAdapter);
    }
}
