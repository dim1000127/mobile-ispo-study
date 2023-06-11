package com.example.lava19;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    private final List<String> notes = new ArrayList<>();

    public MyApp() {
        super();
        notes.add("Record 1");
        notes.add("Record 2");
    }

    public List<String> getList(){
        return notes;
    }
}
