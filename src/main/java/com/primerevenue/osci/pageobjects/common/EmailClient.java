package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.primerevenue.osci.utils.SeleniumUtils;

public class EmailClient {
	
	final static Logger logger = Logger.getLogger(EmailClient.class);
	
	 @FindBy(xpath = "//script[@type='jsv#7^']/..")
	    public WebElement inbox;
	 
	 @FindBy(xpath = "html/body/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/ul/li[1]/span[2]/span[1]/div/span/span")
	    public WebElement newEmail;
	 
	 
	 public String readEmail()	{
		 
		 SeleniumUtils.click(inbox);
		 SeleniumUtils.click(newEmail);
		 
		return null;
		 
		 
	 }

}
