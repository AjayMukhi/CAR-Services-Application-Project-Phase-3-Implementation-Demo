/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.webcarservicessystem;

import com.services.webcarservices.CustOrder;
import com.services.webcarservices.Exception_Exception;
import com.services.webcarservices.OrderService_Service;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author AjayMukhi
 */
public class OrderService {
    
        
     private static final Logger LOG = Logger.getLogger(com.services.webcarservicessystem.OrderService.class.getName());
     
     
     
    OrderService_Service orderService;
    com.services.webcarservices.OrderService ordProxy;
    
    
    public OrderService(){
    orderService = new OrderService_Service();
    ordProxy = orderService.getOrderServicePort();
       
    }
    
    
    public void createOrder(CustOrder order) throws Exception_Exception {
       ordProxy.createOrder(order);
       LOG.info("110Create...");
    }
    
    public List<CustOrder> getOrderList() {
        return ordProxy.getOrderList();
    }
    
    public List<CustOrder> getOrderByUserName(String username) {
        return ordProxy.getOrderUserName(username);
    }
    
    
    
}
