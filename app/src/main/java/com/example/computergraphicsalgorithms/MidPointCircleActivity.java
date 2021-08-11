package com.example.computergraphicsalgorithms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MidPointCircleActivity extends AppCompatActivity {

    private TextView tv1, tv2, tv3, tv4;
    private TableLayout table1, table2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_point_circle);
        findV();

        Intent intent = getIntent();
        int x = Integer.parseInt(intent.getStringExtra("X"));
        int y = Integer.parseInt(intent.getStringExtra("Y"));
        int r = Integer.parseInt(intent.getStringExtra("R"));


        calculateMidPoints(x, y, r);


    }

    private void calculateMidPoints(int x, int y, int r) {
        int xi=0, yi=r;

        ArrayList<QuadrantMidPCirc>fdata = new ArrayList<>();
        fdata.add(new QuadrantMidPCirc(xi, yi, x, y));
        int p;
        p=1-r;
        int fxi, fyi;
        if(p<0){
            xi+=1;
        }else {
            xi+=1;
            yi-=1;
        }

        int _2xi=2*xi, _2yi=2*yi;
        ArrayList<MidPointData> data = new ArrayList<>();

        int i=0;

        fdata.add(new QuadrantMidPCirc(xi, yi, x, y));
        data.add(new MidPointData(i, p, _2xi, _2yi));
        do{

            i++;
            if(p<0){
                _2xi=2*xi;
                _2yi=2*yi;
                p=p+_2xi+1;
            }else{
                _2xi=2*xi;
                _2yi=2*yi;
                p=p+_2xi-_2yi+1;
            }
            if(p<0){
                xi+=1;
            }else {
                xi+=1;
                yi-=1;
            }
            data.add(new MidPointData(i, p, _2xi, _2yi));
            fdata.add(new QuadrantMidPCirc(xi, yi, x, y));
        }while(xi<yi);
        ans(x, y, r);
        showData(data, fdata);
        showQuadrant(fdata, x, y);

    }

    private void ans(int x, int y, int r) {
        String tv1str = "Here,\nr = "+String.valueOf(r)+"\n"+
                        "(Xo, Yo) = (0, "+String.valueOf(r)+")\n"+
                        "As, center is ("+String.valueOf(x)+", "+String.valueOf(y)+").\n"+
                        "So, (Xo, Yo) = ("+String.valueOf(x)+", "+String.valueOf(y+r)+").";
        tv1.setText(tv1str);

        String tv4str = "Xo = Xo + Xc = 0 + "+String.valueOf(x)+" = "+String.valueOf(x)+"\n"+
                "Yo = Yo + Yc = "+String.valueOf(r)+ " + " +String.valueOf(y) +" = "+String.valueOf(y+r);
        tv4.setText(tv4str);
        tv2.setText(Html.fromHtml("We know,<br>If, P<sub><small>i</small></sub>&#60 0, then (X<sub><small>i</small></sub>+1, Y<sub><small>i</small></sub>)" +
                "<br>also, P<sub><small>i+1</small></sub> = P<sub><small>i</small></sub> + 1 + 2X<sub><small>i+1</small></sub>" +
                "<br>And if P<sub><small>i</small></sub>&#62= 0, then (X<sub><small>i</small></sub>+1, Y<sub><small>i</small></sub>-1)" +
                "<br>also, P<sub><small>i+1</small></sub> = P<sub><small>i</small></sub> + 1 + 2X<sub><small>i+1</small></sub> - 2Y<sub><small>i+1</small></sub>"));
        String tv3str = "Po = 1 - r\n= 1 - "+String.valueOf(r)+"\n= "+String.valueOf(1-r);
        tv3.setText(tv3str);
    }

    private void showQuadrant(ArrayList<QuadrantMidPCirc> data, int tx, int ty) {

    int left, top, right, bottom, textSize=20;
    left=25;
    top=10;
    right=25;
    bottom=10;
    String[] xyName = new String[]{"X, Y", "Y, X", "Y, -X", "X, -Y", "-X, -Y", "-Y, -X", "-Y, X", "-X, Y"};
    String constx_y = Integer.toString(tx)+", "+Integer.toString(ty);
    String[] xym = new String[8];
    String[] xyf = new String[8];
    for(int i=-2;i<data.size();i++) {

        if(i>-1) {
            xym[0]=data.get(i).getO1();
            xyf[0]=data.get(i).getO1f();
            xym[1]=data.get(i).getO2();
            xyf[1]=data.get(i).getO2f();
            xym[2]=data.get(i).getO3();
            xyf[2]=data.get(i).getO3f();
            xym[3]=data.get(i).getO4();
            xyf[3]=data.get(i).getO4f();
            xym[4]=data.get(i).getO5();
            xyf[4]=data.get(i).getO5f();
            xym[5]=data.get(i).getO6();
            xyf[5]=data.get(i).getO6f();
            xym[6]=data.get(i).getO7();
            xyf[6]=data.get(i).getO7f();
            xym[7]=data.get(i).getO8();
            xyf[7]=data.get(i).getO8f();
        }
        TableRow tr_head = new TableRow(this);
        if (i == -2) {
            for (int j = 0; j < 8; j++) {
                TextView label_heading = new TextView(this), label_heading_null = new TextView(this);
                label_heading.setText("O-" + Integer.toString(j + 1));
                label_heading_null.setText("Points");
                label_heading.setGravity(Gravity.RIGHT);
                label_heading.setTextColor(Color.BLACK);
                label_heading_null.setGravity(Gravity.LEFT);
                label_heading_null.setTextColor(Color.BLACK);
                if (j % 2 == 0){
                    label_heading.setBackgroundResource(R.color.tc3);
                    label_heading_null.setBackgroundResource(R.color.tc3);
                }
                else{
                    label_heading.setBackgroundResource(R.color.tc4);
                    label_heading_null.setBackgroundResource(R.color.tc4);
                }
                label_heading.setTextSize(textSize);
                label_heading_null.setTextSize(textSize);
                label_heading.setPadding(left, top, right, bottom);
                label_heading_null.setPadding(0, top,right, bottom);
                tr_head.addView(label_heading);
                tr_head.addView(label_heading_null);
            }

        } else {
            for (int j = 0; j < 8; j++) {
                TextView label_data1 = new TextView(this);
                if (i == -1) {
                    label_data1.setText(xyName[j]);
                } else {
                    label_data1.setText(xym[j]);
                }
                if (i % 2 == 0) {
                    label_data1.setBackgroundResource(R.color.tc2);
                } else if (i % 2 != 0 && j % 2 != 0) {

                }

                label_data1.setGravity(Gravity.CENTER);
                label_data1.setTextColor(Color.BLACK);
                label_data1.setTextSize(textSize);
                label_data1.setPadding(left, top, right, bottom);
                tr_head.addView(label_data1);

                TextView label_data2 = new TextView(this);
                if (i == -1) {
                    label_data2.setText(constx_y);
                } else {
                    label_data2.setText(xyf[j]);
                }
                if (i % 2 != 0) {
                    label_data2.setBackgroundResource(R.color.tc1);
                } else if (i % 2 != 0 && j % 2 != 0) {

                }

                label_data2.setGravity(Gravity.CENTER);
                label_data2.setTextColor(Color.BLACK);
                label_data2.setTextSize(textSize);
                label_data2.setPadding(left, top, right, bottom);
                tr_head.addView(label_data2);
            }
        }
        table2.addView(tr_head);
    }


}

    private void showData(ArrayList<MidPointData> data, ArrayList<QuadrantMidPCirc> fdata) {

        int left, top, right, bottom, textSize=20;
        left=16;
        top=10;
        right=16;
        bottom=10;
        for(int i=-1;i<data.size();i++){
            TableRow tr_head = new TableRow(this);
            //tr_head.setId();
            TextView label_date = new TextView(this);
            if(i==-1){
                label_date.setText("i      ");
                label_date.setBackgroundResource(R.color.tc3);
            }else{
                label_date.setText(Integer.toString(data.get(i).getI()));
                if(i%2==0)
                    label_date.setBackgroundResource(R.color.tc2);
            }
            label_date.setTextColor(Color.BLACK);
            label_date.setTextSize(textSize);
            label_date.setPadding(left, top, right, bottom);
            label_date.setGravity(Gravity.CENTER);
            tr_head.addView(label_date);

            //tr_head.setId();
            TextView label_date1 = new TextView(this);
            if(i==-1){
                label_date1.setText(Html.fromHtml("P<sub><small>i</small></sub>            "));
                label_date1.setBackgroundResource(R.color.tc4);
            }else{
                label_date1.setText(Integer.toString(data.get(i).getPi()));
                if(i%2==0)
                    label_date1.setBackgroundResource(R.color.tc2);
            }
            label_date1.setTextColor(Color.BLACK);
            label_date1.setTextSize(textSize);
            label_date1.setPadding(left, top, right, bottom);
            label_date1.setGravity(Gravity.CENTER);
            tr_head.addView(label_date1);


            //tr_head.setId();
            TextView label_date2 = new TextView(this);
            if(i==-1){
                label_date2.setText(Html.fromHtml("2*X<sub><small>i+1</small></sub>      "));
                label_date2.setBackgroundResource(R.color.tc3);
            }else{
                label_date2.setText(Integer.toString(data.get(i).get_2Xi_1()));
                if(i%2==0)
                    label_date2.setBackgroundResource(R.color.tc2);
            }
            label_date2.setTextColor(Color.BLACK);
            label_date2.setTextSize(textSize);
            label_date2.setPadding(left, top, right, bottom);
            label_date2.setGravity(Gravity.CENTER);
            tr_head.addView(label_date2);

            //tr_head.setId();
            TextView label_date3 = new TextView(this);
            if(i==-1){
                label_date3.setText(Html.fromHtml("2*Y<sub><small>i+1</small></sub>      "));
                label_date3.setBackgroundResource(R.color.tc4);
            }else{
                label_date3.setText(Integer.toString(data.get(i).get_2Yi_1()));
                if(i%2==0)
                    label_date3.setBackgroundResource(R.color.tc2);
            }
            label_date3.setTextColor(Color.BLACK);
            label_date3.setTextSize(textSize);
            label_date3.setPadding(left, top, right, bottom);
            label_date3.setGravity(Gravity.CENTER);
            tr_head.addView(label_date3);

            //tr_head.setId();
            TextView label_date4 = new TextView(this);
            if(i==-1){
                label_date4.setText(Html.fromHtml("X<sub><small>i</small></sub>+1, Y<sub><small>i</small></sub>-1      "));
                label_date4.setBackgroundResource(R.color.tc3);
            }else{
                label_date4.setText(fdata.get(i+1).getO1());
                if(i%2==0)
                    label_date4.setBackgroundResource(R.color.tc2);
            }
            label_date4.setTextColor(Color.BLACK);
            label_date4.setTextSize(textSize);
            label_date4.setPadding(left, top, right, bottom);
            label_date4.setGravity(Gravity.CENTER);
            tr_head.addView(label_date4);


            //tr_head.setId();
            TextView label_date5 = new TextView(this);
            if(i==-1){
                label_date5.setText(Html.fromHtml("X=X+X<sub><small>c</small></sub> , Y=Y+Y<sub><small>c</small></sub>"));
                label_date5.setBackgroundResource(R.color.tc4);
            }else{
                label_date5.setText(fdata.get(i+1).getO1f());
                if(i%2==0)
                    label_date5.setBackgroundResource(R.color.tc2);
            }
            label_date5.setTextColor(Color.BLACK);
            label_date5.setTextSize(textSize);
            label_date5.setPadding(left, top, right, bottom);
            label_date5.setGravity(Gravity.CENTER);
            tr_head.addView(label_date5);

            table1.addView(tr_head);
        }


    }

    private void findV() {
        tv1 = findViewById(R.id.tv1cd);
        tv2 = findViewById(R.id.tv2cd);
        tv3 = findViewById(R.id.tv3cd);
        tv4 = findViewById(R.id.tv4cd);
        table1 = findViewById(R.id.tb1MpC);
        table2 = findViewById(R.id.tb2MpC);

    }
}