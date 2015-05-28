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
public class ExceptionDao extends Exception {
    
    //public static final Logger logger = Logger.getLogger(ExceptionDao.class);

    public ExceptionDao() {
    }

    public ExceptionDao(String message) {
        super(message);
    }

    public ExceptionDao(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionDao(Throwable cause) {
        super(cause);
    }    
    
}
