
package com.servlet.webcarservicessystem;

import com.model.webcarservicessystem.User;
import com.services.webcarservices.LoginService;
import com.services.webcarservices.LoginService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import parser.CarParser;
import parser.PartsParser;

/**
 *
 * @author AjayMukhi
 */
public class loginServlet extends HttpServlet {
    
    LoginService loginService;
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        System.out.println("--------------------------------------------------------------------------");
        //calling the PartsParse method to parse the Parts xml and load the data into database
        PartsParser pparse = new PartsParser();
        pparse.partsParse();
        
        System.out.println("--------------------------------------------------------------------------");
        //calling the PartsParse method to parse the Parts xml and load the data into database
        CarParser cparse = new CarParser();
        cparse.carParse();
        
        
        
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        //String userType = request.getParameter("type");
        //System.out.println(userType);
        
        LoginService_Service login=new LoginService_Service();        
        com.services.webcarservices.LoginService proxy=login.getLoginServicePort();
        
        
        
        HttpSession hs=request.getSession();
        
        
        boolean loginSuccess = false;
        try {
                loginSuccess = proxy.getUserLogin(username, pass);
                com.services.webcarservices.User user=proxy.getUserByUserName(username);
                String userType=user.getUsertype();
                System.out.println(userType);
                
                
            if (loginSuccess) {
                if (username.equals("admin") && userType.equals("admin") ) {
                    
                    hs.setAttribute("userid",username);
                    hs.setAttribute("role","Admin");
                    response.sendRedirect("AdminHome.jsp");
                } //out.println("Correct login credentials");
                else if(userType.equals("customer") ) {
                    
                    hs.setAttribute("userid",username);
                    hs.setAttribute("role","customer");
                    response.sendRedirect("Customer.jsp");
                }
                else{
                    hs.setAttribute("userid",username);
                    hs.setAttribute("role","dealer");
                    response.sendRedirect("DealerHome.jsp");
                }
            }
            else
                response.sendRedirect("./loginPage.jsp?msg=Check your userid and password.");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("./loginPage.jsp?msg1=User profile does not exist.");
        }

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
