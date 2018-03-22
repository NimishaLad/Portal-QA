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
import com.portalQA.Pages.Report_DownloadPages;
import com.portalQA.Pages.Signonpage;

public class Report_Download {

	public WebDriver driver;
	Signonpage login;
	Report_DownloadPages RD;
	Common_Elements CE;
	
	@Test
	public void Veify_Click_On_Report_Download() throws IOException {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
	    driver= new ChromeDriver();

		//System.setProperty("webdriver.gecko.driver","geckodriver");
		//driver= new FirefoxDriver();

		driver.get("https://portal-qa.mobileplatform.solutions/ja/user/login?destination=dashboard");
		driver.manage().window().maximize();

		login=new Signonpage(driver);
		RD=new Report_DownloadPages(driver);
        CE=new Common_Elements(driver);
		AssertJUnit.assertEquals(driver.getTitle(),"ユーザーログイン | ポータル");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		//System.out.println("total number of :"+links.size());
		AssertJUnit.assertEquals(links.size(),5);
		login.Adminlogin();
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//String HomePageTest =driver.findElement(By.linkText("Home")).getText();
/*
		if((driver.findElement(By.linkText("Home")).getText()).equalsIgnoreCase("Home"))
		{

			System.out.println("I am log in in English page");
		}
		else {
			System.out.println("I am log in in jappness page");
			driver.quit();	
		}
*/
	
	}

	@Test
	public void verify_Report_AppDown(){
		//driver.findElement(By.linkText("Report - App Downloads")).click();

		RD.ClickonRptDownload().click();

		AssertJUnit.assertEquals(driver.getTitle(),"App Downloads Report | Portal");
        System.out.println("passes title test .....");
        CE.ClickonstartDate().sendKeys("2017/1/01"); 
		CE.ClickonEndDate().sendKeys("2017/11/11");	
		Select publisher=new Select(CE.SelectPublisher());
		publisher.selectByValue("536");

		Select status=new Select(CE.SelectStatus());
		status.selectByValue("1");
		Select apptitle=new Select(CE.SelectApptitle());
		apptitle.selectByValue("1693");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RD.ClickOnApply().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(CE.SortByDate());
		CE.SortByDate().click();

		CE.SortByDownloadNum().click();
		CE.ClickOnCSV().click();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			}
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
