package com.example.scaffolding.data.database;

import android.provider.BaseColumns;

public final class PartContract {
    private PartContract() {
    }

    public static class PartEntry implements BaseColumns {
        public static final String TABLE_NAME = "parts";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_LENGTH = "length";
        public static final String COLUMN_WEIGHT = "weight";
    }
}
