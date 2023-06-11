package com.example.laba32;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите кота")
                .setItems(catNamesArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),
                                "Любимое имя кота: " + catNamesArray[which], Toast.LENGTH_SHORT).show();
                        ((Main)getActivity()).listData("Выбранный кот: "+catNamesArray[which]);
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
