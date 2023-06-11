package com.example.laba28;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    ArrayAdapter<String> arad;
    Button button1, button2;
    ListView listView;
    Spinner spinner1, spinner2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        button1 = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        listView = (ListView)findViewById(R.id.lv);
        spinner1 = (Spinner)findViewById(R.id.priority);
        spinner2 = (Spinner)findViewById(R.id.priority2);
        ArrayAdapter adapterForSpinner = new ArrayAdapter<>(this, R.layout.tv);
        adapterForSpinner.addAll(getResources().getStringArray(R.array.array));
        arad = new ArrayAdapter<String>(this, R.layout.tv);
        spinner1.setAdapter(adapterForSpinner);
        spinner2.setAdapter(adapterForSpinner);
        spinner1.setSelection(0);
        spinner2.setSelection(0);
        listView.setAdapter(arad);
        button1.setOnClickListener(forBtn1);

        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        arad.add(spinner2.getSelectedItem().toString());
                    }
                }
        );
    }

    private View.OnClickListener forBtn1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //spinner1.getSelectedItemPosition();
            arad.add(spinner1.getSelectedItem().toString());
        }
    };
}
