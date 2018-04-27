/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.webcarservicessystem;

import com.services.webcarservices.DealerService_Service;
import com.services.webcarservices.Exception_Exception;
import com.services.webcarservices.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AjayMukhi
 */
public class DealerServlet extends HttpServlet {

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
        
        
        String fname= request.getParameter("fname");
        String lname= request.getParameter("lname");
        String username= request.getParameter("username");
        String usertype= request.getParameter("usertype");
        String pass= request.getParameter("pass");
        String email= request.getParameter("email");
        String phone= request.getParameter("phone");
        String address= request.getParameter("address");
        String city= request.getParameter("city");
        String state= request.getParameter("state");
        String zipcode= request.getParameter("zipcode");
        String country= request.getParameter("country");
        
        DealerService_Service dealer=new DealerService_Service();        
        com.services.webcarservices.DealerService proxy=dealer.getDealerServicePort();
        
        User cust = new User();
        cust.setId(Integer.MIN_VALUE);
        cust.setFirstname(fname);
        cust.setLastname(lname);
        cust.setUsername(username);
        cust.setUsertype(usertype);
        cust.setPassword(pass);
        cust.setEmail(email);
        cust.setPhone(phone);
        cust.setAddress(address);
        cust.setCity(city);
        cust.setState(state);
        cust.setZipcode(zipcode);
        cust.setCountry(country);
        
        boolean dealerSuccess = false;
        if(username!=null){
            try {
                dealerSuccess = proxy.createDelearUser(cust);
            } catch (Exception_Exception ex) {
                Logger.getLogger(DealerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //carList.
        if(dealerSuccess)
            response.sendRedirect("./Dealer.jsp?msg=Dealer Added");
        else
            response.sendRedirect("./AddDealerDetails.jsp?msg1=There is some error.Unable to Add.");
        out.close();   
            
            
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
