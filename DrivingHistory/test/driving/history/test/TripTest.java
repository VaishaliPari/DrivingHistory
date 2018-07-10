package driving.history.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import driving.history.Trip;

public class TripTest {

	private Trip trip;
	
	@Before
    public void setUp() {
        trip = new Trip("Alex","12:01","13:16",42.0);
    }
	@Test
	public void tripTimeInMinsTest() {
		final int expectedTime = 75;

        final int actualTime = trip.tripTimeInMins();

        Assert.assertEquals(actualTime, expectedTime);
	}
	@Test
	public void speedCalcTest() {
		final int expectedSpeed = 34;
		
		trip.speedCalc();
		
        final int actualSpeed = trip.getSpeed();

        Assert.assertEquals(actualSpeed, expectedSpeed);
	}
	
	@After
    public void tearDown() {
       trip = null;
    }
}
