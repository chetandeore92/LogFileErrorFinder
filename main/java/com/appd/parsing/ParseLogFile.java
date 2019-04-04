package com.appd.parsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.appd.dao.ErrorDao;


public class ParseLogFile {
	private File logFile;

	public ParseLogFile(File logFile) {
		//System.out.println("Inside file parser");
		this.logFile = logFile;
	}
	
	public File parseLogFile(String matcher) throws IOException {
		
		File file = new File("/Users/chdeore/Documents/Eclips/LogFilesErrorFinder/tempfiles/"+logFile.getName());
		System.out.println(logFile.getAbsolutePath());
		FileInputStream fStream = new FileInputStream(logFile);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fStream));
		boolean isErrorFile = false;
		FileWriter fwriter=new FileWriter(file);
		

		List<String> repeatedErrorList = new ArrayList<String>();
		
		String line ;
		while ((line = bf.readLine()) != null) {
			//System.out.println("inside method parseLogFile()");
			if(line.contains(matcher))
				{
				String str = line.substring(line.lastIndexOf(";|") + 2);
				System.out.println(str);
				String [] strArr = str.split("#");
				if(strArr[0].contains("|"))
				{
				str = strArr[0].substring(0,strArr[0].length()-1) +"\n"; 
				}
				else
				{
				str = strArr[0].substring(0) +"\n"; 
				}
				//System.out.println(str);

				if(!repeatedErrorList.contains(str))
				{
					fwriter.write(str);
					repeatedErrorList.add(str);
				}
				
				isErrorFile = true;
				}
			//fwriter.write(line+"\n");
		}
		
		fStream.close();
		fwriter.close();
		
		if(!isErrorFile)
			return null;
		
		
		return new ErrorDao().checkForFalseErrors(file,matcher);
	}
	
}
