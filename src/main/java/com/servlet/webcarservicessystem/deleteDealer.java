/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.webcarservicessystem;

import com.services.webcarservices.DealerService;
import com.services.webcarservices.DealerService_Service;
import com.services.webcarservices.User;
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
public class deleteDealer extends HttpServlet {
    
    DealerService dealerService;
    List<User> dealerlist;
    
    private static final Logger LOG = Logger.getLogger(DealerServlet.class.getName());

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
        
        DealerService_Service dealer=new DealerService_Service();        
        com.services.webcarservices.DealerService proxy=dealer.getDealerServicePort();
       try {
                        
            String del = request.getParameter("model");
            System.out.println(del);
            

            if(del!=null){
                LOG.info("reach00");
                proxy.deleteDealerById(Integer.parseInt(del));
                LOG.info("reach001");
            }
            List<User> dealerList = proxy.getDealerList();
            request.setAttribute("dealerList", dealerList);
            LOG.info("reach" + Arrays.asList(dealerList));
            response.sendRedirect("Dealer.jsp");
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
