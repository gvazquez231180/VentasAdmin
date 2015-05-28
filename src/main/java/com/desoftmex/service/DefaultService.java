/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.service;

import com.desoftmex.exception.DefaultException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gustavo
 */
public interface DefaultService<T,Id extends Serializable> {
    
    public void saveOrUpdate(T entity) throws DefaultException;    
    public void delete(T entity) throws DefaultException;
    public T findById(Id id) throws DefaultException;
    public List<T> findFilterAll(T entity) throws DefaultException;
    public List<T> findAll() throws DefaultException;
    
}
