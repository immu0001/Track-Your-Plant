package com.google.android.gms.samples.vision.Scanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.support.constraint.Constraints.TAG;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mylist.db";
    private static final String TABLE_NAME = "table1";
    private static final String COL1 = "ID";
    public static final String COL2 = "DATA";
    private static final String COL3 = "LATITUDE";
    private static final String COL4 = "LONGITUDE";
    private static final String COL5 = "PHONE";
    private static final String COL6 = "PLANT";
    private static final String COL7 = "WORK";


    private static final String create_table =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT ," + COL3 + " TEXT ," + COL4 + " TEXT ," + COL5 + " TEXT ," + COL6 + " TEXT ," + COL7 + " TEXT)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);

        Log.d("database created", "onCreate: table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        Log.d("database", "getListContents: executed");
        return data;
    }

    public boolean adddata(String item1, String item2, String item3, String item4, String item5, String item6)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3, item2);
        contentValues.put(COL4, item3);
        contentValues.put(COL5, item4);
        contentValues.put(COL6, item5);
        contentValues.put(COL7, item6);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


}
