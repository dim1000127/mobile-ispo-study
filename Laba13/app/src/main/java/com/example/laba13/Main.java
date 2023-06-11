package com.example.laba13;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity implements TextWatcher{
        EditText editText;
        TextView textView;
        Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        editText = (EditText)findViewById(R.id.et);
        textView = (TextView)findViewById(R.id.tv);
        button = (Button)findViewById(R.id.btn);
        button.setEnabled(false);
        editText.addTextChangedListener(this);
    }

    public void ok_click(View view){
        String text = editText.getText().toString();
        textView.setText(text);
        editText.setText("");
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(editText.getText().toString().trim().length()!=0){
            button.setEnabled(true);
        }
        else{
            button.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
