package com.appd.bean;

import java.io.File;
import java.io.FilenameFilter;

public class ListBean {
public File [] list;
public int count = 1;


public int getCount() {
	return count;
}

public void setCount() {
	this.count ++;
}

public ListBean() {
	System.out.println("Inside list bean");	// TODO Auto-generated constructor stub
}

public ListBean(File[] list) {
	this.list = list;
}

public void getListOfFiles() {
	System.out.println("Inside getList");
	File file = new File("/Users/chdeore/Documents/Eclips/LogFilesErrorFinder/rowfiles");
	list = file.listFiles(new FilenameFilter() {
		
		public boolean accept(File dir, String name) {
			if(name.toLowerCase().endsWith(".log"))
				return true;
			return false;
		}
	});
	System.out.println("Size : "+list.length);
}
public int getLength(){
	
	return list.length;
}

public File[] getList() {
	return list;
}

public void setList(File[] list) {
	this.list = list;
}



}
