package PageClasses;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(id = "departDate1")
	WebElement departDate; 
	
	
	@FindBy(xpath = "//input[@class='calendar-date-field ref--searchinput']")
	WebElement firstCalendarMonthDropdown;
	
	
	@FindBy(xpath = "(//div[@class='calendar-date-suggestion'])[1]")
	WebElement firstClandarMonthDropdownSecondOption;
	
	@FindBy(xpath = "//li[@data-num=\"12\"]")
	WebElement DateChoosen;
	
	
	@FindBy(xpath = "//div[@class=\"dwc--SiaCookie__PopupCookie\"]")
	WebElement Popup1;
	
	@FindBy(xpath="//button[text()='Accept']")
	WebElement popup2;
//	
	
	
	public SingaporeAirlinesHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void enterOriginCity(String originCityName) throws AWTException {
		
		originTextBox.clear();
		originTextBox.sendKeys(originCityName);
		//firstOriginCity.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.DOWN).build().perform();
//		act.sendKeys(Keys.ENTER).build().perform();
				
		
	}
	
	
	public void enterdestination(String destinationName) {
		
		Actions act1= new Actions(driver);
		act1.sendKeys(Keys.TAB).build().perform();
		destinationTextBox.sendKeys(destinationName);
		act1.sendKeys(Keys.DOWN).build().perform();
		act1.sendKeys(Keys.ENTER).build().perform();
		//firstDestinationCity.click();
	}
	
	public void popHandling() {
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			boolean status = popup2.isDisplayed();
			if(status) {
			popup2.click();
			wait1.until(ExpectedConditions.invisibilityOf(popup2));	
			
			}
		}
			
			catch(NoSuchElementException se)
		{
				System.out.println(se);
		}
		}
			
		
	public void departDate() throws InterruptedException {
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			departDate.click();
			firstCalendarMonthDropdown.click();
			firstClandarMonthDropdownSecondOption.click();
			wait.until(ExpectedConditions.visibilityOf(DateChoosen));
			DateChoosen.click();

			
	}
}

