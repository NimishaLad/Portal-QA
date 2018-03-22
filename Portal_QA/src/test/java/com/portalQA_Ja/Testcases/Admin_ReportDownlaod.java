package com.portalQA_Ja.Testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.portalQA.Pages.Signonpage;

public class Admin_ReportDownlaod {
	public WebDriver driver;
	Signonpage login;
	@Test
	public void setup() throws IOException {

		System.setProperty("webdriver.chrome.driver", "//home//mobiroo//eclipse-workspace//chromedriver");
		driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","//home//mobiroo//Downloads//geckodriver");
		//driver= new FirefoxDriver();
		driver.get("https://portal-qa.mobileplatform.solutions/ja/user/login?destination=dashboard");
		driver.manage().window().maximize();
	    assertEquals(driver.getTitle(),"ユーザーログイン | ポータル");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

		AssertJUnit.assertEquals(links.size(),5);
		login =new Signonpage(driver);
		login.Adminlogin();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void verify_Admin_Download(){
		driver.findElement(By.linkText("Admin Report - Downloads")).click();
		assertEquals(driver.getTitle(),"App Downloads Report | Portal");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}



}
