<%-- 
    Document   : question
    Created on : Dec 11, 2015, 2:36:45 PM
    Author     : Aval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="connection.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="table.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question</title>
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
    <body>
        <div style="margin:100px auto">
        <% 
if(request.getParameter("subcatid")!=null){
    String subcatid=request.getParameter("subcatid");
    connect();
    st=con.prepareStatement("select * from ques_tb where subcatId=?");
    st.setString(1,subcatid);
    rst=st.executeQuery();
    while(rst.next()){
        %>
    <center>
        <table border="1" >
            <tr>
                <th><i>Asked by</i> <%=session.getAttribute("user")%></th>
        </tr>
        <tr>
            <td><h2><%=rst.getString(2)%></h2>
            <h4 style="color:gray"><%=rst.getString(3)%></h4></td>
            
        </tr>
<%
    }
}
%>
        </table>
    </center>
        </div>
        <% 
if(session.getAttribute("qId")!=null){
    try{
    String qid=(String)session.getAttribute("qId");
    System.out.println(qid);
    connect();
    st=con.prepareStatement("select *,(Select name from reg_tb a where a.regId=b.regId)  from ques_tb b where qId=?");
    st.setString(1,qid);
    rst=st.executeQuery();
    while(rst.next()){
        %>
    <center>
        <table border="1" style="margin: 200px auto;">
            <tr>
                <th><h2><i>Asked by</i> <%=rst.getString(13)%></h2></th>
        </tr>
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
        
<%
    }

%>
      </table>
        <% }
    catch(Exception e)
{
        System.out.println(e);
}      
        }

        %>
        
        <% 
if(request.getParameter("qid")!=null){
    try{
    String qid=request.getParameter("qid");
    //System.out.println(qid);
    connect();
    st=con.prepareStatement("select *,(Select name from reg_tb a where a.regId=b.regId)  from ques_tb b where qId=?");
    st.setString(1,qid);
    rst=st.executeQuery();
    while(rst.next()){
        %>
    <center>
        <table border="1" style="margin: 200px auto;">
            <tr>
                <th>
            <h2>
                <i>Asked by</i> <%=rst.getString(12)%>
            </h2>
                </th>
        </tr>
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
            </td>
<%
    }
                if(session.getAttribute("reg")==null){%>
                    <td> Login to Answer:
                <form name="answer" action="ansserv">
                <input type="hidden" name="qid" value="<%=qid%>" />
                <input type="submit" value="Login" name="btn" />
                </form>
                    
                
               <% }
              %>
               <input style="display:block;" class="expand" onclick="expand(this.name)" type="submit" value="Read Answers" name="<%=qid%>" />
            </td>
        </table>
              
            <%
            connect();
            st=con.prepareStatement("select * from ans_tb where qId=?");
           st.setString(1, qid);
          ResultSet rst1=st.executeQuery(); %>
          <div style="display:none;" class="answer">
              <table border="1">
             <%  while(rst1.next())
               {
                %>
                <tr>
                    <th><h2><i>Answered by</i> <%=session.getAttribute("user")%><i>&#160;on&#160;</i><%=rst1.getString(4)%></h2></th>
                    <td> <%=rst1.getString(2)%><br><br></td>
                </tr>        
             
            <% }%>
              </table>
             </div>
  <%  }
    }
    catch(Exception e)
{
        System.out.println(e);
}       
        }%>

    </body>
</html>
