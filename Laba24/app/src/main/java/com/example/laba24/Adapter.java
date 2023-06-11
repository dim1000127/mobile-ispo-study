package com.example.laba24;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class Adapter extends BaseAdapter {
    Context context;
    private final Random random;
    List<Note> notes;

    public Adapter (Context context2){
        context = context2;
        MyApp myApp = (MyApp) context.getApplicationContext();
        notes = myApp.getList();
        random = new Random();
    }

    int randColor(){
        int r,g,b;
        r = random.nextInt(256);
        g = random.nextInt(256);
        b = random.nextInt(256);
        return Color.rgb(r,g,b);
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Note getItem(int position) {
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
        ColoredView tvColor = layout.findViewById(R.id.tvColor);
        TextView tvText = (TextView) layout.findViewById(R.id.tvTextName);
        tvText.setText(notes.get(position).getName());
        TextView tvText2 = (TextView) layout.findViewById(R.id.tvTextContent);
        tvText2.setText(notes.get(position).getContent());
        TextView tvText3 = (TextView) layout.findViewById(R.id.tvTextTime);
        tvText3.setText(notes.get(position).getTime().toString());
        tvColor.setColor(randColor());
        return convertView;
    }
}
