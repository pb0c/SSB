package com.example.ssb.dto;

import com.example.ssb.dto.User;

import java.io.Serializable;

public class Alarma extends User implements Serializable {
    private User user;
    private Boolean estado;

    public Alarma() {
    }

    public Alarma(User user, Boolean estado) {
        this.user = user;
        this.estado = estado;
    }

    public Alarma(Boolean estado) {
        this.estado = estado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        return (this.getUser()+" -- "+this.getEstado());
    }
}
