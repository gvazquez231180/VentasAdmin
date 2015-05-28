/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desoftmex.secured;

import com.desoftmex.control.LoginBean;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.Serializable;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        LoginBean loginBean = (LoginBean)((HttpServletRequest)request).getSession().getAttribute("loginBean");
        String contextPath = ((HttpServletRequest)request).getContextPath();
	String pagina = doPagina(((HttpServletRequest)request).getRequestURI(),contextPath);        
        if(loginBean == null){            
            ((HttpServletResponse)response).sendRedirect(pagina);
        }else{
            if(loginBean.getIsLogin() == null){
                ((HttpServletResponse)response).sendRedirect(pagina);
            }else{
                if(!loginBean.getIsLogin())
                    ((HttpServletResponse)response).sendRedirect(pagina);
            }
        }
        
        chain.doFilter(request, response);
    }
    
    private String doPagina(String url,String contextPath){               
        String pagina = url.replaceAll(contextPath,"");
        int i = pagina.indexOf("view");
        if( i > 0)
            pagina=contextPath + "/EndSession.xhtml"; 
        else
            pagina=contextPath + "/index.xhtml"; 
        return pagina;
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
