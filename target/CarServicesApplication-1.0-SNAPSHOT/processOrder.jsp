<%-- 
    Document   : processOrder
    Created on : Apr 2, 2018, 11:50:31 AM
    Author     : AjayMukhi
--%>




<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.services.webcarservices.Cart"%>
<%@page import="com.services.webcarservices.CartService_Service"%>
<%@page import="com.services.webcarservicessystem.CartService"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


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
        
        .container {
  width: 500px;
  clear: both;
}

.container input {
  width: 100%;
  clear: both;
}
    </style>
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
	  height: 30px;
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
var msg1='There is some problem in processing the Order into database.';
alert(msg1);
<%
}

%>
}

//}

   
   
   
</script>  
      
    
    
    <body onload="return check()">
          
       <div id='container'>
	
	<div id='body'>
         <section id='content' style=" float: right;width: 75%;">
         <article>
            
       <%
	HttpSession hs=request.getSession();
        String uname=(String)hs.getAttribute("userid");
       // out.println(uname);
        String role=(String)hs.getAttribute("role");
        
        /*String quantity="";
        try{
        if(hs.getAttribute("quantity").toString()==null){
          quantity="0";
        }else
            quantity=(String)hs.getAttribute("quantity").toString();
        }catch(Exception e){
            quantity="0";   
        } */
        
        String quantity=(String)hs.getAttribute("quantity").toString();
        
       // String price1=(String)hs.getAttribute("price").toString();
        
        //double price = Double.parseDouble(price1);
        //out.println(quantity);
        int quant =Integer.parseInt(quantity);
        //out.println(quant);
        
        
         //setting the userid to the session
         hs.setAttribute("userid", uname);
        
           CartService_Service cartserv=new CartService_Service();        
           com.services.webcarservices.CartService proxy=cartserv.getCartServicePort();

                           // CartService cartservice = new CartService();
                            try{
                            
                            
                            List<Cart> cartList = new ArrayList<Cart>();
                            cartList=proxy.getCartList();
                            
                            System.out.println(cartList.listIterator().next().getPartid());
                            System.out.println(cartList.listIterator().next().getPartname());
                        
                            request.setAttribute("cartList", cartList);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            
             %>   
             
             
             
              <tr> 
              <h1>Order in Your  cart </h1>
			    <hr>
		            
			    
                          
                              
                              
                            <c:choose>                              
                                   <c:when test="${empty requestScope.cartList}">
                                        <tr><th><span class="detail-label" style="font-weight: bold;
                                                  font-size:16px;text-align:center">No Record Found</span></th></tr>
                                   </c:when>                          
                              <c:otherwise>  
                               
                            <c:forEach items="${requestScope.cartList}" var="cart">
                            
                             <table  frame='box' rules='rows'>
                                 
                              
                                <tr>
                                <td>
                                <td><span class="detail-label" style="font-weight: bold;
                                      color:blue;font-size:16px;text-align:center">Product</span></td>
                                <td><span class="detail-label" style="font-weight: bold;
                                          color:blue;font-size:16px;text-align:center">Price</span></td>
                                <td><span class="detail-label" style="font-weight: bold;
                                          color:blue;font-size:16px;text-align:center">Quantity</span></td></td>
                                
                                     
                                          
                                     
                                       <input type='hidden' name='partname' value='<c:out value="${cart.partname}"></c:out>'>
                                       
                                       <tr>
                                          <td align="left">      
                                            <img src="<c:out value="${cart.imageURL}"></c:out>" height="140px" width="155px">        
                                         </td> 
                                          
                                         <td>
                                             <span class="detail-content"><c:out value="${cart.partname}"></c:out></span>
                                         </td>
                                         <td>
                                              <c:out value="${cart.price}"></c:out>
                                         </td>
                                         
                                         
                                             
                                        <td>
                                            <select id="quantity"  name="quantity" >
                                                   <option value='1' selected>1</option>
                                                    <option value='2'>2</option>
                                                    <option value='3'>3</option>
                                                    <option value='4'>4</option>
                                                    <option value='5'>5</option>
                                              </select>
                                        </td>
                                      
                                      </tr> 
                                   

                                
                                      
                                      
                                        <!-- Billing section -->
                                        <td><br>
                                <span class="detail-label" style="font-weight: bold;
                                          color:green;font-size:16px;text-align:center">Payment Method
                                </span>
                                
                            </td></br>
                
                            
              <table>               
                  
           
                         
                             
                             
                    
                             
                         <form class = 'submit-button' action ="OrderServlet" method="post">   
                             
                             <input type="radio"  onclick="javascript:yesnoCheck();" name="yesno" id="noCheck" />Cash
        <input type="radio"  onclick="javascript:yesnoCheck();" name="yesno" id="yesCheck" />Card<br />
        
      
            
                         <div class="wrapR" id="ifYes" style="display:none;" >
                              <h2>Billing Address Information</h2>
                              <p>
                                  
                                  <input type='text' id='fname' name='fname' placeholder="Full Name" required>
                            
                                   
                                  <input type='text' id='address' name='address' placeholder="Address" required>
                            
                            
                            <input type="text" id="city" name="city" placeholder="City" required>
                            
                            
                            <select id="state" type="state" name="state" required></br>
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
                            </select>                 <br>
                                                
                                     
                                     <input type="text" id="zipcode" name="zipcode" placeholder="Zipcode" required >
                                       
                                     
                                     <input type="text" id="country" name="country" placeholder="Country" required>
                                     
                                     
                                     <input type="text" id="phone" name="phone" placeholder="Phone" required>
                              </p>
                                     
                               <h2>Payment Information</h2>
                               <p>
                               
                               <input type="text" id="cardnumber" name="cardnumber" placeholder="Card Number" required>
                              
                              
                               <input type="text" id="cvv" name="cvvcode"  placeholder="CVV Code" required><br>
                              
                               Expiry Date:
                               <input type="date" id="date" name="expdate"  required></br>
                               </p>
                               
                               
                           
                               
                           </span>
                          </div>
                          
                            <td align='center' colspan='5'>
                              <span  class="detail-label" style="font-weight: bold;
                              color:red; font-size:16px;text-align:center"> 
                              <input type='hidden' name='id' value='<c:out value="${cart.id}"></c:out>'>
                              <input type='hidden' name='partid' value='<c:out value="${cart.partid}"></c:out>'>
                              <input type='hidden' name='partname' value='<c:out value="${cart.partname}"></c:out>'>
                              <input type='hidden' name='description' value='<c:out value="${cart.description}"></c:out>'>
                              <input type='hidden' name='price'  value='<c:out value="${cart.price}"></c:out>' >
                               <input type='submit'  name='checkOut' value='Process Order'>
                            
                          
                          
                          </td>
                          </form>
                   </table>
                         
                          </c:forEach> 
                              </c:otherwise>
                            </c:choose> 
                          
                          <tr>
                           
                              
                          </tr>
                         
                        </th>

            </tr>
            
            
            
            
           </table>
                                        
                         
                         
                         
                            
                                         
           

         </article>
         </section>
             
<script>
    function yesnoCheck() {
    
    alert("111");
    
   
    if (document.getElementById('yesCheck').checked) {
        alert("card....");
        document.getElementById('ifYes').style.display = 'block';
            }
    else {
        alert("cash...");
        document.getElementById('ifYes').style.display = 'none';
        
    }

}

</script>
<script type="text/javascript">

var d='<%=quantity%>';

if( d ==="1") ){
    alert("123455");
    alert('<%=quantity%>'+d);
    var t=document.getElementById('quantity');
            t.options[3].selected = true;
}else{
    alert('quantity');
}
    

</script>
     <aside class='sidebar'>
	<ul>	
	<li>
	<h4>Order Processing</h4>
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