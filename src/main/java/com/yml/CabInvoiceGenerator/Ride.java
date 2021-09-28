package com.yml.CabInvoiceGenerator;

import com.yml.CabInvoiceGenerator.CabInvoiceGenerator.RIDE;

public class Ride {
	private double distance;
	private int time;
	private int userID;
	private RIDE ride;
	
	public Ride(int userID, RIDE ride, double distance, int time) {
		this.distance = distance;
		this.time = time;
		this.userID = userID;
		this.ride = ride;
	}
	
	public RIDE getRide() {
		return ride;
	}

	public void setRide(RIDE ride) {
		this.ride = ride;
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
