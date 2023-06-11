package com.example.laba17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    protected MyApp myApp;
    protected static final int MY_ACTION=0x000314;
    EditText editText1, editText2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        myApp= (MyApp)getApplicationContext();
        editText1 = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
        editText1.setText(myApp.getTextOne());
        editText2.setText(myApp.getTextTwo());
    }

    public void ok_click(View view){
        Intent intent=new Intent(this, Second.class);
        myApp.setTextOne(editText1.getText().toString());
        myApp.setTextTwo(editText2.getText().toString());
        startActivityForResult(intent, MY_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            editText1.setText(myApp.getTextOne());
            editText2.setText(myApp.getTextTwo());
        }
    }
}
