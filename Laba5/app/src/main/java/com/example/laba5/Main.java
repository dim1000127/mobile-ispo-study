package com.example.laba5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayAdapter<String> arad;
    ListView lw;
    EditText editText;
    Button edit, del;
    public int pos;
    private View curView=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        arad = new ArrayAdapter<String>(this,R.layout.tv);

        editText = (EditText)findViewById(R.id.et1);
        lw = (ListView)findViewById(R.id.lw);
        edit = (Button)findViewById(R.id.Btn2);
        del = (Button)findViewById(R.id.Btn3);
        lw.setAdapter(arad);
        arad.add("first");
        arad.add("second");
        lw.setOnItemClickListener(this);
        edit.setEnabled(false);
        del.setEnabled(false);
    }

    public void Add(View view) {
        String n = editText.getText().toString();
        arad.add(n);
        editText.setText(null);
    }

    public void Clear(View view) {
        arad.clear();
    }

    public void Edit(View view){
        String s = arad.getItem(pos);
        arad.remove(s);
        arad.insert(editText.getText().toString(),pos);
        editText.setText(null);
        edit.setEnabled(false);
        del.setEnabled(false);
    }

    public void Del(View view){
        String s = arad.getItem(pos);
        arad.remove(s);
        editText.setText(null);
        edit.setEnabled(false);
        del.setEnabled(false);
    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (curView != null) {
            curView.setBackgroundColor(ContextCompat.getColor(this,R.color.lvBack));
        }

        edit.setEnabled(true);
        del.setEnabled(true);

        pos = position;
        String s = arad.getItem(position);
        view.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        editText.setText(s);
        curView=view;
    }
}

