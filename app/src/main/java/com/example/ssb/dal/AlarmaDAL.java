package com.example.ssb.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ssb.MenuActivity;
import com.example.ssb.dto.Alarma;
import com.example.ssb.dto.User;
import com.example.ssb.helpers.DatabaseHelper;

import java.util.ArrayList;


public class AlarmaDAL {
    private DatabaseHelper dbHelper;
    private Alarma alarma;
    private UserDAL userDAL;
    private DatabaseHelper helper;
    private User user;


    public AlarmaDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.alarma = new Alarma();

    }

    public AlarmaDAL(Context context, Alarma alarma){
        this.dbHelper = new DatabaseHelper(context);
        this.alarma = alarma;
    }

    public boolean insertar(){
        return tryInsert();
    }

    public boolean insertar(String rutUser, String estado){
        this.alarma.setRutUser(rutUser);
        this.alarma.setEstado(estado);

        return this.tryInsert();
    }


    public boolean tryInsert() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        User user = new User();

        ContentValues c = new ContentValues();

        //c.put("rutUser",this.alarma.getRutUser());
        c.put("estado",this.alarma.getEstado());

        c.put("rutUser",this.userDAL.getUser().getRut());



        try {
            db.insert("alarma", null, c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ArrayList<Alarma> seleccionar(){
        ArrayList<Alarma> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor consulta = db.rawQuery("SELECT rut FROM usuario WHERE rut=?", null);

        if(consulta.moveToFirst()) {
            do {
                String rutUser = consulta.getString(0);
                String estado = consulta.getString(1);

                Alarma alarma = new Alarma(rutUser,estado);

                lista.add(alarma);

            } while(consulta.moveToNext());
        }
        return lista;
    }



    public Alarma getAlarma() {
        return this.alarma;
    }
}
