/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 *
 * @author gustavo
 */

@Entity
@Table(name="Personas")
@Inheritance(strategy=InheritanceType.JOINED)
public class Personas implements Serializable {
    
    @Id
    private long id; 
    @NotNull
    @Column(length = 50)    
    private String nombre;
    @Column(length = 20)
    private String apPaterno;
    @Column(length = 20)
    private String apMaterno;
    @Column(length = 13)
    private String rfc;
    @Column(length = 30)
    private String email;
    private short sexo;
    @Column(length = 50)
    private String calle;
    @Column(length = 30)
    private String colonia;
    private int cp;
    @Column(length = 15)
    private String tel;
    @Column(length = 10)
    private long fechaAlta;
    private short status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getSexo() {
        return sexo;
    }

    public void setSexo(short sexo) {
        this.sexo = sexo;
    }   

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public long getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(long fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }   
    
}
