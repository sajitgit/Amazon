package AutomationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public WebDriver driver;//declare
	
	
	public WebDriver browserinitialization(String browsername) throws Exception {
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			
			driver= new ChromeDriver();
		}
		
		else if (browsername.equalsIgnoreCase("Firefox")){
			
			driver = new FirefoxDriver();
			
		}
		
		else if(browsername.equalsIgnoreCase("Edge")) {
			
			
			driver = new EdgeDriver();
		}
		
		else {
			
			throw new Exception("Invalid name exception");
		}
		
		return driver;
	}
	
	
	
	
	

}
