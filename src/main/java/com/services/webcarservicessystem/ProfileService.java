/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.webcarservicessystem;

import com.services.webcarservices.Exception_Exception;
import com.services.webcarservices.ProfileService_Service;
import com.services.webcarservices.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AjayMukhi
 */
public class ProfileService {
    
    private static final Logger LOG = Logger.getLogger(com.services.webcarservicessystem.ProfileService.class.getName());
    

    
    ProfileService_Service profileService;
    com.services.webcarservices.ProfileService proProxy;
    
    
    public ProfileService(){
    profileService = new ProfileService_Service();
    proProxy = profileService.getProfileServicePort();
       
    }
    
    
    public List<User> getUserList() {
        return proProxy.getUsertList();
    }


    public List<User> getUserDetailsById(String username) {
        return proProxy.getUserDetailsById(username);
    }
        
    public void updateUserProfile(Integer id, User user){
        try {
            
            ProfileService_Service userServ = new ProfileService_Service();
            proProxy = userServ.getProfileServicePort();
            proProxy.updateUserProfileById(id, user);
            LOG.info("120Update......");
        } catch (Exception_Exception ex) {
            Logger.getLogger(CarService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    
    

}
