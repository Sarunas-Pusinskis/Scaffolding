package com.example.scaffolding.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PartDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "scaffolding.db";
    private static final int DATABASE_VERSION = 1;

    public PartDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PARTS_TABLE = "CREATE TABLE " +
                PartContract.PartEntry.TABLE_NAME + " (" +
                PartContract.PartEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PartContract.PartEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                PartContract.PartEntry.COLUMN_LENGTH + " REAL NOT NULL, " +
                PartContract.PartEntry.COLUMN_WEIGHT + " REAL NOT NULL);";

        db.execSQL(SQL_CREATE_PARTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement database upgrade logic if needed
    }
}
