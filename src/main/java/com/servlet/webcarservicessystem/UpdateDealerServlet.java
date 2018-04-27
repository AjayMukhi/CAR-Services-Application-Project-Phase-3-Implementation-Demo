/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.webcarservicessystem;

import com.services.webcarservices.ProfileService_Service;
import com.services.webcarservices.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AjayMukhi
 */
@WebServlet(name = "UpdateDealerServlet", urlPatterns = {"/UpdateDealerServlet"})
public class UpdateDealerServlet extends HttpServlet {

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
        HttpSession hs = request.getSession();  
        String userid=(String)hs.getAttribute("userid");        
        System.out.println(userid);
        
        String id = request.getParameter("id");        
        int userprofileid= Integer.parseInt(id);
        System.out.println(userprofileid);
        
        String firstname= request.getParameter("fname");
        String lastname= request.getParameter("lname");
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String email =request.getParameter("email");    
        String phone =request.getParameter("phone");
        String usertype= request.getParameter("usertype");
        String address =request.getParameter("address");
        String city =request.getParameter("city");
        String state =request.getParameter("state");
        String zipcode =request.getParameter("zipcode");
        String country =request.getParameter("country");
        
                
        
        
        
        ProfileService_Service profile=new ProfileService_Service();        
        com.services.webcarservices.ProfileService proxy=profile.getProfileServicePort();
        
        
        User profileupdate = new User();
        //carAdd.setId(Integer.MIN_VALUE);
        //profileupdate.setId(userprofileid);
        profileupdate.setFirstname(firstname);
        profileupdate.setLastname(lastname);
        profileupdate.setUsername(username);
        profileupdate.setPassword(password);
        profileupdate.setPhone(phone);
        profileupdate.setEmail(email);
        profileupdate.setAddress(address);
        profileupdate.setCity(city);
        profileupdate.setState(state);
        profileupdate.setZipcode(zipcode);
        profileupdate.setCountry(country);
        
       
        boolean updateSuccess = false;
        
        try {
            
            if(id!=null){                
              updateSuccess= proxy.updateUserProfileById(userprofileid, profileupdate);
            }
            //carList.
             hs.setAttribute("username",username);  
             if(updateSuccess)
                 response.sendRedirect("Dealer.jsp?msg=Profile updated Successfully");
             else
                 response.sendRedirect("UpdateDealer.jsp?msg1=There is some problem in Updating the Profile into database.");
                 
                 
        }catch(Exception e){        
             e.printStackTrace();
        }
        
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
