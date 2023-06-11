package com.example.laba30;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import java.sql.Time;

public class Second extends MyBaseActivity implements TextWatcher {
    EditText editText, editText2;
    Button button_ok;
    Spinner spinner;
    Note note;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        editText = (EditText)findViewById(R.id.etName);
        editText.addTextChangedListener(this);
        editText2 = (EditText)findViewById(R.id.etContent);
        editText2.addTextChangedListener(this);
        button_ok = (Button)findViewById(R.id.btnOK);
        button_ok.setEnabled(false);
        spinner = (Spinner)findViewById(R.id.priority);
        ArrayAdapter adapterForSpinner1 = new ArrayAdapter<>(this, R.layout.tvforspin);
        adapterForSpinner1.addAll(Priority.values());
        spinner.setAdapter(adapterForSpinner1);
        spinner.setSelection(0);
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            note = (Note) extras.getSerializable(EXTRA_NOTE);
            if(note!=null){
                editText.setText(note.getName());
                editText2.setText(note.getContent());
                spinner.setSelection(note.getPriority().ordinal());
            }
        }
    }

    public void ok_click(View view){
        Intent intent = getIntent();
        note.setName(editText.getText().toString());
        note.setContent(editText2.getText().toString());
        note.setTime(new Time(System.currentTimeMillis()));
        note.setPriority(Priority.valueOf(spinner.getSelectedItemPosition()));
        intent.putExtra(EXTRA_NOTE, note);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel_click(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if ((editText.getText().toString().trim().length() != 0) && (editText2.getText().toString().trim().length() != 0)){
            button_ok.setEnabled(true);
        }
        else {
            button_ok.setEnabled(false);
        }
    }

    @Override

    public void afterTextChanged(Editable s) { }
}
