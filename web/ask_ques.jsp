<%-- 
    Doc/* global k */

ument   : ask_ques
    Created on : Dec 8, 2015, 7:12:56 PM
    Author     : Aval
--%>


<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@include file="connection.jsp"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
        <script type="text/javascript">
            function run(){
                 var a;
                   a=document.getElementById("cat").value;
                   window.location.replace("quesserv?id=" + a); 
            }
            
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
            
          
            <link href="table.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        
      <div class="question">
    <center> <h1 style="margin:60px auto;">Start a New Discussion</h1>
        <form name="question" action="quesserv">
        <table>
            <tr>
                <td> Category:</td>
                <td><select name="cat" id="cat" onchange="run()" >
                
              <%  if(request.getAttribute("cat")!=null){
               String a=(String)request.getAttribute("cat");
                 
                 %>
                <option value="<%=a%>" selected="selected">Selected</option>
                <%
                }
                else
                {%>
                    <option selected="selected">Select Category </option>
                <%
                }
              connect();
                st=con.prepareStatement("select catId,cat_name from cat_tb");
                rst=st.executeQuery();
             while(rst.next())
             {    
               %>
               <option value="<%=rst.getLong(1)%>" > <%=rst.getString(2)%></option>  
        <%}%>
                    </select> </td>
            </tr>
            <% ArrayList al=new ArrayList();
            if(request.getAttribute("subcat")!=null){
                
                al=(ArrayList)request.getAttribute("subcat");
            
            %>
            <tr>
                <td> Sub-category:</td>
                <td><select name="subcat" >
                        
                  <option selected="selected">Select sub-category</option>      
                        <% 
            int i=0;
            while(i<al.size()){%>
            
            <option value="<%=al.get(i).toString()%>">
            <% i++;%>
            <%=al.get(i).toString()%>
            </option>
            <%i++;
             }
            }%>
                
            </select>
                </td>
            </tr>
            <tr>
                <td>Question:</td>
                <td><textarea name="ques" rows="2" cols="20" placeholder="Add a place">
                    </textarea><br></td>
            </tr>
            <tr>
                <td>More Details(optional):</td>
                <td><textarea name="detail" rows="2" cols="20">
                    </textarea><td>
            </tr>
            <tr>
                    <td>Keywords:</td>
                    <td><input type="text" name="kw1" value="" /></td>
            <tr>
                  <td></td><td> <input type="text" name="kw2" value="" /></td></tr>
            <tr>  <td></td> <td>  <input type="text" name="kw3" value="" /></td></tr>
                
            <tr><td></td>
                <td colspan="3"><input type="submit" value="Post" name="btn" /></td></tr>
            
            
        </table>
            </form>
    </center>
      </div>
              <div class="discuss">
            <center> <h1 style="margin:50px auto;">Existing Discussions</h1>
            
                <table border="1" cellspacing="4">
                    
                        
                            <% 
                               connect();
                       st=con.prepareStatement("select catId,cat_name from cat_tb");
                         ResultSet rst1=st.executeQuery();
                         int k=3;
                         int j=0;
            while(rst1.next())
             {    k=Integer.parseInt(rst1.getString(1));
                  System.out.println(k);
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
