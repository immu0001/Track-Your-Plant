package com.google.android.gms.samples.vision.Scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    EditText phone;
    public static String phonenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn=findViewById(R.id.btn_get_started);
        phone=findViewById(R.id.PhoneTxt);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (phone.length()>=10){
            phonenum=phone.getText().toString();
            Toast.makeText(SignIn.this, "phone: "+phonenum, Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(this,ChoosePlant.class);
            startActivity(intent);}else{
            Toast.makeText(SignIn.this, "Please Enter a valid Phone Number", Toast.LENGTH_SHORT).show();

        }
    }
}
