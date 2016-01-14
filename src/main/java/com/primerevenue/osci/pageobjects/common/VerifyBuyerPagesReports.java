package com.primerevenue.osci.pageobjects.common;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class VerifyBuyerPagesReports {

	final static Logger logger = Logger
			.getLogger(VerifyBuyerPagesReports.class);

	@FindBy(xpath = "//div[text()='Payment Schedule']")
	public WebElement paymentSchePageTitle;

	@FindBy(xpath = "//div[text()='Payment History']")
	public WebElement paymentHistoryPageTitle;

	@FindBy(xpath = "//div[text()='Set Maturing Calendar']")
	public WebElement setMatureCalPageTitle;

	@FindBy(id = "dateOption")
	public WebElement dateValue;

	@FindBy(xpath = "//a[contains(@href, 'javascript: submitTrackDocSearch();')]")
	public WebElement search;

	@FindBy(xpath = "//div[text()='Payment Obligation Search Results']")
	public WebElement poSearchResultsPageTitle;

	@FindBy(xpath = "//div[text()='View Rejected Documents']")
	public WebElement viewRejctedDocPageTitle;

	@FindBy(xpath = "//div[text()='Load Confirmations']")
	public WebElement loadConfirmPageTitle;

	@FindBy(xpath = "//a[contains(text(),'Run')]")
	public WebElement run;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]")
	public WebElement fbMainContainer;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[11]")
	public WebElement endOfDayReportTitle;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[11]")
	public WebElement tradeDetailsReportTitle;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[110]")
	public WebElement supplierTradTrendReportTitle;

	public void paymentSchedulePage() {
		PageFactory.initElements(Browser.eDriver, this);
		boolean display1 = SeleniumUtils.isTextPresent("Payment Schedule");
		logger.info("Payment Schedule page title verified: : : "
				+ display1);
	}

	public void paymentHistoryPage() {
		PageFactory.initElements(Browser.eDriver, this);
		boolean display2 = SeleniumUtils.isTextPresent("Payment History");
		logger.info("Payment History page title verified: : : :"
				+ display2);
	}

	public void matureCalendarPage() {
		PageFactory.initElements(Browser.eDriver, this);
		boolean display3 = SeleniumUtils.isTextPresent("Set Maturing Calendar");
		logger.info("setMatureCalPageTitle verified: : :" + display3);
	}

	public void payObligationSerachResultsPage() {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.selectOption(dateValue, "Last Year");
		SeleniumUtils.click(search);
		boolean display4 = SeleniumUtils
				.isTextPresent("Payment Obligation Search Results");
		System.out
				.println("Payment Obligator serach results page title verified: : : :"
						+ display4);
	}

	public void viewRejectedPage() {
		PageFactory.initElements(Browser.eDriver, this);
		boolean display5 = SeleniumUtils
				.isTextPresent("View Rejected Documents");
		logger.info("View Rejected Document page title verified: : : "
				+ display5);
	}

	public void loadConfirmationPage() {
		PageFactory.initElements(Browser.eDriver, this);
		boolean display6 = SeleniumUtils.isTextPresent("Load Confirmations");
		logger.info("Load confirmation page title verified: : :"
				+ display6);
	}

	public void endOfDayReportGen() {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.selectOption(dateValue, "Last Year");
		SeleniumUtils.click(run);
		SeleniumUtils.switchToNewWindow(fbMainContainer, endOfDayReportTitle);
		boolean title = SeleniumUtils
				.isTextPresent("End of Day Funding Report");
		logger.info("End of Day Funding Report Title verified: : :"
				+ title);
	}

	public void tradeDetailsReportGen() throws Exception {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.selectOption(dateValue, "Last Year");
		SeleniumUtils.click(run);
		Synchronizer.explicitWait(5);
		Runtime.getRuntime().exec(
				"C:/jar/autoTestBuyerMod.exe");
		Synchronizer.explicitWait(10);
		PDFManager pdfManager = new PDFManager();
		pdfManager.setFilePath();
		Synchronizer.explicitWait(10);
		logger.info(pdfManager.ToText());
		Synchronizer.explicitWait(5);
		String username = System.getProperty("user.name");
		SeleniumUtils.deleteFile("C:/Users/"+username+"/Downloads", "PDF");
		

	}

	public void supplierTradTrendReportsGen() throws Exception {
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.selectOption(dateValue, "Last Year");
		SeleniumUtils.click(run);
		Synchronizer.explicitWait(10);
		Runtime.getRuntime().exec(
				"C:/jar/autoTestBuyerMod.exe");
		Synchronizer.explicitWait(5);
		PDFManager pdfManager = new PDFManager();
		pdfManager.setFilePath();
		Synchronizer.explicitWait(8);
		logger.info(pdfManager.ToText());
		Synchronizer.explicitWait(5);
		String username = System.getProperty("user.name");
		SeleniumUtils.deleteFile("C:/Users/"+username+"/Downloads", "PDF");

	}
}
