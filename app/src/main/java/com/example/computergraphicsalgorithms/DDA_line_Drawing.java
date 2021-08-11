package com.example.computergraphicsalgorithms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DDA_line_Drawing extends AppCompatActivity {

    private TextView tv1, tv2, tv3;
    private TableLayout tbl1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dda_line_drawing);

        findK();

        calculate();
    }

    private void calculate() {
        Intent intent = getIntent();
        int X1 = Integer.parseInt(intent.getStringExtra("X1"));
        int Y1 = Integer.parseInt(intent.getStringExtra("Y1"));
        int X2 = Integer.parseInt(intent.getStringExtra("X2"));
        int Y2 = Integer.parseInt(intent.getStringExtra("Y2"));

        if(X1>X2 && Y1>Y2){
            int tX = X1;
            X1 = X2;
            X2 = tX;

            int ty = Y1;
            Y1 = Y2;
            Y2 = ty;
        }

        int del_X = Math.abs(X1-X2);
        int del_Y = Math.abs(Y1-Y2);
        float m = (float) del_Y/del_X;


        int steps = Math.max(del_X, del_Y);
        ArrayList<DDA_data> data = new ArrayList<>();
        float x1 = X1, y1 = Y1;
        for(int i=0;i<=steps;i++){
            data.add(new DDA_data(x1, y1));
            if(0<m && m<=1){
                x1 += 1;
                y1 += m;
            }else if(m>1) {
                x1 += (1/m);
                y1 += 1;
            }
        }
        showTV(del_X, del_Y, m, X1, Y1, X2, Y2);
        showTable(data);
    }

    private void showTV(int del_x, int del_y, float m, int X1, int Y1, int X2, int Y2) {
        String tv1str = "\u0394X = "+String.valueOf(X2)+" - "+String.valueOf(X1)+" = "+String.valueOf(del_x)+
                "\n\u0394Y = "+String.valueOf(Y2)+" - "+String.valueOf(Y1)+" = "+String.valueOf(del_y);
        tv1.setText(tv1str);
        String tv2str = "So, slope m = \u0394Y / \u0394X \n= "+String.valueOf(del_y)+" / "+String.valueOf(del_x)+
                "\n= "+String.valueOf(m);
        tv2.setText(tv2str);
        if(m>1)
        tv3.setText(Html.fromHtml("If, m>1 then, <br>X<sub><small>1</small></sub> = X<sub><small>o</small></sub> + 1/m" +
                "<br> Y<sub><small>1</small></sub> = Y<sub><small>o</small></sub> + 1"));
        else if(0<m && m<=1)
            tv3.setText(Html.fromHtml("If, m>1 then, <br>X<sub><small>1</small></sub> = X<sub><small>o</small></sub> + 1" +
                    "<br> Y<sub><small>1</small></sub> = Y<sub><small>o</small></sub> + m"));
    }


    private void showTable(ArrayList<DDA_data> data) {
            int left, top, right, bottom, textSize=20;
            left=16;
            top=10;
            right=16;
            bottom=10;

            String[] xyName = new String[]{"X", "Y", "X-plot", "Y-plot", "(X, Y)"};

            for(int i=-1;i<data.size();i++){
                TableRow tr_head = new TableRow(this);

                String[] value = new String[5];
                if(i>-1){
                    value[0] = data.get(i).getX();
                    value[1] = data.get(i).getY();
                    value[2] = data.get(i).getXr();
                    value[3] = data.get(i).getYr();
                    value[4] = data.get(i).getRes();
                }
                for(int j=0;j<5;j++){
                    TextView label_data = new TextView(this);
                    if(i==-1){
                        label_data.setText(xyName[j]);
                        label_data.setBackgroundResource(R.color.tc3);
                    }  else {
                        label_data.setText(value[j]);
                        label_data.setBackgroundResource(R.color.tc2);
                    }
                    label_data.setGravity(Gravity.CENTER);
                    label_data.setTextColor(Color.BLACK);
                    label_data.setTextSize(textSize);
                    label_data.setPadding(left, top, right, bottom);
                    tr_head.addView(label_data);
                }
            tbl1.addView(tr_head);
            }
    }

    private void findK() {
        tv1 = findViewById(R.id.tv1_ll_dda);
        tv2 = findViewById(R.id.tv2_ll_dda);
        tv3 = findViewById(R.id.tv3_ll_dda);
        tbl1 = findViewById(R.id.tb1_ll_dda);
    }
}