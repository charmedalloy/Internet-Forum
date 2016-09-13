<%-- 
    Document   : showques
    Created on : Dec 10, 2015, 11:43:40 AM
    Author     : Aval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@include file="connection.jsp"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questions</title>
        <link href="table.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
    function expand(n){
        
        var x=document.getElementsByClassName("answer");
        var y=document.getElementsByClassName("expand");
        if(x[n-1].style.display==="none"){
        x[n-1].style.display="block";
        x[n-1].style.transition="5s";
        y[n-1].value="Collapse Answers";
    }
        else{
        x[n-1].style.display="none";
        y[n-1].value="Read Answers";
    }  
    }
    </script>
    </head>
    
        <% 
        String subcat=null,subcatid=null;
        if(request.getAttribute("answer")!="posted"){
               subcatid=request.getParameter("subcatid");
               subcat=request.getParameter("subcat");
               
              session.setAttribute("subcat_name",subcat);
              session.setAttribute("subcatid",subcatid);
        }  
        %>
    <h1 style="margin:60px auto;">Questions asked on <%=(String)session.getAttribute("subcat_name")%></h1>
    <%connect();
    st=con.prepareStatement("select *,(Select name from reg_tb a where a.regId=b.regId)  from ques_tb b where subcatId=?");
    st.setString(1, (String)session.getAttribute("subcatid"));
    rst=st.executeQuery();
    String qid;
    int exp=1;
    
    while(rst.next()){
        %>
    <center>
        <table border="1">
            <tr>
                <th><i>Asked by</i> <%=rst.getString(13)%></th>
            </tr>
        <%   qid=rst.getString(1);
        
        %>
        <tr>
            <td><h2><%=rst.getString(2)%></h2>   
            <h4 style="color:gray"><%=rst.getString(3)%></h4></td>
            
            <%   if(session.getAttribute("reg")!=null){%>
            <td> Answer this Question:
                
                <form name="answer" action="ansserv">
                    <textarea name="answer" rows="4" cols="35">
                </textarea>
                    <input type="hidden" name="qid" value="<%=qid%>" />
                    
                <input type="submit" value="Post" name="btn" />
                </form>
                    
               <% if(request.getAttribute("answer")=="posted"){ %>
                    Thank you for the answer.
              <% } 
               else
                   if(request.getAttribute("answer")=="fail"){%>
                     Sorry! Try again.
               <%
               }
            }
            else
                if(session.getAttribute("reg")==null){%>
                    <td> Login to Answer:
                <form name="answer" action="ansserv">
                <input type="hidden" name="qid" value="<%=qid%>" />
                <input type="submit" value="Login" name="btn" />
                </form>
               <% }
              %>
              <form action="">
               <input style="display:block;" class="expand" onclick="expand(this.name)" type="submit" value="Read Answers" name="<%=exp%>" />
              </form>
            </td>
        </table>
              
            <%
            connect();
            st=con.prepareStatement("update ques_tb set hit=hit+1 where qId=?");
                 st.setString(1,qid);
                st.executeUpdate();
            st=con.prepareStatement("select *,(select name from reg_tb a where a.regId=b.regId) from ans_tb b where qId=?");
           st.setString(1, qid);
          ResultSet rst1=st.executeQuery(); %>
          <div style="display:none;" class="answer">
              <table border="1">
             <%  while(rst1.next())
               {
                %>
                <tr>
                    <th><h2><i>Answered by</i><%=rst1.getString(7)%><i>&#160;on&#160;</i><%=rst1.getString(4)%></h2></th>
                    <td> <%=rst1.getString(2)%><br><br></td>
                </tr>        
   <% 
           }
             %>
              </table>
             </div>
              
  <%  exp++;
    }
   %>
   
    
