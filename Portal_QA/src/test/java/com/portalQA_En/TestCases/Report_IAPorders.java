package com.portalQA_En.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import com.portalQA.Pages.Common_Elements;
import com.portalQA.Pages.Signonpage;

public class Report_IAPorders {

	public WebDriver driver;
	Signonpage login;
	Common_Elements CE;
	
	@Test
	public void setup() throws IOException {
			System.out.println("I am in set up test");
		System.setProperty("webdriver.chrome.driver", "//home//mobiroo//eclipse-workspace//chromedriver");
		driver= new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver","//home//mobiroo//Downloads//geckodriver");
		//driver= new FirefoxDriver();
		driver.get("https://portal-qa.mobileplatform.solutions/ja/user/login?destination=dashboard");
		driver.manage().window().maximize();
		AssertJUnit.assertEquals(driver.getTitle(),"ユーザーログイン | ポータル");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		AssertJUnit.assertEquals(links.size(),5);        // verify condition for Home page load
		login =new Signonpage(driver);
		CE =new Common_Elements(driver);
		login.Adminlogin();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void verify_Report_IAPorder(){
		
		System.out.println("I am in vreify report test");
		driver.findElement(By.linkText("Report - IAP Orders")).click();
		AssertJUnit.assertEquals(driver.getTitle(),"IAP Orders Report | Portal");       //condition to verify load Report_IAP order page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		CE.ClickonstartDate().sendKeys("2017/11/01"); 
		CE.ClickonEndDate().sendKeys("2017/11/15");	
		Select publisher=new Select(CE.SelectPublisher());
		publisher.selectByValue("536");
		Select status=new Select(CE.SelectStatus());
		status.selectByValue("1");
		Select apptitle=new Select(CE.SelectApptitle());
		apptitle.selectByValue("1693");
		Select IAPTitle=new Select(CE.SelectIAPTitle());
		IAPTitle.selectByValue("1697");
		Select PaymentMethod=new Select(CE.SelecctPaymentMethod());
		PaymentMethod.selectByValue("1");
		
	    driver.findElement(By.id("edit-submit-reporting-iap")).click();
	    CE.ClickOnCSV().click();
	    WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void TearDown() {
		System.out.println("I am in aftertest");
		driver.quit();
	}
		
	
}
