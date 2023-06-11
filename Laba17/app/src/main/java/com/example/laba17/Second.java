package com.example.laba17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    protected MyApp myApp;
    EditText editText1, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        myApp= (MyApp)getApplicationContext();
        editText1 = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
        editText1.setText(myApp.getTextOne());
        editText2.setText(myApp.getTextTwo());
    }

    public void ok_click(View view){
        myApp.setTextOne(editText1.getText().toString());
        myApp.setTextTwo(editText2.getText().toString());
        setResult(RESULT_OK);
        finish();
    }


    public void cancel_click(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
