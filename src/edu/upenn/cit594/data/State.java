package edu.upenn.cit594.data;

public class State {
	
	private String name;
	private double latitude;
	private double longitude;
	
	public State(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public double getLatitude() {
		return latitude; 
	}

	public double getLongitude() {
		return longitude;
	}
	
	
	

}
