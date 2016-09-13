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
public class quesserv extends HttpServlet {

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
            if(request.getParameter("id")!=null){
            String id=request.getParameter("id");
            ArrayList al=new ArrayList(); 
            clientclass x=new clientclass();
            al=x.getsubcat(id);
         request.setAttribute("subcat",al);
         request.setAttribute("cat",id);
         RequestDispatcher regd = request.getRequestDispatcher("ask_ques.jsp");
         regd.include(request, response);
        }
         
        String cat=request.getParameter("cat");
        String subcat=request.getParameter("subcat");
        String ques =request.getParameter("ques");
        String md =request.getParameter("detail");
        String kw1 =request.getParameter("kw1");
        String kw2 =request.getParameter("kw2");
        String kw3 =request.getParameter("kw3");
        String button =request.getParameter("btn"); 
        
        if(button.equals("Post")){
            clientclass x=new clientclass();
            HttpSession session=request.getSession();
                 
                 String regId=(String)session.getAttribute("reg");
            if(x.insertquestion(ques,md,cat,subcat,kw1,kw2,kw3,regId))
            {
                response.sendRedirect("question.jsp?subcatid="+subcat);
               
            }
            
        }
            
            
            
        } finally {
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
