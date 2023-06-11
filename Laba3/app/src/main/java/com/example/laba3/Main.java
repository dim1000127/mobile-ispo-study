package com.example.laba3;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity {
    LinearLayout linearLayout;
    TextView textView1, textView2;

    @Override
    protected  void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.layout);
        linearLayout=(LinearLayout)findViewById(R.id.mLL);
        textView1=(TextView)findViewById(R.id.tv1);
        textView2=(TextView)findViewById(R.id.tv2);
    }

    public void change(View view){
//        linearLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.btnBack1));
        Button btn1 = (Button) view;
        if (btn1.getId()==R.id.lBtn1 || btn1.getId()==R.id.lBtn2 || btn1.getId()==R.id.lBtn3)
        {
            textView1.setTextColor(btn1.getTextColors().getDefaultColor());
            textView1.setBackgroundColor(btn1.getBackgroundTintList().getDefaultColor());

            textView2.setTextColor(btn1.getTextColors().getDefaultColor());
            textView2.setBackgroundColor(btn1.getBackgroundTintList().getDefaultColor());
        }
        else
        {
            linearLayout.setBackgroundColor(btn1.getBackgroundTintList().getDefaultColor());
        }
    }
}