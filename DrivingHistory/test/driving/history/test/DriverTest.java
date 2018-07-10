package driving.history.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import driving.history.Driver;

public class DriverTest {
	
	private Driver driver;
	
	@Before
    public void setUp() {
        driver = new Driver("Alex");
    }
	
	@Test
	public void speedCalcTest(){
		driver.setMiles(42);
		driver.setTime(75);
		driver.speedCalc();
		
		final int expectedSpeed = 34;

        final int actualSpeed = driver.getSpeed();

        Assert.assertEquals(actualSpeed, expectedSpeed);
	
	}
	
	@After
    public void tearDown() {
       driver = null;
    }

}
