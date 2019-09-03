package com.google.android.gms.samples.vision.Scanner;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ScannedList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_list);
        DatabaseHelper db = new DatabaseHelper(this);

        ListView listView = findViewById(R.id.LL1);
        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = db.getListContents();
        if (data.getCount() == 0) {
            Toast.makeText(ScannedList.this, "NO DATA FOUND!!!", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thelist);
                listView.setAdapter(listAdapter);
            }

        }

    }
}
