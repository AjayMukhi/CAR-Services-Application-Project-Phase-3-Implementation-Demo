<%-- 
    Document   : updateCar
    Created on : Apr 18, 2018, 11:58:23 PM
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

<script type="text/javascript">
function check()
{
<%
if(request.getParameter("msg")!=null)
{
%>
var msg='Car Updated Successfully';
alert(msg);
<%
}


if(request.getParameter("msg1")!=null)
{
%>
var msg1='There is some problem in Updating the Car into database.';
alert(msg1);
<%
}

%>
}

//}

   
   
   
</script>   
<style>


.wrapR h2{
	text-align: center;
	margin-buttom: 30px;
	
}
.wrapR{
	
	width: 630px;
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
        String uname=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
        
        
        
        String productid =(String)hs.getAttribute("productid");
        //out.println(productid);
        
        
                            CarService car = new CarService();
                            List<Car> carList = car.getCarDetailsByproductId(productid);
                            //List<Car> carList = car.getCarList();
                            
                        
                            request.setAttribute("carList", carList);
        





 %>
 
 
 
 
            
 <body style="background-color:silver" onload="return check()">          
<table align="center" width="100%" height="100%" border=0 cellpadding=12> 
<tr><td>
        
        

      <div class="wrapR" align="center">
       <form action ="CarUpdateServlet" method="post">
           
         <h2>Update Car Details </h2>
         
         
      <c:forEach items="${requestScope.carList}" var="car">                               
          
          <input id="productid" type="text" name="productid" value="<c:out value="${car.productId}"></c:out>"  required >         
          <input id="productname" type="text" name="productname" value="<c:out value="${car.productName}"></c:out>" required >              
          <input id="model" type="text" name="model" value="<c:out value="${car.model}"></c:out>" required >
          <input id="vin" type="text" name="vin" value="<c:out value="${car.vin}"></c:out>" required>
           <input id="description" type="text" name="description" value="<c:out value="${car.description}"></c:out>" required>
          <input id="displayunder" type="text" name="display" value="<c:out value="${car.displayUnder}"></c:out>" required>
          <input id="retailprice" type="text" name="retailprice" value="<c:out value="${car.retailPrice}"></c:out>" required>
          <input id="price" type="text" name="price" value="<c:out value="${car.price}"></c:out>" required>   
           <input id="engine" type="text" name="engine" value="<c:out value="${car.engine}"></c:out>" required>
           <input id="body" type="text" name="body" value="<c:out value="${car.body}"></c:out>" required>    
           <input id="trans" type="text" name="trans" value="<c:out value="${car.trans}"></c:out>" required>
          <input id="year" type="text" name="year" value="<c:out value="${car.year}"></c:out>" required>
           <input id="interior" type="text" name="interior" value="<c:out value="${car.interior}"></c:out>" required>
           <input id="exterior" type="text" name="exterior" value="<c:out value="${car.exterior}"></c:out>" required><br>
         Image URL: <input id="image" type="text" name="imageURL" value="<c:out value="${car.imageURL}"></c:out>" required></br>
         
              

         <input type='hidden' id='id'   name='id' value='<c:out value="${car.id}"></c:out>'>        
         <!--<input id="type" type="text" name="type" placeholder="UserType" required> -->
         <button type="submit" class="btn" >Update</button>
                
         </c:forEach>   
      
       </form>
      </div>
</table> 
 </body>
                       
                        
            
            
            
            
            
            
            
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