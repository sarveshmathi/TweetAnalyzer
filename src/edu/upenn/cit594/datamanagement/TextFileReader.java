package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.upenn.cit594.data.Tweet;

public class TextFileReader implements DataReader {
	
	protected String filename;
	
	public TextFileReader(String name) {
		filename = name; 
	}
	

	@Override
	public List<Tweet> getAllTweets() {
		
		List<Tweet> tweets = new ArrayList<Tweet>();
		
		Scanner in = null;
		
		try {
			
			in = new Scanner(new File(filename));
			
			while (in.hasNextLine()) {
				String line = in.nextLine();
				Tweet tweet = processLine(line);
				tweets.add(tweet);
			}
			
		} catch(Exception e){
			
			throw new IllegalStateException(e);
			
		} finally {
			
			in.close(); 
			
		}
		
		return tweets;
	}
	
	private Tweet processLine(String line) {
		
		String[] components = line.split("\t");
		
		String location = components[0];
		
		double latitude = Double.parseDouble(location.substring(1,location.indexOf(",")-1));
		
		double longitude = Double.parseDouble(location.substring(location.indexOf(",")+1, location.length()-2));
		
		String date = components[2];
		
		String text = components[3];
		
		Tweet tweet = new Tweet(latitude, longitude, date, text);
		
		return tweet;
	}
	
//	public static void main(String[] args) {
//		
//		TextFileReader tfr = new TextFileReader("flu_tweets.txt");
//		
//		List<Tweet> tweets = tfr.getAllTweets();
//		
//		for (Tweet tweet : tweets) {
//			
//			System.out.println(tweet.getLatitude() + ", " + tweet.getLongitude() + ", "+ tweet.getDate() + ", " + tweet.getText());
//			
//		}
//		
//	}
	
}
