/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.control;

import com.desoftmex.entity.Cliente;
import com.desoftmex.exception.DefaultException;
import com.desoftmex.resources.Utility;
import com.desoftmex.service.impl.ClienteServiceImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Gustavo
 */
@Named
@ViewScoped
public class ClienteBean implements Serializable{
    
    //@Inject    
    private Cliente cliente;
    private Cliente cte;
    private List<Cliente> listCte;
    private ClienteServiceImpl cteService=new ClienteServiceImpl();
    
    @PostConstruct
    protected void initBean(){
        if (cliente==null)
            cliente=new Cliente();
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListCte() {
        return listCte;
    }

    public void setListCte(List<Cliente> listCte) {
        this.listCte = listCte;
    }   

    public Cliente getCte() {
        return cte;
    }

    public void setCte(Cliente cte) {
        this.cte = cte;
    }
    
    
    
    public void saveCte(){
        try{
            cteService.saveOrUpdate(cliente);
            FacesContext.getCurrentInstance().addMessage("Info",Utility.mensajeInfo("Cliente registrado"));
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
    
    public void deleteCte(){
        try{
            cteService.delete(cliente);
            FacesContext.getCurrentInstance().addMessage("Info",Utility.mensajeInfo("Cliente eliminado"));
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
    
    
    public void findCteId(){
        try{
            cliente = cteService.findById(String.valueOf(cliente.getId()));
            if (cliente == null) {
                cliente = new Cliente();
                FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError("Cliente no existe"));
            }
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
    
    public void findListCte(){
        try{
            listCte = cteService.findFilterAll(cliente);
            if (listCte == null) {                
                FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError("No hay informacion"));
            }
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
}
