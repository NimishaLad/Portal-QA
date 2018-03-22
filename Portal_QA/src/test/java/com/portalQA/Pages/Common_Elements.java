package com.portalQA.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Common_Elements {

	
	WebDriver driver;

		public Common_Elements(WebDriver driver) {
	
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
	@FindBy(name="date_filter[value][date]")
	public WebElement startdate;
	
	@FindBy(name="date_filter_1[value][date]")
	public WebElement enddate;
	
	@FindBy(name="developer_id")
	public WebElement publisher;
	
	@FindBy(name="app_id")
	public WebElement Apptitle;
	
	@FindBy(name="iap_id")
	public WebElement IAP_Title;
	
	@FindBy(name="published")
	public WebElement Status;
	
	@FindBy(xpath="//img[@title='CSV']")
	public WebElement ClickOnCSV;
	
	@FindBy(linkText="Date")
	public WebElement SortByDate;
	
	@FindBy(linkText="Downloaded")
	public WebElement SortByNoOfDown;
	
	@FindBy(linkText="Package Name")
	public WebElement SortbyPakagebname;
	
	@FindBy(name="TransactionPaymentMethod")
    public WebElement PaymentMEthod;
	
	public WebElement SelecctPaymentMethod() {
		return PaymentMEthod;
	}
	
	public WebElement ClickonstartDate() {
		return startdate;
	}
	
	public WebElement ClickonEndDate() {
		return enddate;
	}
	
	public WebElement SelectPublisher() {
		return publisher;
	}
	
	public WebElement SelectApptitle() {
		return Apptitle;
	}
	
	public WebElement SelectStatus() {
		return Status;
	}
		
	public WebElement SortByDate() {
		return SortByDate;
	}
	
	public WebElement ClickOnCSV() {
		return ClickOnCSV;
	}

	public WebElement SortByDownloadNum() {
		return SortByNoOfDown;
	}
	
	public WebElement SelectIAPTitle() {
		return IAP_Title;
	}
	
}
