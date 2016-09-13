<%-- 
    Document   : subcategory
    Created on : Dec 1, 2015, 6:33:09 PM
    Author     : Aval
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@include file="admin-header.jsp"%>
<%@include file="connection.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <% ArrayList al=new ArrayList();
if(request.getAttribute("data")!=null){
    al = (ArrayList) request.getAttribute("data");
     try
     {%><center>
        <form name="subcategory" action="subcatserv" method="get">
            Sub category:<input type="text" name="subcat_name" value="<%=al.get(1).toString()%>" /><br><br>
            Category:
                <% connect();
                String x;
                 x=al.get(2).toString();
                st=con.prepareStatement("select cat_name from cat_tb where catId=?") ;
                st.setLong(1, Long.parseLong(x));
                rst=st.executeQuery();
             while(rst.next())
             { %>    
             <%= rst.getString(1)%>
             <%}
             %> <br><br>
             Change Category:<select name="cat">
                 
        <% st=con.prepareStatement("select catId,cat_name from cat_tb ");
                rst=st.executeQuery();
             while(rst.next())
             {    
               %>
               <option value="<%=rst.getLong(1)%>" > <%=rst.getString(2)%></option>
        <%}%>
            </select><br><br> 
          Course:
                <% 
                String y;
                 y=al.get(3).toString();
                st=con.prepareStatement("select course_name from course_tb where courseId=?") ;
                st.setLong(1, Long.parseLong(y));
                rst=st.executeQuery();
             while(rst.next())
             { %>    
             <%= rst.getString(1)%>
             <%}
             %> <br><br>
             Change Course:<select name="course">
                 
        <% st=con.prepareStatement("select courseId,course_name from course_tb");
                rst=st.executeQuery();
             while(rst.next())
             {    
               %>
               <option value="<%=rst.getLong(1)%>" > <%=rst.getString(2)%></option>
        <%}%>
            </select><br><br>
            
            <% rst.close();
            disconnect();%>
            <br><br>
            <input type="submit" value="update" name="btn" />
            <br><br>
           <%}

    catch(Exception ex)
                {
            out.println(ex);
            }   
}
else
{
%> 
        <center>
        <form name="subcategory" action="subcatserv" method="get">
            Sub category:<input type="text" name="subcat_name" value="" /><br><br>
            Category: <select name="cat">
                <% connect();
                st=con.prepareStatement("select catId,cat_name from cat_tb");
                rst=st.executeQuery();
             while(rst.next())
             {    
               %>
               <option value="<%=rst.getLong(1)%>" > <%=rst.getString(2)%>
        </option>  
        <%}%>
          </select> 
          Course: <select name="course">
                <% 
                st=con.prepareStatement("select courseId,course_name from course_tb");
                rst=st.executeQuery();
             while(rst.next())
             {    
               %>
               <option value="<%=rst.getLong(1)%>" > <%=rst.getString(2)%>
        </option>  
        <%}%>
          </select> 
            <% rst.close();
            disconnect();%>
            <br><br>
            <input type="submit" value="add" name="btn" />
            <br><br>
            
            <%  
            connect();
        try {   
            st=con.prepareStatement("Select *, (Select cat_name from cat_tb a where b.catId = a.catId),"
                    + "(Select course_name from course_tb c where b.courseId = c.courseId)  from subcat_tb b ");
            rst=st.executeQuery();
            %> 
            <table border="1"> 
                <tr>
                    <td>Click to edit</td>
                    <td>Sub category </td>
                    <td>category</td>
                    <td>Course</td>
                </tr>
            <% while(rst.next())
            {
            %>
            <tr>
                <td>
                    <form action="subcatserv">
                    <input type="submit" value="Select" name="btn" />
                <input type="text" name="txt_id" value="<%=rst.getString(1)%>" size="2" /></form></td>
                <td><%=rst.getString(2)%></td>
                <td><%=rst.getString(5)%></td>
                <td><%=rst.getString(6)%></td>
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
%>
     </form>
    </center> 
    </body>
</html>
