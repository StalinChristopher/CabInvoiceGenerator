package com.yml.CabInvoiceGenerator;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
	
	CabInvoiceGenerator cabInvoiceGenerator;
	
	@Before
	public void initialize() {
		cabInvoiceGenerator = new CabInvoiceGenerator();
	}

	/**
	 * Test case to validate fare given distance and time 
	 */
	@Test
	public void generatefareforgivendistanceandtime(){
		double distance = 30;
		int time = 40;
		double actualFare = cabInvoiceGenerator.generateFare(distance,time);
		double expectedFare = 340.0;
		Assert.assertEquals(expectedFare, actualFare,1e-15);
	}
	
	/**
	 * Test case to validate aggregate fare for multiple rides 
	 */
	@Test
	public void generateFareForMultipleRides() {
		Ride[] rides = { new Ride(10, 15), new Ride(15, 30)};
		double aggregateFare = cabInvoiceGenerator.generateAggregateFare(rides);
		double expectedFare = 295.0;
		Assert.assertEquals(expectedFare, aggregateFare,1e-15);
	}
	
	/**
	 * Test case to validate total fare, number of rides and average fare per ride
	 */
	@Test
	public void generateTotalFareTotalRidesAverageFareExpectedTrue() {
		Ride[] rides = { new Ride(10, 15), new Ride(15, 30), new Ride(8, 10)};
		Invoice invoice = cabInvoiceGenerator.generateInvoice(rides);
		double expectedRides = 3;
		double expectedTotalFare = 385;
		double expectedAverageFarePerRide = 128.3;
		Assert.assertEquals(expectedTotalFare, invoice.totalFare,0);
		Assert.assertEquals(expectedRides,invoice.numberOfRides,1e-15);
		Assert.assertEquals(expectedAverageFarePerRide,invoice.averageFare,0.1);
		
	}
}
