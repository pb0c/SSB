package com.example.ssb.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.ssb.dto.User;
import com.example.ssb.helpers.DatabaseHelper;

import java.util.ArrayList;

public class UserDAL {
    private DatabaseHelper dbHelper;
    private User user;


    public UserDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.user = new User();

    }

    public UserDAL(Context context, User user){
        this.dbHelper = new DatabaseHelper(context);
        this.user = user;
    }

    public boolean insertar(){
        return tryInsert();
    }

    public boolean insertar(String rut, String nombre, String pass){
        this.user.setRut(rut);
        this.user.setNombre(nombre);
        this.user.setPass(pass);

        return this.tryInsert();
    }

    public boolean tryInsert() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put("rut",this.user.getRut());
        c.put("nombre",this.user.getNombre());
        c.put("pass",this.user.getPass());


        try {
            db.insert("usuario", null, c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //Validar usuario
    public Cursor verif(String us, String pass) throws SQLException    {
        Cursor mcursor = null;
        mcursor = this.dbHelper.getReadableDatabase().query("usuario",
                new String[]{"rut","nombre","pass","mail"},"rut like '"+us+"' and pass like '"+pass+"'",
                null,null,null,null);


        return mcursor;
    }


    public User getUser() {
        return this.user;
    }

}

