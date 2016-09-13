<%-- 
    Document   : comment
    Created on : Dec 5, 2015, 4:05:47 PM
    Author     : Aval
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="header.css" rel="stylesheet" type="text/css"/>
    </head>
    
    
        <%
            ArrayList al=new ArrayList();
        if(request.getAttribute("news")!=null){
         al = (ArrayList) request.getAttribute("news");
        try {%>
             <div class="news">
                <table>
                 <tr> <td>
                <B><%=al.get(1).toString()%></b><br>
                <%=al.get(2).toString()%><br>
                <%=al.get(3).toString()%>,<%=al.get(4).toString()%>
                     </td><%
                }
        catch(Exception e){
            System.out.println(e);
        }
              %>
                </table>
            </div>   
        <%
        } 
            if(request.getAttribute("comments")!=null){
                ArrayList al1=new ArrayList();
         al1 = (ArrayList) request.getAttribute("comments");
        try {    %>
        
        <div class="comment news">
            <h3><b>Comments</b></h3>
               <% int i=0;
              while(i < al1.size())
                 {
                      for(int j=0;j<=2;j++)
                  { %>
                     <%=al1.get(i).toString()%> 
                     <br>
                    <%i++;
                   }%>
                      <br>
                 <%}
        }
        catch(Exception e){
            System.out.println(e);
        }}
            if(request.getAttribute("comments")==null)
            {%>
                no comments.
            <%}%>
        </div>
              <div class="form">
              <center> 
               <form action="commentserv">
              <% if(session.getAttribute("reg")!=null){
                 
              %>    
              Comment:<textarea name="comment" rows="4" cols="20">
              </textarea>
             <% }
               if(session.getAttribute("reg")==null)
               {session.removeAttribute("recordInserted");
             %>
             <% }%>
              <input type="hidden" name="newsid" value=<%=(String)session.getAttribute("row")%>  />
              <input type="submit" value="Comment" name="btn" />
                </form>
              </center>
              </div>
              <%
        if(request.getAttribute("commented")=="posted"){
            %>
    <center>Thank you!!</center>
       <% }%>
        
   
</html>
