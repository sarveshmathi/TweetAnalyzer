package edu.upenn.cit594.ui​;

import java.util.Map;

import edu.upenn.cit594.processor.Processor;

public class UserInterface {
	
	protected Processor processor;
	
	public UserInterface(Processor processor) {
		this.processor = processor;
	}
	
	public void printFluTweetsPerState() {
		
		Map<String, Integer> tweetsPerStateMap = processor.getFluTweetsPerState();
		
		for (String state : tweetsPerStateMap.keySet()) {
			System.out.println(state + ": " + tweetsPerStateMap.get(state)); 
		}
		
	}
	

}
