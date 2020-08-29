package edu.upenn.cit594;
import java.io.File;

import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.Processor;
import edu.upenn.cit594.ui​.UserInterface;


public class Main {
	
	public static void main(String[] args) {
		
		if (args.length != 4) {
			System.out.println("Incorrect arguments.");
			System.exit(0);
		}
		
		if (args[0].equals("text") && args[0].equals("json")) {
			System.out.println("Incorrect file format specified.");
			System.exit(0);
		}
		
		String inputFileFormat = args[0];
		
		String inputFileName = args[1]; 
				
		String statesFileName = args[2];
		
		Logger.filename = args[3];
		
		File inputFile = new File(inputFileName);
		
		File statesFile = new File(statesFileName);
		
		if (!inputFile.exists() || !inputFile.canRead()) {
			System.out.println("The specified input file " + inputFileName + " does not exit or cannot be read.");
			System.exit(0);
		}
		
		if (!statesFile.exists() || !statesFile.canRead()) {
			System.out.println("The specified states file " + statesFileName + " does not exit or cannot be read.");
			System.exit(0);
		}
		
		DataReader dataReader = null;
		
		if (inputFileFormat.equals("text")) {
			
			dataReader = new TextFileReader(inputFileName);
			
		} else { 
			
			dataReader = new JSONFileReader(inputFileName);
			
		}

		
		StatesReader statesReader = new CSVStatesReader(statesFileName); 
		
		
		Processor processor = new Processor(dataReader, statesReader);
		
		
		UserInterface ui = new UserInterface(processor);
		
		
		ui.printFluTweetsPerState();
		
	}

}
