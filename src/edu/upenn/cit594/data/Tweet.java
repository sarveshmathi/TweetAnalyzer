package edu.upenn.cit594.data;

public class Tweet {
	
	private final double latitude;
	private final double longitude;
	private final String date;
	private final String text;
	
	public Tweet(double latitude, double longitude, String date, String text) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.text = text; 
	}

	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public String getDate() {
		return date;
	}

	public String getText() {
		return text;
	}
	
}
