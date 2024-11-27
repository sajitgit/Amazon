package PageClasses;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingaporeAirlinesHomePage {
	
	
	WebDriver driver;
	
	@FindBy(id="flightOrigin1")
	WebElement originTextBox;
	
//	@FindBy(xpath="//div[text()='COK']")
//	WebElement firstOriginCity;
//	
	
	@FindBy(xpath  = "//input[@name='destination']")
	WebElement destinationTextBox;
	
	
	
	
//	@FindBy(xpath = "(//Strong[text()='Singapore'])[1]")
//	WebElement firstDestinationCity;
//	
	
	
	public SingaporeAirlinesHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void enterOriginCity(String originCityName) {
		
		originTextBox.clear();
		originTextBox.sendKeys(originCityName);
		//firstOriginCity.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
				
		
	}
	
	
	public void enterdestination(String destinationName) {
		
		Actions act1= new Actions(driver);
		act1.sendKeys(Keys.TAB).build().perform();
		destinationTextBox.sendKeys(destinationName);
		act1.sendKeys(Keys.DOWN).build().perform();
		act1.sendKeys(Keys.ENTER).build().perform();
		//firstDestinationCity.click();
	}

}
