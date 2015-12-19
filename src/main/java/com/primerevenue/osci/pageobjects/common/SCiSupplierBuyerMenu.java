package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;

/**
 * @author Sai Amuluru;
 *
 **/

public class SCiSupplierBuyerMenu {

	final static Logger logger = Logger.getLogger(SCiSupplierBuyerMenu.class);

	@FindBy(id = "dashboard-toggle")
	public WebElement userMenu;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement home;

	@FindBy(xpath = "//a[contains(text(),'Payments')]")
	public WebElement payments;

	@FindBy(xpath = "//a[contains(text(),'Payment Schedule')]")
	public WebElement paymentsSchedule;

	@FindBy(xpath = "//a[contains(text(),'Payment History')]")
	public WebElement paymentHistory;

	@FindBy(xpath = "//a[contains(text(),'Buyer Pgm Mgmt')]")
	public WebElement buerPgmMgmt;

	@FindBy(xpath = "//a[contains(text(),'Track Documents')]")
	public WebElement trackDocment;

	@FindBy(xpath = "//a[contains(text(),'Set Maturing Calendar')]")
	public WebElement setMaturingCalendar;

	@FindBy(xpath = "//a[contains(text(),'View Rejected Documents')]")
	public WebElement viewRejDocument;

	@FindBy(xpath = "//a[contains(text(),'Load Confirmations')]")
	public WebElement loadConfirmation;
	
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	public WebElement reports;
	
	@FindBy(xpath = "//a[contains(text(),'End Of Day Funding Report')]")
	public WebElement endOfDayFundingReport;
	
	@FindBy(xpath = "//a[contains(text(),'Trade Details Report')]")
	public WebElement tradeDetailsReport;
	
	@FindBy(xpath = "//a[contains(text(),'Supplier Trading Trends Report')]")
	public WebElement supplierTradTrendReport;
	
	@FindBy(xpath = "//div[text()='Buyer Home']")
	public WebElement titleText;

	public void menuToPaySchedule() {

		PageFactory.initElements(Browser.eDriver, this);
		Boolean spTitle = SeleniumUtils.isTextPresent("Buyer Home");
		logger.info("Buyer Home Title verified : : :"
				+ spTitle);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(payments);
		SeleniumUtils.click(paymentsSchedule);
	}

	public void menuToPaysHistory() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(paymentHistory);

	}

	public void menuToSetMaturingCalendar() {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.scrollInFocus(userMenu);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(buerPgmMgmt);
		SeleniumUtils.click(setMaturingCalendar);

	}

	public void menuToTrackDocuments() {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(trackDocment);

	}

	public void menuToViewRejDocuments() {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(buerPgmMgmt);
		SeleniumUtils.click(viewRejDocument);

	}

	public void menuToLoadConfirmations() {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(loadConfirmation);

	}
	public void menuToEndOfDayReports() {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(reports);
		SeleniumUtils.click(endOfDayFundingReport);

	}
	public void menuToTradeDetailReports() {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(tradeDetailsReport);
	}
	public void menuToSupplierTradTrendReports() {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(supplierTradTrendReport);
	}
}
	
