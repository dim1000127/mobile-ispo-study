package com.example.laba38;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    Context context;
    double coef;
    List<TestValute> testValute;
    String flagName = "";

    public Adapter(Context context2, List<TestValute> _testValute, double _coef){
        testValute = _testValute;
        context = context2;
        coef = _coef;
    }

    @Override
    public int getCount() {
        return testValute.size();
    }

    @Override
    public Object getItem(int position) {
        return testValute.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public String getFlag(String code){
        return code.toLowerCase().substring(0,2);
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
        TextView tvText = (TextView) layout.findViewById(R.id.flag);
        tvText.setText(testValute.get(position).getValuteCharCode());
        flagName = getFlag(testValute.get(position).getValuteCharCode());
        ImageView imageView=(ImageView)layout.findViewById(R.id.flagImg);
        int id1 = context.getResources().getIdentifier("com.example.laba38:drawable/" + flagName, null, null);
        imageView.setImageResource(id1);
        TextView tvText2 = (TextView) layout.findViewById(R.id.nameValute);
        tvText2.setText(testValute.get(position).getValuteName());
        TextView tvText3 = (TextView) layout.findViewById(R.id.buyValute);
        tvText3.setText(String.format("%.2f",(testValute.get(position).getValuteValue() - (testValute.get(position).getValuteValue() * coef))));
        TextView tvText4 = (TextView) layout.findViewById(R.id.saleValute);
        tvText4.setText(String.format("%.2f", (testValute.get(position).getValuteValue() + (testValute.get(position).getValuteValue() * coef))));

        if(position % 2 ==0) {
            tvText4.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.green, 0);
            tvText3.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.red, 0);
        } else {
            tvText4.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.red, 0);
            tvText3.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.green, 0);
        }

        return convertView;
    }
}
