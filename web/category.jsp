<%-- 
    Document   : admin
    Created on : Dec 1, 2015, 6:11:52 PM
    Author     : Aval
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@include file="admin-header.jsp" %>
<%@include file="connection.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
    </head>
    <body>
<% ArrayList al=new ArrayList();
if(request.getAttribute("data")!=null)
{
    al = (ArrayList) request.getAttribute("data");
     try{
%>
    <center>
    <form name="category" action="catserv" method="get">
            category:<input type="text" name="cat_name" value="<%=al.get(1).toString()%>" /><br><br>
            Course:
               <% connect();
                String x;
                 x=al.get(2).toString();
                st=con.prepareStatement("select course_name from course_tb where courseId=?") ;
                st.setLong(1, Long.parseLong(x));
                rst=st.executeQuery();
             while(rst.next())
             { %>    
             <%= rst.getString(1)%>
             <%}
             %> 
             <br><br>
             Course:<select name="course">
                 
        <% st=con.prepareStatement("select courseId,course_name from course_tb ");
                rst=st.executeQuery();
             while(rst.next())
             {    
               %>
               <option value="<%=rst.getLong(1)%>" > <%=rst.getString(2)%></option>
        <%}%>
            </select><br><br>
            <input type="submit" value="update" name="btn" /></form>
             <%}
    catch(Exception ex)
                {
            out.println(ex);
            }   
}
else
{
%>
    </center>
    <br><br>
    <center>
        <form name="category" action="catserv" method="get">
            category:<input type="text" name="cat_name" value="" /><br><br>
            Course: <select name="course">
                <% connect();
                st=con.prepareStatement("select courseId,course_name from course_tb");
                rst=st.executeQuery();
             while(rst.next())
             {    
               %>
               <option value="<%=rst.getLong(1)%>" > <%=rst.getString(2)%>
        </option>  
        <%}%>
            </select><br><br>
            <input type="submit" value="add" name="btn" />
        </form>
    </center><br><br>
    
   <%  
            connect();
        try {   
            st=con.prepareStatement("Select *,(select course_name from course_tb a where a.courseId=b.courseId ) from cat_tb b ");
            rst=st.executeQuery();
            %> 
            <center><table border="1"> 
                <tr>
                    <td>Click to edit</td>
                    <td>Category</td>
                    <td>Course</td>
                </tr>
            <% while(rst.next())
            {
            %>
            <tr>
                <td><form action="catserv"><input type="submit" value="Select" name="btn" />
                <input type="text" name="txt_id" value="<%=rst.getString(1)%>" size="2" /></form></td>
                <td><%=rst.getString(2)%></td>
                <td><%=rst.getString(4)%></td>
            </tr>
            
            <%
             }
               rst.close();
            %>
                </table></center><br><br>
            <%
         }
               catch(Exception e)
            {
                System.out.println(e);
            }
        disconnect();
}
%>
    </body>
</html>
                 
             
