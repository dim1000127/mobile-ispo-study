package com.example.laba27;

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
        public static String getCreateStatement(){
            return String.format(
                    "CREATE TABLE %s(" +
                            "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "%s TEXT," +
                            "%s TEXT," +
                            "%s TEXT" +
                            ")",
                    TABLE_NAME,
                    BaseColumns._ID,
                    COLUMN_NAME,
                    COLUMN_TEXT,
                    COLUMN_TIME
            );
        }
        public static String[] getNote(Cursor cursor){
            int nameID = cursor.getColumnIndex(COLUMN_NAME),
                    textID = cursor.getColumnIndex(COLUMN_TEXT),
                    timeID = cursor.getColumnIndex(COLUMN_TIME);
            String nameN = cursor.getString(nameID);
            String textN = cursor.getString(textID);
            String timeN=cursor.getString(timeID);
            String[] note = new String[]{nameN, textN, timeN};
            return note;
        }

        public static long insertTest(SQLiteDatabase db, Note note){
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, note.getName());
            values.put(COLUMN_TEXT, note.getContent());
            values.put(COLUMN_TIME, note.getTime().toString());
            return db.insert(TABLE_NAME, null, values);
        }

        public static long updTest(SQLiteDatabase db, String id, Note note){
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, note.getName());
            values.put(COLUMN_TEXT, note.getContent());
            values.put(COLUMN_TIME, note.getTime().toString());
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
