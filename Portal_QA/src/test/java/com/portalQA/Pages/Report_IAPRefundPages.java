package com.portalQA.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Report_IAPRefundPages {


	WebDriver driver;

	public Report_IAPRefundPages(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText="Report - IAP Refunds")
	public WebElement RptIAPRefund;
	@FindBy(id="edit-refund-date-0-value-datepicker-popup-0")
	public WebElement RefundCreateafter;
	@FindBy(id="edit-refund-date-1-value-datepicker-popup-0")
	public WebElement RefundCreatebefore;
	@FindBy(name="iap_id")
	public WebElement IAPTitle;
	@FindBy(id="edit-submit-reporting-iap-refund")
	public WebElement Applybtn;
    @FindBy (linkText="Order Created")
    public WebElement OrderbycreatedDate;
	
	public WebElement clickOnRefundcreatAfter() {
		return RefundCreateafter;
	}
	public WebElement clickOnRefundcreatebefore() {
		return RefundCreatebefore;
	}

	public WebElement ClickonRptIAP() {
		return RptIAPRefund;
	}
	public WebElement ClickonIAPtitle() {
		return IAPTitle;
	}

	public WebElement ClickOnApply() {
		return Applybtn;
	}
   public WebElement ClickonShortByOrderDate() {
	   return OrderbycreatedDate;
   }
	
}
