/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Aval
 */
public class clientclass {
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
         
        
       public ArrayList login(String n,String pw){
           try{    connect();
              st=con.prepareStatement("Select * from reg_tb where emailId=? and password=?");
              st.setString(1, n);
              st.setString(2, pw);
             rst = st.executeQuery();
                if(rst.next())
                {//System.out.println("hello");
                    
                    
                    al.add(rst.getString(1));
                    al.add(rst.getString(2));
                }
       }
           catch(Exception e){
               System.out.println(e);
           }
        return al;
       }
       
       public boolean register(String n,String roll,String c,String email,String pw){
           try{    connect();
           
              st=con.prepareCall("{call prcInsertUser(?,?,?,?,?)}");
              st.setString(1, n);
              st.setLong(2,Long.parseLong(roll) );
              st.setLong(3,Long.parseLong(c) );
              st.setString(4, email);
              st.setString(5, pw);
                if(st.executeUpdate()>0){
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
       public ArrayList getnews(String row) {
            try{
            connect();
            System.out.println("get news");
           Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
            rst=stmt.executeQuery("select * from news_tb where newId='"+row+"'");
            
           if(rst.next())
           {
                al.add(rst.getString(1));
                al.add(rst.getString(2));
                al.add(rst.getString(3));
                al.add(rst.getString(4));
                al.add(rst.getString(5));
                
           }
            rst.close();
            } 
            
            catch (SQLException ex) {
            Logger.getLogger(adminclass.class.getName()).log(Level.SEVERE, null, ex);
        }
            catch (Exception e) {
            System.out.println(e);
            }
            disconnect();
        return al;
       }
       
       public ArrayList getcomments(String newsId) {
            try{
            connect();
            System.out.println("get comments");
           st = con.prepareStatement("select (select name from reg_tb a where b.regId=a.regId),comment,date from comment_tb b where newId=?");
           st.setString(1,newsId);
            rst=st.executeQuery();
              
            while(rst.next()){
           
                al.add(rst.getString(1));
                al.add(rst.getString(2));
                al.add(rst.getString(3));
            }
            rst.close();
            } 
            
            catch (SQLException ex) {
            Logger.getLogger(adminclass.class.getName()).log(Level.SEVERE, null, ex);
        }
            catch (Exception e) {
            System.out.println(e);
            }
            disconnect();
        return al;
       } 
       
       public boolean insertcomments(String comment,String reg,String newsId)
       { try{    connect();
          
               String com=comment.trim();
              st=con.prepareCall("{call prcInsertComment(?,?,?)}");
              st.setString(1, newsId);
              st.setString(2,com);
              st.setString(3, reg);
              
                if(st.executeUpdate()>0){
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
       
       public ArrayList getsubcat(String id){
        try{
            connect();
            st=con.prepareStatement("select subcatId,subcategory_name from subcat_tb where catId=?");
            st.setString(1,id);
            rst=st.executeQuery();
            while(rst.next()){
                al.add(rst.getString(1));
                al.add(rst.getString(2));
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return al;
           
       }
       
       
       public boolean insertquestion(String ques,String md,String cat,String subcat,String kw1,String kw2,String kw3,String regId)
       { try{    connect();
          
               String question=ques.trim();
               String details=md.trim();
              st=con.prepareCall("{call prcInsertQuestion(?,?,?,?,?,?,?,?)}");
              st.setString(1, question);
              st.setString(2,details);
              st.setString(3, cat);
              st.setString(4, subcat);
              st.setString(5, kw1);
              st.setString(6, kw2);
              st.setString(7, kw3);
              st.setString(8, regId);
              
                if(st.executeUpdate()>0){
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
       
       
       public boolean insertanswer(String ans,String qid,String regId)
       { try{    connect();
          
               String answer=ans.trim();
               
              st=con.prepareCall("{call prcInsertAnswer(?,?,?)}");
              st.setString(1, answer);
              st.setString(2,qid);
              st.setString(3, regId);
              
                if(st.executeUpdate()>0){
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
       
       public ArrayList search(String s){
           try{
               
           connect();
           //st=con.createStatement(" select * from ques_tb where kw_1=" +s+ or "kw_2= or kw_3=? or question like %?%");
            st=con.prepareCall("{call prcSearch(?)}");
            st.setString(1, s);
            rst=st.executeQuery();
               System.out.println (s);
              
              System.out.println ("searched");
              
                while(rst.next()){
                    
                   al.add(rst.getString("qId"));
                   al.add(rst.getString("title"));
                  
                }
           }
           catch(Exception e){
               System.out.println(e);
           } 
        return al;
       }
}

       
           
       