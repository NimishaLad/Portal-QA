package com.portalQA_En.TestCases;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.portalQA.Pages.Common_Elements;
import com.portalQA.Pages.Report_IAPRefundPages;
import com.portalQA.Pages.Signonpage;

public class Report_IAPRefund {

	public WebDriver driver;
	Signonpage login;
	Report_IAPRefundPages RIAP;
	Common_Elements CE;

	@Test
	public void Veify_Click_On_Report_IAPRefund() throws IOException {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","geckodriver");
		//driver= new FirefoxDriver();
		driver.get("https://portal-qa.mobileplatform.solutions/ja/user/login?destination=dashboard");
		driver.manage().window().maximize();

		login=new Signonpage(driver);
		RIAP=new Report_IAPRefundPages(driver);
		CE=new Common_Elements(driver);
		AssertJUnit.assertEquals(driver.getTitle(),"ユーザーログイン | ポータル");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		//System.out.println("total number of :"+links.size());
		AssertJUnit.assertEquals(links.size(),5);
		login.Adminlogin();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Test
	public void verify_Report_AppDown() throws InterruptedException{

		RIAP.ClickonRptIAP().click();

		AssertJUnit.assertEquals(driver.getTitle(),"IAP Refunds Report | Portal");
		CE.ClickonstartDate().sendKeys("2015/10/01"); 
		CE.ClickonEndDate().sendKeys("2018/01/01");	
		RIAP.clickOnRefundcreatAfter().sendKeys("2015/10/01");
		RIAP.clickOnRefundcreatebefore().sendKeys("2018/01/01");

		Select publisher=new Select(CE.SelectPublisher());
		publisher.selectByValue("307");
		Select apptitle=new Select(CE.SelectApptitle());
		apptitle.selectByValue("567");
		Select IAPtitle=new Select(RIAP.ClickonIAPtitle());
		IAPtitle.selectByValue("852");
		Select status=new Select(CE.SelectStatus());
		status.selectByValue("1");


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RIAP.ClickOnApply().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RIAP.ClickonShortByOrderDate().click();

		CE.ClickOnCSV().click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Return to previous page")));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       Thread.sleep(2000);
	}
	@AfterTest
	public void TearDown() {
		driver.quit();
	}


}
