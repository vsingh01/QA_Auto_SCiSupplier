package com.primerevenue.osci.pageobjects.common;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.EBrowser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

public class LoginFrmTmpPwd {
	final static Logger logger = Logger.getLogger(LoginFrmTmpPwd.class);
	
	protected EmailClient tempPwd;
	
	@FindBy(xpath = ".//input[@type='text']")
    public WebElement user_name;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement signIn;
    
    @FindBy(id = "watLogout")
	public WebElement logout;
    
    @FindBy(xpath = "//a[contains(text(),'Return to Login page')]")
	public WebElement goToLoginLink;
    
    // forgot password page
    
    @FindBy(id = "oldPassword")
	public WebElement oldPassword;
    
    @FindBy(id = "password")
	public WebElement newPassword;
    
    @FindBy(id = "passwordConfirm")
	public WebElement passwordConfirm;
    
    @FindBy(id = "changePasswordButton")
	public WebElement changePasswordButton;
    
    @FindBy(id = "agreeCheck")
   	public WebElement agreeCheck;
    
  //input[@id='agreeCheck']
    
    @FindBy(id = "proceedButton")
   	public WebElement proceedButton;
       
    
    public void loginWithNewUser(String str) throws Exception	{
    	
    	PageFactory.initElements(Browser.eDriver, this);
    	
    	
    	SeleniumUtils.click(logout);
    	    	
    	String xxx = Browser.eDriver.getTitle();
    	
    	SeleniumUtils.mouseClick(goToLoginLink);
    	
    	
    	SeleniumUtils.type(user_name, "samulu2");
    	   			
    	
    	SeleniumUtils.type(password,str);
    	SeleniumUtils.click(signIn);
    	Synchronizer.explicitWait(2);
    	
    	SeleniumUtils.type(oldPassword, str);
    	SeleniumUtils.type(newPassword, "Prime109");
    	SeleniumUtils.type(passwordConfirm, "Prime109");
    	SeleniumUtils.click(changePasswordButton);
    	
    	Synchronizer.explicitWait(5);
		Runtime.getRuntime().exec(
				"C:/jar/autoTestNewUsrLogin");
		Synchronizer.explicitWait(5);
    	SeleniumUtils.clickCheckBox(agreeCheck, "ON");
    	SeleniumUtils.click(proceedButton);
    	Synchronizer.explicitWait(10);
    	Boolean spTitle = SeleniumUtils.isTextPresent("Supplier Home");
		logger.info("Supplier Home Title verified : : :"
				+ spTitle);
    }

}

 

