package com.example.computergraphicsalgorithms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    private RadioGroup rBtnGrp;


    private EditText ddaAlgoX1, ddaAlgoY1, ddaAlgoX2, ddaAlgoY2;
    private LinearLayout ddaAlgoll;
    private EditText bresenhamAlgoX1, bresenhamAlgoY1, bresenhamAlgoX2, bresenhamAlgoY2;
    private LinearLayout bresenhamAlgoll;
    private EditText midCricAlgoX, midCricAlgoY, midCricAlgoR;
    private LinearLayout midCircll;
    private Button submitBtn;
    private TextView nameTelegram;
    //safety
    private Boolean rb1flag=false, rb2flag=false, rb3flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findV();

        ddaAlgoll.setActivated(false);
        ddaAlgoll.setVisibility(View.GONE);

        bresenhamAlgoll.setActivated(false);
        bresenhamAlgoll.setVisibility(View.GONE);

        midCircll.setActivated(false);
        midCircll.setVisibility(View.GONE);



        nameTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL("https://t.me/znmehedi");
            }
        });

        rBtnGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbtn1:
                        rb1flag=true;
                        //disable rbtn2
                        rb2flag=false;
                        bresenhamAlgoll.setActivated(false);
                        bresenhamAlgoll.setVisibility(View.GONE);
                        //disable rbtn3
                        rb3flag=false;
                        midCircll.setActivated(false);
                        midCircll.setVisibility(View.GONE);
                        //call for method
                        ddaAlgo();
                        break;
                    case R.id.rbtn2:
                        rb2flag=true;
                        //disable rbtn1
                        rb1flag=false;
                        ddaAlgoll.setActivated(false);
                        ddaAlgoll.setVisibility(View.GONE);
                        //disable rbtn3
                        rb3flag=false;
                        midCircll.setActivated(false);
                        midCircll.setVisibility(View.GONE);
                        //call for method
                        bresenhamAlgo();
                        break;
                    case R.id.rbtn3:
                        rb3flag=true;
                        //disable rbtn1
                        rb1flag=false;
                        ddaAlgoll.setActivated(false);
                        ddaAlgoll.setVisibility(View.GONE);
                        //disable rbtn2
                        rb2flag=false;
                        bresenhamAlgoll.setActivated(false);
                        bresenhamAlgoll.setVisibility(View.GONE);
                        //call for method
                        midPointCircle();
                        break;
                    default:
                        //disable all btn
                        rb1flag=false;
                        ddaAlgoll.setActivated(false);
                        ddaAlgoll.setVisibility(View.GONE);

                        rb3flag=false;
                        midCircll.setActivated(false);
                        midCircll.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }


    private void gotoURL(String s) {
        Uri uri = Uri.parse(s);

        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }


    private void ddaAlgo() {
        ddaAlgoll.setActivated(true);
        ddaAlgoll.setVisibility(View.VISIBLE);
        if(rb1flag)
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String X1, Y1, X2, Y2;
                    X1 = ddaAlgoX1.getText().toString();
                    Y1 = ddaAlgoY1.getText().toString();
                    X2 = ddaAlgoX2.getText().toString();
                    Y2 = ddaAlgoY2.getText().toString();

                    if(!X1.isEmpty() && !Y1.isEmpty() && !X2.isEmpty() && !Y2.isEmpty()){
                        Intent intent = new Intent(MainActivity.this, DDA_line_Drawing.class);
                        intent.putExtra("X1", X1);
                        intent.putExtra("Y1", Y1);
                        intent.putExtra("X2", X2);
                        intent.putExtra("Y2", Y2);
                        startActivity(intent);


                    }else {
                        Toast.makeText(MainActivity.this, "Fill all those feilds.", Toast.LENGTH_SHORT).show();
                        return;
                    }

            }
        });
    }
    private void bresenhamAlgo() {
        bresenhamAlgoll.setActivated(true);
        bresenhamAlgoll.setVisibility(View.VISIBLE);
        if(rb2flag)
            submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String X1, Y1, X2, Y2;
                    X1 = bresenhamAlgoX1.getText().toString();
                    Y1 = bresenhamAlgoY1.getText().toString();
                    X2 = bresenhamAlgoX2.getText().toString();
                    Y2 = bresenhamAlgoY2.getText().toString();

                    if(!X1.isEmpty() && !Y1.isEmpty() && !X2.isEmpty() && !Y2.isEmpty()){
                        Intent intent = new Intent(MainActivity.this, Bresenham_algo.class);
                        intent.putExtra("X1", X1);
                        intent.putExtra("Y1", Y1);
                        intent.putExtra("X2", X2);
                        intent.putExtra("Y2", Y2);
                        startActivity(intent);

                    }else {
                        Toast.makeText(MainActivity.this, "Fill all those feilds.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            });
    }
    private void midPointCircle() {
        midCircll.setActivated(true);
        midCircll.setVisibility(View.VISIBLE);
        if(rb3flag)
            submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String X, Y, R;
                    X=midCricAlgoX.getText().toString();
                    Y=midCricAlgoY.getText().toString();
                    R=midCricAlgoR.getText().toString();
                    if(R.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Enter Radius...", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(X.isEmpty())
                        X="0";
                    if(Y.isEmpty())
                        Y="0";
                    Intent intent = new Intent(MainActivity.this, MidPointCircleActivity.class);
                    intent.putExtra("X", X);
                    intent.putExtra("Y", Y);
                    intent.putExtra("R", R);
                    startActivity(intent);
            }
        });
    }

    private void findV() {
        rBtnGrp = (RadioGroup) findViewById(R.id.radioGrp);

        ddaAlgoll = findViewById(R.id.llRbtn1);
        ddaAlgoX1 = findViewById(R.id.et1_llRbtn1);
        ddaAlgoY1 = findViewById(R.id.et2_llRbtn1);
        ddaAlgoX2 = findViewById(R.id.et3_llRbtn1);
        ddaAlgoY2 = findViewById(R.id.et4_llRbtn1);

        bresenhamAlgoll = findViewById(R.id.llRbtn2);
        bresenhamAlgoX1 = findViewById(R.id.et1_llRbtn2);
        bresenhamAlgoY1 = findViewById(R.id.et2_llRbtn2);
        bresenhamAlgoX2 = findViewById(R.id.et3_llRbtn2);
        bresenhamAlgoY2 = findViewById(R.id.et4_llRbtn2);

        midCircll = findViewById(R.id.llRbtn3);
        midCricAlgoX = findViewById(R.id.et1_llRbtn3);
        midCricAlgoY = findViewById(R.id.et2_llRbtn3);
        midCricAlgoR = findViewById(R.id.et3_llRbtn3);

        submitBtn = findViewById(R.id.submitBtn);
        nameTelegram = findViewById(R.id.bottomTv);
    }
}