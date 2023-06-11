package com.example.laba27;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Main extends MyBaseActivity implements AdapterView.OnItemClickListener {
    protected MyApp myApp;
    Adapter adapter;
    List<Note> notes;
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        myApp= (MyApp)getApplicationContext();
        myApp.loadNotes();
        notes = new ArrayList<Note>();
        adapter = new Adapter(this, notes);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        myApp.setNotes(notes);
        listView.invalidateViews();
    }

    public void btnAdd(View view){
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_NOTE, new Note("", "", null));
        startActivityForResult(intent, CREATE_ACTION);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_NOTE, adapter.getItem(position));
        intent.putExtra(EXTRA_ID, position+1);
        startActivityForResult(intent, EDIT_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Note note = (Note) extras.getSerializable(EXTRA_NOTE);
            switch (requestCode){
                case CREATE_ACTION:
                    myApp.addNotes(note);
                    break;
                case EDIT_ACTION:
                    int pos = extras.getInt(EXTRA_ID);
                    myApp.setItem(pos, note);
                    break;
            }
        }
        myApp.setNotes(notes);
        listView.invalidateViews();
    }
}
