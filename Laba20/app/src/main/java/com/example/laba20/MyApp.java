package com.example.laba20;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    private final List<String> notes = new ArrayList<>();
    ToastHelper toast;

    public MyApp() {
        super();
        notes.add("Record 1");
        notes.add("Record 2");
        toast = new ToastHelper(this);
    }

    public List<String> getList(){
        return notes;
    }

    public void addNotes(String str){
        notes.add(str);
        toast.show(getResources().getString(R.string.addTextToast));
    }

    public void setItem(int id, String str){
        notes.set(id, str);
        toast.show(getResources().getString(R.string.editTextToast));
    }
}