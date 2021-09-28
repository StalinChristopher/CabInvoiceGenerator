package com.yml.CabInvoiceGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
	
	CabInvoiceGenerator cabInvoiceGenerator;
	RideRepository rideRepository;
	
	@Before
	public void initialize() {
		cabInvoiceGenerator = new CabInvoiceGenerator();
		rideRepository = new RideRepository();
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
		rideRepository.addRide(new Ride(1,10,15));
		rideRepository.addRide(new Ride(1,15,30));
		double aggregateFare = cabInvoiceGenerator.generateAggregateFare(rideRepository.getAllRides());
		double expectedFare = 295.0;
		Assert.assertEquals(expectedFare, aggregateFare,1e-15);
	}
	
	/**
	 * Test case to validate total fare, number of rides and average fare per ride
	 */
	@Test
	public void generateTotalFareTotalRidesAverageFareExpectedTrue() {
		rideRepository.addRide(new Ride(1,10,15));
		rideRepository.addRide(new Ride(1,15,30));
		rideRepository.addRide(new Ride(1,8,10));
		Invoice invoice = cabInvoiceGenerator.generateInvoice(rideRepository.getAllRides());
		double expectedRides = 3;
		double expectedTotalFare = 385;
		double expectedAverageFarePerRide = 128.3;
		Assert.assertEquals(expectedTotalFare, invoice.totalFare,0);
		Assert.assertEquals(expectedRides,invoice.numberOfRides,1e-15);
		Assert.assertEquals(expectedAverageFarePerRide,invoice.averageFare,0.1);
	}
	
	@Test
	public void generateInvoiceForGivenUserID() {
		rideRepository.addRide(new Ride(1,10,15));
		rideRepository.addRide(new Ride(1,15,30));
		rideRepository.addRide(new Ride(1,8,10));
		rideRepository.addRide(new Ride(2,10,10));
		rideRepository.addRide(new Ride(2,20,25));
		rideRepository.addRide(new Ride(2,12,15));
		rideRepository.addRide(new Ride(2,5,9));
		
		//User 1
		Invoice invoice = cabInvoiceGenerator.generateInvoice(rideRepository.getAllRides().stream()
				.filter(r -> r.getUserID()==1).collect(Collectors.toList()));
		double expectedRides = 3;
		double expectedTotalFare = 385;
		double expectedAverageFarePerRide = 128.3;
		Assert.assertEquals(expectedTotalFare, invoice.totalFare,0);
		Assert.assertEquals(expectedRides,invoice.numberOfRides,1e-15);
		Assert.assertEquals(expectedAverageFarePerRide,invoice.averageFare,0.1);
		
		//User2
		invoice = cabInvoiceGenerator.generateInvoice(rideRepository.getAllRides().stream()
				.filter(r -> r.getUserID()==2).collect(Collectors.toList()));
		expectedRides = 4;
		expectedTotalFare = 529;
		expectedAverageFarePerRide = 132.25;
		Assert.assertEquals(expectedTotalFare, invoice.totalFare,0);
		Assert.assertEquals(expectedRides,invoice.numberOfRides,1e-15);
		Assert.assertEquals(expectedAverageFarePerRide,invoice.averageFare,0.1);
		
	}
}
