package com.appd.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.appd.util.JdbcUtil;

public class ErrorDao {

	public File checkForFalseErrors(File file,String matcher) throws IOException {
		List<String> listOfErrors = getFalseErrorList();
		System.out.println("List Of Errors \n\n");
		for (String string : listOfErrors) {
			System.out.println(string);
		}
		System.out.println("\n\n");

		File tempFile = new File("/Users/chdeore/Documents/Eclips/LogFilesErrorFinder/logfiles/"+matcher+file.getName());
		FileInputStream fStream = new FileInputStream(file);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fStream));
		FileWriter fwriter=new FileWriter(tempFile);
		String line;
		
		while ((line = bf.readLine()) != null) {
			

			if(listOfErrors.contains(line))
				{
				System.out.println(line);
				continue;
				}
			
			String str = matcher+"  : "+line+"\n\n";
			fwriter.write(str);
			System.out.println(str);
				
		}
		file.delete();
		fwriter.close();
		bf.close();
		return tempFile;
	}
	
	private static List<String> getFalseErrorList(){
		
		List<String> listOfErrors = new ArrayList<String>();
		
		try (JdbcUtil jdbc = new JdbcUtil();){
            jdbc.open();
            jdbc.getConnection();
            Statement stmt = jdbc.con.createStatement();
            String sql = "select * from false_error";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
				listOfErrors.add(rs.getString("keywords"));
			}
            
        } catch (Exception e){
        		e.printStackTrace();
        }
		return listOfErrors;
	}
}
