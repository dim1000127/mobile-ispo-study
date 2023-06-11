package com.example.laba12;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyBaseActivity extends AppCompatActivity {
    SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        preferences = getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);
    }

    @Override
    protected void onResume(){
        super.onResume();
        int colorVal = preferences.getInt(getString(R.string.color), getResources().getColor(R.color.white));
        getWindow().getDecorView().setBackgroundColor(colorVal);
    }
}
