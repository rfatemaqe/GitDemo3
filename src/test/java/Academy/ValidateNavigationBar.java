package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	
	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialization() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("asd");
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
	System.out.println("this is the first change");
	System.out.println("this is the second change from original person");
	
	LandingPage l = new LandingPage(driver);
	
	Assert.assertTrue(l.getNavigationBar().isDisplayed());	
		

	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
