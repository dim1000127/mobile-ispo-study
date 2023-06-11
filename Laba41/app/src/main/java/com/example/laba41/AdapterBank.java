package com.example.laba41;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class AdapterBank extends BaseAdapter {

    Context context;
    List<Bank> banks;

    public AdapterBank(Context context2, List<Bank> _banks){
        context = context2;
        banks = _banks;
    }

    @Override
    public int getCount() {
        return banks.size();
    }

    @Override
    public Object getItem(int position) {
        return banks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public String startStr(int position){
        return banks.get(position).getStart();
    }

    public String finStr(int position){
        return banks.get(position).getFin();
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
        TextView adrBank = (TextView)layout.findViewById(R.id.addressBank);
        adrBank.setText(banks.get(position).getAdr());
        TextView typeBank = (TextView)layout.findViewById(R.id.typeBank);
        int type = Integer.valueOf(banks.get(position).getT());
        if (type == 2){
            typeBank.setText("Банкомат");
        }
        else {
            typeBank.setText("Отделение");
        }
        TextView workBank = (TextView)layout.findViewById(R.id.workBank);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm");
        String dateTime=dateFormat.format(c.getTime());
        int color;
        String str;
        if(dateTime.compareTo(startStr(position))>=0 && dateTime.compareTo(finStr(position))<=0){
            color = ContextCompat.getColor(context, R.color.green);
            str = "Работает";
        }
        else{
            color = ContextCompat.getColor(context, R.color.red);
            str = "Закрыто";
        }
        workBank.setText(str);
        workBank.setTextColor(color);
        TextView timeBank = (TextView)layout.findViewById(R.id.timeBank);
        timeBank.setText(startStr(position)+" - "+finStr(position));
        return convertView;
    }
}
