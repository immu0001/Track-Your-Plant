/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gms.samples.vision.Scanner;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.vision.barcode.Barcode;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

/**
 * Main activity demonstrating how to pass extra parameters to an activity that
 * reads barcodes.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    // use a compound button so either checkbox or switch widgets work.
    private CompoundButton autoFocus;
    private CompoundButton useFlash;
    private Switch autoCapture;
    private TextView statusMessage;
    private TextView barcodeValue;
     Button readbarcode;
    Button viewlist;
    private FusedLocationProviderClient client;
    public static String plant;
    public static String Work;
    String latitude;
    String longitude;
    public  String value;
    String number;
    DatabaseHelper db=new DatabaseHelper(this);

    private static final int RC_BARCODE_CAPTURE = 9001;
    private static final String TAG = "BarcodeMain";
    SignIn sign=new SignIn();
    ChoosePlant choosePlant=new ChoosePlant();
    Rubber rubber=new Rubber();
    CocoNut coconut=new CocoNut();
    ArecaNut arecaNut=new ArecaNut();
    BlackPepper blackPepper=new BlackPepper();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        


        statusMessage = findViewById(R.id.status_message);
        barcodeValue = findViewById(R.id.barcode_value);

        autoFocus =  findViewById(R.id.auto_focus);
        useFlash = findViewById(R.id.use_flash);
        autoCapture =  findViewById(R.id.use_auto);

        readbarcode=findViewById(R.id.read_barcode);
        viewlist=findViewById(R.id.btnViewList);

        viewlist.setOnClickListener(this);
        readbarcode.setOnClickListener(this);



        number= SignIn.phonenum.toString();
        plant= ChoosePlant.plant1.toString();
        if (Rubber.work!=null){Work=Rubber.work;}else if (ArecaNut.work!=null){Work=ArecaNut.work;}else if (CocoNut.work!=null){Work=CocoNut.work;}else if (BlackPepper.work!=null){Work=BlackPepper.work;}

        Toast.makeText(MainActivity.this, "work chose: "+Work, Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "phone"+number, Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "plant chose : "+plant, Toast.LENGTH_SHORT).show();

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.read_barcode :
            // launch barcode activity.
            Intent intent = new Intent(this, BarcodeCaptureActivity.class);
            intent.putExtra(BarcodeCaptureActivity.AutoFocus, autoFocus.isChecked());
            intent.putExtra(BarcodeCaptureActivity.UseFlash, useFlash.isChecked());
            intent.putExtra(BarcodeCaptureActivity.AutoCapture, autoCapture.isChecked());
            startActivityForResult(intent, RC_BARCODE_CAPTURE);
            break;

            case R.id.btnViewList:
                Intent i=new Intent(MainActivity.this,ScannedList.class);
                Log.d(TAG, "onClick: list view clicked");
                startActivity(i);
                break;
        }

    }

    /**
     * Called when an activity you launched exits, giving you the requestCode
     * you started it with, the resultCode it returned, and any additional
     * data from it.  The <var>resultCode</var> will be
     * {@link #RESULT_CANCELED} if the activity explicitly returned that,
     * didn't return any result, or crashed during its operation.
     * <p/>
     * <p>You will receive this call immediately before onResume() when your
     * activity is re-starting.
     * <p/>
     *
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode  The integer result code returned by the child activity
     *                    through its setResult().
     * @param data        An Intent, which can return result data to the caller
     *                    (various data can be attached to Intent "extras").
     * @see #startActivityForResult
     * @see #createPendingResult
     * @see #setResult(int)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    final Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    statusMessage.setText(R.string.barcode_success);
                        Log.d(TAG, "Barcode read: " + barcode.displayValue);

                       client = LocationServices.getFusedLocationProviderClient(this);
                    Log.d(TAG, "onActivityResult: location");
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{ACCESS_FINE_LOCATION}, 1);
                            return;

                        }
                        client.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                               // if (location != null) {

                                    latitude = String.valueOf(location.getLatitude());
                                    longitude = String.valueOf(location.getLongitude());
                                    Log.d(TAG, "location1: onsuccess");

                                    Toast.makeText(MainActivity.this, "Latitude :" + latitude, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(MainActivity.this, "Longitude :" + longitude, Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "location3: ");
                                    value = barcode.displayValue;
                                    Adddata(value,latitude,longitude,number,plant,Work);
                                    Log.d(TAG, "location3: after adddata");
                                    barcodeValue.setText("Latitude :" + latitude + " Longitude :" + longitude);
                                    Toast.makeText(MainActivity.this, "value data : " + value + latitude + longitude, Toast.LENGTH_SHORT).show();

                                //}


                            }
                        });


                } else {
                    statusMessage.setText(R.string.barcode_failure);
                    Log.d(TAG, "No barcode captured, intent data is null");
                }
            } else {
                statusMessage.setText(String.format(getString(R.string.barcode_error),
                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void Adddata(String newEntry,String newEntry1,String newEntry2,String newEntry3,String newEntry4,String newEntry5)
    {
        Log.d(TAG, "Adddata: Add data method below");
        boolean insertData=db.adddata(newEntry,newEntry1,newEntry2,newEntry3,newEntry4,newEntry5);

        if (insertData==true){
            Toast.makeText(MainActivity.this, "New Entry Added !!", Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(MainActivity.this, "something went wrong !!!", Toast.LENGTH_SHORT).show();
        }



    }
}