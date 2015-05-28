/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.dao.impl;

import com.desoftmex.dao.DefaultDao;
import com.desoftmex.entity.Rol;
import com.desoftmex.exception.ExceptionDao;
import com.desoftmex.resources.Utility;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author gustavo
 */
public class RolDaoImpl implements DefaultDao<Rol,String> {
    
    private ManagerDao managerDao;

    @Override
    public void saveOrUpdate(Rol entity)throws ExceptionDao {
        managerDao=new ManagerDao();
        try {
            managerDao.saveOrUpdate(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }        
    }

    @Override
    public void delete(Rol entity)throws ExceptionDao {
        managerDao=new ManagerDao();
        try {
            managerDao.delete(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
    }

    @Override
    public Rol findById(String id)throws ExceptionDao {
        managerDao=new ManagerDao();
        Rol result=null;
        String query="select t from Rol t Where t.id = " + id;
        try {
            result = (Rol)managerDao.findId(query);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Rol> findFilterAll(Rol entity)throws ExceptionDao{
        List<Rol> result=null;
        managerDao=new ManagerDao();
        String query="select t from Rol t";
        query = Utility.queryFilter(query, "id",entity.getId());
        query = Utility.queryFilter(query, "nombre",entity.getNombre());
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
    public List<Rol> findAll()throws ExceptionDao {
        List<Rol> result=null;
        managerDao=new ManagerDao();
        String query="select t from Rol t";
        try {
            result=managerDao.find(query);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }
    
}
