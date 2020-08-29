package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.upenn.cit594.data.State;

public class CSVStatesReader implements StatesReader {
	
	protected String filename;
	
	public CSVStatesReader(String name) {
		filename = name;
	}

	@Override
	public List<State> getAllStates() {
		
		List<State> states = new ArrayList<State>(); 
		
		Scanner in = null;
		
		try {
			in = new Scanner(new File(filename));
			
			while(in.hasNextLine()) {
				
				String line = in.nextLine();
				
				State state = processLine(line);
				
				states.add(state);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return states; 
	}
	
	
	private State processLine(String line) {
		String[] components = line.split(",");
		
		String name = components[0];
		
		double latitude = Double.parseDouble(components[1]);
		
		double longitude = Double.parseDouble(components[2]);
		
		State state = new State(name, latitude,longitude);
		
		return state;
	}
	
//	public static void main(String[] args) {
//		
//		CSVStatesReader csr = new CSVStatesReader("states.csv");
//		
//		List<State> states = csr.getAllStates();
//		
//		for (State state : states) {
//			System.out.println(state.getName() + " " + state.getLatitude() + " " + state.getLongitude());
//		}
//	}
	
	

}
