/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.webcarservicessystem;

import com.services.webcarservices.Car;
import com.services.webcarservices.CarService_Service;
import com.services.webcarservices.Exception_Exception;
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
public class CarServlet extends HttpServlet {

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
        
        
        Car carAdd = new Car();
        carAdd.setId(Integer.MIN_VALUE);
        carAdd.setProductId(productid);
        carAdd.setProductName(productname);
        carAdd.setModel(model);
        carAdd.setVin(vin);
        carAdd.setDescription(desc);
        carAdd.setDisplayUnder(display);
        carAdd.setRetailPrice(retailprice);
        carAdd.setPrice(price);
        carAdd.setEngine(engine);
        carAdd.setBody(body);
        carAdd.setTrans(trans);
        carAdd.setYear(year);
        carAdd.setInterior(interior);
        carAdd.setExterior(exterior);
        carAdd.setImageURL(imageURL);
        
        boolean addSuccess = false;
        
        try {
            
            if(productid!=null){                
              addSuccess= proxy.createCar(carAdd);            
            }
            //carList.
             hs.setAttribute("userid",userid);  
             if(addSuccess)
                 response.sendRedirect("AddCar.jsp?msg=Car Added Successfully");
             else
                 response.sendRedirect("AddCar.jsp?msg1=There is some problem in Adding the Car into database.");
                 
                 
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
