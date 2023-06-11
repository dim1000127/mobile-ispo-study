package com.example.laba32;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class MyDialogFragment4 extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.personlay, null);
        EditText editText = (EditText)view.findViewById(R.id.et1);
        EditText editText2 = (EditText)view.findViewById(R.id.et2);
        Spinner spinner1 = (Spinner)view.findViewById(R.id.priority1);
        Spinner spinner2 = (Spinner)view.findViewById(R.id.priority2);
        ArrayAdapter adapterForSpinner1 = new ArrayAdapter<>( getActivity(), R.layout.tv);
        ArrayAdapter adapterForSpinner2 = new ArrayAdapter<>( getActivity(), R.layout.tv);
        adapterForSpinner1.addAll(Sex.values());
        adapterForSpinner2.addAll(Status.values());
        spinner1.setAdapter(adapterForSpinner1);
        spinner2.setAdapter(adapterForSpinner2);
        spinner1.setSelection(0);
        spinner2.setSelection(0);
        builder.setTitle("Введите свои данные")
                .setView(view)
                .setPositiveButton("Готово", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Person person =  new Person(editText.getText().toString(),
                                Integer.valueOf(editText2.getText().toString()),
                                Sex.valueOf(spinner1.getSelectedItemPosition()),
                                Status.valueOf(spinner2.getSelectedItemPosition()));
                        ((Main) getActivity()).personData(person);
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
