<%-- 
    Document   : AdminHeader
    Created on : Mar 27, 2018, 11:00:48 AM
    Author     : AjayMukhi
--%>


<%@page import="com.services.webcarservices.Cart"%>
<%@page import="com.services.webcarservices.CartService_Service"%>
<%@page import="com.services.webcarservicessystem.CartService"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.services.webcarservicessystem.CartService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <titleme to Car Dealer Company</title>
    </head>
    <body>
        
        
       
     <%
	HttpSession hs=request.getSession();
        String uname=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
        
         //setting the userid to the session
         hs.setAttribute("userid", uname);
         
           

           CartService_Service cartserv=new CartService_Service();        
           com.services.webcarservices.CartService proxy=cartserv.getCartServicePort();

                           
                           int count=0;
                         try{
                            count = proxy.getCartCountByUserName(uname);                            
                            request.setAttribute("count", count);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
           
        
     %>
     
        
      <nav class="navbar navbar-inverse">
    <div class="container-fluid">
        
        
      
      <ul class="nav navbar-nav">
          
          <li class="active" style="float:right">
          <td>
           
           <span class="detail-label" style="font-weight: bold;
                 font-size:16px;text-align:right; valign:bottom; color:red "><a></a>Welcome, <%=uname%></span>
         
          </td>
          
      </li>
      
      
      <li class="active">
          <a href="./AdminHome.jsp">HOME</a>
      </li>
      
      
      <li class="dropdown">
	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" 
           aria-expanded="false">CARS <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="./AdminChevrolet.jsp">Chevrolet</a></li>
            <li><a href="./AdminBuick.jsp">Buick</a></li>  
            <li><a href="./AdminGmcCar.jsp">GMC</a></li> 
            <li><a href="./AdminHyundai.jsp">Hyundai</a></li> 
            <li><a href="./AdminToyota.jsp">Toyota</a></li> 
       </ul>
     </li>
           
      <li><a href="#">SERVICES</a> 
          
      <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" 
           aria-expanded="false">PARTS<span class="caret"></span></a>
           <ul class="dropdown-menu">
            <li><a href="./ShopParts.jsp">Shop Parts</a></li>
            <li><a href="./SpecialParts.jsp">Special Parts</a></li>            
          </ul>
      </li>
      
         
      <li><a href="./Dealer.jsp">DEALER INFO</a></li>
     
      <li><a href="./contact.jsp">CONTACTS</a></li>
      
      <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" 
           aria-expanded="false">ORDER INFO<span class="caret"></span></a>
           <ul class="dropdown-menu">
            <li><a href="./processOrder.jsp">Order Processing</a></li>
            <li><a href="./reviewOrder.jsp">View Order</a></li>            
          </ul>
      </li>
     
      
       <% if ( uname == null){%>
           
           <li class='' ><a href='viewCart.jsp'>Cart(0)</a></li>
     <% } else{ %> 

           <li class='' ><a href='viewCart.jsp'>Cart(<%=count%>)</a></li>
                  
      <% } %> 
      
      <li><a href="./ProfilePage.jsp">PROFILE</a> 

      <li><a href="./loginPage.jsp">LogOut</a></li>
      
       
          
      
      
      
      
      </ul>
    </div>
    </nav> 
    </body>
</html>
