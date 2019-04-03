package com.appd;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadFile extends HttpServlet {
	
   
    public DownloadFile() {
       
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = request.getParameter("name");
		System.out.println(filePath);
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String [] filePathArr = filePath.split("/");
		
		response.setContentType("APPLICATION/OCTET-STREAM");   
		response.setHeader("Content-Disposition","attachment; filename=\"" + filePathArr[filePathArr.length - 1] + "\"");   
		  
		FileInputStream fileInputStream = new FileInputStream(filePath );  
		            
		int i;   
		while ((i=fileInputStream.read()) != -1) {  
		out.write(i);   
		}   
		fileInputStream.close();   
		out.close();   
		//response.sendRedirect("listOfLogFiles.jsp");
		}  
	}


