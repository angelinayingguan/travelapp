package com.example.angelina.travelapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by angelina on 2/10/17.
 */

public class MapDatavaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="map.db";
    private static final String TABLE_NAME = "maps";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_ADDRESS1 ="address1";
    private static final String COLUMN_ADDRESS2 ="address2";

    SQLiteDatabase dbmap;
    private static final String TABLE_CREATE ="create table maps (id integer primary key not null , " + " address1 not null, address2);";

    public MapDatavaseHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase dbmap) {
        dbmap.execSQL(TABLE_CREATE);
        this.dbmap =dbmap;
    }

    public void insertMap(MapData mpdata){
        dbmap = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query ="select * from maps";
        Cursor cursor =dbmap.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(COLUMN_ID, count);
        values.put(COLUMN_ADDRESS1, mpdata.getLocation1());
        values.put(COLUMN_ADDRESS2, mpdata.getLocation2());


        dbmap.insert(TABLE_NAME, null, values);
        dbmap.close();
    }

    public boolean searchLocation1(String e1)
    {
        dbmap = this.getReadableDatabase();
        String query = " select address1" + TABLE_NAME;
        Cursor cursor = dbmap.rawQuery (query, null);
        String em;
        if(cursor.moveToFirst()){
            do {
                em = cursor.getString(0);
                if (em.equals(e1)) {
                    return true;

                }
            }
            while(cursor.moveToNext());
        }
        return false;
    }

    public boolean searchLocation2(String e2){
        dbmap = this.getReadableDatabase();
        String query = " select address2" + TABLE_NAME;
        Cursor cursor = dbmap.rawQuery (query, null);
        String em;
        if(cursor.moveToFirst()){
            do {
                em = cursor.getString(0);
                if (em.equals(e2)) {
                    return true;

                }
            }
            while(cursor.moveToNext());
        }
        return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbmap, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        dbmap.execSQL(query);
        this.onCreate(dbmap);
    }
}
