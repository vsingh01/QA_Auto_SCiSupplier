package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

public class Otp2fa {
	
	final static Logger logger = Logger.getLogger(Otp2fa.class);
	
	@FindBy(xpath = "html/body/div[2]/div/div[2]/div[1]/form/fieldset/div[2]/input")
	public WebElement senCode;
	
	@FindBy(xpath = "html/body/div[2]/div/div[2]/div[1]/form/fieldset/div[3]/input")
    public WebElement pwdTextBox;
	
	@FindBy(xpath = "html/body/div[2]/div/div[2]/div[1]/form/fieldset/div[4]/input[1]")
    public WebElement submit;
	
	public String oSCiWindow;
	
	public String  sendOtpToEmail()	{
		PageFactory.initElements(Browser.eDriver, this);
		
		//SeleniumUtils.click(senCode);
		String oSCiWindow = Browser.eDriver.getWindowHandle();
		logger.info("OSCi_window :::::" + oSCiWindow);
		this.oSCiWindow = oSCiWindow;
		SeleniumUtils.mouseClick(senCode);
		return oSCiWindow;
				
		
	}
	public void typeOtp2fapwd(String str)	{
		PageFactory.initElements(Browser.eDriver, this);
		
		String oSCiWindow = Browser.eDriver.getWindowHandle();
		logger.info("OSCi_window :::::" + oSCiWindow);
		Browser.eDriver.switchTo().window(oSCiWindow);
		
		//EmailClient acess = new EmailClient();
		
		SeleniumUtils.type(pwdTextBox, str);
		SeleniumUtils.click(submit);
		Synchronizer.explicitWait(10);
		Boolean sdsdd = SeleniumUtils.isTextPresent("Community Home");
		logger.info("Community Home Page Title Verified and User is able to scucceefully logged in with 2FA credentials:::::"+ sdsdd);
		
	}
	

}
