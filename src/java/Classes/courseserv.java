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
public class courseserv extends HttpServlet {
 public static long id=-1;
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
        String c=request.getParameter("course");
        String dur=request.getParameter("duration");
        String type=request.getParameter("type");
        String button=request.getParameter("btn");
        try {
            if(button.equals("add")){
                
                adminclass x=new adminclass();
                if(x.insertcourse(c,dur,type))
                {
                    
                RequestDispatcher regd = request.getRequestDispatcher("course.jsp");
                  regd.include(request, response);
                }   
        }
             else
        if(button.equals("Select"))
                {//System.out.println("aval");
                    adminclass x=new adminclass();
                    
                    ArrayList al=new ArrayList();
               id=Long.parseLong(request.getParameter("txt_id"));
                    
                    al=x.searchcourse(id);
                    request.setAttribute("data",al);
                    
                    RequestDispatcher regd = request.getRequestDispatcher("course.jsp");
                    regd.include(request, response);
            }
            else
            if(button.equals("update")){
            adminclass x=new adminclass();
            
            if(x.updatecourse(id,c,dur,type)){
                RequestDispatcher regd = request.getRequestDispatcher("course.jsp");
                regd.include(request, response);
        }
            }
        }
        finally {
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
