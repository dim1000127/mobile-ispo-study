package com.example.laba31;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Second extends AppCompatActivity {

    TextView textView1, textView2;
    DatePicker datePicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        textView1 = (TextView)findViewById(R.id.tvDateGet);
        textView2 = (TextView)findViewById(R.id.tvDateReturn);
        datePicker = (DatePicker)findViewById(R.id.dataPicker);
    }

    public void getBook_click(View view){
        textView1.setText(
                ("Дата получения книги:\n")
                +(datePicker.getDayOfMonth())+(".")
                +(datePicker.getMonth() + 1)+(".")
                +(datePicker.getYear()));
    }

    public void returnBook_click(View view){
        textView2.setText(
                ("Дата возврата книги:\n")
                        +(datePicker.getDayOfMonth())+(".")
                        +(datePicker.getMonth() + 1)+(".")
                        +(datePicker.getYear()));
    }

    public void setDateCurrent_click(View view){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, null);
    }
}
