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

public class Admin_ReportDownlaod {
	public WebDriver driver;
	Signonpage SP;
	Report_DownloadPages RD;
	Common_Elements CE;
	
	
	@Test
	public void setup() throws IOException {

		System.setProperty("webdriver.chrome.driver", "//home//mobiroo//eclipse-workspace//chromedriver");
		driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","//home//mobiroo//Downloads//geckodriver");
		//driver= new FirefoxDriver();
		driver.get("https://portal-qa.mobileplatform.solutions/ja/user/login?destination=dashboard");
		driver.manage().window().maximize();
		AssertJUnit.assertEquals(driver.getTitle(),"ユーザーログイン | ポータル");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

		AssertJUnit.assertEquals(links.size(),5);
		SP =new Signonpage(driver);
		RD=new Report_DownloadPages(driver);
        CE=new Common_Elements(driver);
		SP.Adminlogin();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void verify_Admin_Download(){
		driver.findElement(By.linkText("Admin Report - Downloads")).click();
		AssertJUnit.assertEquals(driver.getTitle(),"App Downloads Report | Portal");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		    CE.ClickonstartDate().sendKeys("2017/11/01"); 
			CE.ClickonEndDate().sendKeys("2017/11/11");	
			Select publisher=new Select(CE.SelectPublisher());
			publisher.selectByValue("536");

			Select status=new Select(CE.SelectStatus());
			status.selectByValue("1");
			Select apptitle=new Select(CE.SelectApptitle());
			apptitle.selectByValue("1693");
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
