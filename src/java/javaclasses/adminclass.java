/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import org.apache.commons.fileupload.FileItem;


/**
 *
 * @author Aval
 */
public class adminclass {
    
    Connection con=null;
                public void connect()
         { 
        try
            {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://CHARMEDALLOY\\SQLEXPRESS;databasename=mydb","sa","aval");
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
         ArrayList al=new ArrayList();
        
       public boolean insertcat(String cat,String id){
           connect();
         try{
         st=con.prepareCall("{call prcInsertcategory(?,?)}");
         st.setString(1,cat);
         st.setLong(2,Long.parseLong(id));
         
         if(st.execute()==false){
           disconnect();
           return true;
         }
         }
         catch(Exception e){
                 System.out.println(e);
                 }
        return false;
       }
       
       public boolean insertsubcat(String sub,String catid,String courseid ){
         connect();
         try{
         st=con.prepareCall("{call prcInsertsubcategory(?,?,?)}");
         st.setString(1,sub);
         st.setLong(2,Long.parseLong(catid));
         st.setLong(3,Long.parseLong(courseid));
         if(st.execute()==false){
           disconnect();
           return true;
         }
         }
         catch(SQLException e){
                 System.out.println(e);
                 } catch (NumberFormatException e) {
                     System.out.println(e);
        }
        return false;
       }
        
           
       
         
       public boolean insertcourse(String s,String dur,String type){
           connect();
         try{
         st=con.prepareCall("{call prcInsertCourse(?,?,?)}");
         st.setString(1,s);
         st.setString(2,dur);
         st.setString(3,type);
         if(st.execute()==false){
           disconnect();
           return true;
         }
         }
         catch(SQLException e){
                 System.out.println(e);
                 } catch (NumberFormatException e) {
                     System.out.println(e);
        }
        return false;
       }
       
       public boolean insertnews(String t,String n,String d,String time,FileItem file) throws IOException{
           connect();
         try{
             String news;
             news=n.trim();
         st=con.prepareCall("{call prcInsertNews(?,?,?,?,?)}");
         st.setString(1,t);
         st.setString(2,news);
         st.setString(3,d);
         st.setString(4,time);
         st.setBinaryStream(5, file.getInputStream(), (int) file.getSize());
         if(st.execute()==false){
           disconnect();
           return true;
         }
         }
         catch(SQLException e){
                 System.out.println(e);
                 } catch (NumberFormatException e) {
                     System.out.println(e);
        }
        return false;
       }
       
       
     public ArrayList searchcat(long i){
        try{
            connect();
        st=con.prepareStatement("select * from cat_tb where catId=?");
        st.setLong(1,i);
        rst=st.executeQuery();
        while(rst.next())
        {   al.add(rst.getString(1));
            al.add(rst.getString(2));
            al.add(rst.getString(3));
        }
        rst.close();
        }
            catch(SQLException e){
                System.out.println(e);
                disconnect();
        } catch (NumberFormatException e) {
            System.out.println(e);
            disconnect();
        }
        return al;
    }
    


     public ArrayList searchsubcat(long id){
        try{
            connect();
        st=con.prepareStatement("select * from subcat_tb where subcatId=?");
        st.setLong(1,id);
        rst=st.executeQuery();
        while(rst.next())
        {   al.add(rst.getString(1));
            al.add(rst.getString(2));
            al.add(rst.getString(3));
            al.add(rst.getString(4));
        }
        rst.close();
        }
            catch(SQLException e){
                System.out.println(e);
                disconnect();
        } catch (NumberFormatException e) {
            System.out.println(e);
            disconnect();
        }
        return al;
    }
    

     public ArrayList searchcourse(long id){
        try{
            connect();
        st=con.prepareStatement("select * from course_tb where courseId=?");
        st.setLong(1,id);
        rst=st.executeQuery();
        while(rst.next())
        {   al.add(rst.getString(1));
            al.add(rst.getString(2));
            al.add(rst.getString(3));
            al.add(rst.getString(4));
           
        }
        rst.close();
        }
            catch(SQLException e){
                System.out.println(e);
                disconnect();
        } catch (NumberFormatException e) {
            System.out.println(e);
            disconnect();
        }
        return al;
    }
    

     public ArrayList searchnews(long id){
        
    try{
            connect();
        st=con.prepareStatement("select * from news_tb where newId=?");
        st.setLong(1,id);
        rst=st.executeQuery();
        while(rst.next())
        {   al.add(rst.getString(1));
            al.add(rst.getString(2));
            al.add(rst.getString(3));
            al.add(rst.getString(4));
            al.add(rst.getString(5));
            
        }
        rst.close();
        }
            catch(SQLException e){
                System.out.println(e);
                disconnect();
        } catch (NumberFormatException e) {
            System.out.println(e);
            disconnect();
        }
        return al;
    }
     
     public boolean updatecat(long i,String cat,String id){
         try
            {  connect();
            
            st=con.prepareCall("{call prcUpdatecategory(?,?,?)}");
            st.setLong(1,i);
            st.setString(2,cat);
            st.setLong(3, Long.parseLong(id));
            
             if (st.executeUpdate()>0){
                 disconnect();
                 return true;          
            }
            }
            catch(SQLException e)
            {
                System.out.println("what the heck is this error " + e);
   }    catch (NumberFormatException e) {
       System.out.println("what the heck is this error " + e);
        }
        return false;
     }   
     
     
     public boolean updatesubcat(long id,String sub,String catid,String courseid){
         try
            {  connect();
            
            st=con.prepareCall("{call prcUpdatesubcategory(?,?,?,?)}");
            st.setLong(1,id);
            st.setString(2,sub);
            st.setLong(3, Long.parseLong(catid));
            st.setLong(4, Long.parseLong(courseid));
             if (st.executeUpdate()>0){
                 disconnect();
                 return true;          
            }
            }
            catch(SQLException e)
            {
                System.out.println("what the heck is this error " + e);
   }    catch (NumberFormatException e) {
       System.out.println("what the heck is this error " + e);
        }
        return false;
     }   
     
     public boolean updatecourse(long id,String c,String dur,String type){
         try
            {  connect();
            
            st=con.prepareCall("{call prcUpdateCourse(?,?,?,?)}");
            st.setLong(1,id);
            st.setString(2,c);
            st.setString(3,dur);
            st.setString(4,type);
             if (st.executeUpdate()>0){
                 disconnect();
                 return true;          
            }
            }
            catch(SQLException e)
            {
                System.out.println("what the heck is this error " + e);
   }    catch (NumberFormatException e) {
       System.out.println("what the heck is this error " + e);
        }
        return false;
     }   
     
     public boolean updatenews(long id,String t,String n,String d,String time){
         try
            {  connect();
            String news;
            news=n.trim();
            st=con.prepareCall("{call prcUpdateNews(?,?,?,?,?)}");
            st.setLong(1,id);
            st.setString(2,t);
            st.setString(3,news);
            st.setString(4,d);
            st.setString(5,time);
             if (st.executeUpdate()>0){
                 disconnect();
                 return true;          
            }
            }
            catch(SQLException e)
            {
                System.out.println("what the heck is this error " + e);
   }    catch (NumberFormatException e) {
       System.out.println("what the heck is this error " + e);
        }
        return false;
     }
        
     
}

