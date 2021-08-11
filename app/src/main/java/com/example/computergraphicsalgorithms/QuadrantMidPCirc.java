package com.example.computergraphicsalgorithms;

public class QuadrantMidPCirc {
    private int x1, y1, fx1, fy1;
    public QuadrantMidPCirc(int x1, int y1, int fx1, int fy1) {
        this.x1 = x1;
        this.y1 = y1;
        this.fx1 = fx1;
        this.fy1 = fy1;
    }


    public String getO1(){
        return Integer.toString(x1)+", "+Integer.toString(y1);
    }
    public String getO1f(){
        return Integer.toString(fx1+x1)+", "+Integer.toString(fy1+y1);
    }
    public String getO2(){
        return Integer.toString(y1)+", "+Integer.toString(x1);
    }
    public String getO2f(){
        return Integer.toString(y1+fx1)+", "+Integer.toString(x1+fy1);
    }
    public String getO3(){
        return Integer.toString(y1)+", "+Integer.toString(x1*-1);
    }
    public String getO3f(){
        return Integer.toString(y1+fx1)+", "+Integer.toString((x1*-1)+fy1);
    }
    public String getO4(){
        return Integer.toString(x1)+", "+Integer.toString(y1*-1);
    }
    public String getO4f(){
        return Integer.toString(fx1+x1)+", "+Integer.toString((y1*-1)+fy1);
    }
    public String getO5(){
        return Integer.toString(x1*-1)+", "+Integer.toString(y1*-1);
    }
    public String getO5f(){
        return Integer.toString((x1*-1)+fx1)+", "+Integer.toString((y1*-1)+fy1);
    }
    public String getO6(){
        return Integer.toString(y1*-1)+", "+Integer.toString(x1*-1);
    }
    public String getO6f(){
        return Integer.toString((y1*-1)+fx1)+", "+Integer.toString((x1*-1)+fy1);
    }
    public String getO7(){
        return Integer.toString(y1*-1)+", "+Integer.toString(x1);
    }
    public String getO7f(){
        return Integer.toString((y1*-1)+fx1)+", "+Integer.toString(x1+fy1);
    }
    public String getO8(){
        return Integer.toString(x1*-1)+", "+Integer.toString(y1);
    }
    public String getO8f(){
        return Integer.toString((x1*-1)+fx1)+", "+Integer.toString(fy1+y1);
    }

}
