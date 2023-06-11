package com.example.lava19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.List;

public class Main extends MyBaseActivity implements AdapterView.OnItemClickListener {
    protected MyApp myApp;
    Adapter adapter;
    List<String> notes;
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        myApp= (MyApp)getApplicationContext();
        notes = myApp.getList();
        adapter = new Adapter(this);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
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
        intent.putExtra(EXTRA_TEXT,adapter.getItem(position));
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
                    notes.add(text);
                    break;
                case EDIT_ACTION:
                    int pos = extras.getInt(EXTRA_ID);
                    notes.set(pos,text);
                    break;
            }
        }
        listView.invalidateViews();
    }
}
