<%-- 
    Document   : viewCart
    Created on : Mar 28, 2018, 9:34:38 AM
    Author     : AjayMukhi
--%>






<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.services.webcarservices.Cart"%>
<%@page import="com.services.webcarservices.CartService_Service"%>
<%@page import="com.services.webcarservicessystem.CartService"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>

<!DOCTYPE html>
<html>
    <jsp:include page="./AdminHeader.jsp" /> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Dealer Company</title>
        <link rel='shortcut icon' href='/images/icon.jpg'/>
	<link rel='stylesheet' href='css/styles.css' type='text/css' />
    </head>
    
    
    <script type='text/javascript'>
$(function() {
    
    //alert("12344554");
    $('#myselect').change(function() {
        // if changed to, for example, the last option, then
        // $(this).find('option:selected').text() == D
        // $(this).val() == 4
        // get whatever value you want into a variable
        var x = $(this).val();
        //alert(x);
        // and update the hidden input's value
        $('#myhidden').val(x);
    });
});
</script>
    
    
    <body>
          
       <div id='container'>
	
	<div id='body'>
         <section id='content' style=" float: right;width: 75%;">
         <article>
            
       <%
	HttpSession hs=request.getSession();
        String uname=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
        
         //setting the userid to the session
         hs.setAttribute("userid", uname);
        
           CartService_Service cartserv=new CartService_Service();        
           com.services.webcarservices.CartService proxy=cartserv.getCartServicePort();

                           // CartService cartservice = new CartService();
                            try{
                            
                            
                            List<Cart> cartList = new ArrayList<Cart>();
                            cartList=proxy.getCartList();
                        
                            request.setAttribute("cartList", cartList);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            
             %>   
             
             
             
              <tr> 
              <h1>Items in Your  cart </h1>
			    <hr>
		            
			    
                          
                              
                              
                            <c:choose>                              
                                   <c:when test="${empty requestScope.cartList}">
                                        <tr><th><span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">No Record Found</span></th></tr>
                                   </c:when>                          
                              <c:otherwise>  
                               
                            <c:forEach items="${requestScope.cartList}" var="cart">
                             <table  frame='box' rules='rows'>
                                <tr>
                                <td>
                                <td><span class="detail-label" style="font-weight: bold;
                                      color:blue;font-size:16px;text-align:center">Product</span></td>
                                <td><span class="detail-label" style="font-weight: bold;
                                          color:blue;font-size:16px;text-align:center">Price</span></td>
                                <td><span class="detail-label" style="font-weight: bold;
                                          color:blue;font-size:16px;text-align:center">Quantity</span></td></td>
                                  
                                     
                                          
                                     
                                       <input type='hidden' name='partname' value='<c:out value="${cart.partname}"></c:out>'>
				       <tr>
                                          <td align="left">      
                                            <img src="<c:out value="${cart.imageURL}"></c:out>" height="140px" width="155px">        
                                         </td>   
                                         <td>
                                             <span class="detail-content"><c:out value="${cart.partname}"></c:out></span>
                                         </td>
                                         <td>
                                              <c:out value="${cart.price}"></c:out>
                                         </td>
                                             
                                        <td>
                                             <select name='quantity' id="myselect">
                                                    <option value='1' selected>1</option>
                                                    <option value='2'>2</option>
                                                    <option value='3'>3</option>
                                                    <option value='4'>4</option>
                                                    <option value='5'>5</option>
                                              </select>
                                        </td>
                                        <form action ="removeItem" method="post">
					    <td>
                                               <input type='hidden' name='model' value='<c:out value="${cart.id}"></c:out>'>
                                              
                                             <span  class="detail-label" style="font-weight: bold;
                                                    color:red; font-size:16px;text-align:center">
                                                 <input type='submit' name='remove' value='Remove'>
                                             </span>
                                            </td>
                                        </form>    
                                        <form action ="checkOutItem" method="post">
                                           <td align='center' colspan='5'>
                                                <span  class="detail-label" style="font-weight: bold;
                                                   color:red; font-size:16px;text-align:center">
                                            
                                            <input type='hidden' name='quantity' id='myhidden' value=''>
                                            <input type='submit'  name='checkOut' value='CheckOut'>
                                                </span>
                                           </td>                                           
                                        </form>
                                      </tr> 
                                  </table>

                                 </c:forEach> 
                              </c:otherwise>
                            </c:choose> 
                 </th>

            </tr>
           </table>
                    
           

         </article>
         </section>
        <!--  side bar starts   -->    
	<aside class='sidebar'>
	<ul>	
	<li>
	<h4>Shop by Parts</h4>
	<ul>
	<li><a href='./AdminAntenna.jsp'>Antenna</a></li>
        <li><a href='./AdminAirCleaner.jsp'>Air Cleaner Assembly</a></li>
	<li><a href='./AdminBolt.jsp'>Bolt</a></li>
        <li><a href='./AdminBrake.jsp'>Brake Pad set</a></li>
        <li><a href='./AdminBrakeDisc.jsp'>Brake disc</a></li>
	<li><a href='./AdminConnectors.jsp'>Connectors</a></li>
        <li><a href='./AdminCooling.jsp'>Cooling System</a></li>
	<li><a href='./AdminDoorWS.jsp'>Door Weatherstrip Steal</a></li>
        <li><a href='./AdminEngine.jsp'>Engine</a></li>
	<li><a href='./AdminElectrical.jsp'>Electrical Wires</a></li>
        <li><a href='./AdminIgnition.jsp'>Ignition</a></li>
        <li><a href='./AdminLight.jsp'>Light Bulbs</a></li>
        <li><a href='./AdminLED.jsp'>LED Bulbs</a></li>
        <li><a href='./AdminLug.jsp'>Lug Nut</a></li>        
        <li><a href='./AdminLightB.jsp'>Light Bulbs</a></li>
        <li><a href='./AdminWashers.jsp'>Washers</a></li>
        <li><a href='./AdminWheels.jsp'>Wheels</a></li>
        <li><a href='./AdminWiper.jsp'>Wiper Blades</a></li>
	</ul>
	</li>	
	<li>
	<h4>About us</h4>
	<h5>Delivering product since 1979</h5>
	
	</li>	   	
	<li>	
	<h4>Helpful videos and links</h4>	
	<ul>	
	<li><a href='https://www.w3schools.com/' title='google'>w3schools.com</a></li>	
	<li><a href='https://www.youtube.com/watch?v=y3UH2gAhwPI&feature=youtu.be/' title=' learn html and css'>Learn HTML and CSS</a></li>	
	</ul></li></ul></aside>	
	<div class='clear'></div>
	</div>	
	<footer>	
	<div class='footer-content'>	
	<div class='clear'></div>	
	</div>	
	<div class='footer-bottom'>	
	<p>AKM Auto Private ltd </p>	
	</div>	
	</footer>	
	</div>	
        
    </body>
</html>