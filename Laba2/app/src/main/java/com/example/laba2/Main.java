package com.example.laba2;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    TextView textView1, textView2;
    Button buttonAdd, buttonCopy;

    @Override
    protected  void onCreate(@Nullable Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.layout);
        textView1=(TextView)findViewById(R.id.tv1);
        textView2=(TextView)findViewById(R.id.tv2);
        buttonAdd=(Button) findViewById(R.id.add);
        buttonCopy=(Button)findViewById(R.id.cpy);
    }

    public void onAdd(View view){
        String s = textView1.getText().toString();
        s+="*";
        textView1.setText(s);
    }

    public void onCopy(View view){
        String s1= textView1.getText().toString();
        textView2.setText(s1);
    }
}
