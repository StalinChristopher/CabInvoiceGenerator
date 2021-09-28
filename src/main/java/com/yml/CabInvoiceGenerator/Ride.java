package com.yml.CabInvoiceGenerator;

public class Ride {
	private double distance;
	private int time;
	private int userID;
	
	public Ride(int userID, double distance, int time) {
		this.distance = distance;
		this.time = time;
		this.userID = userID;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
}
