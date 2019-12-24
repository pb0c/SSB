package com.example.ssb.dto;

import java.io.Serializable;

public class User implements Serializable {
    private String rut;
    private String nombre;
    private String pass;
    private String mail;

    public User() {
    }

    public User(String rut) {
        this.rut = rut;
    }

    public User(String rut, String nombre, String pass) {
        this.rut = rut;
        this.nombre = nombre;
        this.pass = pass;
    }

    public User(String rut, String nombre, String pass, String mail) {
        this.rut = rut;
        this.nombre = nombre;
        this.pass = pass;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
