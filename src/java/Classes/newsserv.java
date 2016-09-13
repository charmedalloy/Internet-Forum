/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaclasses.adminclass;
//import javax.servlet.annotation.MultipartConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// for file uploading 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author Aval
 */
public class newsserv extends HttpServlet {
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
            throws ServletException, IOException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);

            if (! ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
                return;
            }
        
        try {// parse request
            List items = sfu.parseRequest(request);
            FileItem  title = (FileItem) items.get(0);
            String t =  title.getString();
            //System.out.println("t=" + t);
            FileItem news = (FileItem) items.get(1);
            String   n =  news.getString();
            
            FileItem date = (FileItem) items.get(2);
            String   d=  date.getString();
            
            FileItem time = (FileItem) items.get(3);
            String   ti =  time.getString();

            FileItem btn = (FileItem) items.get(5);
            String   button =  btn.getString();
            
            
            // get uploaded file
            FileItem file = (FileItem) items.get(4);
                
            if(button.equals("add")){
                adminclass x=new adminclass();
                if(x.insertnews(t,n,d,ti,file))
                {
                    
                RequestDispatcher regd = request.getRequestDispatcher("news.jsp");
                  regd.include(request, response);
                }
        }
            
            else
        if(button.equals("Select"))
                {//System.out.println("aval");
                    adminclass x=new adminclass();
                    
                    ArrayList al=new ArrayList();
                id=Long.parseLong(request.getParameter("txt_id"));
                    
                    al=x.searchnews(id);
                    request.setAttribute("data",al);
                   // out.println("Record Searched");
        //            id=Long.parseLong(al.get(0).toString());
                    //System.out.println(id);
                    RequestDispatcher regd = request.getRequestDispatcher("news.jsp");
                    regd.include(request, response);
            }
            else
            if(button.equals("update"))
            {
            adminclass x=new adminclass();
            
            if(x.updatenews(id,t,n,d,ti)){
                RequestDispatcher regd = request.getRequestDispatcher("news.jsp");
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
    try {
        processRequest(request, response);
    } catch (FileUploadException ex) {
        Logger.getLogger(newsserv.class.getName()).log(Level.SEVERE, null, ex);
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
    } catch (FileUploadException ex) {
        Logger.getLogger(newsserv.class.getName()).log(Level.SEVERE, null, ex);
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
