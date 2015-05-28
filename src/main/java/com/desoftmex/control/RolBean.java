/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.control;

import com.desoftmex.entity.Rol;
import com.desoftmex.exception.DefaultException;
import com.desoftmex.resources.Utility;
import com.desoftmex.service.DefaultService;
import com.desoftmex.service.impl.RolServiceImpl;
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
public class RolBean implements Serializable{
    @Inject
    private SessionBean application;
    
    private DefaultService service;
    
    private Rol rol;
    private List<Rol> listaRol;
    
    @PostConstruct
    public void init() {          
        rol=new Rol();           
    }
    
    public SessionBean getApplication() {
        return application;
    }

    public void setApplication(SessionBean application) {
        this.application = application;
    }
    

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }
    
    /*=======================================================================*/
    public void saveRol(){
        service=new RolServiceImpl();
        try{
            service.saveOrUpdate(rol);
            FacesContext.getCurrentInstance().addMessage("Info",Utility.mensajeInfo("Rol registrado"));
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
    
    public void deleteRol(){
        service=new RolServiceImpl();
        try{
            service.delete(rol);
            FacesContext.getCurrentInstance().addMessage("Info",Utility.mensajeInfo("Rol registrado"));
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
    
    public void findFilterAllRol(){
        service=new RolServiceImpl();
        try{
            listaRol = service.findFilterAll(rol);
            if(listaRol==null)
                FacesContext.getCurrentInstance().addMessage("Info",Utility.mensajeInfo("No existe informacion"));
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
    
    public void findAllRol(){
        service=new RolServiceImpl();
        try{           
            
            listaRol = service.findAll();
            if(listaRol==null)
                FacesContext.getCurrentInstance().addMessage("Info",Utility.mensajeInfo("No existe informacion"));
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
}
