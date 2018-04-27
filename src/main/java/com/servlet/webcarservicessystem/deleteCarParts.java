/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.webcarservicessystem;

import com.services.webcarservices.CarParts;
import com.services.webcarservices.CarPartsService;
import com.services.webcarservices.CarPartsService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AjayMukhi
 */
public class deleteCarParts extends HttpServlet {
    
    CarPartsService carpartsService;
    List<CarParts> carpartslist;
    
    private static final Logger LOG = Logger.getLogger(CarPartsServlet.class.getName());


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
        LOG.info("reach00....");
        
        CarPartsService_Service carParts=new CarPartsService_Service();        
        com.services.webcarservices.CarPartsService proxy=carParts.getCarPartsServicePort();
       try {
                        
            String del = request.getParameter("model");
            System.out.println(del);
            

            if(del!=null){
                LOG.info("reach00");
                proxy.deleteCarPartsById(Integer.parseInt(del));
                LOG.info("reach001");
            }
            List<CarParts> carPartsList = proxy.getCarPartsList();
            request.setAttribute("carPartsList", carPartsList);
            LOG.info("reach" + Arrays.asList(carPartsList));
            response.sendRedirect("ShopParts.jsp");
            //getServletContext().getRequestDispatcher("AdminChevrolet.jsp").forward(request, response);
        } catch (Exception e) {
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
