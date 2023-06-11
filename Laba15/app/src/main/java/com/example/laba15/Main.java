package com.example.laba15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Main extends MyBaseActivity
        implements AdapterView.OnItemClickListener {
    ArrayAdapter<String> arad;
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        arad = new ArrayAdapter<String>(this, R.layout.tv);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(arad);
        listView.setOnItemClickListener(this);
    }

    public void btnAdd(View view){
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_TEXT,"");
        startActivityForResult(intent, CREATE_ACTION);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_TEXT,arad.getItem(position));
        intent.putExtra(EXTRA_ID,position);
        startActivityForResult(intent, EDIT_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            String text = extras.getString(EXTRA_TEXT);
            switch (requestCode){
                case CREATE_ACTION:
                    arad.add(text);
                    break;
                case EDIT_ACTION:
                    int pos = extras.getInt(EXTRA_ID);
                    arad.remove(arad.getItem(pos));
                    arad.insert(text, pos);
                    break;
            }
        }
    }
}