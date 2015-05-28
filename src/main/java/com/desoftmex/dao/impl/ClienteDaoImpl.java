/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.dao.impl;

import com.desoftmex.dao.DefaultDao;
import com.desoftmex.entity.Cliente;
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
public class ClienteDaoImpl implements DefaultDao<Cliente,String> {
    
    private ManagerDao managerDao;

    @Override
    public void saveOrUpdate(Cliente entity)throws ExceptionDao {
        managerDao=new ManagerDao();
        try {
            managerDao.saveOrUpdate(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }        
    }

    @Override
    public void delete(Cliente entity)throws ExceptionDao {
        managerDao=new ManagerDao();
        try {
            managerDao.delete(entity);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
    }

    @Override
    public Cliente findById(String id)throws ExceptionDao {
        managerDao=new ManagerDao();
        Cliente result=null;
        String query="select t from Cliente t Where t.id = " + id;
        try {
            result = (Cliente)managerDao.findId(query);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Cliente> findFilterAll(Cliente entity)throws ExceptionDao{
        List<Cliente> result=null;
        managerDao=new ManagerDao();
        String query="select t from Cliente t";
        query = Utility.queryFilter(query, "id",entity.getId());
        query = Utility.queryFilter(query, "nombre",entity.getNombre());
        try {
            result=managerDao.find(query);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Cliente> findAll()throws ExceptionDao {
        List<Cliente> result=null;
        managerDao=new ManagerDao();
        String query="select t from Cliente t";
        try {
            result=managerDao.find(query);
        } catch (ExceptionDao ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }

    
    
}
