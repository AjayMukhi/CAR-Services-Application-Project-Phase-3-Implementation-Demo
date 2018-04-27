<%-- 
    Document   : Dealer
    Created on : Apr 3, 2018, 1:05:06 AM
    Author     : AjayMukhi
--%>



<%@page import="com.services.webcarservices.User"%>
<%@page import="com.services.webcarservices.DealerService_Service"%>
<%@page import="java.util.List"%>
<%@page import="com.services.webcarservicessystem.DealerService"%>
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
<style>


.wrapR h2{
	text-align: center;
	margin-buttom: 30px;
	
}
.wrapR{
	
	width: 630px;
	height: 550px;
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
	  height: 20px;
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
        
        
           
    </head>
    
   
    <body>
      <div id='container'>
	<div id='body'>	
            
             
                      
	<section id='content' style=" float: right;
    width: 75%;">
            
            
       
            <%
                           DealerService_Service dealer=new DealerService_Service();        
                           com.services.webcarservices.DealerService proxy=dealer.getDealerServicePort();
                            List<User> dealerList = proxy.getDealerList();
                            //out.println(dealerList.listIterator().next().getUsertype());
                        
                            request.setAttribute("dealerList", dealerList); HttpSession hs=request.getSession();
        String uname=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
       %>
       
       
       
          <% if(!role.equalsIgnoreCase("customer")){ %>
             
             <form  style ="float:right" class='submit-button' method = 'post' action = 'AddDealer'>                     
                    <input class = 'submit-button'  type = 'submit' name = 'AddDealer' value = 'AddDealer'>
             </form>
 
              <% }else{ %>
                       
                   <% } %>   
                   
                   <table>
                          <tr>
                          
                              
                              
                              <c:choose>                              
                                   <c:when test="${empty requestScope.dealerList}">
                                        <tr><th><span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">No Record Found</span></th></tr>
                                   </c:when>                          
                              <c:otherwise>       
     
                              <c:forEach items="${requestScope.dealerList}" var="del">
                               
                               <div class="vehicle-content"> 
                                 <tr>   
                                <th colspan="5" style="text-align:left;">
                                   <span class="detail-content"><c:out value="${del.username}"></c:out></span>
                                </th>
                                   <tr>                               
                                <td align="left">      
                                    <img src="images/No-image.jpg" height="140px" width="155px">        
                                </td>
                                   <td> 
                                    <ul>

                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">First Name:</span>
                                            <span class="detail-content"><c:out value="${del.firstname}"></c:out></span>
                                        </li>
                                        <li>
                                            <span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">Last Name</span>
                                            <span class="detail-content"><c:out value="${del.lastname}"></c:out></span>
                                        </li>
                                        
                                        
                                    </ul>
                               
                               
                               <span class="detail-label" style="font-weight: bold;
                              color:red; font-size:20px;text-align:center">Dealer Phone:</span>
                                            <span class="detail-content"><c:out value="${del.phone}"></c:out></span>
                             
                                        
                                   </td>
                               
                               <td>
                    
                  <% if(!role.equalsIgnoreCase("customer")){ %>                 
                  <form class = 'submit-button' method = 'post' action = 'updateDealer'>                     
                    <input class = 'submit-button'  type = 'submit'  name = 'updateDealer' value = 'Update'>
                    <input type='hidden' name='model' value='<c:out value="${del.id}"></c:out>'>  
                    <input type='hidden' name='username' value='<c:out value="${del.username}"></c:out>'>                     
                   </form>
                  
                    <form class = 'submit-button' method = 'post' action = 'deleteDealer'>                     
                    <input class = 'submit-button'  type = 'submit' name = 'DeleteDealer' value = 'Delete'>
                    <input type='hidden' name='model' value='<c:out value="${del.id}"></c:out>'>                      
                   </form>
                   
                   <% } %>
                   
                   <br>
                   <br>
                   <br>
                   
                   
                                   
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
	<h4>Dealer Details</h4>
	<ul>
		
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