package com.example.computergraphicsalgorithms;

import android.content.Intent;

public class DDA_data {
    float x, y;
    int xr, yr;

    public DDA_data(float x, float y) {
        this.x = x;
        this.y = y;
        xr = (int) Math.round(x);
        yr = (int) Math.round(y);
    }

    public String getX() {
        return String.valueOf(x);
    }

    public String getY() {
        return String.valueOf(y);
    }

    public String getXr() {
        return Integer.toString(xr);
    }

    public String getYr() {
        return Integer.toString(yr);
    }

    public String getRes() {//(x, y)
        return "("+ Integer.toString(xr)+", "+Integer.toString(yr)+")";
    }
}
