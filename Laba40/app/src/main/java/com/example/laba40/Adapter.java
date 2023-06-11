package com.example.laba40;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    List<Message> messages;
    Context context;

    public Adapter(Context _context, List<Message> _messages){
        context = _context;
        messages = _messages;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
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
        TextView tvText = (TextView) layout.findViewById(R.id.textId);
        tvText.setText(String.valueOf(messages.get(position).getId()));
        TextView tvText2 = (TextView) layout.findViewById(R.id.textTime);
        tvText2.setText(String.valueOf(messages.get(position).getTime()));
        return convertView;
    }
}
