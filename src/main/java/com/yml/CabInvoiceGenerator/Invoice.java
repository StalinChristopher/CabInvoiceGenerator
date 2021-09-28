package com.yml.CabInvoiceGenerator;

public class Invoice {
	public double totalFare;
	public int numberOfRides;
	public double averageFare;
	
	public Invoice(double totalFare, int noOfRides){
		this.totalFare = totalFare;
		this.numberOfRides = noOfRides;
		this.averageFare = totalFare/noOfRides;
	}
	
}
