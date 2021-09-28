package com.yml.CabInvoiceGenerator;

/**
 * Hello world!
 *
 */
public class CabInvoiceGenerator {
	
	private final double MIN_FARE = 5;
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Cab Invoice generator program" );
    }
    
    public double generateFare(double distance, int time) {
    	double fare = 0;
    	fare = (distance *10) + (time * 1);
    	if( fare < 5) {
    		fare = MIN_FARE;
    	}
    	return fare;
    	
    }
}
