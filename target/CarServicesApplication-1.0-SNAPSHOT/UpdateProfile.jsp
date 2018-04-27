<%-- 
    Document   : UpdateProfile
    Created on : Apr 24, 2018, 3:24:55 PM
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
           
            <body style="background-color:silver" onload="return check()">          
               <table align="center" width="100%" height="100%" border=0 cellpadding=12> 
                  
           </table>
            </body>
               
            
            
            <div class="wrapR" align="center">
       <form action ="UpdateProfileServlet" method="post">
           <p> 
         <h2>Update Profile Details </h2>
         
       </p>
      <c:forEach items="${requestScope.profileList}" var="profileList">                               
          
          First Name: <input id="fname" type="text" name="fname" value="<c:out value="${profileList.firstname}"></c:out>"  required > <br>        
          Last Name: <input id="lname" type="text" name="lname" value="<c:out value="${profileList.lastname}"></c:out>" required > <br>             
          User Name: <input id="username" type="text" name="username" value="<c:out value="${profileList.username}"></c:out>" required ><br>
          Password: <input id="password" type="text" name="password" value="<c:out value="${profileList.password}"></c:out>" required ><br>
           Email :<input id="email" type="text" name="email" value="<c:out value="${profileList.email}"></c:out>" required>
          
           User Type:  <input id="usertype" type="text" name="usertype" value="<c:out value="${profileList.usertype}"></c:out>" required><br>
          Phone :<input id="phone" type="text" name="phone" value="<c:out value="${profileList.phone}"></c:out>" required>
           Address: <input id="address" type="text" name="address" value="<c:out value="${profileList.address}"></c:out>" required><br>   
          City:<input id="city" type="text" name="city" value="<c:out value="${profileList.city}"></c:out>" required><br>
           State: <select id="state" type="state" name="state" required>
         <option selected="selected" value="" disabled="disabled">--- Select a State ---</option>
            <option value="AL">Alabama (AL)</option>
	    <option value="AK">Alaska (AK)</option>
	    <option value="AZ">Arizona (AZ)</option>
	    <option value="AR">Arkansas (AR)</option>
	    <option value="CA">California (CA)</option>
	    <option value="CO">Colorado (CO)</option>
	    <option value="CT">Connecticut (CT)</option>
	    <option value="DE">Delaware (DE)</option>
	    <option value="DC">District Of Columbia (DC)</option>
	    <option value="FL">Florida (FL)</option>
	    <option value="GA">Georgia (GA)</option>
	    <option value="HI">Hawaii (HI)</option>
	    <option value="ID">Idaho (ID)</option>
	    <option value="IL">Illinois (IL)</option>
	    <option value="IN">Indiana (IN)</option>
	    <option value="IA">Iowa (IA)</option>
	    <option value="KS">Kansas (KS)</option>
	    <option value="KY">Kentucky (KY)</option>
	    <option value="LA">Louisiana (LA)</option>
	    <option value="ME">Maine (ME)</option>
	    <option value="MD">Maryland (MD)</option>
	    <option value="MA">Massachusetts (MA)</option>
	    <option value="MI">Michigan (MI)</option>
	    <option value="MN">Minnesota (MN)</option>
	    <option value="MS">Mississippi (MS)</option>
	    <option value="MO">Missouri (MO)</option>
	    <option value="MT">Montana (MT)</option>
	    <option value="NE">Nebraska (NE)</option>
	    <option value="NV">Nevada (NV)</option>
	    <option value="NH">New Hampshire (NH)</option>
	    <option value="NJ">New Jersey (NJ)</option>
	    <option value="NM">New Mexico (NM)</option>
	    <option value="NY">New York (NY)</option>
	    <option value="NC">North Carolina (NC)</option>
	    <option value="ND">North Dakota (ND)</option>
	    <option value="OH">Ohio (OH)</option>
	    <option value="OK">Oklahoma (OK)</option>
	    <option value="OR">Oregon (OR)</option>
	    <option value="PA">Pennsylvania (PA)</option>
	    <option value="RI">Rhode Island (RI)</option>
	    <option value="SC">South Carolina (SC)</option>
	    <option value="SD">South Dakota (SD)</option>
	    <option value="TN">Tennessee (TN)</option>
	    <option value="TX">Texas (TX)</option>
	    <option value="UT">Utah (UT)</option>
	    <option value="VT">Vermont</option>
	    <option value="VA">Virginia</option>
	    <option value="WA">Washington</option>
	    <option value="WV">West Virginia</option>
	    <option value="WI">Wisconsin</option>
	    <option value="WY">Wyoming</option>  
           </select>
           ZipCode:  <input id="zipcode" type="text" name="zipcode" value="<c:out value="${profileList.zipcode}"></c:out>" required><br>
           Country: <input id="country" type="text" name="country" value="<c:out value="${profileList.country}"></c:out>" required><br>
           
               
         
              

         <input type='hidden' id='id'   name='id' value='<c:out value="${profileList.id}"></c:out>'>        
         <!--<input id="type" type="text" name="type" placeholder="UserType" required> -->
         <button type="submit" class="btn" >Update</button>
                
         </c:forEach>   
      
       </form>
      </div>
</table> 
 </body>
                  
           
            
       
                    </article>
                
            
            
            
            
            </section>

</script>
     <aside class='sidebar'>
	<ul>	
	<li>
	<h4>Profile Update </h4>
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
