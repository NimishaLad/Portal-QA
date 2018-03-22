package com.portalQA_Ja.Testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_Refund {
	
	public WebDriver driver;
	@Test
	public void setup() {
			
		System.setProperty("webdriver.chrome.driver", "//home//mobiroo//eclipse-workspace//chromedriver");
		driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","//home//mobiroo//Downloads//geckodriver");
		//driver= new FirefoxDriver();
		driver.get("https://portal-qa.mobileplatform.solutions/ja/user/login?destination=dashboard");
		driver.manage().window().maximize();
		assertEquals(driver.getTitle(),"ユーザーログイン | ポータル");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		
		AssertJUnit.assertEquals(links.size(),5);
		driver.findElement(By.id("edit-name")).sendKeys("nlad");
		driver.findElement(By.id("edit-pass")).sendKeys("mYgMuZzH88Hv");
		driver.findElement(By.id("edit-submit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void Verify_CreateRefund(){
		driver.findElement(By.linkText("Create Refund")).click();
		assertEquals(driver.getTitle(),"Create Refund | Portal");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}
	
	

}
