/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javaclasses.clientclass;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.Address.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author Aval
 */
public class registerserv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String n=request.getParameter("name");
            String roll=request.getParameter("roll");
            String c=request.getParameter("course");
            String email=request.getParameter("email");
            String pw=request.getParameter("pass");
            String button=request.getParameter("btn");
            
            Connection con=null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://CHARMEDALLOY\\SQLEXPRESS;databasename=mydb","sa","aval");
            System.out.println("connected");
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery("Select count(*) from reg_tb where emailId='"+email+"' or  name='"+n+"'");
            rs.next();
           if(Integer.parseInt(rs.getString(1))==0)
          {
    String host = "mail.instaxs.net";
    String from = "contact@infonetgroup.org";
    String pass = "9sep78!";
    Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", "false"); // added this line
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password",pass);
    props.put("mail.smtp.port", "25");
    props.put("mail.smtp.auth", "true");
          
    String[] to = {request.getParameter("email")}; // added this line

    Session sessions = Session.getDefaultInstance(props, null);
    MimeMessage message = new MimeMessage(sessions);
    message.setFrom(new InternetAddress(from));

    InternetAddress[] toAddress = new InternetAddress[to.length];

    // To get the array of addresses
    for( int i=0; i < to.length; i++ ) { // changed from a while loop
        toAddress[i] = new InternetAddress(to[i]);
    }
    System.out.println(Message.RecipientType.TO);

    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
    }


    message.setSubject("Forum :  Successful Registration !");
    message.setText("Hi, You are registered on NIT Kurukshetra Forum ! \n Your user name is: "+n +"\n Your password is: "+pw +" \n keep it safe and do not share with others \n \n \n Regards \n Forum Team");
    Transport transport = sessions.getTransport("smtp");
    transport.connect(host,from,pass);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
    out.println("Sending Email !");
    
                clientclass x=new clientclass();
                if (x.register(n,roll,c,email,pw)){
                    RequestDispatcher regd = request.getRequestDispatcher("login.jsp");
                     regd.include(request, response);
                }
          }
           else
{
response.sendRedirect("register.jsp");
}
          }
         catch(ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (MessagingException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ServletException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registerserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(registerserv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registerserv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(registerserv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
