/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 *
 * @author gustavo
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Usuario extends Personas {
    @NotNull
    @Column(length = 30)
    private String usuario;
    @NotNull
    @Column(length = 30)
    private String password;
    private float sueldo;
    private int rol;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    
    
}
