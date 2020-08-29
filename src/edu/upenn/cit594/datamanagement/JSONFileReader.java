package edu.upenn.cit594.datamanagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.upenn.cit594.data.Tweet;

public class JSONFileReader implements DataReader {
	
	protected String filename;
	
	public JSONFileReader(String name) {
		filename = name;
	}

	@Override
	public List<Tweet> getAllTweets() {
		
		List<Tweet> tweets = new ArrayList<Tweet>();
		
		JSONParser parser = new JSONParser();
		
		try {
			
			JSONArray tweetObjects = (JSONArray) parser.parse(new FileReader(filename));
			
			Iterator<JSONObject> iter = tweetObjects.iterator();
			
			
			while (iter.hasNext()) {
				
				Tweet tweet =  processJSONObject((JSONObject) iter.next());
				
				tweets.add(tweet);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		return tweets;
	}
	
	private Tweet processJSONObject(JSONObject object) {
		
		JSONArray location = (JSONArray) object.get("location");
		
		double latitude = (double) location.get(0);
		
		double longitude = (double) location.get(1);
		
		String date = (String) object.get("time");
		
		String text = (String) object.get("text");
		
		Tweet tweet = new Tweet(latitude, longitude, date, text);
		
		return tweet;
		
	}
	
//	public static void main(String[] args) {
//	
//	JSONFileReader jfr = new JSONFileReader("flu_tweets.json");
//	
//	List<Tweet> tweets = jfr.getAllTweets();
//	
//	for (Tweet tweet : tweets) {
//		
//		System.out.println(tweet.getLatitude() + ", " + tweet.getLongitude() + ", "+ tweet.getDate() + ", " + tweet.getText());
//		
//	}
//	
//}

}
