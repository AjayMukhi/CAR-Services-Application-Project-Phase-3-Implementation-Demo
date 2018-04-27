/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.webcarservicessystem;

import com.services.webcarservices.CartService_Service;
import com.services.webcarservices.CustOrder;
import com.services.webcarservices.Exception_Exception;
import com.services.webcarservices.OrderService_Service;
import com.services.webcarservicessystem.OrderService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author AjayMukhi
 */
public class OrderServlet extends HttpServlet {

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
        
        
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            HttpSession hs = request.getSession();
            String userid=(String)hs.getAttribute("userid");
            //String userid2=request.getParameter("userid");
            System.out.println(userid);
            
            //request.getAttribute("cartList");
            
            String partid = request.getParameter("partid");
            String partname =request.getParameter("partname");
            String desc =request.getParameter("description");
            
            String quantity = request.getParameter("quantity");            
            if(quantity==null){
                quantity="1";
            }
            String stringasprice =request.getParameter("price");
            String stringtax = request.getParameter("tax");
            String phone = request.getParameter("phone");
            
            String cardnumber = request.getParameter("cardnumber");
            String paytype= request.getParameter("yesno");
            if(cardnumber!=null ){
                paytype="card";
            }
            //String paytype= request.getParameter("yesno");
            
            
            String cvvcode = request.getParameter("cvvcode");
            
            String expDate =request.getParameter("expdate");
            System.out.println("Exp:"+expDate);
            //Date date = new Date();
            
            
            

           String ordDate = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
           System.out.println(ordDate);


            
        
        /*    
        Date exp = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(exp);
        System.out.println("Current Date:"+exp);
                        
            GregorianCalendar gregory = new GregorianCalendar();
            XMLGregorianCalendar expDate = null;
            try {
                
                gregory.setTime(exp);
                expDate = DatatypeFactory.newInstance()
                        .newXMLGregorianCalendar(
                                gregory);
                
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            
            System.out.println("gregorian exp date:"+expDate);
            
            
           
        
             
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        System.out.println("Current Date:"+today);
        
            GregorianCalendar gregory1 = new GregorianCalendar();
            XMLGregorianCalendar ordDate = null;
            try {
                
                gregory1.setTime(today);
                ordDate = DatatypeFactory.newInstance()
                        .newXMLGregorianCalendar(
                                gregory);
                
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            System.out.println("gregorian order date:"+ordDate);
            
            
            
            */
            
            
            
            
            String cvv = request.getParameter("cvvcode");
            
            
            
            
            
            
            CustOrder order = new CustOrder();
            
            
            
            
            Random random = new Random();
            int Low = 1;
            int High = 562566;
            int rand = random.nextInt(High - Low) + Low;
            String orderno = "ABC-" + rand;
            
            
            int low=1;
            int high=1000;
            int payrand=random.nextInt(high-low)+low;
            
            
            
            
            int quant = 1;
            
            try {
                quant = Integer.parseInt(quantity);
                if (quant < 0)
                    quant = 1;
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                quant = 1;
            }
            
            double price=Double.parseDouble(stringasprice);
            
            
            if (stringtax==null)
                stringtax="0.0";
            double tax=Double.parseDouble(stringtax);
            
            
            double totalprice = quant* price+tax;
            
            String address= request.getParameter("address");
            String city= request.getParameter("city");
            String state= request.getParameter("state");
            String zipcode= request.getParameter("zipcode");
            String country= request.getParameter("country");
            
            String stringid = request.getParameter("id");
            
            int id =Integer.parseInt(stringid);
            
            
            
            
            order.setId(Integer.MIN_VALUE);
            order.setOrderid(orderno);
            order.setItemid(partid);
            order.setItemname(partname);
            order.setDescription(desc);
            order.setQuantity(quant);
            order.setPrice(totalprice);
            
            order.setUserid(userid);
            order.setUsername(userid);
            order.setPhone(phone);
            
            order.setPaymentid(payrand);
            
            order.setPaymenttype(paytype);
            System.out.println(paytype);
            if(paytype.equals("cash")){
            
            order.setCardnumber("NA");
            order.setExpirationdate(expDate);
            order.setCvvcode(000);
               
            }
                
            
            order.setCardnumber(cardnumber);
            order.setExpirationdate(expDate);
            order.setCvvcode(Integer.parseInt(cvv));
            order.setOrderdate(ordDate);
            order.setAddress(address);
            order.setCity(city);
            order.setState(state);
            order.setZipcode(zipcode);
            order.setCountry(country);
            order.setPlacedby(userid);
            
            System.out.println(order.toString());
            
            OrderService_Service custOrder=new OrderService_Service();
            com.services.webcarservices.OrderService ordproxy=custOrder.getOrderServicePort();
            
            CartService_Service cartserv=new CartService_Service();
            com.services.webcarservices.CartService cartproxy=cartserv.getCartServicePort();
            
            boolean orderSuccess = false;
            
            if(order!=null){
                try {
                    orderSuccess = ordproxy.createOrder(order);
                    
                    List<CustOrder> orderList = new OrderService().getOrderList();
                    request.setAttribute("orderList", orderList);
                    
                    cartproxy.deleteCartById(id);
                    
                } catch (Exception_Exception ex) {
                    Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendRedirect("processOrder.jsp?msg1=There is some problem in creating Order into database."); 
                }
                catch (Exception ex) {
                        ex.printStackTrace();
                    Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);                    
                     response.sendRedirect("processOrder.jsp?msg1=There is some problem in creating Order into database."); 
                   
        }
            }
            
        }catch (Exception ex) {
            ex.printStackTrace();
                    Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                   
        }
            
    }    
            /*String stringid = request.getParameter("id");
            
            int id =Integer.parseInt(stringid);
            CartService_Service cartserv=new CartService_Service();
            com.services.webcarservices.CartService cartproxy=cartserv.getCartServicePort();
            cartproxy.deleteCartById(id);
            boolean orderSuccess =true;
            //carList.
            if(orderSuccess)
                response.sendRedirect("./reviewOrder.jsp?msg=Order Added");
            else
                response.sendRedirect("./processOrder.jsp?msg1=There is some error.Unable to process the order.");
            
            
            out.close();
            
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (Exception ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
