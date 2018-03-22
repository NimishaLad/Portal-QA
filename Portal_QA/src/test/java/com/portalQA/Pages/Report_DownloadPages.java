package com.portalQA.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Report_DownloadPages {

	WebDriver driver;

	public Report_DownloadPages(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Report - App Downloads")
	public WebElement RptappDown;
	@FindBy(id="edit-submit-reporting-download")
	public WebElement ClickOnApply;
	public WebElement ClickonRptDownload() {
	return RptappDown;
	}
	public WebElement ClickOnApply() {
		return ClickOnApply;
	}
	



}
