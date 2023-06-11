package com.example.laba10;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        listView = (ListView)findViewById(R.id.lw);
        String[] items = getResources().getStringArray(R.array.array);
        ColorsAdapter adapter = new ColorsAdapter(items);
        listView.setAdapter(adapter);
    }
}
