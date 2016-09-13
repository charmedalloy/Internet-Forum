<%-- 
    Document   : news
    Created on : Dec 1, 2015, 8:16:54 PM
    Author     : Aval
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="admin-header.jsp"%>
<%@include file="connection.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News</title>
    </head>
    <body>
        <% ArrayList al=new ArrayList();
if(request.getAttribute("data")!=null){
    al = (ArrayList) request.getAttribute("data");
     try
     {%><center>
        <form name="category" action="newsserv" method="get">
            
            Title:<input type="text" name="title" value="<%=al.get(1).toString()%>" /><br><br>
            News:<br> <textarea name="news" rows="2" cols="50" ><%=al.get(2).toString()%> </textarea><br><br>
            Date: <input type="text" name="date" value="<%=al.get(3).toString()%>" /><br><br>
            Time:<input type="text" name="time" value="<%=al.get(4).toString()%>" /><br><br>
            <input type="submit" value="update" name="btn" />
            <%}

    catch(Exception ex)
                {
            out.println(ex);
            }   
}
else
{
%>
        </form>
    </center>
        
        <center>
            <form name="category" action="newsserv" method="post" enctype="multipart/form-data">
            
            Title:<input type="text" name="title" value="" /><br>
            News:<br><br> <textarea name="news" rows="4" cols="20">
            </textarea><br><br>
            Date: <input type="text" name="date" value="" /><br><br>
            Time:<input type="text" name="time" value="" /><br><br>
            Image :<input type="file" name="photo"/>
            <input type="submit" value="add" name="btn" />
        </form>
    </center>
    <br><br>
    <center>
    <%  
            connect();
        try {   
            st=con.prepareStatement("Select *  from news_tb ");
            rst=st.executeQuery();
            %> 
            <table border="1"> 
                <tr>
                    <td>Click to edit</td>
                    <td>Title</td>
                    <td>News</td>
                    <td>Date</td>
                    <td>time</td>
                </tr>
            <% while(rst.next())
            {
            %>
            <tr>
                <td><form action="newsserv"><input type="submit" value="Select" name="btn" />
                <input type="text" name="txt_id" value="<%=rst.getString(1)%>" size="1" /></form></td>
                <td><%=rst.getString(2)%></td>
                <td><%=rst.getString(3)%></td>
                <td><%=rst.getString(4)%></td>
                <td><%=rst.getString(5)%></td>
            </tr>
            <%
             }
               rst.close();
            %>
            </table><br><br>
            <%
         }
               catch(Exception e)
            {
                System.out.println(e);
            }
        disconnect();
}
%></center>
    </body>
</html>
