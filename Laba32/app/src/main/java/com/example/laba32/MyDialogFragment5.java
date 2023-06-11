package com.example.laba32;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import java.sql.Time;

public class MyDialogFragment5 extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.time, null);
        TimePicker timePicker = (TimePicker)view.findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        builder.setTitle("Выберите время")
                .setView(view)
                .setPositiveButton("Готово", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String timestr = "";
                        if (timePicker.getMinute() < 10) {
                            timestr = String.format("%s:0%s:00", timePicker.getHour(), timePicker.getMinute());
                        }
                        timestr = String.format("%s:%s:00", timePicker.getHour(), timePicker.getMinute());
                        ((Main)getActivity()).timeData(Time.valueOf(timestr));
                        dialog.dismiss();
                    }
                })

                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
