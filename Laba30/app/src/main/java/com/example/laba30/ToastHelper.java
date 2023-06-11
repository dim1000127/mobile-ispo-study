package com.example.laba30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ToastHelper {

    Context context;

    public ToastHelper(Context context){
        this.context = context;
    }

    public void show(String message1) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.toast, null);
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        TextView tv=(TextView)layout.findViewById(R.id.toast);
        tv.setText(message1);
        toast.show();
    }
}
