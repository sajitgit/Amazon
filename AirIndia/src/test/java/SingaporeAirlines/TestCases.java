package SingaporeAirlines;

import org.testng.annotations.Test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import AutomationCore.BaseClass;
import PageClasses.SingaporeAirlinesHomePage;

public class TestCases extends BaseClass {

	
public WebDriver driver;
SingaporeAirlinesHomePage homepage;

	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browsername) throws Exception {
		
		
		driver = browserinitialization(browsername);
		homepage = new SingaporeAirlinesHomePage(driver);
		driver.get("https://www.singaporeair.com/en_UK/in/home#/book/bookflight");
		driver.manage().window().maximize();
		
		
		
	}
	
	@Test
	public void searchFlights() throws AWTException, InterruptedException {
		
		homepage.enterOriginCity("Kochi");
		homepage.enterdestination("Singapore");
		homepage.departDate();
		
		
		
	}
	
}
