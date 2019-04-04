package com.appd;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.appd.parsing.ParseLogFile;

public class FileUpload extends HttpServlet
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		try {
			System.out.println("Inside Fileupload");
			
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> fileItems = sf.parseRequest(request);
			//System.out.println(fileItems.size());
			
			out.println("<html>");
			out.println("<head></head>");
			out.println("<body>");
			
			
			if(fileItems.size() == 0)
			{
				out.println("<h5 style='color='Red''>No File Selected</h5>");	
			}
			else {
				for (FileItem fileItem : fileItems) {
					fileItem.write(new File("/Users/chdeore/Documents/Eclips/LogFilesErrorFinder/rowfiles/"+fileItem.getName()));
					//System.out.println(fileItem.getName());
				}	
				out.println("Uploaded Succesfully");
				out.println("</br>");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		out.println("<a href = 'index.jsp'>Back</a>");
		out.println("</br>");
		out.println("</br>");
		out.println("<a href='listOfLogFiles.jsp'>Get List</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
