package edu.upenn.cit594.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.upenn.cit594.data.*;
import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logger;

public class Processor {

	protected DataReader dataReader;
	protected StatesReader statesReader;
	protected List<Tweet> allTweets; 
	protected List<State> states;
	protected List<Tweet> fluTweets;
	
	public Processor(DataReader dataReader, StatesReader statesReader) {
		this.dataReader = dataReader; 
		this.statesReader = statesReader;
		allTweets = dataReader.getAllTweets();
		states = statesReader.getAllStates();
		fluTweets = getFluTweets(allTweets);
	}
	
	private List<Tweet> getFluTweets(List<Tweet> allTweets) {	
		List<Tweet> output = new ArrayList<Tweet>();
		
		for (Tweet tweet : allTweets) {
			if (isFluTweet(tweet.getText().toLowerCase())) {
				output.add(tweet);
			}
		}
		
		return output;
	}
	
	private boolean isFluTweet(String tweetText) {
		
		Pattern p = Pattern.compile("\\b#?flu\\W?\\b");
		
		Matcher m = p.matcher(tweetText);
		
		return m.find();
		 
	}
	
	public Map<String, Integer> getFluTweetsPerState() {
		
		Map<String, Integer> map = new TreeMap<>();
		
		Logger logger = Logger.getInstance();
		
		for (Tweet fluTweet : fluTweets) {
			
			String state = getStateForTweet(fluTweet);
			
			if (map.containsKey(state)) {
				int existingCount = map.get(state);
				map.put(state, existingCount +1);
			} else {
				map.put(state, 1);
			}
			
			String loggerText = state + "\t" + fluTweet.getText();
			
			logger.log(loggerText);
			
		}
		
		return map;
	}
	
	private String getStateForTweet(Tweet tweet) {
		
		double tweetLatitude = tweet.getLatitude();
		double tweetLongitude = tweet.getLongitude();
		
		double minDistance = Double.MAX_VALUE;
		String closestState = "";
		
		for (State state : states) {
			double stateLatitude = state.getLatitude();
			double stateLongitude = state.getLongitude();
			
			double equation = Math.pow((stateLatitude - tweetLatitude), 2) + Math.pow((stateLongitude - tweetLongitude), 2);
			
			double distance = Math.sqrt(equation);
			
			if (distance < minDistance) {
				minDistance = distance;
				closestState = state.getName();
			}
			
		}
		
		return closestState;
	}
	
//	public static void main(String[] args) {
//		
//		Processor p = new Processor(new TextFileReader("flu_tweets.txt"), new CSVStatesReader("states.csv"));
//		
//		String text = "so sick with the #flue gonna go home now";
//		
//		System.out.println(p.isFluTweet(text.toLowerCase()));
//		
//	}
	
}
