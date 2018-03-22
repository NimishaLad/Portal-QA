package com.portalQA.Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signonpage {

	public static Properties config=new Properties();
	WebDriver driver;

	public Signonpage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);

	}


	@FindBy(id="edit-name")
	public WebElement userName;

	@FindBy(id="edit-pass")
	public WebElement passWord;

	@FindBy(id="edit-submit")
	public WebElement login;


	public WebElement GetUsername() {
		return userName;
	}

	public WebElement GetPassword() {

		return passWord;
	}

	public WebElement Onlogin() {
		return login;
	} 

	public void Adminlogin() throws IOException {

			//load config property file	
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java/com//portalQA//Resources//object.properties");
			config.load(fis);
		

		userName.sendKeys(config.getProperty("username"));
		passWord.sendKeys(config.getProperty("password"));
		login.click();
	}


}
