package com.yml.CabInvoiceGenerator;
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
}
