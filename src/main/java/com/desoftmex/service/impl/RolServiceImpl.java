/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.service.impl;

import com.desoftmex.dao.DefaultDao;
import com.desoftmex.dao.impl.RolDaoImpl;
import com.desoftmex.entity.Rol;
import com.desoftmex.exception.DefaultException;
import com.desoftmex.exception.ExceptionDao;
import com.desoftmex.service.DefaultService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author gustavo
 */


public class RolServiceImpl implements DefaultService<Rol,String> {

    private RolDaoImpl rolDao=new RolDaoImpl();
    
    public RolDaoImpl getRolDao() {
        return rolDao;
    }

    
    public void setRolDao(RolDaoImpl rolDao) {
        this.rolDao = rolDao;
    }
            
    @Override
    public void saveOrUpdate(Rol entity) throws DefaultException {
        try {
            rolDao.saveOrUpdate(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
    }

    @Override
    public void delete(Rol entity) throws DefaultException {
        try {
            rolDao.delete(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
    }

    @Override
    public Rol findById(String id) throws DefaultException {
        Rol result=null;
        try {
            result = (Rol)rolDao.findById(id);
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Rol> findFilterAll(Rol entity) throws DefaultException {
        List<Rol> result=null;
        try {
            result= rolDao.findFilterAll(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Rol> findAll() throws DefaultException {
        List<Rol> result=null;
        try {
            result = rolDao.findAll();
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
        return result;
    }   
    
}
