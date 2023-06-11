package com.example.laba17;

import android.app.Application;

public class MyApp extends Application {
    private String classText1;
    private String classText2;

    public MyApp() {
        super();
        classText1 = "TXT";
        classText2 = "STR";
    }

    public String getTextOne() {
        return classText1;
    }

    public String getTextTwo() {
        return classText2;
    }

    public void setTextOne(String text) {
        classText1 = text;
    }

    public void setTextTwo(String text) {
        classText2 = text;
    }
}
