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

import java.util.ArrayList;

public class Bresenham_algo extends AppCompatActivity {

    private TextView tv1, tv2, tv3, tv4;
    private TableLayout tbl1, tbl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bresenham_algo);

        findk();

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
        int _2del_X = del_X * 2;
        int del_Y = Math.abs(Y1-Y2);
        int _2del_Y = del_Y * 2;
        int init_p = _2del_Y - del_X;
        int p = init_p;
        int x = X1, y = Y1;
        int steps = Math.max(del_X, del_Y);
        ArrayList<Bresenham_data> data = new ArrayList<>();

        for(int i=0;i<steps;i++){
            if(p>=0){
                x+=1;
                y+=1;
            }else{
                x+=1;
            }
            data.add(new Bresenham_data(p, x, y));
            if(p>=0){
                p = p +_2del_Y-_2del_X;
            }else{
                p = p + _2del_Y;
            }
        }
        textViews(X1, Y1, X2, Y2, del_X, del_Y, _2del_X, _2del_Y, init_p);
        valueOfP(data, _2del_X, _2del_Y, del_X, del_Y);
        showTable(data);
    }


    private void textViews(int x1, int y1, int x2, int y2, int del_x, int del_y, int _2del_x1, int _2del_y1, int p) {
        String tv1str = "Here,\n\u0394X="+String.valueOf(x2)+"-"+String.valueOf(x1)+"="+String.valueOf(del_x)+
                            "\n\u0394Y="+String.valueOf(y2)+"-"+String.valueOf(y1)+"="+String.valueOf(del_y)+
                            "\n2\u0394X=2*"+String.valueOf(del_x)+"="+String.valueOf(_2del_x1)+
                            "\n2\u0394Y=2*"+String.valueOf(del_y)+"="+String.valueOf(_2del_y1);
        tv1.setText(tv1str);
        tv2.setText(Html.fromHtml("If, P<sub><small>k</small></sub>>=0 <br>then, P<sub><small>k+1</small></sub>=P<sub><small>k</small></sub>+2&#916Y-2&#x0394X" +
                "<br>also, (X<sub><small>k</small></sub>+1, Y<sub><small>k</small></sub>+1)" +
                "<br>" +
                "If, P<sub><small>k</small></sub> &#60 0 <br>then, P<sub><small>k+1</small></sub>=P<sub><small>k</small></sub>+2&#916Y" +
                "<br>also, (X<sub><small>k</small></sub>+1, Y<sub><small>k</small></sub>)"));
        String tv3str = "For initial postion we know,\n"+
                        "Pk=Po=2*\u0394Y-\u0394X="+String.valueOf(_2del_y1)+"-"+String.valueOf(del_x)+
                        "="+String.valueOf(p);
        tv3.setText(tv3str);
        String tv4str = "Starting point ("+String.valueOf(x1)+", "+String.valueOf(y1)+")";
        tv4.setText(tv4str);

    }
    private void valueOfP(ArrayList<Bresenham_data> data, int del_x, int del_y, int del_x1, int del_y1) {
        int left, top, right, bottom, textSize=20;
        left=16;
        top=10;
        right=16;
        bottom=10;
        for(int i=0;i<data.size()-1;i++){
            TableRow tr_head = new TableRow(this);
            TextView textView = new TextView(this);
            String tv1 = "P"+String.valueOf(i+1)+"=P"+String.valueOf(i)+"+";
            String temp;
            if(Integer.parseInt(data.get(i).getP())>=0){
                temp = "2\u0394Y-2\u0394X = "+data.get(i).getP()+"+"+String.valueOf(del_y)+"-"+String.valueOf(del_x);
            }else{
                temp = "2\u0394Y = "+data.get(i).getP()+"+"+String.valueOf(del_y);
            }
            tv1 = tv1+temp+" = "+String.valueOf(data.get(i+1).getP());
            textView.setText(tv1);
            tr_head.addView(textView);
            tbl1.addView(tr_head);
        }
    }




    private void showTable(ArrayList<Bresenham_data> data) {
        int left, top, right, bottom, textSize=20;
        left=16;
        top=10;
        right=16;
        bottom=10;

        String[] xyName = new String[]{"K", "Pk", "X, Y"};

        for(int i=-1;i<data.size();i++){
            TableRow tr_head = new TableRow(this);

            String[] value = new String[3];
            if(i>-1){
                value[0] = String.valueOf(i);
                value[1] = data.get(i).getP();
                value[2] = data.get(i).res();
            }
            for(int j=0;j<3;j++){
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
            tbl2.addView(tr_head);
        }
    }

    private void findk() {
        tv1 = findViewById(R.id.tv1_ll_bresenham_upper_left);
        tv2 = findViewById(R.id.tv2_ll_bresenham_upper_right);
        tv3 = findViewById(R.id.tv3_ll_bresenham);
        tv4 = findViewById(R.id.tv4_ll_bresenham);

        tbl1 = findViewById(R.id.tb1_ll_bresenham);
        tbl2 = findViewById(R.id.tb2_ll_bresenham);
    }
}