package com.yml.CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stalin Christopher
 *
 */
public class CabInvoiceGenerator {
	
	private final double MIN_FARE = 5;
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Cab Invoice generator program" );
    }
    
    /**
     * @param distance
     * @param time
     * @return
     * Method to generate fare for given distance and time
     */
    public double generateFare(double distance, int time) {
    	double fare = 0;
    	fare = (distance *10) + (time * 1);
    	if( fare < 5) {
    		fare = MIN_FARE;
    	}
    	return fare;
    	
    }

	/**
	 * @param rides
	 * @return
	 * Method to generate aggregate fare for given array of rides
	 */
	public double generateAggregateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += generateFare(ride.getDistance(), ride.getTime());
		};
		return totalFare;
		
	}

	public List<Double> generateInvoice(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += generateFare(ride.getDistance(), ride.getTime());
		};
		List<Double> invoice = new ArrayList<Double>();
		invoice.add(totalFare);
		invoice.add(Double.valueOf(rides.length));
		invoice.add(totalFare/rides.length);
		return invoice;
	}
}
