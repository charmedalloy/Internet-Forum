<%-- 
    Document   : profile
    Created on : Dec 4, 2015, 5:32:12 PM
    Author     : Aval
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="connection.jsp" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="header.css" rel="stylesheet" type="text/css"/>
    </head>
   
<div id="nav" style="display:none;width:230px">
	<h3><a href="login.jsp">Login</a></h3>
	<h3><a href="register.jsp">Register</a></h3>
	<h3><a href=""></a></h3>
        <h3><a href=""></a></h3>
</div>
        </div>
        <div class="news">
                
                
                <%
                    int i;
                    connect();
                //Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               st=con.prepareStatement("select top(5) * from news_tb order by date desc");
                rst=st.executeQuery();
                %>
                <table>
                    <tr><td><b>Latest News</b></td></tr>
                    <tr><td></td></tr>
                <% 
                  i=5;
                while(rst.next() && i>=1)
                { 
                 %>
                 <tr> <td>
                <B><%=rst.getString(2)%></b><br>
                <%=rst.getString(3)%><br>
                <%=rst.getString(4)%>,<%=rst.getString(5)%>
                 </td>
                 <td><a href="commentserv?a=<%=i%>">Comment</a></td></tr>
                <%  
                i--;
                }
                disconnect();
                %>
                 
                </table>
            </div>  
            
    
</html>
