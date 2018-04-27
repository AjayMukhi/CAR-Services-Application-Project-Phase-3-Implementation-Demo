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
public class CarPartsUpdateServlet extends HttpServlet {

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
        int carpartid= Integer.parseInt(id);
        System.out.println(carpartid);
        
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
        String quantity= request.getParameter("quantity");
        int quant=1;
        if(quantity!=null)
            quant = Integer.parseInt(quantity);
        
        String imageURL= request.getParameter("imageURL");
        
        CarPartsService_Service carparts=new CarPartsService_Service();        
        com.services.webcarservices.CarPartsService proxy=carparts.getCarPartsServicePort();
        
        
        CarParts carpartsupdate = new CarParts();
        //carAdd.setId(Integer.MIN_VALUE);
        carpartsupdate.setPartId(partid);
        carpartsupdate.setPartName(partname);
        carpartsupdate.setType(type);
        carpartsupdate.setDescription(desc);
        carpartsupdate.setRetailPrice(retailprice);
        carpartsupdate.setPrice(price);
        carpartsupdate.setColor(color);
        carpartsupdate.setSku(sku);
        carpartsupdate.setStock(stock);
        carpartsupdate.setQuantityinstock(quant);        
        carpartsupdate.setImageURL(imageURL);
        
        boolean updateSuccess = false;
        
        try {
            
            if(partid!=null){                
              updateSuccess= proxy.updateCarPartsById(carpartid,carpartsupdate);
            }
            //carList.
             hs.setAttribute("userid",userid);  
             if(updateSuccess)
                 response.sendRedirect("updateCarParts.jsp?msg=CarParts updated Successfully");
             else
                 response.sendRedirect("updateCarParts.jsp?msg1=There is some problem in Updating the CarParts into database.");
                 
                 
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
