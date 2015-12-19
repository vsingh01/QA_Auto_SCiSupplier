package com.primerevenue.osci.pageobjects.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Iterables;
import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;

/**
 * @author Sai Amuluru;
 *
 **/

public class SCiSupplierFIMenu {

	final static Logger logger = Logger.getLogger(SCiSupplierFIMenu.class);

	@FindBy(id = "dashboard-toggle")
	public WebElement userMenu;

	@FindBy(xpath = "//a[contains(text(),'Trading Desk')]")
	public WebElement tradingDesk;

	@FindBy(xpath = "//a[contains(text(),'Trade History')]")
	public WebElement tradeHistory;

	@FindBy(xpath = "//a[contains(text(),'Settlement History')]")
	public WebElement settleHistory;

	@FindBy(xpath = "//a[contains(text(),'Portfolio Manager')]")
	public WebElement portfolioManager;

	@FindBy(xpath = "//a[contains(text(),'Available Portfolios')]")
	public WebElement availablePortfolios;

	@FindBy(xpath = "//a[contains(text(),'Active Portfolios')]")
	public WebElement activePortfolios;

	@FindBy(id = "dateOption")
	public WebElement dateValue;

	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	public WebElement reports;

	@FindBy(xpath = "//a[contains(text(),'Remittance Advice Outbound')]")
	public WebElement remitAdvOutboundReport;

	@FindBy(xpath = "//a[contains(text(),'Payment Obligation Notification Report')]")
	public WebElement poNotificationReport;

	@FindBy(xpath = "//a[contains(text(),'Summary Booking Report')]")
	public WebElement sumBookingReport;

	// Titles

	@FindBy(xpath = "//div[text()='Trade History']")
	public WebElement tradeHistoryPageTitle;

	@FindBy(xpath = "//div[text()='Settlement History']")
	public WebElement settledHistoryPageTitle;

	@FindBy(xpath = "//div[text()='Available Portfolios']")
	public WebElement availPortPageTitle;

	@FindBy(xpath = "//div[text()='Active Portfolios']")
	public WebElement activPortpageTile;

	@FindBy(xpath = "//div[text()='Track Documents']")
	public WebElement trackDocPageTitle;

	// ...........................

	@FindBy(xpath = "//a[contains(text(),'Track Documents')]")
	public WebElement trackDocuments;

	@FindBy(id = "currencyCode")
	public WebElement currencyCode;

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	public WebElement search;
	
	@FindBy(xpath = "//a[contains(text(),'Buy Offers')]")
	public WebElement buyOffer;
	
	@FindBy(id = "documentType")
	public WebElement documentType;
	
	

	public void menuToAvailablePortfolios() {
		PageFactory.initElements(Browser.eDriver, this);
		Boolean spTitle = SeleniumUtils
				.isTextPresent("Financial Institution Home");
		logger.info("Financial Institution Home Title verified : : :"
				+ spTitle);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(portfolioManager);
		SeleniumUtils.click(availablePortfolios);
		SeleniumUtils.isTextPresent("Available Portfolios");

	}

	public void verifyFIPages() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(portfolioManager);
		SeleniumUtils.click(availablePortfolios);
		SeleniumUtils.isTextPresent("Available Portfolios");

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(activePortfolios);
		SeleniumUtils.isTextPresent("Active Portfolios");

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(trackDocuments);
		SeleniumUtils.isTextPresent("Track Documents");
		SeleniumUtils.selectOption(dateValue, "This Year");
		SeleniumUtils.selectOption(currencyCode, "USD");
		SeleniumUtils.click(search);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(tradingDesk);
		SeleniumUtils.click(tradeHistory);
		SeleniumUtils.isTextPresent("Trade History");

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(settleHistory);
		SeleniumUtils.isTextPresent("Settlement History");

	}

	public void menuToTradeDeskSub() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(tradingDesk);
		SeleniumUtils.click(tradeHistory);
		SeleniumUtils.isTextPresent("Trade History");

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(settleHistory);
		SeleniumUtils.isTextPresent("Settlement History");

	}

	public void menuToFIremitAdvOutboundReport() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(reports);
		SeleniumUtils.click(remitAdvOutboundReport);

	}

	public void menuToFIpoNotificationReport() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(poNotificationReport);

	}

	public void menuToFISummBookReport() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(sumBookingReport);

	}
	public void menuToFIBuyOffer() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(tradingDesk);
		SeleniumUtils.click(buyOffer);
			
	}
	public void menuToFITrackDocumentsAndSearchBP() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(trackDocuments);
		SeleniumUtils.isTextPresent("Track Documents");
		SeleniumUtils.selectOption(documentType, "EFT Statements");
		SeleniumUtils.selectOption(currencyCode, "USD");
		SeleniumUtils.click(search);
	}
}

