/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.webcarservicessystem;


import com.services.webcarservices.User;
import com.services.webcarservices.LoginService_Service;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author AjayMukhi
 */
public class LoginService {
    
    
     LoginService_Service loginService;
     com.services.webcarservices.LoginService loginProxy;
     
      public LoginService() {
        loginService = new LoginService_Service();
        loginProxy = loginService.getLoginServicePort();
    }

     public boolean userLogin(String userName, String password) {
          //LOG.info("loginTest");
        boolean loginStatus = loginProxy.getUserLogin(userName, password);
        //LOG.info("loginTestB"+loginStatus);
        return loginStatus;
        
       // User user = em.createNamedQuery("User.findUserByUsername", User.class).setParameter("username", userName).getSingleResult();
        
      
    }
     
     
     
     public User getUserDetails(String username) {
        return loginProxy.getUserByUserName(username);
    }
     
   
     
    
     
     
}
