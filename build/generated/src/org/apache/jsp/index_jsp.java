package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 Connection con=null;
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
         
     
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/connection.jsp");
    _jspx_dependants.add("/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("     <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>header</title>\n");
      out.write("        <link href=\"header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("     function hamburger () {\n");
      out.write("     \tif(document.getElementById('nav').style.display ===\"block\"){\n");
      out.write("     \t\tclose();\n");
      out.write("            return;\n");
      out.write("     \t}\n");
      out.write("     \t \n");
      out.write("     \tdocument.getElementById('nav').style.display = \"block\";\n");
      out.write("     \tdocument.getElementById('main').style.transition=\"0.6s\";\n");
      out.write("     \t//document.getElementById('main').style.marginLeft=\"35%\";\n");
      out.write("     \tdocument.getElementById('nav').style.width = \"230px\";\n");
      out.write("     \treturn;\n");
      out.write("\n");
      out.write("     \tfunction close () {\n");
      out.write("     \t\tdocument.getElementById('nav').style.display = \"none\";\n");
      out.write("     \t\t//document.getElementById('main').style.marginLeft=\"35%\";\n");
      out.write("     \t\treturn;\n");
      out.write("     \t}\n");
      out.write("     }\n");
      out.write("\t</script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("       \n");
      out.write("        <div id=\"header\">\n");
      out.write("            <span onclick=\"hamburger()\" style=\"cursor: pointer;\"> \n");
      out.write("                Menu&#160;&#160;&#160;&#160;&#160;\n");
      out.write("                </span>\n");
      out.write("            ");
 try
            {
                if(session.getAttribute("reg")!=null){
                           
      out.write("\n");
      out.write("            Welcome,");
      out.print((String) session.getAttribute("user"));
      out.write("\n");
      out.write("                \n");
      out.write("            \n");
      out.write("           ");
 }
                else{ 
      out.write("\n");
      out.write("                    NIT Kurukshetra Technical Forum\n");
      out.write("         ");
   
           }
            }
              catch(Exception e)
              {  
             
      out.write("\n");
      out.write("             \n");
      out.write("             NIT Kurukshetra Technical Forum\n");
      out.write("           \n");
      out.write("            ");
   
               }
                
             
      out.write("\n");
      out.write("            \n");
      out.write("            <form action=\"search\">\n");
      out.write("            <div class=\"search\">\n");
      out.write("                \n");
      out.write("                <input type=\"text\" name=\"search\" value=\"\" placeholder=\"Search\" />\n");
      out.write("                <input type=\"submit\" value=\"Search\" name=\"btn\" />\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            </form>\n");
      out.write("    </div>\n");
      out.write("   \n");
      out.write("            ");

            try{
            
if( session.getAttribute("reg")!=null)
{
    
      out.write("\n");
      out.write("<div id=\"nav\" style=\"display:none;width:230px\">\n");
      out.write("        <h3><a href=\"index.jsp\">Home</a></h3>\n");
      out.write("\t<h3><a href=\"profile.jsp\">My Profile</a></h3>\n");
      out.write("\t<h3><a href=\"ask_ques.jsp\">Ask a Question</a></h3>\n");
      out.write("\t<h3><a href=\"logout.jsp?log=logout\">Logout</a></h3>\n");
      out.write("        <h3><a href=\"\"></a></h3>\n");
      out.write("</div>\n");
 }
            
else
{
      out.write("\n");
      out.write("    <div id=\"nav\" style=\"display:none;width:230px\">\n");
      out.write("        <h3><a href=\"index.jsp\">Home</a></h3>\n");
      out.write("\t<h3><a href=\"login.jsp\">Login</a></h3>\n");
      out.write("\t<h3><a href=\"register.jsp\">Register</a></h3>\n");
      out.write("\t<h3><a href=\"\"></a></h3>\n");
      out.write("        <h3><a href=\"\"></a></h3>\n");
      out.write("</div>\n");
      out.write("        ");

}
            }
            catch(Exception e)
            {
        
      out.write("  \n");
      out.write("        <div id=\"nav\" style=\"display:none;width:230px\">\n");
      out.write("\t<h3><a href=\"login.jsp\">Login</a></h3>\n");
      out.write("\t<h3><a href=\"register.jsp\">Register</a></h3>\n");
      out.write("\t<h3><a href=\"\"></a></h3>\n");
      out.write("        <h3><a href=\"\"></a></h3>\n");
      out.write("</div>\n");
      out.write(" ");
 }
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>header</title>\n");
      out.write("        <link href=\"header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"table.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("             function expand(k){\n");
      out.write("                 var a=k;\n");
      out.write("             var x=document.getElementsByClassName(\"subcatid\");\n");
      out.write("             var y=document.getElementsByClassName(\"plus\");\n");
      out.write("        if(x[a].style.display===\"none\"){\n");
      out.write("        x[a].style.display=\"block\";\n");
      out.write("        x[a].style.transition=\"5s\";\n");
      out.write("        y[a].value=\"-\";\n");
      out.write("    }\n");
      out.write("        else{\n");
      out.write("        x[a].style.display=\"none\";\n");
      out.write("        y[a].value=\"+\";\n");
      out.write("    }\n");
      out.write("    }\n");
      out.write("          \n");
      out.write("            </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("<div id=\"main\">\n");
      out.write("    <center><h1>Welcome to Forum!</h1></center>\n");
      out.write("    <center>\n");
      out.write("    <ul>\n");
      out.write("        <li>24/7 Discussions</li>\n");
      out.write("        <li>Talk To The Faculty</li>\n");
      out.write("        <li>Latest Technical News Updates</li>\n");
      out.write("    </ul>\n");
      out.write("    </center>\n");
      out.write("</div>\n");
      out.write("        <div class=\"news\" style=\"float: left;\">\n");
      out.write("            <center> <h3 style=\"margin:1px auto;\">Latest news</h3>\n");
      out.write("                ");

                    int i;
                    connect();
                //Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               st=con.prepareStatement("select top(5) * from news_tb order by date desc");
                rst=st.executeQuery();
                
      out.write("\n");
      out.write("                <table>\n");
      out.write("                ");
 
                  i=5;
                while(rst.next() && i>=1)
                { 
                 
      out.write("\n");
      out.write("                <tr> <td><img width='100' height='120' src=\"view_file?newsid=");
      out.print(rst.getString(1));
      out.write("\" alt=\"\"/></td>\n");
      out.write("                  <td>\n");
      out.write("                <b>");
      out.print(rst.getString(2));
      out.write("</b><br>\n");
      out.write("                ");
      out.print(rst.getString(3));
      out.write("<br>\n");
      out.write("                ");
      out.print(rst.getString(4));
      out.write(',');
      out.print(rst.getString(5));
      out.write("\n");
      out.write("                 </td>\n");
      out.write("                 <td><a href=\"commentserv?newsid=");
      out.print(rst.getString(1));
      out.write("&btn=");
      out.print("seecomment");
      out.write("\">Comment</a></td></tr>\n");
      out.write("                ");
  
                i--;
                }
                disconnect();
                
      out.write("\n");
      out.write("                 \n");
      out.write("                </table>\n");
      out.write("            </div>  \n");
      out.write("                <div class=\"discuss\">\n");
      out.write("            <center> <h3 style=\"margin:50px auto;\">Existing Discussions</h3>\n");
      out.write("            \n");
      out.write("                <table border=\"1\" cellspacing=\"4\">\n");
      out.write("                    \n");
      out.write("                        \n");
      out.write("                            ");
 
                               connect();
                       st=con.prepareStatement("select catId,cat_name from cat_tb");
                         ResultSet rst1=st.executeQuery();
                         int k=3;
                         int j=0;
            while(rst1.next())
             {    k=Integer.parseInt(rst1.getString(1));
               
      out.write("\n");
      out.write("               <tr>\n");
      out.write("               <td> ");
      out.print(rst1.getString(2));
      out.write("</td> \n");
      out.write("               <th><input class=\"plus\" type=\"button\" onclick=\"expand(this.name)\" name=\"");
      out.print(j);
      out.write("\" value=\"+\"></th>\n");
      out.write("               </tr>\n");
      out.write("              ");
 connect();
                       st=con.prepareStatement("select subcatId,subcategory_name from subcat_tb where catId=?");
                       st.setLong(1,k);
                      ResultSet  rst2=st.executeQuery();  
                      
      out.write("\n");
      out.write("                      <tr class=\"subcatid\" style=\"display:none;\">\n");
      out.write("                   ");
      
                              while(rst2.next())
                       {
      out.write("    \n");
      out.write("                          <td align=\"center\">\n");
      out.write("                              <a href=\"showques.jsp?subcatid=");
      out.print(rst2.getString(1));
      out.write("&subcat=");
      out.print(rst2.getString(2));
      out.write("\" target=\"_blank\">\n");
      out.write("                           ");
      out.print(rst2.getString(2));
      out.write("\n");
      out.write("                              </a>\n");
      out.write("                           \n");
      out.write("                          </td>       \n");
      out.write("                    ");
 }
                          j++;    
                              
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                       ");
 }
      out.write("\n");
      out.write("                   \n");
      out.write("                </table>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
