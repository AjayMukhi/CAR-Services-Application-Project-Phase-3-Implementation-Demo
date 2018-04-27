<%-- 
    Document   : AdminGmcCar
    Created on : Mar 27, 2018, 11:19:44 AM
    Author     : AjayMukhi
--%>


<%@page import="com.services.webcarservices.Car"%>
<%@page import="java.util.List"%>
<%@page import="com.services.webcarservicessystem.CarService"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./AdminHeader.jsp" /> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Dealer Company</title>
        <link rel='shortcut icon' href='images/icon.jpg'/>
	<link rel='stylesheet' href='css/styles.css' type='text/css' />
 <script>
    function ConfirmDelete()
    {
      var x = confirm("Are you sure you want to delete?");
      if (x)
          return true;
      else
        return false;
    }
</script>   
        
        
           
    </head>
    
   
    <body>
      <div id='container'>
	<div id='body'>	
            
             
                      
	<section id='content' style=" float: right;
    width: 75%;">
            
            
       
            <%
                           
                            CarService car = new CarService();
                            List<Car> carList = car.getCarGMCList();
                            
                        
                            request.setAttribute("carList", carList);
             HttpSession hs=request.getSession();
        String uname=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
             %>
          <% if(!role.equalsIgnoreCase("customer")){ %>
            
               <form  style ="float:right" class='submit-button' method = 'post' action = 'AddCar'>                     
                 <input class = 'submit-button'  type = 'submit' name = 'AddCar' value = 'AddCar'>
               </form>
           <% }else{ %>
                    
                     </br>
               
              <%} %>
                       
                        <table>
                          <tr>
                          
                              
                              
                              <c:choose>                              
                                   <c:when test="${empty requestScope.carList}">
                                         <tr><th><span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">No Record Found</span></th></tr>
                                   </c:when>                          
                              <c:otherwise>       
     
                              <c:forEach items="${requestScope.carList}" var="car">
                               
                               <div class="vehicle-content"> 
                                 <tr>   
                                <th colspan="5" style="text-align:left;">
                                   <span class="detail-content"><c:out value="${car.productName}"></c:out></span>
                                </th>
                                   <tr>                               
                                <td align="left">      
                                    <img src="<c:out value="${car.imageURL}"></c:out>" height="140px" width="155px">        
                                </td>
                                   <td> 
                                    <ul>

                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">Model:</span>
                                            <span class="detail-content"><c:out value="${car.model}"></c:out></span>
                                        </li>
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">MSRP:</span>
                                            <span class="detail-content"><c:out value="${car.retailPrice}"></c:out></span>
                                        </li>
                                        
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">Engine:</span>
                                            <span class="detail-content"><c:out value="${car.engine}"></c:out></span>
                                        </li>
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">Body:</span>
                                            <span class="detail-content"><c:out value="${car.body}"></c:out></span>
                                        </li>
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">Trans:</span>
                                            <span class="detail-content"><c:out value="${car.trans}"></c:out></span>
                                        </li>
                                        <li>

                                            <span  class="detail-label" style="font-weight: bold;
                                                   font-size:16px;text-align:center">Interior:</span>
                                            <span class="detail-content"><c:out value="${car.interior}"></c:out></span>
                                        </li>
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">Exterior:</span>
                                            <span class="detail-content"><c:out value="${car.exterior}"></c:out></span>
                                        </li>
                                    </ul>
                               
                               
                               <span class="detail-label" style="font-weight: bold;
                              color:red; font-size:20px;text-align:center">Our Price:</span>
                                            <span class="detail-content"><c:out value="${car.price}"></c:out></span>
                                        </li>
                                        
                                   </td>
                               
                               <td>
                                   
                   <% if(!role.equalsIgnoreCase("customer")){ %>                
                    <form class = 'submit-button' method = 'post' action = 'UpdateCar'>                     
                    <input class = 'submit-button'  type = 'submit'  name = 'UpdateChevrolet' value = 'Update'>
                    <input type='hidden' name='model' value='<c:out value="${car.id}"></c:out>'>                      
                   </form>
                  
                    <form class = 'submit-button' method = 'post' action = 'deleteCar'>                     
                    <input class = 'submit-button'  type = 'submit' name = 'DeleteChevrolet' value = 'Delete'>
                    <input type='hidden' name='model' value='<c:out value="${car.id}"></c:out>'>                      
                   </form>
                   <% } %>
                   <br>
                   <br>
                   <br>
                   <form class = 'submit-button' method = 'post' action = 'contactDealer'>                     
                    <input class = 'submit-button'  type = 'submit'  name = 'contactDealer' value = 'Contact Dealer'>
                    <input type='hidden' name='model' value='<c:out value="${car.id}"></c:out>'>                      
                   </form>
                                   
                               </td>
                               
                               
                               
                               </tr>

                               </c:forEach> 

                            </div>

                     
                          
                            </c:otherwise>
                   </c:choose> 
                              </th>

            </tr>
                         </table>
                    </article>
                
            
            
            
            
            </section>
	
	<aside class='sidebar'>
	<ul>	
	<li>
	<h4>Products</h4>
	<ul>
	<li><a href='./AdminChevrolet.jsp'>Chevrolet</a></li>
	<li><a href='./AdminBuick.jsp'>Buick</a></li>
	<li><a href='./AdminGmcCar.jsp'>GMC</a></li>
	<li><a href='./AdminHyundai.jsp'>Hyundai </a></li>
	<li><a href='./AdminToyota.jsp'>Toyota </a></li>	
	</ul>
	</li>	
	<li>
	<h4>About us</h4>
	//<h5>Delivering product since 1979</h5>
	
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
    </body>
</html>
