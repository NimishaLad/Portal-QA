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

public class Report_AppUsage {


	public WebDriver driver;
	Signonpage login;
	Common_Elements CE;

	@Test
	public void Verify_load_Report_Appusage() throws IOException {


		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","geckodriver");
		//driver= new FirefoxDriver(); 

		driver.get("https://portal-qa.mobileplatform.solutions/ja/user/login?destination=dashboard");
		driver.manage().window().maximize();
		AssertJUnit.assertEquals(driver.getTitle(),"ユーザーログイン | ポータル");  // condition to pass Test
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		AssertJUnit.assertEquals(links.size(),5);                              // condition to pass Test

		login= new Signonpage(driver);  
		CE= new Common_Elements(driver);                                  //constructor initialization

		login.Adminlogin();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void verify_Report_AppUsage(){

		driver.findElement(By.linkText("Report - App Usage")).click();
		AssertJUnit.assertEquals(driver.getTitle(),"Report - App Usage | Portal");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CE.ClickonstartDate().sendKeys("2017/1/01"); 
		CE.ClickonEndDate().sendKeys("2017/11/11");	
		Select publisher=new Select(CE.SelectPublisher());
		publisher.selectByValue("536");
		Select status=new Select(CE.SelectStatus());
		status.selectByValue("1");
		Select apptitle=new Select(CE.SelectApptitle());
		apptitle.selectByValue("1693");
		driver.findElement(By.id("edit-submit-reporting-usage")).click();

		CE.SortByDate().click();
		CE.ClickOnCSV().click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
