/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.desoftmex.exception;

/**
 *
 * @author Gustavo
 */
public class DefaultException extends RuntimeException {
    
    private int codError;
    private String msgError;
    
    public DefaultException(){
        
    }
      

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }   

    public DefaultException(int codError) {
        this.codError = codError;
    }   
    
    public int getCodError() {
        return codError;
    }

    public void setCodError(int codError) {
        this.codError = codError;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }
    
    
}
