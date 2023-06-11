package com.example.laba23;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Second extends MyBaseActivity implements TextWatcher {
    EditText editText;
    Button button_ok;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        editText = (EditText)findViewById(R.id.et);
        editText.addTextChangedListener(this);
        button_ok = (Button)findViewById(R.id.btnOK);
        button_ok.setEnabled(false);
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            String text = extras.getString(EXTRA_TEXT);
            if(text!=null){
                editText.setText(text);
            }
        }
    }

    public void ok_click(View view){
        Intent intent = getIntent();
        intent.putExtra(EXTRA_TEXT, editText.getText().toString());
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
        if (editText.getText().toString().trim().length() == 0){
            button_ok.setEnabled(false);
        }
        else {
            button_ok.setEnabled(true);
        }
    }

    @Override

    public void afterTextChanged(Editable s) {

    }

}
