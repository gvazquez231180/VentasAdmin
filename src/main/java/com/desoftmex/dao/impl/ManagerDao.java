/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.dao.impl;

import com.desoftmex.exception.ExceptionDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author gustavo
 */


public class ManagerDao<T, ID extends Serializable> {
    
    
    public void saveOrUpdate(T entity) throws ExceptionDao{   
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            //session.close();
        }catch(HibernateException ex){
            throw new ExceptionDao(ex.getMessage());
        }
    }

    
    
    public void delete(T entity) throws ExceptionDao {
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            //session.close();
        }catch(HibernateException ex){
            throw new ExceptionDao(ex.getMessage());
        }
    }
    

    
    public T findId(String query) throws ExceptionDao {
        T result;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            //session.beginTransaction();
            result = (T)session.createQuery(query).uniqueResult();
            //session.getTransaction().commit();  
            //session.close();
        }catch(HibernateException ex){
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }

    
    public List<T> find(String query) throws ExceptionDao {
        List<T> result;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            //session.beginTransaction();
            result = session.createQuery(query).list();
            //session.getTransaction().commit();
            //session.close();
        }catch(HibernateException ex){
            throw new ExceptionDao(ex.getMessage());
        }
        return result;
    }
    
}
