package com.example.laba26;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TestsHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "testDB";

    public static final class Tests {

        public static final String TABLE_NAME = "testTable";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";
        public static String getCreateStatement(){
            return String.format(
                    "CREATE TABLE %s(" +
                            "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "%s TEXT," +
                            "%s TEXT," +
                            "%s INTEGER" +
                            ")",
                    TABLE_NAME,
                    BaseColumns._ID,
                    COLUMN_SURNAME,
                    COLUMN_NAME,
                    COLUMN_AGE
            );
        }
        public static String getTest(Cursor cursor){
            int surnameID = cursor.getColumnIndex(COLUMN_SURNAME),
                    nameID = cursor.getColumnIndex(COLUMN_NAME),
                    ageID = cursor.getColumnIndex(COLUMN_AGE);
            String testSurname = cursor.getString(surnameID);
            String testName = cursor.getString(nameID);
            String testAge=cursor.getString(ageID);
            return(testSurname + " " + testName + " " + testAge);
        }

        public static long insertTest(SQLiteDatabase db, String testSurname, String testName, int testAge){
            ContentValues values = new ContentValues();
            values.put(COLUMN_SURNAME, testSurname);
            values.put(COLUMN_NAME,testName);
            values.put(COLUMN_AGE, testAge);
            return db.insert(TABLE_NAME, null, values);
        }

        public static long updTest(SQLiteDatabase db, String id, String testSurname, String testName, int testAge){
            ContentValues values = new ContentValues();
            values.put(COLUMN_SURNAME, testSurname);
            values.put(COLUMN_NAME,testName);
            values.put(COLUMN_AGE, testAge);
            return db.update(TABLE_NAME, values, "_id = ?", new String[] { id });
        }

        public static long delTest(SQLiteDatabase db, String id) {
            return db.delete(TABLE_NAME, "_id = ?", new String[]{id});
        }

        public static Cursor srchTest(SQLiteDatabase db, String surname, String name, int _age){
            String age = String.valueOf(_age);
            return db.query(TABLE_NAME, null, "surname = ? and name = ? and age = ?", new String[]{surname, name, age}, null, null,null);
        }
    }

    public TestsHelper(Context context) {
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