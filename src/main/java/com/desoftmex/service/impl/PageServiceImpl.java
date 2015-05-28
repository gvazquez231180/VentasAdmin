/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.service.impl;

import com.desoftmex.dao.impl.PageDaoImpl;
import com.desoftmex.entity.Pantalla;
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
public class PageServiceImpl implements DefaultService<Pantalla,String> {
    
    PageDaoImpl pageDao=new PageDaoImpl();

    public PageDaoImpl getPageDao() {
        return pageDao;
    }

    public void setPageDao(PageDaoImpl pageDao) {
        this.pageDao = pageDao;
    }  
    
    @Override
    public void saveOrUpdate(Pantalla entity) throws DefaultException {
        try {
            pageDao.saveOrUpdate(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
    }

    @Override
    public void delete(Pantalla entity) throws DefaultException {
        try {
            pageDao.delete(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
    }

    @Override
    public Pantalla findById(String id) throws DefaultException {
        Pantalla result=null;
        try {
            result = (Pantalla)pageDao.findById(id);
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Pantalla> findFilterAll(Pantalla entity) throws DefaultException {
        List<Pantalla> result=null;
        try {
            result = pageDao.findFilterAll(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Pantalla> findAll() throws DefaultException {
        List<Pantalla> result=null;
        try {
            result = pageDao.findAll();
        } catch (ExceptionDao ex) {
            Logger.getLogger(RolServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new DefaultException(ex.getMessage());
        }
        return result;
    }
    
}
