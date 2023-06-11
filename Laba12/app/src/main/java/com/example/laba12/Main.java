package com.example.laba12;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Main extends MyBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
    }

    public void Start(View view){
        Intent intent = new Intent (this,Second.class);
        startActivity(intent);
    }

    public void StartThird(View view){
        Intent intent = new Intent (this,Third.class);
        startActivity(intent);
    }

}