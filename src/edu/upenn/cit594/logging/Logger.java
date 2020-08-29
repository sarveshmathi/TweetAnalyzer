package edu.upenn.cit594.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	
	public static String filename;
	
	private PrintWriter out;
	
	private static Logger instance;
	
	
	public static Logger getInstance() {
		
		if (instance == null) {
			instance = new Logger();
		}
		
		
		try {
			instance.out = new PrintWriter(new FileWriter(filename, false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return instance;
	}
	 
	public void log(String string) {
		out.println(string);
		out.flush();
	}
	
}
