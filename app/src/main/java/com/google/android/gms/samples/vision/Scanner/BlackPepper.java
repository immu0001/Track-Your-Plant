package com.google.android.gms.samples.vision.Scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BlackPepper extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    public static String work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_pepper);

        b1=findViewById(R.id.button31);
        b2=findViewById(R.id.button32);
        b3=findViewById(R.id.button33);
        b4=findViewById(R.id.button34);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button31:
                work = "Yield Collection";
                Intent a = new Intent(BlackPepper.this, MainActivity.class);
                startActivity(a);
                break;

            case R.id.button32:
                work = "Irrigation";
                Intent b = new Intent(BlackPepper.this, MainActivity.class);
                startActivity(b);
                break;

            case R.id.button33:
                work = "Fertilizer";
                Intent c = new Intent(BlackPepper.this, MainActivity.class);
                startActivity(c);
                break;

            case R.id.button34:
                work = "Other";
                Intent d = new Intent(BlackPepper.this, MainActivity.class);
                startActivity(d);
                break;
        }
    }
}
