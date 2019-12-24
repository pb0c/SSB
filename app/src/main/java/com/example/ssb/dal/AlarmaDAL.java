package com.example.ssb.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ssb.dto.Alarma;
import com.example.ssb.dto.User;
import com.example.ssb.helpers.DatabaseHelper;

public class AlarmaDAL {
    private DatabaseHelper dbHelper;
    private Alarma alarma;


    public AlarmaDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.alarma = new Alarma();

    }

    public AlarmaDAL(Context context, User user){
        this.dbHelper = new DatabaseHelper(context);
        this.alarma = alarma;
    }

    public boolean insertar(){
        return tryInsert();
    }

    public boolean insertar(User user, boolean estado){
        this.alarma.setUser(user);
        this.alarma.setEstado(estado);

        return this.tryInsert();
    }

    public boolean tryInsert() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put("user",this.alarma.getUser().getNombre());
        c.put("estado",this.alarma.getEstado());

        try {
            db.insert("alarma", null, c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public Alarma getAlarma() {
        return this.alarma;
    }
}
