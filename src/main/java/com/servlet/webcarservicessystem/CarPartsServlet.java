/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.webcarservicessystem;

import com.services.webcarservices.CarParts;
import com.services.webcarservices.CarPartsService_Service;
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
public class CarPartsServlet extends HttpServlet {

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
        
        String partid= request.getParameter("partid");
        String partname= request.getParameter("partname");
        
        String type= request.getParameter("type");        
        String desc= request.getParameter("description");
        
        double retailprice = Double.parseDouble(request.getParameter("retailprice"));
        System.out.println(retailprice);
	double price = Double.parseDouble(request.getParameter("price"));
        System.out.println(price); 
        
        String color= request.getParameter("color");
        String sku= request.getParameter("sku");
        String stock= request.getParameter("stock");
        String quantityasString= request.getParameter("quantity");
        int quant=1;
        if(quantityasString!=null)
             quant = Integer.parseInt(quantityasString);
        
        String imageURL= request.getParameter("imageURL");
        
        CarPartsService_Service carParts=new CarPartsService_Service();        
        com.services.webcarservices.CarPartsService proxy=carParts.getCarPartsServicePort();
        
        CarParts carpartsAdd = new CarParts();
        carpartsAdd.setId(Integer.MIN_VALUE);
        carpartsAdd.setPartId(partid);
        carpartsAdd.setPartName(partname);
        carpartsAdd.setType(type);
        carpartsAdd.setDescription(desc);
        carpartsAdd.setRetailPrice(retailprice);
        carpartsAdd.setPrice(price);
        carpartsAdd.setColor(color);
        carpartsAdd.setSku(sku);
        carpartsAdd.setStock(stock);
        carpartsAdd.setQuantityinstock(quant);
        carpartsAdd.setImageURL(imageURL);
        
        
        boolean addSuccess = false;
        try {
            
            if(partid!=null){                
              addSuccess= proxy.createCarParts(carpartsAdd);            
            }
            //carList.
             hs.setAttribute("userid",userid);  
             if(addSuccess)
                 response.sendRedirect("AddCarParts.jsp?msg=CarParts Added Successfully");
             else
                 response.sendRedirect("AddCarParts.jsp?msg1=There is some problem in Adding the CarParts into database.");
                 
                 
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
