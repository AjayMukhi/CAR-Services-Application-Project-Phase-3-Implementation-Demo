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
var msg='Please Check your userid and password';
alert(msg);

<%
}


if(request.getParameter("msg1")!=null)
{
%>
var msg1='User Profile doesnot exist.Please create. !';
alert(msg1);
<%
}

%>
}

//}
</script>

<link rel="stylesheet" type="text/css" href="css/loginstyle.css">
</head>
<body style="background-color:silver" onload="return check()"><center style="height: 614px; ">
<table  width="100%">
	<tr>
	<!--<td align=""><img src="./Images/defect.jpg" height="120"></img></td> -->
	<td align=""><font face="arial narrow" size="10px" color="Orange"><b> Car Services System</b></font></td>
	</tr>
</table>
<hr>


<table align="right" width="20%"  border=0 cellpadding=12> 
<tr><td>

      <div class="wrap">
       <form action ="loginServlet" method="post">
         <h2>Login Page</h2>
         <input id="username" type="text" name="username" placeholder="Username" required >
         <input id="pass" type="password" name="pass" placeholder="Password" required>
         <!--<input id="type" type="text" name="type" placeholder="UserType" required> -->
         <button type="submit" class="btn" >Login</button><br>
         <br><font face="arial narrow" color="red">If New User,click <a href="Register.jsp">here</a></font></br>

      
       </form>
      </div>
</table> 
</body>
</html>