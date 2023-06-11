package com.example.laba14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {

    EditText editText1, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        editText1 = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String txt1=extras.getString(getResources().getString(R.string.et1));
            String txt2=extras.getString(getResources().getString(R.string.et2));
            if(txt1!=null){
                editText1.setText(txt1);
            }
            if(txt2!=null){
                editText2.setText(txt2);
            }
        }
    }

    public void ok_click(View view){
        Intent intent=getIntent();
        intent.putExtra(getResources().getString(R.string.et1), editText1.getText().toString());
        intent.putExtra(getResources().getString(R.string.et2), editText2.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }


    public void cancel_click(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
