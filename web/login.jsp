<%-- 
    Document   : login
    Created on : Dec 3, 2015, 10:45:30 PM
    Author     : Aval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="header.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            form{
                margin: 200px auto;
            }
        </style>
        <title>login page</title>
    </head>
    <body>
    <center>
        <form name="login" action="loginserv">
        E-mail Id:<input type="text" name="name" value="" /><br><br>
        Password:<input type="password" name="pass" value="" /><br><br>
        
        <input type="submit" value="Login" name="btn" />
        </form>
    </center>
    </body>
</html>
