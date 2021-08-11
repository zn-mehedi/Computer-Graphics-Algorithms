package com.example.computergraphicsalgorithms;

public class MidPointData {

    private int i, Pi, _2Xi_1, _2Yi_1;

    public MidPointData(int i, int pi, int _2Xi_1, int _2Yi_1) {
        this.i = i;
        Pi = pi;
        this._2Xi_1 = _2Xi_1;
        this._2Yi_1 = _2Yi_1;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getPi() {
        return Pi;
    }

    public void setPi(int pi) {
        Pi = pi;
    }

    public int get_2Xi_1() {
        return _2Xi_1;
    }

    public void set_2Xi_1(int _2Xi_1) {
        this._2Xi_1 = _2Xi_1;
    }

    public int get_2Yi_1() {
        return _2Yi_1;
    }

    public void set_2Yi_1(int _2Yi_1) {
        this._2Yi_1 = _2Yi_1;
    }

}
