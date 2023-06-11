package com.example.laba16;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ToastHelper {

    Context context;

    public ToastHelper(Context context){
        this.context = context;
    }

    public void show(String message1, String message2) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast, null);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        TextView tv=(TextView)layout.findViewById(R.id.text);
        TextView tv2=(TextView)layout.findViewById(R.id.text2);
        tv.setText(message1);
        tv2.setText(message2);
        toast.show();
    }
}
