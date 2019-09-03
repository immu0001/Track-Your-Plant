package com.google.android.gms.samples.vision.Scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChoosePlant extends AppCompatActivity implements View.OnClickListener{
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    public static String plant1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_plant);

        Toast.makeText(ChoosePlant.this, "Pick a plant!!", Toast.LENGTH_SHORT).show();
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                plant1="Rubber";
                Intent a=new Intent(ChoosePlant.this,Rubber.class);
                startActivity(a);
                break;
            case R.id.button2:
                plant1="Areca nut";
                Intent b=new Intent(ChoosePlant.this, ArecaNut.class);
                startActivity(b);
                break;
            case  R.id.button3:
                plant1="Coconut";
                Intent c=new Intent(ChoosePlant.this,CocoNut.class);
                startActivity(c);
                break;
            case R.id.button4:
                plant1="Black Pepper";
                Intent d=new Intent(ChoosePlant.this,BlackPepper.class);
                startActivity(d);
                break;        }
    }
}
