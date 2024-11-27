package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import AutomationCore.BaseClass;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AmazonTestCases extends BaseClass {

	
	WebDriver driver;
	
	@BeforeMethod(groups = {"regressiontest"})
	@Parameters({"browser"})
	
	public void initialization(String browsername) throws Exception {
		
		
		driver = browserinitialization(browsername);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println("BeforeMethod");
		
		
	}
	
	@Test(retryAnalyzer = TestCases.RetryAnalyser.class)
	public void tc01() throws InterruptedException {
		
		System.out.println("Testcase 01");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(products.size());
		AssertJUnit.assertEquals(products.size(), 18);
		
////		Select drp = new Select(driver.findElement(By.id("s-result-sort-select")));
////		drp.selectByValue("review-rank");
////		drp.selectByVisibleText("Price: High to Low");
//		driver.findElement(By.xpath("//span[text()='Apple']")).click();
//		Thread.sleep(3000);
//		//driver.findElement(By.className("a-input-text a-span12 auth-autofocus auth-required-field auth-require-claim-validation")).sendKeys("sajith");
//		driver.findElement(By.name("field-keywords")).clear();
//		driver.findElement(By.name("field-keywords")).sendKeys("Smart tv");
//		driver.findElement(By.id("nav-search-submit-button")).click();
//		
//		
//		
//		//driver.findElement(By.tagName("input"));
//		//driver.findElement(By.linkText("Conditions of Use")).click();
//		//driver.findElement(By.partialLinkText("Privacy")).click();
////		driver.navigate().to("https://www.netflix.com/in/");
////		driver.navigate().back();
////		driver.navigate().forward();
////		driver.navigate().refresh();
//		String value = driver.findElement(By.xpath("(//span[@class='nav-line-1'])[2]")).getText();
//		System.out.println(value);
//		String value1 =driver.findElement(By.id("twotabsearchtextbox")).getAttribute("class");
//		System.out.println(value1);
	}
	
	@Test
	public void tc02() throws InterruptedException {
		
		System.out.println("tc02");
		boolean flag;
		driver.findElement(By.name("field-keywords")).sendKeys("Smart tv");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='a-button-text' and @type='button']")).click();
		//driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
		Thread.sleep(3000);
		WebElement texts= driver.findElement(By.xpath("//span[@class='a-truncate-cut' and @style='height: auto;']"));
		String text = texts.getText();

		//String text =driver.findElement(By.xpath("(//span[@class='a-truncate-full a-offscreen'])[last()]")).getText();
		System.out.println(text);
		Thread.sleep(3000);
		if(text.contains("TV")) {
			
			flag=true;
			System.out.println("Smart TV added succesfully");
		}
		
		else {
			System.out.println("Wrong product added");
			flag=false;
		}
		
		AssertJUnit.assertEquals(flag, true);
	}
//	
	@Test
	public void tc03() throws InterruptedException {
		
		System.out.println("TC03");
		
		driver.navigate().to("https://demo.guru99.com/test/radio.html");
		Thread.sleep(5000);	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.id("vfb-7-1"))));
		driver.findElement(By.id("vfb-7-1")).click();
			
	}
//	
	@Test
	public void tc04() {
		
		SoftAssert softassert = new SoftAssert();
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();	
		boolean status = driver.findElement(By.id("continue")).isEnabled();
		System.out.println(status);
		AssertJUnit.assertEquals(status, true);
		boolean status2 = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).isDisplayed();
		System.out.println(status2);
		AssertJUnit.assertEquals(status2, true);
		softassert.assertAll();//mandatory step in soft assert.
	}
	
	@Test
	public void tc05() throws InterruptedException {
		
		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String>it = tabs.iterator();
		while(it.hasNext()) {
			
			String child = it.next();
			if(!parent.equals(child)) {
				
				driver.switchTo().window(child);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
				
			}
			
			
		}
		 
//		driver.switchTo().window(parent);
//		driver.navigate().refresh();
//		
//		
//		for(String tab:tabs)
//			
//			if(parent.equals(tab)) {
//				
//				System.out.println(tab);
//			}
//		
//		
//			else {
//				
//				driver.switchTo().window(tab);
//				driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
//			}
//		
//		System.out.println("Parent"+parent);
//		
//		
//		//boolean buttonvisible=driver.findElement(By.xpath("//select[@id='s-result-sort-select']")).isEnabled();
//		//System.out.println(buttonvisible);
//		String currentwindow=driver.getWindowHandle();
//		System.out.println(currentwindow);
//		
}
	
	@Test
	public void tc06() {
		System.out.println("TC06");
		
		driver.navigate().to("https://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().sendKeys("Test");
	}
	
	@Test(priority=2,groups = {"regressiontest","smoketest"})
	public void tc07() {
		
		System.out.println("TC07");
		driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
		Actions action = new Actions(driver);
		WebElement source =driver.findElement(By.id("column-a"));
		WebElement destination = driver.findElement(By.id("column-b"));
		action.dragAndDrop(source, destination).build(); //To perform drag and drop actions
		action.contextClick().build();//To perform right click
		driver.navigate().to("https://www.amazon.in/");
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build();//To mousehover an element
		action.sendKeys(Keys.ESCAPE);// To perform keyboard keys -build.perform only needed for mouse related actions.
		action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("C"))
		.keyUp(Keys.CONTROL).perform();
		action.build().perform();
	}
	
	@Test(priority=1,groups = {"regressiontest"})
	public void tc08() {
		System.out.println("TC08");
		WebElement el = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		JavascriptExecutor jsc =(JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,1000)");//change first index value for right side scroll
		jsc.executeScript("arguments[0].click();",el);
		
		
	}
	
//	@Test
//	public void tc09() {
//		
//		
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
//		driver.findElement(By.id("nav-search-submit-button")).click();
//		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
//		System.out.println(products.size());
//		Select drp = new Select(driver.findElement(By.id("s-result-sort-select")));
//		drp.selectByValue("review-rank");
//		drp.selectByVisibleText("Price: High to Low");
//		driver.findElement(By.xpath("//span[text()='Apple']")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Apple']"))));
//		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
//		.withTimeout(Duration.ofSeconds(40))
//		.pollingEvery(Duration.ofSeconds(5));
//		//wait1.until(Expected)
//		
//	}
	@Test
	public void tc10() {
		
		
		System.out.println("Testcase 10");
	}
	
	@Test
	public void tc11() {
		
		System.out.println("Testcase 11");
	}
	
	@BeforeSuite
	public void BeforeSuiteexample() {
		
		System.out.println("Beforesuite");
	}
	
	@AfterSuite
	public void AfterSuiteexample() {
		
		System.out.println("AfterSuite");
	}
	
	@BeforeClass
	public void BeforeClassexample() {
		
		System.out.println("Beforeclass");
	}
	
	@AfterClass
	public void AfterClassmethod() {
		
		System.out.println("Afterclassmethod");
	}
	
	@org.testng.annotations.BeforeTest
	public void BeforeTest() {
		
		System.out.println("BeforeTest");
	}
	
	@org.testng.annotations.AfterTest
	public void AfterTest() {
		
		System.out.println("AfterTest");
	}
	
	@BeforeGroups(groups = {"regressiontest"})
	public void BeforeGroup() {
		System.out.println("BeforeGroup");
		
	}
	
	@AfterGroups(groups = {"regressiontest"})
	public void AfterGroup() {
		System.out.println("AfterGroup");
	}
	
	
//	@AfterMethod
//	public void teardown() {
//		System.out.println("AfterMethod");
//		driver.quit();
//	}
	
	@Test(dataProvider = "testData")
	public void tc12(String userName,String Password) {
		
		driver.navigate().to("https://qalegend.com/crm/index.php/signin");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	@Test
	@DataProvider(name="testData")
	public Object[][] testDataFeed() {
		
		Object[][] userData = new Object[2][2];
		userData[0][0]="admin@admin.com";
		userData[0][1]="12345678";
		
		userData[1][0]="admin123@123.com";
		userData[1][1]="123";
		return userData;
	}
}
