package com.example.laba9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity{

    EditText editText, editText2, editText3;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        editText = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
        editText3 = (EditText)findViewById(R.id.et3);
        preferences = getSharedPreferences(getString(R.string.preferences),MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String intElKey = getString(R.string.key1);
        String intElKey2 = getString(R.string.key2);
        String intElKey3 = getString(R.string.key3);
        String El = preferences.getString(intElKey, "Hello");
        String E2 = preferences.getString(intElKey2, "Hello");
        int intE3 = preferences.getInt(intElKey3, 5);
        editText.setText(El);
        editText2.setText(E2);
        editText3.setText(String.valueOf(intE3));
    }

    @Override
    protected void onPause() {
        super.onPause();
        String E1 = editText.getText().toString();
        String E2 = editText2.getText().toString();
        int intE3 = Integer.parseInt(editText3.getText().toString());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(getString(R.string.key1), E1);
        editor.putString(getString(R.string.key2), E2);
        editor.putInt(getString(R.string.key3), intE3);
        editor.commit();
    }
}

