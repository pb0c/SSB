package com.example.ssb.helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "alarma.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario(rut TEXT PRIMARY KEY, nombre TEXT, pass TEXT, mail TEXT);");
        db.execSQL("CREATE TABLE alarma(rutUser TEXT, estado TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor verif(String us, String pass) throws SQLException    {
        Cursor mcursor = null;
        mcursor = this.getReadableDatabase().query("usuario",
                new String[]{"rut","nombre","pass","mail"},"rut like '"+us+"' and pass like '"+pass+"'",
                null,null,null,null);


        return mcursor;
    }

}