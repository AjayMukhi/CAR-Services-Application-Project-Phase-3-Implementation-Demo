<%-- 
    Document   : AddCarParts
    Created on : Apr 23, 2018, 11:12:04 AM
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
<script type="text/javascript">
function check()
{
<%
if(request.getParameter("msg")!=null)
{
%>
var msg='Car Parts Added Successfully';
alert(msg);
<%
}


if(request.getParameter("msg1")!=null)
{
%>
var msg1='There is some problem in Adding the CarParts into database.';
alert(msg1);
<%
}

%>
}
</script> 
 <style>


.wrapR h2{
	text-align: center;
	margin-buttom: 30px;
	
}
.wrapR{
	
	width: 500px;
	height: 450px;
	overflow: hidden;
	margin: auto;
	margin-top: 50px;
	padding: 20px;
	background: #fff; 
	border: 1px solid silver;
	border-radius: 5px;
}


.wrapR input{
	  
	  width: 200px;
	  height: 20px;
	  margin-bottom: 20px;
	  border-radius: 3px;
	  border: 1px solid silver;
	  padding: 5px;
	  
	
}



.wrapR .btn{
	padding: 10px;
	width: 200px;
	height: 35px;
	background-color: #778899;
	color: #fff;
	border-radius: 3px;
	border: 0;
	font-size: 12px;
}

.wrapR .btn:hover{
    background-color: #EA5444;
    text-fill: white;

}
.wrapR .btn:focused{
   -fx-border-width: 0.5px;
    -fx-border-color: #ACACAC;
   -fx-border-radius: 50px;
}
  

    
    
    
    
</style> 


       
        
           
    </head>
    
   
    <body>
      <div id='container'>
	<div id='body'>	
            
             
                      
	<section id='content' style=" float: right;
    width: 75%;">
            
              
       <%
           
           
           HttpSession hs=request.getSession();
        String userid=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
        
         //setting the userid to the session
         hs.setAttribute("userid", userid);
                           
                            CarPartsService car = new CarPartsService();
                            List<CarParts> carpartsList = car.getCarPartsAntennaList();
                            
                        
                            request.setAttribute("carpartsList", carpartsList);
             %>
             
           <body style="background-color:silver" onload="return check()">          
<table align="center" width="100%" height="100%" border=0 cellpadding=12> 
<tr><td>

      <div class="wrapR" align="center">
       <form action ="CarPartsServlet" method="post">
           
           <h2> Add Car Parts Details </h2>
         
         <input id="partid" type="text" name="partid" placeholder="PartID" required >
         <input id="partname" type="text" name="partname" placeholder="Part Name" required >
         <input id="type" type="text" name="type" placeholder="CarPart Category" required >         
         <input id="description" type="text" name="description" placeholder="Descrition" required>         
         <input id="retailprice" type="text" name="retailprice" placeholder="Retail Price" required>
         <input id="price" type="text" name="price" placeholder="Price" required>         
         
         <input id="color" type="text" name="color" placeholder="Color" required>
         <input id="sku" type="text" name="sku" placeholder="SKU" required>         
         <input id="stock" type="text" name="stock" placeholder="Stock" required>
         <input id="quantity" type="text" name="quantity" placeholder="Quantity in Stock" required>         
         <input id="image" type="text" name="imageURL" placeholder="imageURL" required></br>
         
         

                 
         <!--<input id="type" type="text" name="type" placeholder="UserType" required> -->
         <button type="submit" class="btn" >Add</button>
                  
      
       </form>
      </div>
</table> 
 </body>
                       
                        
            
            
            
            
               
             
             
             
             
        
        
        
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
