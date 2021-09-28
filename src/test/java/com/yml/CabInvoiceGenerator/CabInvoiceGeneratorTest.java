package com.yml.CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
   

	@SuppressWarnings("deprecation")
	@Test
	public void generatefareforgivendistanceandtime(){
		CabInvoiceGenerator  cabInvoiceGenerator = new CabInvoiceGenerator();
		double distance = 30;
		int time = 40;
		double actualFare = cabInvoiceGenerator.generateFare(distance,time);
		double expectedFare = 340.0;
		Assert.assertEquals(expectedFare, actualFare,1e-15);
	}	
}
