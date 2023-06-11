package com.example.laba18;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity{
    EditText editText1, editText2;
    LinearLayout layout;
    protected void onCreate(@Nullable Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.layout);
        editText1 = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
        layout = (LinearLayout)findViewById(R.id.ll);
    }

    public void addTv(View view){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView textView = (TextView) inflater.inflate(R.layout.tv, null);
        textView.setText(editText1.getText().toString());
        layout.addView(textView);
        editText1.setText(null);
    }

    public void addForm(View view){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout root = (LinearLayout) inflater.inflate(R.layout.form, null);
        TextView textView = (TextView) root.findViewById(R.id.nameTxt);
        TextView textView2 = (TextView) root.findViewById(R.id.ageTxt);
        textView.setText(editText1.getText().toString());
        textView2.setText(editText2.getText().toString());
        layout.addView(root);
    }
}

