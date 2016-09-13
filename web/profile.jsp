<%-- 
    Document   : profile
    Created on : Dec 15, 2015, 11:06:17 AM
    Author     : Aval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="connection.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="header.css" rel="stylesheet" type="text/css"/>
        
        <link href="table.css" rel="stylesheet" type="text/css"/>
            <style type="text/css">
                .exp
                {
                   cursor: pointer; 
                }
            </style>
    </head>
    <body>
        
        <% connect();
        String regid=null;
         regid=(String)session.getAttribute("reg");%>
        <div id="topmenu">
            <table >
                <tr>
                <td><h3><a href="profile.jsp"><%=session.getAttribute("user")%></a></h3></td>
        
         
            <td><a href="user.jsp?show=<%="ques"%>" class="exp" >Questions</a></td>
            <% st=con.prepareStatement("select count(qId) from ques_tb where regId=? ");
               st.setString(1, regid);
               rst=st.executeQuery();
               if(rst.next()){
                   %>
                   <td><h4 style="margin:2px;"> <%=rst.getString(1)%></h4></td>
             <%  }
            %>
        
        
            <td><a href="user.jsp?show=<%="ans"%>" class="exp">Answers</a></td>
            <% st=con.prepareStatement("select count(aId) from ans_tb where regId=? ");
               st.setString(1, regid);
               rst=st.executeQuery();
               if(rst.next()){
                   %>
                   <td>   <h4 style="margin:2px;"> <%=rst.getString(1)%></h4></td>
             <%  }
            %>
            </tr>
            </table>
        </div>
    </body>
</html>
