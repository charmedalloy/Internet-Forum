<%-- 
    Document   : logout
    Created on : Dec 3, 2015, 10:13:16 PM
    Author     : Aval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logout</title>
    </head>
    <body><%
         if(session.getAttribute("reg")!=null)
       {
                   
                      session.invalidate(); %>
                    <%@include file="login.jsp"%>
    
            <% 
                      
}
        if(request.getAttribute("data")=="wronglogin")
        {%>
        <%@include file="login.html" %>
        <center> <span style="color:red;">Invalid username or password</span></center>
        <%
        }
        else
        { if(request.getParameter("log")=="logout"){
            %>
            <%@include file="login.html"%> 
            <center> <span style="color:blue;">Login Again</span></center>
            <% 
        }
}
%>       
       
    </body>
</html>
