/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javaclasses.adminclass;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aval
 */
public class catserv extends HttpServlet {
public static long i=-1;
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
        String button=request.getParameter("btn");
        String cat=request.getParameter("cat_name");
        String id=request.getParameter("course");
        try {
            if(button.equals("add")){
                adminclass x=new adminclass();
                if(x.insertcat(cat,id))
                {
                RequestDispatcher regd = request.getRequestDispatcher("category.jsp");
                regd.include(request, response);
                }
            }
            else
        if(button.equals("Select"))
                {//System.out.println("aval");
                    adminclass x=new adminclass();
                    
                    ArrayList al=new ArrayList();
                i=Long.parseLong(request.getParameter("txt_id"));
                    
                    al=x.searchcat(i);
                    request.setAttribute("data",al);
                    RequestDispatcher regd = request.getRequestDispatcher("category.jsp");
                    regd.include(request, response);
            }
            else
        if(button.equals("update")){
            adminclass x=new adminclass();
            
            if(x.updatecat(i,cat,id)){
                RequestDispatcher regd = request.getRequestDispatcher("category.jsp");
                regd.include(request, response);
        }
        }
        }finally {
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
