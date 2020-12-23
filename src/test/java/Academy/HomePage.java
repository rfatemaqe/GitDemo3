package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	private static Logger log =LogManager.getLogger(HomePage.class.getName());
	
	@Test(dataProvider="getdata")
	
	
public void basePageNavigation(String username, String password, String text) throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	
	LandingPage l = new LandingPage(driver);
	l.getLogin().click();
	
	LoginPage lg = new LoginPage(driver);
	lg.getEmail().sendKeys(username);
	lg.getPassword().sendKeys(password);
	lg.getLogin().click();
	log.info(text);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}		
	
	@DataProvider(name="getdata")
	
public Object[][] getData(){
Object [][] data = new Object[2][3];	
data[0][0]="nonrestrictedUser@qW.com";
data[0][1]="123456";
data[0][2]= "nonrestricteduser";


	
data[1][0]="restrictedUser@qW.com";
data[1][1]="12653456";
data[1][2]= "restricteduser";;

return data;
}
		
	




}
