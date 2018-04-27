<%-- 
    Document   : ProfilePage
    Created on : Apr 24, 2018, 1:06:29 PM
    Author     : AjayMukhi
--%>


<%@page import="com.services.webcarservices.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.services.webcarservicessystem.ProfileService"%>


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
    

    <script type="text/javascript">
function check()
{
<%
if(request.getParameter("msg")!=null)
{
%>
var msg='Profile Updated Successfully';
alert(msg);
<%
}


if(request.getParameter("msg1")!=null)
{
%>
var msg1='There is some problem in Updating the Profile into database.';
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
	  
	  width: 160px;
	  height: 40px;
	  margin-bottom: 20px;
	  border-radius: 3px;
	  border: 1px solid silver;
	  padding: 5px;
	  
	
}



.wrapR .btn{
	padding: 10px;
	width: 160px;
	height: 45px;
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
   
    
    
    
  
    
    
    
    
    <body>
          
       <div id='container'>
	
	<div id='body'>
         <section id='content' style=" float: right;width: 75%;">
             
              
         <article>
              <%
                           
           
        HttpSession hs=request.getSession();
        String uname=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
        

                               ProfileService  profile = new ProfileService();
                               
                               List<User> userList = profile.getUserDetailsById(uname);
                            
                               request.setAttribute("profileList", userList);
        

                   

 %>
           
            
 
                <% if(!role.equalsIgnoreCase("customer")){ %>
             
             <form  style ="float:right" class='submit-button' method = 'post' action = 'AddProfile'>                     
                    <input class = 'submit-button'  type = 'submit' name = 'Add' value = 'AddProfile'>
             </form>
 
              <% }else{ %>
                       
                   <% } %>   
                   
 
 
 <body style="background-color:silver" onload="return check()">          
               <table align="center" width="100%" height="100%" border=0 cellpadding=12> 
                   <div align="center">
                     <h2>User Profile Details </h2> 
                   </div>
                <tr><td>
                          
                          <tr>
                          
                              
                              
                              <c:choose>                              
                                   <c:when test="${empty requestScope.profileList}">
                                        <tr><th><span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">No Record Found</span></th></tr>
                                   </c:when>                          
                              <c:otherwise>       
                                 <c:forEach items="${requestScope.profileList}" var="profile">
                               
                    <div class="wrapR" align="center"  > 
                              
                      
                       
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">UserName:</span>
                        <span class="detail-content"><c:out value="${profile.username}"></c:out></span>
                        <br>
                       
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">First Name:</span>
                        <span class="detail-content"><c:out value="${profile.firstname}"></c:out></span><br>
                       <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">Last Name:</span>
                              <span class="detail-content"><c:out value="${profile.lastname}"></c:out>
                        </span><br>
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">Password:</span>
                              <span class="detail-content"><c:out value="${profile.password}"></c:out>
                        </span><br>
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">Email Address:</span>
                              <span class="detail-content"><c:out value="${profile.email}"></c:out>
                        </span><br>
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">Phone Number:</span>
                              <span class="detail-content"><c:out value="${profile.phone}"></c:out>
                        </span><br>
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">User Type:</span>
                              <span class="detail-content"><c:out value="${profile.usertype}"></c:out>
                        </span><br>
                        
                        <p>
                        <h2> Address Information </h2>
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">Address:</span>
                              <span class="detail-content"><c:out value="${profile.address}"></c:out>
                        </span><br>
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">City:</span>
                              <span class="detail-content"><c:out value="${profile.city}"></c:out>
                        </span><br>
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">State:</span>
                              <span class="detail-content"><c:out value="${profile.state}"></c:out>
                        </span><br>
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">Zip Code:</span>
                              <span class="detail-content"><c:out value="${profile.zipcode}"></c:out>
                        </span><br>
                        <span class="detail-label" style="font-weight: bold;
                              font-size:16px;text-align:center">Country:</span>
                              <span class="detail-content"><c:out value="${profile.country}"></c:out>
                        </span><br>
                        
                        
                        </p>
                        
                        
                       
                                        
                                        
                      
                               
                               
                              
                                        
                                                                   
                                     
                                    
                                    <form class = 'submit-button' method = 'post' action = 'updateProfile'>
                                      
                                      <input class = 'submit-button' type = 'submit' name = 'updateProfile' value = 'Update Profile'>
                                      <input type='hidden' name='model' value='<c:out value="${profile.id}"></c:out>'>  
                                      <input type='hidden' name='username' value='<c:out value="${profile.username}"></c:out>'>
                                      
                                      
                                    </form>
                                   

                                             
                                     
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
            </body>
               
           
            
       
                    </article>
                
            
            
            
            
            </section>

</script>
     <aside class='sidebar'>
	<ul>	
	<li>
	<h4>View Profile</h4>
	<ul>
	
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
    
    <br>
    <br>
    <br>
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
