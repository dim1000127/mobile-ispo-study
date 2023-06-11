package com.example.laba29;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    ArrayAdapter arad;
    Button button1, button2, button3, button4, button5, button6;
    Spinner spinner1, spinner2;
    ListView listView;
    EditText editText1, editText2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        arad = new ArrayAdapter<String>(this, R.layout.tv);
        ArrayAdapter adapterForSpinner1 = new ArrayAdapter<>(this, R.layout.tv);
        ArrayAdapter adapterForSpinner2 = new ArrayAdapter<>(this, R.layout.tv);
        adapterForSpinner1.addAll(Sex.values());
        adapterForSpinner2.addAll(Status.values());
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button3 = (Button)findViewById(R.id.btn3);
        button4 = (Button)findViewById(R.id.btn4);
        button5 = (Button)findViewById(R.id.btn5);
        button6 = (Button)findViewById(R.id.btn6);
        spinner1 = (Spinner)findViewById(R.id.priority1);
        spinner2 = (Spinner)findViewById(R.id.priority2);
        listView = (ListView)findViewById(R.id.lv);
        editText1 = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
        button1.setOnClickListener(forBtn1);
        button2.setOnClickListener(forBtn2);
        button3.setOnClickListener(forBtn3);
        button4.setOnClickListener(forBtn4);
        button5.setOnClickListener(forBtn5);
        button6.setOnClickListener(forBtn6);
        listView.setAdapter(arad);
        spinner1.setAdapter(adapterForSpinner1);
        spinner2.setAdapter(adapterForSpinner2);
        spinner1.setSelection(0);
        spinner2.setSelection(0);

    }

    private View.OnClickListener forBtn1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            arad.add(spinner2.getSelectedItemPosition());
        }
    };

    private View.OnClickListener forBtn2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            arad.add(Status.valueOf(spinner2.getSelectedItemPosition()));
        }
    };

    private View.OnClickListener forBtn3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            arad.addAll(Sex.values());
        }
    };

    private View.OnClickListener forBtn4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            arad.addAll(Status.values());
        }
    };

    private View.OnClickListener forBtn5 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Person person = new Person(editText1.getText().toString(),
                    Integer.valueOf(editText2.getText().toString()),
                    Sex.valueOf(spinner1.getSelectedItemPosition()),
                    Status.valueOf(spinner2.getSelectedItemPosition()));
            arad.add(person.toString());
        }
    };

    private View.OnClickListener forBtn6 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            arad.clear();
        }
    };
}