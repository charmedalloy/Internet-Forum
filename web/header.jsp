<%-- 
    Document   : header
    Created on : Dec 6, 2015, 6:01:41 PM
    Author     : Aval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
        <link href="header.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
     function hamburger () {
     	if(document.getElementById('nav').style.display ==="block"){
     		close();
            return;
     	}
     	 
     	document.getElementById('nav').style.display = "block";
     	document.getElementById('main').style.transition="0.6s";
     	//document.getElementById('main').style.marginLeft="35%";
     	document.getElementById('nav').style.width = "230px";
     	return;

     	function close () {
     		document.getElementById('nav').style.display = "none";
     		//document.getElementById('main').style.marginLeft="35%";
     		return;
     	}
     }
	</script>
    </head>
    
       
        <div id="header">
            <span onclick="hamburger()" style="cursor: pointer;"> 
                Menu&#160;&#160;&#160;&#160;&#160;
                </span>
            <% try
            {
                if(session.getAttribute("reg")!=null){
                           %>
            Welcome,<%=(String) session.getAttribute("user")%>
                
            
           <% }
                else{ %>
                    NIT Kurukshetra Technical Forum
         <%   
           }
            }
              catch(Exception e)
              {  
             %>
             
             NIT Kurukshetra Technical Forum
           
            <%   
               }
                
             %>
            
            <form action="search">
            <div class="search">
                
                <input type="text" name="search" value="" placeholder="Search" />
                <input type="submit" value="Search" name="btn" />
                
            </div>
            </form>
    </div>
   
            <%
            try{
            
if( session.getAttribute("reg")!=null)
{
    %>
<div id="nav" style="display:none;width:230px">
        <h3><a href="index.jsp">Home</a></h3>
	<h3><a href="profile.jsp">My Profile</a></h3>
	<h3><a href="ask_ques.jsp">Ask a Question</a></h3>
	<h3><a href="logout.jsp?log=logout">Logout</a></h3>
        <h3><a href=""></a></h3>
</div>
<% }
            
else
{%>
    <div id="nav" style="display:none;width:230px">
        <h3><a href="index.jsp">Home</a></h3>
	<h3><a href="login.jsp">Login</a></h3>
	<h3><a href="register.jsp">Register</a></h3>
	<h3><a href=""></a></h3>
        <h3><a href=""></a></h3>
</div>
        <%
}
            }
            catch(Exception e)
            {
        %>  
        <div id="nav" style="display:none;width:230px">
	<h3><a href="login.jsp">Login</a></h3>
	<h3><a href="register.jsp">Register</a></h3>
	<h3><a href=""></a></h3>
        <h3><a href=""></a></h3>
</div>
 <% }%>
</html>
