<%-- 
    Document   : connection
    Created on : Dec 2, 2015, 5:52:45 PM
    Author     : Aval
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%! Connection con=null;
                public void connect()
         { 
        try
            {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://AVAL\\SQLEXPRESS;databasename=mydb","sa","aval");
            System.out.println("connected");
            }
            catch(ClassNotFoundException e){
                System.out.println("not connected"+e);
                
            } catch (SQLException e) {
                System.out.println("not connected"+e);
            }
        }
     public void disconnect()
     { 
         try{
            con.close();
                System.out.println("disconnected");
         }
         catch(Exception e){
             System.out.println("not closed"+e);
         }
     } 
         PreparedStatement st;
         ResultSet rst;
         
     %>
    </body>
</html>
