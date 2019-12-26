package com.example.ssb.dto;

import com.example.ssb.dto.User;

import java.io.Serializable;

public class Alarma implements Serializable {
    private String rutUser;
    private String estado;

    public Alarma() {
    }

    public Alarma(String estado) {
        this.estado = estado;
    }

    public Alarma(String rutUser, String estado){
        this.rutUser = rutUser;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRutUser() {
        return rutUser;
    }

    public void setRutUser(String rutUser) {
        this.rutUser = rutUser;
    }

    @Override
    public String toString(){
        return (this.getEstado());
    }
}
