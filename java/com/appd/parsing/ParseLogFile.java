package com.appd.parsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.text.StyledEditorKit.BoldAction;

public class ParseLogFile {
	private File logFile;

	public ParseLogFile(File logFile) {
		//System.out.println("Inside file parser");
		this.logFile = logFile;
	}
	
	public File parseLogFile() throws IOException {
		
		File file = new File("/Users/chdeore/Documents/Eclips/LogFilesErrorFinder/logfiles/"+logFile.getName());
		//System.out.println("inside method parseLogFile()");
		FileInputStream fStream = new FileInputStream(logFile);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fStream));
		boolean isErrorFile = false;
		FileWriter fwriter=new FileWriter(file);
		
		String matcher = "SEVER";
		String line ;
		while ((line = bf.readLine()) != null) {
			//System.out.println("inside method parseLogFile()");
			if(line.contains(matcher))
				{
				fwriter.write("SEVER Error : "+line.substring(line.lastIndexOf(";|") + 2)+"\n");
				//System.out.println(line.substring(line.lastIndexOf(";|") + 2));
				isErrorFile = true;
				}
			//fwriter.write(line+"\n");
		}
		
		fStream.close();
		fwriter.close();
		
		if(!isErrorFile)
			return null;
		return file;
	}
	
}
