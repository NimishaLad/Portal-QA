package com.portalQA_En.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Create_Refund {
	
	public WebDriver driver;
	@Test(priority=0)
	public void setup() {
			
		System.setProperty("webdriver.chrome.driver", "//home//mobiroo//eclipse-workspace//chromedriver");
		driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","//home//mobiroo//Downloads//geckodriver");
		//driver= new FirefoxDriver();
		driver.get("https://portal-qa.mobileplatform.solutions/ja/user/login?destination=dashboard");
		driver.manage().window().maximize();
		AssertJUnit.assertEquals(driver.getTitle(),"ユーザーログイン | ポータル");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		
		AssertJUnit.assertEquals(links.size(),5);
		driver.findElement(By.id("edit-name")).sendKeys("nlad");
		driver.findElement(By.id("edit-pass")).sendKeys("nnnn");
		driver.findElement(By.id("edit-submit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void Verify_CreateRefund(){
		driver.findElement(By.linkText("Create Refund")).click();
		AssertJUnit.assertEquals(driver.getTitle(),"Create Refund | Portal");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
