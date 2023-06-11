package com.example.laba11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        preferences = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);
    }

    public void Start(View view){
        Intent intent = new Intent (this,Second.class);
        startActivity(intent);
    }

    @Override
    protected void onResume(){
        super.onResume();
        int colorVal = preferences.getInt(getString(R.string.color), getResources().getColor(R.color.white));
        getWindow().getDecorView().setBackgroundColor(colorVal);
    }
}
