package com.example.laba14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    protected static final int MY_ACTION=0x000314;
    EditText editText1, editText2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        editText1 = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
    }

    public void ok_click(View view){
        Intent intent=new Intent(this, Second.class);
        intent.putExtra(getResources().getString(R.string.et1),editText1.getText().toString());
        intent.putExtra(getResources().getString(R.string.et2),editText2.getText().toString());
        startActivityForResult(intent, MY_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            String str1 = extras.getString(getResources().getString(R.string.et1));
            String str2 = extras.getString(getResources().getString(R.string.et2));
            editText1.setText(str1);
            editText2.setText(str2);
        }
    }
}
