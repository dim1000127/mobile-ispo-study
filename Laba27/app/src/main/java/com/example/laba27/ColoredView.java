package com.example.laba27;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ColoredView extends View {

    public ColoredView(Context context) {
        super(context);
    }

    public ColoredView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColoredView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void setColor(int color){
        setBackgroundColor(color);
    }
}
