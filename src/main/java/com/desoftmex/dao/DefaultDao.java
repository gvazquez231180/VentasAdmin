/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.dao;

import com.desoftmex.exception.ExceptionDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gustavo
 */
public interface DefaultDao<T,Id extends Serializable> {
    
    public void saveOrUpdate(T entity)throws ExceptionDao;    
    public void delete(T entity)throws ExceptionDao;
    public T findById(Id id)throws ExceptionDao;
    public List<T> findFilterAll(T entity)throws ExceptionDao;
    public List<T> findAll()throws ExceptionDao;
    
}
