package com.example.laba12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorsAdapter extends BaseAdapter {

    private int[] colors;
    private String[] names;

    public ColorsAdapter(int[] _colors, String [] _names){
        colors = _colors;
        names = _names;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Context context = parent.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.tv, parent, false);
        }

        TextView textView = (TextView) view;
        textView.setText(names[position]);
        textView.setBackgroundColor(colors[position]);

        return view;
    }
}
