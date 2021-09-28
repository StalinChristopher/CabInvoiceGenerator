package com.yml.CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stalin Christopher
 *
 */
public class CabInvoiceGenerator {
	
	private final int NORMAL_MIN_FARE = 5;
	private final int PREMIUM_MIN_FARE = 20;
    private final int NORMAL_FARE_PER_KM = 10;
    private final int PREMIUM_FARE_PER_KM = 15;
    private final int NORMAL_FARE_PER_MIN = 1;
    private final int PREMIUM_FARE_PER_MIN = 2;
	
	enum RIDE {
		NORMAL, PREMIUM
	};
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
    public double generateFare(RIDE ride,double distance, int time) {
    	double fare = 0;
    	if(ride == RIDE.NORMAL ) {
    		fare = (distance * NORMAL_FARE_PER_KM) + (time * NORMAL_FARE_PER_MIN);
        	if( fare < 5) {
        		fare = NORMAL_MIN_FARE;
        	}
    	}else {
    		fare = (distance * PREMIUM_FARE_PER_KM) + (time * PREMIUM_FARE_PER_MIN);
        	if( fare < 5) {
        		fare = PREMIUM_MIN_FARE;
        	}
    	}
    	return fare;
    	
    }

	/**
	 * @param rides
	 * @return
	 * Method to generate aggregate fare for given array of rides
	 */
	public double generateAggregateFare(List<Ride> rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += generateFare(ride.getRide(),ride.getDistance(), ride.getTime());
		};
		return totalFare;
		
	}

	public Invoice generateInvoice(List<Ride> rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += generateFare(ride.getRide(),ride.getDistance(), ride.getTime());
		};
		Invoice invoice = new Invoice(totalFare,rides.size());

		return invoice;
	}
}
