package com.example.ssb.dto;

import java.io.Serializable;

public class User implements Serializable {
    private String rut;
    private String nombre;
    private String pass;

    public User() {
    }

    public User(String nombre) {
        this.nombre = nombre;
    }

    public User(String rut, String nombre, String pass) {
        this.rut = rut;
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
