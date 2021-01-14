package com.example.bigcash;

import android.widget.Button;
import android.widget.TextView;

public class DataPoint {

    int xValue, yValue;


    public DataPoint(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }
    public DataPoint() {
    }


    public int getxValue() {
        return xValue;
    }

    public int getyValue() {
        return yValue;
    }
}
