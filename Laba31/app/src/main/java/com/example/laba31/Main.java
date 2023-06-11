package com.example.laba31;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
    }

    public void dataPicker_click(View view){
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    public void timePicker_click(View view){
        Intent intent = new Intent(this, Third.class);
        startActivity(intent);
    }
}
