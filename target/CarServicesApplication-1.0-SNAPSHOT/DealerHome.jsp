<%-- 
    Document   : DealerHome
    Created on : Apr 26, 2018, 1:26:04 PM
    Author     : AjayMukhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./AdminHeader.jsp" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CAR Services Application</title>
    </head>
    
    
    
  <body>
    
   <!-- Carousel part Starts-->
      
  <div class="container">
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="car-img"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="images/car1.jpg" alt="car 1" style="width:100%;">
      </div>

      <div class="item">
        <img src="images/car2.jpg" alt="car 2" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="images/car3.jpg" alt="car 3" style="width:100%;">
      </div>
        
        <div class="item">
        <img src="images/car4.jpg" alt="car 4" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  
</div>
   
   <!-- Carousel part Ends-->
    
 
</body>
</html>
