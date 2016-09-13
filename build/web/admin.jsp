<%-- 
    Document   : admin
    Created on : Dec 3, 2015, 10:00:58 PM
    Author     : Aval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="connection.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%      String un=request.getParameter("uname");
                String pw=request.getParameter("pass");
                String btn=request.getParameter("btn");
        
                 if (btn.equals("Login")){
              try{    connect();
                      PreparedStatement st=con.prepareStatement("Select * from logintb where username=? and password=?");
                        st.setString(1, un);
                       st.setString(2, pw);
                      ResultSet rs = st.executeQuery();
                if(rs.next())
                {   %>
                <%@include file="admin-header.jsp"%>
                <% }
                else{ 
                 String flag="wronglogin";
                 request.setAttribute("data",flag);%>
                 <%@include file="logout.jsp"%>
                     <%
                 }
                    //response.sendRedirect("login.html");         
 
           }
                catch(Exception e){System.out.println(e);}
                 } %>
                 

    </body>
</html>
