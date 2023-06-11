package com.example.laba30;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "testDB";

    public static final class Tests {

        public static final String TABLE_NAME = "testTable";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TEXT = "text";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_PRIORITY = "priority";
        public static String getCreateStatement(){
            return String.format(
                    "CREATE TABLE %s(" +
                            "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "%s TEXT," +
                            "%s TEXT," +
                            "%s TEXT," +
                            "%s INTEGER" +
                            ")",
                    TABLE_NAME,
                    BaseColumns._ID,
                    COLUMN_NAME,
                    COLUMN_TEXT,
                    COLUMN_TIME,
                    COLUMN_PRIORITY
            );
        }

        public static long insertTest(SQLiteDatabase db, Note note){
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, note.getName());
            values.put(COLUMN_TEXT, note.getContent());
            values.put(COLUMN_TIME, note.getTime().toString());
            values.put(COLUMN_PRIORITY, note.getPriority().ordinal());
            return db.insert(TABLE_NAME, null, values);
        }

        public static long updTest(SQLiteDatabase db, String id, Note note){
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, note.getName());
            values.put(COLUMN_TEXT, note.getContent());
            values.put(COLUMN_TIME, note.getTime().toString());
            values.put(COLUMN_PRIORITY, note.getPriority().ordinal());
            return db.update(TABLE_NAME, values, "_id = ?", new String[] { id });
        }
    }

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tests.getCreateStatement());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
