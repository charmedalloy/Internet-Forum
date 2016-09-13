<%-- 
    Document   : course.jsp
    Created on : Dec 1, 2015, 6:43:55 PM
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
        <title>Course page</title>
           
    </head>
    <body>
         <% ArrayList al=new ArrayList();
if(request.getAttribute("data")!=null){
    al = (ArrayList) request.getAttribute("data");
     try
     {%>
     <center>
        <form name="course" action="courseserv" method="get">
            Course Name:<input type="text" name="course" value="<%=al.get(1).toString()%>" /><br><br>
            Duration:<input type="text" name="duration" value="<%=al.get(2).toString()%>" /><br><br>
            Type:<%=al.get(3).toString()%><br><br>
            Change Type:<select name="type">
                <option>Degree</option>
                <option>Diploma</option>
                <option>Vocational</option>
            </select><br><br>
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
        <form name="course" action="courseserv" method="get">
            Course Name:<input type="text" name="course" value="" /><br><br>
            Duration:<input type="text" name="duration" value="" /><br><br>
            Type:<select name="type">
                <option>Degree</option>
                <option>Diploma</option>
                <option>Vocational</option>
            </select><br><br>
            <input type="submit" value="add" name="btn" />
        </form>
    </center>
    <center>
    <%  
            connect();
        try {   
            st=con.prepareStatement("Select * from course_tb ");
            rst=st.executeQuery();
            %> 
            <table border="1"> 
                <tr>
                    <td>Click to edit</td>
                    <td>Course name</td>
                    <td>Duration </td>
                    <td>Type</td>
                </tr>
            <% while(rst.next())
            {
            %>
            <tr>
                <td><form action="courseserv"><input type="submit" value="Select" name="btn" />
                <input type="text" name="txt_id" value="<%=rst.getString(1)%>" size="1" /></form></td>
                <td><%=rst.getString(2)%></td>
                <td><%=rst.getString(3)%></td>
                <td><%=rst.getString(4)%></td>
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
