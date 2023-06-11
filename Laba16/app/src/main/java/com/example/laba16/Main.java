package com.example.laba16;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    ToastHelper th;
    EditText editText, editText2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        editText = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
        th = new ToastHelper(this);
    }

    public void showToast(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Пора покормить кота!",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void showToastTwo(View view){
        int duration = Toast.LENGTH_LONG;
        Toast toast2 = Toast.makeText(getApplicationContext(),
                R.string.catfood,
                duration);
        toast2.setGravity(Gravity.TOP, 0, 0);
        toast2.show();
    }

    public void showToastThree(View view){
        Toast toast3 = Toast.makeText(getApplicationContext(),
                R.string.catfood, Toast.LENGTH_LONG);
        Toast toast3t = Toast.makeText(getApplicationContext(),
                "Ваша версия Android слишком новая, мы не можем отобразить Toast с картинкой",
                Toast.LENGTH_SHORT);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            toast3.setGravity(Gravity.CENTER, 0, 0);
            LinearLayout toastContainer = (LinearLayout) toast3.getView();
            ImageView catImageView = new ImageView(getApplicationContext());
            catImageView.setImageResource(R.drawable.cat);
            toastContainer.addView(catImageView, 0);
            toast3.show();
        }
        else{
            toast3t.setGravity(Gravity.TOP, 0, 0);
            toast3t.show();
        }

    }

    public void showToastFour(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, null);

        Toast toast4 = new Toast(getApplicationContext());
        toast4.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast4.setDuration(Toast.LENGTH_LONG);
        toast4.setView(layout);
        toast4.show();
    }

    public void showToastFive(View view){
        LayoutInflater inflater2 = getLayoutInflater();
        View layout = inflater2.inflate(R.layout.custom_toast, null);
        TextView tv=(TextView)layout.findViewById(R.id.text);
        TextView tv2=(TextView)layout.findViewById(R.id.text2);
        ImageView iv=(ImageView)layout.findViewById(R.id.image);

        Toast toast5 = new Toast(getApplicationContext());
        toast5.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast5.setDuration(Toast.LENGTH_LONG);
        toast5.setView(layout);
        tv.setText("Волк");
        tv.setBackgroundColor(Color.RED);
        tv.setTextColor(Color.BLUE);
        tv2.setText("Собака");
        tv2.setBackgroundColor(Color.GREEN);
        tv2.setTextColor(Color.GRAY);
        iv.setImageResource(R.drawable.dog);
        toast5.show();
    }

    public void showToastSix(View view){
        th.show(editText.getText().toString(),editText2.getText().toString());
    }
}
