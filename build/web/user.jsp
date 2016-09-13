<%-- 
    Document   : user
    Created on : Dec 18, 2015, 11:11:27 PM
    Author     : Aval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="profile.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
        <link href="table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="ques" >
            <% String id=(String)session.getAttribute("reg");
            if(request.getParameter("show").equals("ques"))
        {  
    
    
    connect();
    st=con.prepareStatement("select *,(select name from reg_tb a where a.regId=b.regId) from ques_tb b where regId=?");
    st.setString(1,id);
    rst=st.executeQuery();
    while(rst.next()){
        %>
    
        <table border="1" >
           
        <tr>
            <td><h2><%=rst.getString(2)%></h2>
            <h4 style="color:gray"><%=rst.getString(3)%></h4></td>
            <td> Answer this Question:<form name="answer" action="ansserv">
                    <textarea name="answer" rows="4" cols="35">
                </textarea>
                <input type="submit" value="Post" name="btn" />
                </form>
            </td>
        </tr>
        </table>      
        
            
        <% 
        }}
        %>
        </div>
        
        <%
            
            
                if(request.getParameter("show").equals("ans"))
            { 
                try {
              connect();
              st=con.prepareStatement("select *,(select title from ques_tb a where a.qId=b.qId) from ans_tb b where regId=?");
              st.setString(1,id);
              rst=st.executeQuery();%>
          <div>
              <table border="1">
             <%  while(rst.next())
               {
                %>
                <tr><th><%=rst.getString(7)%></th>
               
                    
                    <td> <%=rst.getString(2)%></td>
                </tr>        
   <% 
           }
            }
            
                catch(Exception e){
                        System.out.println(e);
                        }
            }
             %>
              </table> 
          </div>
              
    </body>
</html>
