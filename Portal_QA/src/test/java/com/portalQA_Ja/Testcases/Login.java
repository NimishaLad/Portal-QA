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
import org.testng.asserts.SoftAssert;

import com.portalQA.Pages.Signonpage;

public class Login {

	public WebDriver driver;
	
	Signonpage sp;
	
	
	
	@Test(priority=0)
	public void setup() {
			
		System.setProperty("webdriver.chrome.driver", "//home//mobiroo//eclipse-workspace//chromedriver");
		driver= new ChromeDriver();
		
		sp=new Signonpage(driver);

		//System.setProperty("webdriver.gecko.driver","//home//mobiroo//Downloads//geckodriver");
		//driver= new FirefoxDriver(); 

		driver.get("https://portal-qa.mobileplatform.solutions/ja/user/login?destination=dashboard");
		driver.manage().window().maximize();
		assertEquals(driver.getTitle(),"ユーザーログイン | ポータル");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		AssertJUnit.assertEquals(links.size(),5);
	}
	// log in 

	@Test(priority=1)
	public void verify_login() throws IOException{
		
	    sp.Adminlogin();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SoftAssert sa=new SoftAssert();
		assertEquals(driver.getTitle(),"Home | Portal");
		sa.assertAll();
		driver.quit();

	}
	
	
	
}


