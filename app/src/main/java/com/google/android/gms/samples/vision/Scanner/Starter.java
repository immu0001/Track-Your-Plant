package com.google.android.gms.samples.vision.Scanner;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Starter extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        setContentView(R.layout.activity_starter);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent homeIntent = new Intent(Starter.this,SignIn.class);
                startActivity(homeIntent);
                finish();

                Toast.makeText(getApplicationContext(),"Welcome!!",Toast.LENGTH_SHORT).show();
            }

        },SPLASH_TIME_OUT);
    }
}
