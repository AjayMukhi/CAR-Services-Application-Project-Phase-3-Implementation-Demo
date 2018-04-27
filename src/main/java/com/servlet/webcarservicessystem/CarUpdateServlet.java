/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.webcarservicessystem;

import com.services.webcarservices.Car;
import com.services.webcarservices.CarService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AjayMukhi
 */
public class CarUpdateServlet extends HttpServlet {

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
        int carid= Integer.parseInt(id);
        System.out.println(carid);
        
        String productid= request.getParameter("productid");
        String productname= request.getParameter("productname");
        String model= request.getParameter("model");
        String vin= request.getParameter("vin");        
        String desc= request.getParameter("description");
        String display= request.getParameter("display");
        double retailprice = Double.parseDouble(request.getParameter("retailprice"));
        System.out.println(retailprice);
	double price = Double.parseDouble(request.getParameter("price"));
        System.out.println(price);   
        String engine= request.getParameter("engine");
        String body= request.getParameter("body");
        String trans= request.getParameter("trans");
        String year= request.getParameter("year");
        String interior= request.getParameter("interior");
        String exterior= request.getParameter("exterior");
        String imageURL= request.getParameter("imageURL");
        
        CarService_Service car=new CarService_Service();        
        com.services.webcarservices.CarService proxy=car.getCarServicePort();
        
        
        Car carupdate = new Car();
        //carAdd.setId(Integer.MIN_VALUE);
        carupdate.setProductId(productid);
        carupdate.setProductName(productname);
        carupdate.setModel(model);
        carupdate.setVin(vin);
        carupdate.setDescription(desc);
        carupdate.setDisplayUnder(display);
        carupdate.setRetailPrice(retailprice);
        carupdate.setPrice(price);
        carupdate.setEngine(engine);
        carupdate.setBody(body);
        carupdate.setTrans(trans);
        carupdate.setYear(year);
        carupdate.setInterior(interior);
        carupdate.setExterior(exterior);
        carupdate.setImageURL(imageURL);
        
        boolean updateSuccess = false;
        
        try {
            
            if(productid!=null){                
              updateSuccess= proxy.updateCarById(carid,carupdate);
            }
            //carList.
             hs.setAttribute("userid",userid);  
             if(updateSuccess)
                 response.sendRedirect("updateCar.jsp?msg=Car updated Successfully");
             else
                 response.sendRedirect("updateCar.jsp?msg1=There is some problem in Updating the Car into database.");
                 
                 
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
