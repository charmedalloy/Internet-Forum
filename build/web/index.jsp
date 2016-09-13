<%-- 
    Document   : index
    Created on : Dec 1, 2015, 12:35:28 PM
    Author     : Aval
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="connection.jsp" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
        <link href="header.css" rel="stylesheet" type="text/css"/>
        <link href="table.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
             function expand(k){
                 var a=k;
             var x=document.getElementsByClassName("subcatid");
             var y=document.getElementsByClassName("plus");
        if(x[a].style.display==="none"){
        x[a].style.display="block";
        x[a].style.transition="5s";
        y[a].value="-";
    }
        else{
        x[a].style.display="none";
        y[a].value="+";
    }
    }
          
            </script>
    </head>
    
    <body>
<div id="main">
    <center><h1>Welcome to Forum!</h1></center>
    <center>
    <ul>
        <li>24/7 Discussions</li>
        <li>Talk To The Faculty</li>
        <li>Latest Technical News Updates</li>
    </ul>
    </center>
</div>
        <div class="news" style="float: left;">
            <center> <h3 style="margin:1px auto;">Latest news</h3>
                <%
                    int i;
                    connect();
                //Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               st=con.prepareStatement("select top(5) * from news_tb order by date desc");
                rst=st.executeQuery();
                %>
                <table>
                <% 
                  i=5;
                while(rst.next() && i>=1)
                { 
                 %>
                <tr> <td><img width='100' height='120' src="view_file?newsid=<%=rst.getString(1)%>" alt=""/></td>
                  <td>
                <b><%=rst.getString(2)%></b><br>
                <%=rst.getString(3)%><br>
                <%=rst.getString(4)%>,<%=rst.getString(5)%>
                 </td>
                 <td><a href="commentserv?newsid=<%=rst.getString(1)%>&btn=<%="seecomment"%>">Comment</a></td></tr>
                <%  
                i--;
                }
                disconnect();
                %>
                 
                </table>
            </div>  
                <div class="discuss">
            <center> <h3 style="margin:50px auto;">Existing Discussions</h3>
            
                <table border="1" cellspacing="4">
                    
                        
                            <% 
                               connect();
                       st=con.prepareStatement("select catId,cat_name from cat_tb");
                         ResultSet rst1=st.executeQuery();
                         int k=3;
                         int j=0;
            while(rst1.next())
             {    k=Integer.parseInt(rst1.getString(1));
               %>
               <tr>
               <td> <%=rst1.getString(2)%></td> 
               <th><input class="plus" type="button" onclick="expand(this.name)" name="<%=j%>" value="+"></th>
               </tr>
              <% connect();
                       st=con.prepareStatement("select subcatId,subcategory_name from subcat_tb where catId=?");
                       st.setLong(1,k);
                      ResultSet  rst2=st.executeQuery();  
                      %>
                      <tr class="subcatid" style="display:none;">
                   <%      
                              while(rst2.next())
                       {%>    
                          <td align="center">
                              <a href="showques.jsp?subcatid=<%=rst2.getString(1)%>&subcat=<%=rst2.getString(2)%>" target="_blank">
                           <%=rst2.getString(2)%>
                              </a>
                           
                          </td>       
                    <% }
                          j++;    
                              %>
                        </tr>
                       <% }%>
                   
                </table>
            </center>
        </div>
    </body>
</html>
