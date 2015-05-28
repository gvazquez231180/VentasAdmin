package com.desoftmex.control;

import com.desoftmex.entity.Usuario;
import com.desoftmex.resources.Utility;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo
 */

@Named
@SessionScoped
public class LoginBean implements Serializable {
    
    private Usuario user=new Usuario();
    private Boolean isLogin;
    
    LoginBean(){
        user=new Usuario();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }      

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }
    
    public String login(){
        String result="";
        isLogin=false;
        if( (user.getUsuario().equals("gvazquez") && user.getPassword().equals("Barcelona01"))){
            user.setNombre("Gustavo Adolfo");
            user.setApPaterno("Vazquez");
            user.setApMaterno("Grijalva");
            user.setRol(1);
            isLogin=true;
            result="view/home";            
        }else{
            FacesContext.getCurrentInstance().addMessage("Error",Utility.mensajeError("Usuario o Password no valido"));            
        }
        return result;
    }
    
    public void doLogout(){        
        //String contextPath = FacesContext.getCurrentInstance().getExternalContext().getContextName();
        
        String result="../index.xhtml";
        if (isLogin != null)
            isLogin=false;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(result);
            //return result;
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
