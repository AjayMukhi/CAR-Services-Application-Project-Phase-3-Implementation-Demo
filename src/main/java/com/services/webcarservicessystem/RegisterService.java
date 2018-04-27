/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.webcarservicessystem;

import com.services.webcarservices.User;
import com.services.webcarservices.RegisterService_Service;
import com.services.webcarservices.Exception_Exception;
import com.services.webcarservices.RegisterService_Service;
import java.util.logging.Logger;

/**
 *
 * @author AjayMukhi
 */
public class RegisterService {
    
     private static final Logger LOG = Logger.getLogger(com.services.webcarservicessystem.RegisterService.class.getName());
     
     
     
    RegisterService_Service registerService;
    com.services.webcarservices.RegisterService regProxy;
    
    
    public RegisterService(){
    registerService = new RegisterService_Service();
    regProxy = registerService.getRegisterServicePort();
       
    }
    
    
     public void createUser(User user) throws Exception_Exception {
       regProxy.createUser(user);
       LOG.info("110Create...");
    }
    
    
    
    
    
}
