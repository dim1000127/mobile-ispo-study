package com.example.laba20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class Adapter extends BaseAdapter {
    Context context;
    List<String> notes;

    public Adapter (Context context2){
        context = context2;
        MyApp myApp = (MyApp) context.getApplicationContext();
        notes = myApp.getList();
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public String getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tv, parent, false);
        }

        LinearLayout layout = (LinearLayout) convertView;
        TextView tvColor = (TextView) layout.findViewById(R.id.tvColor);
        TextView tvText = (TextView) layout.findViewById(R.id.tvText);

        tvColor.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
        tvText.setText(notes.get(position));
        return convertView;
    }
}
