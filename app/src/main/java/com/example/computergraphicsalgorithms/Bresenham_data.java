package com.example.computergraphicsalgorithms;

public class Bresenham_data {
    int p, x, y;

    public Bresenham_data(int p, int x, int y) {
        this.p = p;

        this.x = x;
        this.y = y;
    }

    public String getP() {
        return String.valueOf(p);
    }
    public String res(){
        return "("+String.valueOf(x)+", "+String.valueOf(y)+")";
    }
}
