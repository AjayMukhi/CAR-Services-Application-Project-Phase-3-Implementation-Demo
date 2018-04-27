<%-- 
    Document   : Register
    Created on : Apr 1, 2018, 7:12:49 PM
    Author     : AjayMukhi
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
String msg=null;

msg=request.getParameter("msg");

 %>
<head>
<script type="text/javascript">
function check()
{
<%
if(request.getParameter("msg")!=null)
{
%>
var msg='Registered Successfully';
alert(msg);
<%
}


if(request.getParameter("msg1")!=null)
{
%>
var msg1='There is some problem in registration.';
alert(msg1);
<%
}

%>
}

//}
</script>

<link rel="stylesheet" type="text/css" href="css/registerstyle.css">
</head>
<body style="background-color:silver" onload="return check()">
    
<table align="center" width="100%" height="100%" border=0 cellpadding=12> 
<tr><td>

      <div class="wrapR" align="center">
       <form action ="RegServlet" method="post">
           
         <h2>Registration Page</h2>
         
         <input id="firstname" type="text" name="fname" placeholder="First Name" required >
         <input id="lastname" type="text" name="lname" placeholder="Last Name" required >
         <input id="username" type="text" name="username" placeholder="Username" required >
         <input id="pass" type="password" name="pass" placeholder="Password" required>
         <input id="email" type="text" name="email" placeholder="Email Address" required>
         <input id="phone" type="text" name="phone" placeholder="Phone Number" required>
         <input id="usertype" type="text" name="usertype" placeholder="UserType" required>
         
         <input id="address" type="text" name="address" placeholder="Address" required>
         <input id="city" type="text" name="city" placeholder="City" required><br>
         
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
            <br>
            <input id="zipcode" type="zipcode" name="zipcode" placeholder="ZipCode" required><br>
            <input id="country" type="country" name="country" placeholder="Country" required><br>

                 
         <!--<input id="type" type="text" name="type" placeholder="UserType" required> -->
         <button type="submit" class="btn" >Register</button>
         <br>
         <br>
         <font face="arial narrow" color="red">
              <a href="loginPage.jsp">Login  Page</a></font>
         </br>
         
      
       </form>
      </div>
</table> 
</body>
</html>