package resources;

import java.io.File;
//import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;

//import org.apache.logging.log4j.core.util.FileUtils;

//import org.apache.logging.log4j.core.util.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException  {
	prop= new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Fatema\\E2EProject\\src\\main\\java\\resources\\data.properties");

	prop.load(fis);
	String browserName = System.getProperty("browser");
	//String browserName=prop.getProperty("browser");
	System.out.println(browserName);

	if(browserName.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", "C:\\autoB\\chromedriver.exe");
	driver= new ChromeDriver(); //execute in chrome driver
		
	}

	else if (browserName.equals("firefox")) {
	driver= new FirefoxDriver(); //firefox code
	}
	else if (browserName.equals("IE")){
//		IE code
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	return driver;


	}

	
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C://Users//Fatema//test//"+ result+ "screenshot.png"));
	
		
		
	
	//File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	//copyFile(src,newFile("C:\\Users\\Fatema\\test"+result+"screenshot.png"));
	//FileUtils..copyFile(src, new File("C://test//"+result+"screenshot.png"));
		
	}


}
