<%-- 
    Document   : AdminConnectors
    Created on : Mar 27, 2018, 4:27:42 PM
    Author     : AjayMukhi
--%>

<%@page import="com.services.webcarservices.CarParts"%>
<%@page import="java.util.List"%>
<%@page import="com.services.webcarservicessystem.CarPartsService"%>
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
            
           HttpSession hs=request.getSession();
        String uname=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
        
         //setting the userid to the session
         hs.setAttribute("userid", uname);
                           
                            CarPartsService car = new CarPartsService();
                            List<CarParts> carpartsList = car.getCarPartsConnectorList();
                            
                        
                            request.setAttribute("carpartsList", carpartsList);
             %>
             <% if(!role.equalsIgnoreCase("customer")){ %>
               <form  style ="float:right" class='submit-button' method = 'post' action = 'AddCarParts'>                     
                    <input class = 'submit-button'  type = 'submit' name = 'AddCarParts' value = 'AddCarParts'>
             </form>
               <% }else{ %>
                    
                     </br>
               
              <%} %>

            <table>
                          <tr>
                          
                              
                              
                              <c:choose>                              
                                   <c:when test="${empty requestScope.carpartsList}">
                                        <tr><th><span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">No Record Found</span></th></tr>
                                   </c:when>                          
                              <c:otherwise>       
                                 <c:forEach items="${requestScope.carpartsList}" var="carparts">
                               
                               <div class="vehicle-content"> 
                                 <tr>   
                                <th colspan="5" style="text-align:left;">
                                   <span class="detail-content"><c:out value="${carparts.partName}"></c:out></span>
                                </th>
                                   <tr>                               
                                <td align="left">      
                                    <img src="<c:out value="${carparts.imageURL}"></c:out>" height="140px" width="155px">        
                                </td>
                                   <td> 
                                    <ul>

                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">Type:</span>
                                            <span class="detail-content"><c:out value="${carparts.type}"></c:out></span>
                                        </li>
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">MSRP:</span>
                                            <span class="detail-content"><c:out value="${carparts.retailPrice}"></c:out></span>
                                        </li>
                                        
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">Color:</span>
                                            <span class="detail-content"><c:out value="${carparts.color}"></c:out></span>
                                        </li>
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">SKU:</span>
                                            <span class="detail-content"><c:out value="${carparts.sku}"></c:out></span>
                                        </li>
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">Stock:</span>
                                            <span class="detail-content"><c:out value="${carparts.stock}"></c:out></span>
                                        </li>
                                        <li>

                                            <span  class="detail-label" style="font-weight: bold;
                                                   font-size:16px;text-align:center">Available Quantity:</span>
                                            <span class="detail-content"><c:out value="${carparts.quantityinstock}"></c:out></span>
                                        </li>
                                        
                                    </ul>
                               
                               
                               <span class="detail-label" style="font-weight: bold;
                              color:red; font-size:18px;text-align:center">Our Price:</span>
                               <span class="detail-content" style="font-weight: bold;color:red; font-size:17px;">
                               <c:out value="${carparts.price}"></c:out></span>
                             
                                        
                                   </td>
                                       
                                     
                                    <td>
                                    <form class = 'submit-button' method = 'post' action = 'addtoCart'>
                                      <i class='glyphicon glyphicon-shopping-cart'></i>
                                      <input class = 'submit-button' type = 'submit' name = 'Connectors' value = ' Add to Cart'>
                                      <input type='hidden' name='partid' value='<c:out value="${carparts.partId}"></c:out>'>
                                      <input type='hidden' name='partname' value='<c:out value="${carparts.partName}"></c:out>'>
                                      <input type='hidden' name='type' value='<c:out value="${carparts.type}"></c:out>'> 
                                      <input type='hidden' name='description' value='<c:out value="${carparts.description}"></c:out>'>    
                                      <input type='hidden' name='retailprice' value='<c:out value="${carparts.retailPrice}"></c:out>'>
                                      <input type='hidden' name='price' value='<c:out value="${carparts.price}"></c:out>'>   
                                      <input type='hidden' name='color' value='<c:out value="${carparts.color}"></c:out>'>
                                      <input type='hidden' name='sku' value='<c:out value="${carparts.sku}"></c:out>'>                                      
                                      <input type='hidden' name='imageURL' value='<c:out value="${carparts.imageURL}"></c:out>'>
                                      <input type='hidden' name='quantity' value='" + 1 + "'>
                                    </form>
                                   </td>

                                                 <td>
                                                     
                                                     
                                                     
                                    <% if(!role.equalsIgnoreCase("customer")){ %>
                                                     
                                      <form class = 'submit-button' method = 'post' action = 'updateCarParts'>                     
                                      <input class = 'submit-button'  type = 'submit'  name = 'UpdateConnectors' value = 'Update'>
                                      <input type='hidden' name='model' value='<c:out value="${carparts.id}"></c:out>'> 
                                      <input type='hidden' id='partid' name='partid' value='<c:out value="${carparts.partId}"></c:out>'>                      
                                     </form>

                                      <form class = 'submit-button' method = 'post' action = 'deleteCarParts'>                     
                                      <input class = 'submit-button'  type = 'submit' name = 'DeleteConnectors' value = 'Delete'>
                                      <input type='hidden' name='model' value='<c:out value="${carparts.id}"></c:out>'>                      
                                     </form>
                                 <% } %>
                                     <br>
                                     <br>
                                     <br>



                                    </td>




                                  </tr>

                                    </div>

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
