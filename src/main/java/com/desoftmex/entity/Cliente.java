/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.entity;

import java.io.Serializable;
import javax.enterprise.inject.Default;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 *
 * @author Gustavo
 */

@Entity
//@Table(name="cliente")
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Personas {   
    
    private float limCredito;
    private int tipoPersona;

    public float getLimCredito() {
        return limCredito;
    }

    public void setLimCredito(float limCredito) {
        this.limCredito = limCredito;
    }

    public int getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(int tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
      
}
