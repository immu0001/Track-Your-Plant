package com.google.android.gms.samples.vision.Scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CocoNut extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    public static String work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coco_nut);

        b1=findViewById(R.id.button21);
        b2=findViewById(R.id.button22);
        b3=findViewById(R.id.button23);
        b4=findViewById(R.id.button24);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button21:
                work = "Yield Collection";
                Intent a = new Intent(CocoNut.this, MainActivity.class);
                startActivity(a);
                break;

            case R.id.button22:
                work = "Irrigation";
                Intent b = new Intent(CocoNut.this, MainActivity.class);
                startActivity(b);
                break;

            case R.id.button23:
                work = "Fertilizer";
                Intent c = new Intent(CocoNut.this, MainActivity.class);
                startActivity(c);
                break;

            case R.id.button24:
                work = "Other";
                Intent d = new Intent(CocoNut.this, MainActivity.class);
                startActivity(d);
                break;
        }
    }
}
