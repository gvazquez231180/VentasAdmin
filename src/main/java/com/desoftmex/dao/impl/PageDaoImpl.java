/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.dao.impl;

import com.desoftmex.dao.DefaultDao;
import com.desoftmex.entity.Pantalla;
import com.desoftmex.exception.ExceptionDao;
import com.desoftmex.resources.Utility;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavo
 */
public class PageDaoImpl implements DefaultDao<Pantalla,String> {
    
    private ManagerDao managerDao;

    @Override
    public void saveOrUpdate(Pantalla entity)throws ExceptionDao {
        managerDao=new ManagerDao();
        try {
            managerDao.saveOrUpdate(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }        
    }

    @Override
    public void delete(Pantalla entity)throws ExceptionDao {
        managerDao=new ManagerDao();
        try {
            managerDao.delete(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
    }

    @Override
    public Pantalla findById(String id)throws ExceptionDao {
        managerDao=new ManagerDao();
        Pantalla result=null;
        String query="select t from Pantalla t Where t.id = " + id;
        try {
            result = (Pantalla)managerDao.findId(query);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Pantalla> findFilterAll(Pantalla entity)throws ExceptionDao{
        List<Pantalla> result=null;
        managerDao=new ManagerDao();
        String query="select t from Pantalla t";
        query = Utility.queryFilter(query, "id",entity.getId());
        query = Utility.queryFilter(query, "nombre",entity.getNombre());
        query = Utility.queryFilter(query, "tipo",entity.getTipo());        
        query = Utility.queryFilter(query, "status",entity.getStatus());
        try {
            result=managerDao.find(query);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Pantalla> findAll()throws ExceptionDao {
        List<Pantalla> result=null;
        managerDao=new ManagerDao();
        String query="select t from Pantalla t";
        try {
            result=managerDao.find(query);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }
    
}
