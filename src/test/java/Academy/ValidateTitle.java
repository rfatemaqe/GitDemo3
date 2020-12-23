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

public class ValidateTitle extends Base {
	private static Logger log =LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initialization() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("driver is navigated to homepage");
	}
		
	
	@Test
	public void validateAppTitle() throws IOException {
		
	
	
	LandingPage l = new LandingPage(driver);
	Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
	
	log.info("sucessfully validated text message");	

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
}
