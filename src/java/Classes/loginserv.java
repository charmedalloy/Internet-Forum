/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javaclasses.clientclass;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aval
 */
public class loginserv extends HttpServlet {
         String regId=null;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            
          String btn=request.getParameter("btn");
          HttpSession session=request.getSession();
          
           if(btn.equals("Login"))
           {
           String n=request.getParameter("name");
           String pw=request.getParameter("pass");
           ArrayList al=new ArrayList();
           
           clientclass x=new clientclass();
           al=x.login(n, pw);
           regId=al.get(0).toString();
           
           String  name=al.get(1).toString();
           
                 session.setAttribute("reg",regId);
                 session.setAttribute("user",name);
                 
               
             if(session.getAttribute("qId")!=null){
                 
                 response.sendRedirect("question.jsp");
             }   
             
           
             
             else
                
               if(session.getAttribute("row")!=null)
                   
               {  
                  String row=(String)session.getAttribute("row");
                  response.sendRedirect("commentserv?newsid="+row);
                  
               }
               
             else
                   
                   response.sendRedirect("index.jsp");
               
           }
          
           
        }    catch (IOException e) {
            System.out.println(e);
            out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
