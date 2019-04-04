package com.appd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.appd.parsing.ParseLogFile;

/**
 * Servlet implementation class GetErrorSummury
 */
public class GetErrorSummury extends HttpServlet {
	
	
	
	public GetErrorSummury() {
		//System.out.println("Indside get summurry");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String filePath = request.getParameter("name");
		
		//System.out.println(filePath);
		
		File logFile = new File(filePath);
		File plf = new ParseLogFile(logFile).parseLogFile("SEVER");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		
		if(plf == null) {
			out.println("<h4>No Errors</h4>");
		}
		else {
		FileInputStream fStream = new FileInputStream(plf);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fStream));
		String line;	
		while((line = bf.readLine()) != null) {
			out.println(line);
			out.println("</br>");
		}
		out.println("</br>");
		out.println("</br>");
		System.out.println(plf.getAbsolutePath());
		out.println("<a href='DownloadFile?name="+plf.getAbsolutePath()+"'>Download File</a>");
		}
		out.println("</br>");
		out.println("</br>");
		out.println("<a href='listOfLogFiles.jsp'>Back</a>");
		out.println("</body>");
		out.println("</html>");
	
	}
}
