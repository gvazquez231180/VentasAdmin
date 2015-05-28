/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.control;

import com.desoftmex.entity.Pantalla;
import com.desoftmex.entity.Rol;
import com.desoftmex.exception.DefaultException;
import com.desoftmex.resources.Utility;
import com.desoftmex.service.DefaultService;
import com.desoftmex.service.impl.PageServiceImpl;
import com.desoftmex.service.impl.RolServiceImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
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
public class ConfiguracionBean implements Serializable{
    
    private Icono icono;
    private List<Icono> listIconos;
    
    @Inject
    private SessionBean application;
    
    private DefaultService service;
    
    private Rol rol;
    private List<Rol> listaRol;
    
    private Pantalla page;
    private List<Pantalla> listaPage;
    
    @PostConstruct
    public void init() {          
        rol=new Rol();   
        page=new Pantalla();
        listIconos = application.getListIconos();
    }

    public Icono getIcono() {
        return icono;
    }

    public void setIcono(Icono icono) {
        this.icono = icono;
    }

    public List<Icono> getListIconos() {
        return listIconos;
    }

    public void setListIconos(List<Icono> listIconos) {
        this.listIconos = listIconos;
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

    public Pantalla getPage() {
        return page;
    }

    public void setPage(Pantalla page) {
        this.page = page;
    }

    public List<Pantalla> getListaPage() {
        return listaPage;
    }

    public void setListaPage(List<Pantalla> listaPage) {
        this.listaPage = listaPage;
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
    
    /*=======================================================================*/
    public void savePage(){
        service=new PageServiceImpl();
        try{            
            service.saveOrUpdate(page);
            FacesContext.getCurrentInstance().addMessage("Info",Utility.mensajeInfo("Rol registrado"));
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
    
    public void deletePage(){
        service=new PageServiceImpl();
        try{
            service.delete(page);
            FacesContext.getCurrentInstance().addMessage("Info",Utility.mensajeInfo("Rol registrado"));
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
    
    public void findFilterPage(){
        service=new PageServiceImpl();
        try{
            listaPage = service.findFilterAll(page);
            if(listaRol==null)
                FacesContext.getCurrentInstance().addMessage("Info",Utility.mensajeInfo("No existe informacion"));
        }catch(DefaultException ex){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(ex.getMsgError()));
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError(e.getMessage()));
        }
    }
    
    public void findAllPage(){
        service=new PageServiceImpl();
        try{            
            listaPage = service.findAll();
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
