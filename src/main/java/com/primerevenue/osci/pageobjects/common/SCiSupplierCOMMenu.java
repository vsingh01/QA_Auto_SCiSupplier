package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

public class SCiSupplierCOMMenu {

	final static Logger logger = Logger.getLogger(SCiSupplierCOMMenu.class);

	@FindBy(id = "dashboard-toggle")
	public WebElement cmuserMenu;

	@FindBy(id = "watAdministration")
	public WebElement cmadmin;

	@FindBy(id = "watListUsers")
	public WebElement cmusers;

	@FindBy(xpath = "//a[contains(text(),'Buyer Program')]")
	public WebElement buyerProgram;

	@FindBy(xpath = "//a[contains(text(),'Pending Buyer Programs')]")
	public WebElement pendingBuyerPrograms;

	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	public WebElement reports;

	@FindBy(xpath = "//a[contains(text(),'Supplier Activity Reports')]")
	public WebElement suppActivityReports;

	@FindBy(xpath = "//a[contains(text(),'Buyer Maturing Payment Forecast')]")
	public WebElement buyerMaturepayForcastReport;

	public void theComMenu() {
		PageFactory.initElements(Browser.eDriver, this);
		Synchronizer.waitUntilDisplayed(cmuserMenu, 5);

		try {
			SeleniumUtils.click(cmuserMenu);
			logger.debug("Successful, User Menu click.");
		} catch (Exception e) {
			logger.error("Failed, User Menu click");
		}
		Synchronizer.implicitWait(5);
		try {
			SeleniumUtils.click(cmadmin);
			logger.debug("Successful, Administration click.");
		} catch (Exception e) {
			logger.error("Failed, Administration click");
		}
		Synchronizer.implicitWait(5);
		try {
			SeleniumUtils.click(cmusers);
			logger.debug("Successful, Users click.");
		} catch (Exception e) {
			logger.error("Failed, Users click");
		}
	}

	public void navigateToPendingBuyerProgram() {

		try {
			SeleniumUtils.click(cmuserMenu);
			logger.debug("Successful, User Menu click.");
		} catch (Exception e) {
			logger.error("Failed, User Menu click");
		}
		try {
			SeleniumUtils.click(buyerProgram);
			logger.debug("Successful, Buyer Program click.");
		} catch (Exception e) {
			logger.error("Failed, Buyer Program  click");
		}
		try {
			SeleniumUtils.click(pendingBuyerPrograms);
			logger.debug("Successful, Pending Buyer Program  click.");
		} catch (Exception e) {
			logger.error("Failed, Pending Buyer Program click");
		}
	}

	public void menuToCOMSuppActivityReport() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(cmuserMenu);
		SeleniumUtils.click(reports);
		SeleniumUtils.click(suppActivityReports);

	}
	public void menuToCOMbuyerMaturepayForcastReport() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(cmuserMenu);
		SeleniumUtils.click(buyerMaturepayForcastReport);

	}
}
