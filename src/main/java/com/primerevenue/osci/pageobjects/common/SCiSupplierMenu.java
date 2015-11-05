package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

public class SCiSupplierMenu {

	final static Logger logger = Logger.getLogger(SCiSupplierMenu.class);

	@FindBy(id = "dashboard-toggle")
	public WebElement userMenu;

	@FindBy(id = "watCommDir")
	public WebElement comManagement;

	@FindBy(id = "watComDirectory")
	public WebElement comDir;

	/* SP Community Directory page */

	@FindBy(xpath = "//a[contains(text(),'RKTcom2')]")
	public WebElement comDirName;

	public void theMenu() {
		PageFactory.initElements(Browser.eDriver, this);
		Synchronizer.waitUntilDisplayed(userMenu, 5);

		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, User Menu click.");
		} catch (Exception e) {
			logger.error("Failed, User Menu click");
		}
		Synchronizer.implicitWait(5);
		try {
			SeleniumUtils.click(comManagement);
			logger.debug("Successful, Community Management click.");
		} catch (Exception e) {
			logger.error("Failed, Community Management click");
		}
		Synchronizer.implicitWait(5);
		try {
			SeleniumUtils.click(comDir);
			logger.debug("Successful, Community Directory click.");
		} catch (Exception e) {
			logger.error("Failed, Community Directory click");
		}
		try {
			SeleniumUtils.click(comDirName);
			logger.debug("Successful, Community Directory name link click.");
		} catch (Exception e) {
			logger.error("Failed, Community Directory name link click");
		}

	}

}
