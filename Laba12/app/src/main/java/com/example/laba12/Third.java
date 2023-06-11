package com.example.laba12;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Third extends MyBaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.third);
    }

    public void BackThird(View view){
        this.onBackPressed();
    }
}
