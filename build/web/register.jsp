<%-- 
    Document   : register
    Created on : Dec 3, 2015, 10:52:49 PM
    Author     : Aval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="connection.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
function validateForm()
{
var a=document.forms["register"]["pass"].value;
var b=document.forms["register"]["email"].value;
if(a===null||a==="")
{

	alert("username is blank");
	return false;
}
if(b===null||b==="")
{

	alert("password is blank");
	return false;
}
else
return true;
}
</script>
    </head>
    <body>
        <center>
            <h1 style="margin: 70px auto;">Register</h1>
            <form name="register" action="registerserv" style="margin:100px auto;">
        Name:<input type="text" name="name" value="" /><br><br>
        Roll No.:<input type="text" name="roll" value="" /><br><br>
        Your Course:<select name="course">
            <%connect();
               st=con.prepareStatement("select courseId,course_name from course_tb");
               rst=st.executeQuery();
             while(rst.next())
             {    
               %>
               <option value="<%=rst.getLong(1)%>" > <%=rst.getString(2)%>
        </option>  
        <%}%>
        </select> <br><br>
            <% rst.close();
            disconnect();%>
 Email Id:<input type="text" name="email" value="" /><br><br>
 Password:<input type="password" name="pass" value="" /><br><br>
        <input type="submit" name="btn" value="Register" onclick="return validateForm()" />
        </form>
    </center>
    </body>
</html>
