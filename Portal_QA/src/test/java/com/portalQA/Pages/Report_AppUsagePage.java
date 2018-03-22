package com.portalQA.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Report_AppUsagePage {
	
	WebDriver driver;

	public Report_AppUsagePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Report - App Downloads")
	public WebElement RptappDown;

}
