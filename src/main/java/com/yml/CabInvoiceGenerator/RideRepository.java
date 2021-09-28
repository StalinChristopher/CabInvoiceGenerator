package com.yml.CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {
	private List<Ride> rides;

	RideRepository() {
		rides = new ArrayList<Ride>();
	}

	public void addRide(Ride ride) {
		rides.add(ride);
	}

	public List<Ride> getAllRides() {
		return rides;
	}
}
