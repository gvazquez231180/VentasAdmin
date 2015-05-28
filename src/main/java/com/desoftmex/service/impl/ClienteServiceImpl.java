/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.service.impl;

import com.desoftmex.dao.impl.ClienteDaoImpl;
import com.desoftmex.entity.Cliente;
import com.desoftmex.exception.DefaultException;
import com.desoftmex.exception.ExceptionDao;
import com.desoftmex.service.DefaultService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavo
 */
public class ClienteServiceImpl implements DefaultService<Cliente,String> {
    
    private ClienteDaoImpl cteDao = new ClienteDaoImpl();

    @Override
    public void saveOrUpdate(Cliente entity) throws DefaultException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            cteDao.saveOrUpdate(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
    }

    @Override
    public void delete(Cliente entity) throws DefaultException {
        try {
            cteDao.delete(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
    }

    @Override
    public Cliente findById(String id) throws DefaultException {
        Cliente result=null;
        try {
            result=cteDao.findById(id);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Cliente> findFilterAll(Cliente entity) throws DefaultException {
        List<Cliente> result=null;
        try {
            result=cteDao.findFilterAll(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Cliente> findAll() throws DefaultException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Cliente> result=null;
        try {
            result=cteDao.findAll();
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
        return result;
    }
    
}
