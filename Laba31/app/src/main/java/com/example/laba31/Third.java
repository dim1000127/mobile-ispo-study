package com.example.laba31;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Third extends AppCompatActivity {

    TextView textView1, textView2;
    TimePicker timePicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        textView1 = (TextView)findViewById(R.id.tvTimeCome);
        textView2 = (TextView)findViewById(R.id.tvTimeCare);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
    }

    public void setTimeCome_click(View view){
        textView1.setText(
                ("Время прихода:\n")
                + String.valueOf(timePicker.getHour()) + (":")
                + String.valueOf(timePicker.getMinute()));
    }

    public void setTimeCare_click(View view){
        textView2.setText(
                ("Время ухода:\n")
                + String.valueOf(timePicker.getHour()) + (":")
                + String.valueOf(timePicker.getMinute()));
    }

    public void setTimeCurrent_click(View view){
        Calendar now = Calendar.getInstance();
        timePicker.setHour(now.get(Calendar.HOUR_OF_DAY));
        timePicker.setMinute(now.get(Calendar.MINUTE));
    }

}
