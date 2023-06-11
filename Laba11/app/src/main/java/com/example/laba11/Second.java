package com.example.laba11;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    private SharedPreferences preferences;
    int colorValue;
    String[] names;
    int[] colors;
    ColorsAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        listView = (ListView)findViewById(R.id.lw);
        colorValue = getResources().getColor(R.color.white);
        names = getResources().getStringArray(R.array.array);
        colors = getResources().getIntArray(R.array.color_values);
        adapter = new ColorsAdapter(colors, names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        preferences = getSharedPreferences(getString(R.string.preferences),MODE_PRIVATE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        colorValue = (int)adapter.getItem(position);
        getWindow().getDecorView().setBackgroundColor(colorValue);
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(getString(R.string.color), colorValue);
        editor.commit();
    }

    @Override
    protected void onResume(){
        super.onResume();
        int colorVal = preferences.getInt(getString(R.string.color), colorValue);
        colorValue = colorVal;
        getWindow().getDecorView().setBackgroundColor(colorVal);
    }

    public void back(View view){
        onBackPressed();
    }
}
