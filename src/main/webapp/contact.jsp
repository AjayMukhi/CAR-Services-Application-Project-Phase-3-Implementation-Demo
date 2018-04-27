<%-- 
    Document   : contact
    Created on : Apr 2, 2018, 1:37:08 PM
    Author     : AjayMukhi
--%>

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
        
        
           
    </head>
    
   
    <body>
      <div id='container'>
	
	<div id='body'>
         <section id='content' style=" float: right;width: 75%;">
         <article>
             
                      
	
       <%
           
           
           HttpSession hs=request.getSession();
        String userid=(String)hs.getAttribute("userid"); 
        String role=(String)hs.getAttribute("role");
        
         //setting the userid to the session
         hs.setAttribute("userid", userid);
                           
                            
             %>

             
             <table>
                 <tr> 
                     <td align="left">      
                          <img src="images/store.png">        
                       </td>
                      
                       
                 <tr>
                     
                 <td>
                           
                       <h3>
                  <span class="detail-label" style="font-weight: bold;
                                              color:blue;    font-size:20px;text-align:center">
                       <br>
                       <br>
                       
                       
                       Give us a call at :
                       <span class="detail-label" style="font-weight: bold;
                                              color:red;    font-size:20px;text-align:center">
                 1-800-888-9333
                       </span>
                 </br>
                 </br>
                 For relay service,          please dial 711 
                  </span></h3>
                     </tr>
             </td>
       </tr>
                 
           </table>
                    </article>
           
                
            
            
            
            
            </section>
	
	<!--  side bar starts   -->    
	<aside class='sidebar'>
	<ul>	
	<li>
	<h4>Contact us</h4>
	
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
