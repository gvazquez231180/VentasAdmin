/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.resources;

import javax.faces.application.FacesMessage;

/**
 *
 * @author Gustavo
 */
public class Utility {
    
    public static String queryFilter(String query, String campo,String valor){
        int index = query.lastIndexOf("where");
        if (valor.length()>0){            
            if (index == -1) {
                query += " where t." + campo + " like '%" + valor + "%'";
            }else{ 
                query += " and t." + campo + " like '%" + valor + "%'";
            }
        }
        return query;
    }
    
    public static String queryFilter(String query, String campo,int valor){
        int index = query.lastIndexOf("where");
        if (valor>0){            
            if (index == -1) {
                query += " where t." + campo + " = " + valor;
            }else{ 
                query += " and t." + campo + " = " + valor;
            }
        }
        return query;
    }
    
    public static String queryFilter(String query, String campo,long valor){
        int index = query.lastIndexOf("where");
        if (valor>0){            
            if (index == -1) {
                query += " where t." + campo + " = " + valor;
            }else{ 
                query += " and t." + campo + " = " + valor;
            }
                
        }
        return query;
    }
    
    public static FacesMessage mensajeError(String mensaje){
        FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,mensaje,mensaje);
        //msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        //msg.setDetail(mensaje);
        return msg;
    }
    
    public static FacesMessage mensajeInfo(String mensaje){
        FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,mensaje,mensaje);
        //msg.setSeverity(FacesMessage.SEVERITY_INFO);
        //msg.setDetail(mensaje);
        return msg;
    }
    
    public static FacesMessage mensajeWarn(String mensaje){
        FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_WARN,mensaje,mensaje);
        //msg.setSeverity(FacesMessage.SEVERITY_WARN);
        //msg.setDetail(mensaje);
        return msg;
    }
}
