package com.example.laba7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Second extends Activity {
    ArrayAdapter<String> arad;
    ArrayAdapter<String> arad2;
    ListView lw, lw2;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec);
        arad = new ArrayAdapter<String>(this, R.layout.tv);
        arad2 = new ArrayAdapter<String>(this, R.layout.tv);

        lw = (ListView)findViewById(R.id.lw);
        lw2 = (ListView)findViewById(R.id.lw2);
        editText = (EditText)findViewById(R.id.et1);
        lw.setAdapter(arad);
        lw2.setAdapter(arad2);
    }

    public void AddList1(View view){
        String word = editText.getText().toString();
        arad.add(word);
        editText.setText(null);
    }

    public void AddList2(View view){
        String word2 = editText.getText().toString();
        arad2.add(word2);
        editText.setText(null);
    }

    public void Back(View view){
        onBackPressed();
    }

}
