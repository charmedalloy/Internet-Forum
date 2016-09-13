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
public class commentserv extends HttpServlet {
  public static String nId;
  
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
        try  { 
            RequestDispatcher regd;
            HttpSession session=request.getSession();
            nId=request.getParameter("newsid");
            
            String btn=request.getParameter("btn");
            ArrayList al=new ArrayList();
            String newsId=null;
            session.removeAttribute("recordInserted");
            if(session.getAttribute("reg")==null && btn.equals("Comment") )
               {     
                  regd = request.getRequestDispatcher("login.jsp");
                  regd.forward(request, response); 
               }
             
             if(nId!=null)
         {  
           System.out.println("to the news");
           clientclass x=new clientclass();
            session.setAttribute("row",nId);
            al =x.getnews(nId);
            newsId=al.get(0).toString();
             
            if(session.getAttribute("reg")!=null && request.getParameter("comment")!=null ){
            String reg,comment;
            reg=(String)session.getAttribute("reg");
            comment=request.getParameter("comment");
            clientclass z=new clientclass();
            
            if (session.getAttribute("recordInserted") == null )
           {
            if(z.insertcomments(comment,reg,newsId))  
            { 
                  request.setAttribute("commented","posted");
            }
             session.setAttribute("recordInserted","true");
        }
            else{
                
            }
             }
            
            ArrayList al1=new ArrayList();
            clientclass y=new clientclass();
            al1=y.getcomments(newsId);
            request.setAttribute("news",al);
            request.setAttribute("comments",al1);
            
           
            regd = request.getRequestDispatcher("comment.jsp");
            regd.forward(request, response);
            }
        }catch(Exception e){
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
