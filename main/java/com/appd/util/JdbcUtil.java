package com.appd.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil implements  AutoCloseable{
   public Connection con ;

   public void open(){

       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       }
       catch (Exception ex){
           ex.printStackTrace();
       }

   }

   
   public void close() throws Exception {
       System.out.println("Inside close()");
       try {
           con.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   public void getConnection() throws Exception{

        String  url = "jdbc:mysql://localhost:3306/appd?useSSL=false";
        String user = "root";
        String password ="12345678";
       this.con =  DriverManager.getConnection(url,user,password);
   }
}
