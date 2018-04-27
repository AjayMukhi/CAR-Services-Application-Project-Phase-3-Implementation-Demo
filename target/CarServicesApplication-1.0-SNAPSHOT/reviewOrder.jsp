<%-- 
    Document   : reviewOrder
    Created on : Apr 2, 2018, 10:32:43 PM
    Author     : AjayMukhi
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.services.webcarservices.CustOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.services.webcarservicessystem.OrderService"%>
<%@page import="com.services.webcarservices.OrderService_Service"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./AdminHeader.jsp" /> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Dealer Company</title>
        <link rel='shortcut icon' href='/images/icon.jpg'/>
	<link rel='stylesheet' href='css/styles.css' type='text/css' />
    </head>
        
<%
String msg=null;

 msg=request.getParameter("msg");

        %>
      <script type="text/javascript">
       function check()
       {
       <%
       if(request.getParameter("msg")!=null)
       {
       %>
       var msg='Order created successfully';
       alert(msg);
       <%
       }


       if(request.getParameter("msg1")!=null)
       {
       %>
       var msg1='Some problem while creating order';
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
            
         <section id='content' style=" float: right;width: 75%;">
         <article>
            
       <%
	HttpSession hs=request.getSession();
        String uname=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
        
         //setting the userid to the session
         hs.setAttribute("userid", uname);
         
        
                           OrderService order = new OrderService();
                            List<CustOrder> orderList = order.getOrderList();
                            
                            //List<CustOrder> orderList1 = order.getOrderByUserName(uname);
                            //out.println(orderList.listIterator().next().getOrderid());
                            //out.println(orderList.listIterator().next().getCardnumber());
                        
                            request.setAttribute("orderList", orderList);
                            //request.setAttribute("orderUnameList", orderList1);
             %>

                          
             <%
/*Declaration of variables*/

Connection con;
PreparedStatement pstmt;
ResultSet rs=null;

      String orderid,itemname,description,orderdate;
      double price;
      int quantity;
      String username,phone,paymenttype,address,city,state,zipcode;
              
              

try
{	
	  Class.forName("com.mysql.jdbc.Driver");
       	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "pass");
       	  pstmt=con.prepareStatement("select * from CustOrder");
    	   rs=pstmt.executeQuery();
}
catch(Exception e)
{
	e.printStackTrace();
}
if(rs!=null)
{
%>
	<br>
	<table class=notebook align=center border="1" cellpadding="2" cellspacing="0" bordercolor="green"
               style="font-size:12px;">
	<tr class=row_title bgcolor="#999900">
        
		<th align="center">Order Number</th>
		<th align="center">Item Name</th>
		<th align="center">Description</th>
		<th align="center">Quantity</th>
		<th align="center">Price</th>
		<th align="center">Name</th>
		<th align="center">Phone</th>
                <th align="center">Order Date</th>
		<th align="center">Payment Method</th>
		<th align="center">Address</th>
		<th align="center">City</th>
                <th align="center">State</th>
                <th align="center">Zip code</th>
                
		<%
int DisRow=0;
	/*Getting the values from the database*/

	while(rs.next())
	{
	   orderid=rs.getString("orderid");
	   itemname=rs.getString("itemname");
	   description=rs.getString("description");
           quantity=rs.getInt("quantity");
	   price=rs.getDouble("price");	   
	   username=rs.getString("username");
           phone=rs.getString("phone");
	   
           paymenttype=rs.getString("paymenttype");
           address=rs.getString("address");
	   
	   city=rs.getString("city");
	   state=rs.getString("state");
	   zipcode=rs.getString("zipcode");
	   orderdate = rs.getString("orderdate");
	   
	   DisRow++;
	%>
	<tr class= <%=(DisRow%2!=0)? "row_even" : "row_odd"%> 
         >
		
		<td align="center"><%=orderid%></td>
		<td align="center"><%=itemname%></td>
		<td align="center"><%=description%></td>
                <td align="center"><%=quantity%></td>
		<td align="center"><%=price%></td>		
		<td align="center"><%=username%></td>
		<td align="center"><%=phone%></td>
                <td align="center"><%=orderdate%></td>
		<td align="center"><%=paymenttype%></td>
		<td align="center"><%=address%></td>
                <td align="center"><%=city%></td>
                <td align="center"><%=state%></td>
		<td align="center"><%=zipcode%></td>
                
                
		
		<%
	}
	rs.close();		
if(DisRow==0)
{	
	%>		
			<tr><th colspan=5>No Records found</th></tr>
	<%
}
}
%>
                        
        </table>

             
             
             
             
             
             
                    </article>
           
                
            
            
            
            
            </section>
        <!--  side bar starts   -->    
	<aside class='sidebar'>
	<ul>	
	<li>
	<h4>Review Order</h4>
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