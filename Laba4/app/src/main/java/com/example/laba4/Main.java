package com.example.laba4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    TextView textView1;
    EditText editText1, editText2;

    @Override
    protected void onCreate(@Nullable Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.layout);
        textView1 = (TextView) findViewById(R.id.tv1);
        editText1 = (EditText) findViewById(R.id.et1);
        editText2 = (EditText) findViewById(R.id.et2);
    }

    public void PlusClick(View view) {
        int n = Integer.valueOf(editText1.getText().toString());
        int k = Integer.valueOf(editText2.getText().toString());

        int summa = n + k;

        textView1.setText(String.valueOf(summa));
    }

    public void MinusClick(View view){
        int n = Integer.valueOf(editText1.getText().toString());
        int k = Integer.valueOf(editText2.getText().toString());

        int P = n - k;

        textView1.setText(String.valueOf(P));
    }

    public void MultiplyClick(View view){
        int n = Integer.valueOf(editText1.getText().toString());
        int k = Integer.valueOf(editText2.getText().toString());

        int P = n * k;

        textView1.setText(String.valueOf(P));
    }

    public void DivideClick(View view){
        int n = Integer.valueOf(editText1.getText().toString());
        int k = Integer.valueOf(editText2.getText().toString());

        int P = n / k;

        textView1.setText(String.valueOf(P));
    }
}

