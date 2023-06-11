package com.example.laba25;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    ListView listView;
    ArrayAdapter<String> arad;
    private TestsHelper dbHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(@Nullable Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.layout);
        editText1 = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
        editText3 = (EditText)findViewById(R.id.et3);
        listView = (ListView)findViewById(R.id.lv1);
        arad = new ArrayAdapter<String>(this, R.layout.tv);
        listView.setAdapter(arad);
        dbHelper = new TestsHelper(this);
        loadTests();
    }

    public void addTable_Click(View view){
        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();
        int age = Integer.valueOf(editText3.getText().toString());
        addTest(str1, str2, age);
    }

    public void displayLv_Click(View view){
        arad.clear();
        arad.notifyDataSetChanged();
        for(int i = 0; i<getNotesCount(); i++) {
            arad.add(getTest(i));
        }
    }

    public int getNotesCount() {
        return cursor.getCount();
    }

    public void loadTests() {
        cursor = dbHelper.getReadableDatabase().rawQuery(
                String.format(
                        "SELECT * FROM %s",
                        TestsHelper.Tests.TABLE_NAME
                ), null);
    }

    public String getTest(int id) {
        cursor.moveToPosition(id);
        return TestsHelper.Tests.getTest(cursor);
    }

    public void addTest(String testSurname, String testName, int testAge) {
        TestsHelper.Tests.insertTest(
                dbHelper.getWritableDatabase(),
                testSurname, testName, testAge
        );
        loadTests();
    }
}
