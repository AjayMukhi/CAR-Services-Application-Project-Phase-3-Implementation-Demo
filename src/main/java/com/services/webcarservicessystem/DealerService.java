/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.webcarservicessystem;

import com.services.webcarservices.DealerService_Service;
import com.services.webcarservices.Exception_Exception;
import com.services.webcarservices.User;
import java.util.logging.Logger;

/**
 *
 * @author AjayMukhi
 */
public class DealerService {
    
     
      private static final Logger LOG = Logger.getLogger(com.services.webcarservicessystem.DealerService.class.getName());
    

    DealerService_Service dealerService;
    com.services.webcarservices.DealerService delProxy;
    
    
    public DealerService(){
    dealerService = new DealerService_Service();
    delProxy = dealerService.getDealerServicePort();
       
    }
    
    
     public void createUser(User user) throws Exception_Exception {
       delProxy.createDelearUser(user);
       LOG.info("110Create...");
    }
    
    



}
