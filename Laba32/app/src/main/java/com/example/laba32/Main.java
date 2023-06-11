package com.example.laba32;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.sql.Time;

public class Main extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        textView = (TextView)findViewById(R.id.tv);
    }

    public void list_click(View view){
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(manager, "myDialog");
    }

    public void switch_click(View view){
        FragmentManager manager2 = getSupportFragmentManager();
        MyDialogFragment2 myDialogFragment2 = new MyDialogFragment2();
        myDialogFragment2.show(manager2, "myDialog2");
    }

    public void flag_click(View view){
        FragmentManager manager3 = getSupportFragmentManager();
        MyDialogFragment3 myDialogFragment3 = new MyDialogFragment3();
        myDialogFragment3.show(manager3, "myDialog3");
    }

    public void person_click(View view){
        FragmentManager manager4 = getSupportFragmentManager();
        MyDialogFragment4 myDialogFragment4 = new MyDialogFragment4();
        myDialogFragment4.show(manager4, "myDialog4");
    }

    public void dateTime_click(View view){
        FragmentManager manager5 = getSupportFragmentManager();
        MyDialogFragment5 myDialogFragment5 = new MyDialogFragment5();
        myDialogFragment5.show(manager5, "myDialog5");
    }

    public void listData(String str){
        textView.setText(str);
    }

    public void switchData(String str){
        textView.setText(str);
    }

    public void flagData(String str){
        textView.setText(str);
    }

    public void personData(Person person){
        textView.setText(person.toString());
    }

    public void timeData(Time time){
        textView.setText("Выбранное время: " + time.toString());
    }
}
