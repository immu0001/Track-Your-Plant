package com.google.android.gms.samples.vision.Scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArecaNut extends AppCompatActivity implements  View.OnClickListener {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    public static String work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areca_nut);

        b1 = findViewById(R.id.button11);
        b2 = findViewById(R.id.button12);
        b3 = findViewById(R.id.button13);
        b4 = findViewById(R.id.button14);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button11:
                work = "Yield Collection";
                Intent a = new Intent(ArecaNut.this, MainActivity.class);
                startActivity(a);
                break;

            case R.id.button12:
                work = "Irrigation";
                Intent b = new Intent(ArecaNut.this, MainActivity.class);
                startActivity(b);
                break;

            case R.id.button13:
                work = "Fertilizer";
                Intent c = new Intent(ArecaNut.this, MainActivity.class);
                startActivity(c);
                break;

            case R.id.button14:
                work = "Other";
                Intent d = new Intent(ArecaNut.this, MainActivity.class);
                startActivity(d);
                break;
        }

    }
}
