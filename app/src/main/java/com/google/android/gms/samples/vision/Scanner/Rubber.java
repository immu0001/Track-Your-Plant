package com.google.android.gms.samples.vision.Scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rubber extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    public static String work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rubber);

        b1= findViewById(R.id.button5);
        b2= findViewById(R.id.button6);
        b3= findViewById(R.id.button7);
        b4= findViewById(R.id.button8);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button5:
                work="Tapping";
                Intent a=new Intent(this,MainActivity.class);
                a.putExtra("work",work);
                startActivity(a);
                break;

            case R.id.button6:
                work="Irrigation";
                Intent b=new Intent(this,MainActivity.class);
                startActivity(b);
                break;

            case R.id.button7:
                work="Fertilizer";
                Intent c=new Intent(this,MainActivity.class);
                startActivity(c);
                break;

            case R.id.button8:
                work="Other";
                Intent d=new Intent(this,MainActivity.class);
                startActivity(d);
                break;
        }

    }
}
