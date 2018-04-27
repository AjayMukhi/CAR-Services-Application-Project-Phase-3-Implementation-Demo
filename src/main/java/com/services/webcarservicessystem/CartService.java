/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.webcarservicessystem;

import com.services.webcarservices.Cart;
import com.services.webcarservices.CartService_Service;
import com.services.webcarservices.Exception_Exception;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AjayMukhi
 */
public class CartService {
    
    private static final Logger LOG = Logger.getLogger(com.services.webcarservicessystem.CartService.class.getName());
    

    CartService_Service cartService;
    com.services.webcarservices.CartService cartProxy;
    
    
    public CartService(){
    cartService = new CartService_Service();
    cartProxy = cartService.getCartServicePort();
       
    }
    
    
    public void createCart(Cart cart) throws Exception_Exception {
       cartProxy.createCart(cart);
       LOG.info("110Create...");
    }
    
    public List<Cart> getCartList() {
        return cartProxy.getCartList();
    }
    
    
    public Cart getCartByUserName(String userid) {
        return cartProxy.getCartByUserName(userid);
    }
    
    public void deleteCart(int id){
     
       try {
           
            CartService_Service cartServ = new CartService_Service();
            cartProxy = cartServ.getCartServicePort();            
            cartProxy.deleteCartById(id);
            LOG.info("121delete...");
        } catch (Exception_Exception ex) {
            Logger.getLogger(CartService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    
    
}
