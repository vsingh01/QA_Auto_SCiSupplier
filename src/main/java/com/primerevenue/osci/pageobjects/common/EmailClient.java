package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.EBrowser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

public class EmailClient {

	final static Logger logger = Logger.getLogger(EmailClient.class);

	@FindBy(xpath = "html/body/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/ul[1]/li/ul/li[1]/span/span")
	public WebElement inbox;

	@FindBy(xpath = "html/body/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/ul/li[1]/span[2]/span[1]/div/span/span")
	public WebElement newEmail;

	@FindBy(xpath = "html/body/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/pre")
	public WebElement msgEmail;

	@FindBy(xpath = "html/body/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/pre")
	public WebElement otpMsgEmail;

	public String tempPwd;

	public String accessCode;

	public String getTempPwd() {
		PageFactory.initElements(Browser.eDriver, this);
		Synchronizer.explicitWait(30);
		try {
			SeleniumUtils.click(inbox);
		} catch (Exception e) {
			logger.error("Failed, inbox click");
		}
		try {
			SeleniumUtils.click(newEmail);
		} catch (Exception e) {
			logger.error("Failed, newEmail click");
		}

		String tempPwd;
		String msgCont = msgEmail.getText();
		int xx = msgCont.indexOf("Temporary Password:");
		logger.info("Temporary Password:::::" + xx);
		tempPwd = msgCont.substring(xx + 20, xx + 28);
		logger.info("Temporary Password>>>>>" + tempPwd);
		this.tempPwd = tempPwd;
		Browser.close();
		return tempPwd;

	}

	public void getTempPwd1() throws Exception {
		PageFactory.initElements(Browser.eDriver, this);

		LoginFrmTmpPwd obj = new LoginFrmTmpPwd();
		obj.loginWithNewUser(tempPwd);

	}

	public String getOTP() {
		PageFactory.initElements(EBrowser.eDriver, this);
		Synchronizer.explicitWait(30);
		SeleniumUtils.click(inbox);
		SeleniumUtils.click(newEmail);

		String accessCode;
		String otpmsgCont = otpMsgEmail.getText();
		int xx = otpmsgCont.indexOf("Code:");
		logger.info("Access Code:::::" + xx);
		accessCode = otpmsgCont.substring(xx + 5, xx + 11);
		logger.info("Access Code>>>>>" + accessCode);
		this.accessCode = accessCode;

		String emailWindow = EBrowser.eDriver.getWindowHandle();
		logger.info("emailwindow :::::" + emailWindow);
		EBrowser.eDriver.quit();

		return accessCode;

	}

}
