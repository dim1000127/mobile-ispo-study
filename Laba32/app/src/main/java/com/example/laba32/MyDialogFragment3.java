package com.example.laba32;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class MyDialogFragment3 extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};
        final boolean[] checkedItemsArray = {false, true, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите котов")
                .setMultiChoiceItems(catNamesArray, checkedItemsArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkedItemsArray[which] = isChecked;
                            }
                        })
                .setPositiveButton("Готово", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                StringBuilder state = new StringBuilder();
                                for (int i = 0; i < catNamesArray.length; i++) {
                                    state.append(catNamesArray[i]);
                                    if (checkedItemsArray[i])
                                        state.append(" выбран\n");
                                    else
                                        state.append(" не выбран\n");
                                }
                                Toast.makeText(getActivity(),
                                        state.toString(), Toast.LENGTH_LONG)
                                        .show();
                                ((Main)getActivity()).flagData(state.toString());
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
