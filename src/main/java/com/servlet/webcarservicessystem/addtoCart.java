/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.webcarservicessystem;

import com.services.webcarservices.Cart;
import com.services.webcarservices.CartService_Service;
import com.services.webcarservicessystem.CartService;
import com.services.webcarservices.Exception_Exception;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AjayMukhi
 */
public class addtoCart extends HttpServlet {
    
    CartService cartService;
    List<Cart> cartlist;
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();  
        String userid=(String)session.getAttribute("userid");
        //String userid2=request.getParameter("userid");
        System.out.println(userid);
        
      /*  Cart ekart;
	ekart = (Cart) session.getAttribute("cart");
        if (ekart == null) {
	   ekart = new Cart();
		session.setAttribute("cart", ekart);
                
	}
        */
        String partid = request.getParameter("partid");
        System.out.println(partid);
	String partName = request.getParameter("partname");
        System.out.println(partName);    
        String type = request.getParameter("type");
        System.out.println(type);
        String description=request.getParameter("description");
        System.out.println(description); 
        double retailprice = Double.parseDouble(request.getParameter("retailprice"));
        System.out.println(retailprice);
	double price = Double.parseDouble(request.getParameter("price"));
        System.out.println(price);   
        String color = request.getParameter("color");
        System.out.println(color);
        String quantity = request.getParameter("quantity");
        System.out.println(quantity);
        String sku = request.getParameter("sku");
        System.out.println(sku);
        String imageURL = request.getParameter("imageURL");
        System.out.println(imageURL);
               
        
        

	// Set quantity
        int quant = 1;
	try {
	    quant = Integer.parseInt(quantity);
	    if (quant < 0)
		quant = 1;
	     } catch (NumberFormatException nfe) {
		quant = 1;
        }
        
        System.out.println(quant);
        
        
        CartService_Service cartserv=new CartService_Service();        
        com.services.webcarservices.CartService proxy=cartserv.getCartServicePort();
        
        Cart cart = new Cart();
        cart.setId(Integer.MIN_VALUE);
        cart.setPartid(partid);
        cart.setPartname(partName);
        cart.setType(type);
        cart.setDescription(description);
        cart.setRetailPrice(retailprice);
        cart.setPrice(price);
        cart.setQuantity(quant);
        cart.setColor(color);        
        cart.setSku(sku);
        cart.setImageURL(imageURL);
        cart.setUserid(userid);
        
        
        
         
       try {
            
            //String model = request.getParameter("model");
            //System.out.println(model);
            if(partid!=null){
                
            proxy.createCart(cart);

            List<Cart> cartList = new CartService().getCartList();
            request.setAttribute("cartList", cartList);
            }
            //carList.
                     
            response.sendRedirect("viewCart.jsp");
            //getServletContext().getRequestDispatcher("AdminChevrolet.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        
        
        
        
        
        
       /* 
        ekart.addToCart(partName, price, quant);
	session.setAttribute("cart", ekart);

	RequestDispatcher rd = request.getRequestDispatcher("viewCart.jsp");
	rd.forward(request, response);
       */
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
