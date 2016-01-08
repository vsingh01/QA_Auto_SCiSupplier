package com.primerevenue.osci.pageobjects.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Iterables;
import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class FIAddBuyerProgram {

	final static Logger logger = Logger.getLogger(FIAddBuyerProgram.class);

	// on Available Portfolios page

	@FindBy(xpath = "html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/form/table[2]/tbody/tr/td[8]/a")
	public List<WebElement> addLinks;

	@FindBy(xpath = "(//a[contains(text(),'Add')])[5]")
	public WebElement addBtn;

	// Edit Program page

	@FindBy(id = "_settlmentBankAccountId")
	public WebElement settlmentBankAccountId;

	@FindBy(id = "_clearingBankAccountId")
	public WebElement clearingBankAccountId;

	@FindBy(xpath = "(//input[@name='autoAccept'])[2]")
	public WebElement autoAcceptOffRadio;

	@FindBy(xpath = "//a[contains(text(),'Save')]")
	public WebElement saveBtn;

	@FindBy(xpath = "//a[contains(text(),'Submit')]")
	public WebElement submitBtn;

	@FindBy(id = "dateOption")
	public WebElement dateValue;

	@FindBy(id = "currencyCode")
	public WebElement rmcurrencyCode;

	@FindBy(id = "currencyCodeId")
	public WebElement pocurrencyCode;

	@FindBy(xpath = "//a[contains(text(),'Run')]")
	public WebElement run;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]")
	public WebElement fbMainContainer;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[170]")
	public WebElement remitAdviceOutboundReportTitle;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[122]")
	public WebElement payObligNotificReportTitle;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[184]")
	public WebElement summaryBookingReportTitle;

	public void fIAddBP() {
		PageFactory.initElements(Browser.eDriver, this);
		int addcount = addLinks.size();
		logger.info(addcount);
		WebElement lastElement = Iterables.getLast(addLinks);
		String sssaaaa = lastElement.getText();
		logger.info(sssaaaa);
		SeleniumUtils.click(lastElement);

		SeleniumUtils.selectOption(settlmentBankAccountId, "rohficom103_bank");
		SeleniumUtils.selectOption(clearingBankAccountId, "rohficom103_bank");

		boolean radio1 = autoAcceptOffRadio.isSelected();
		logger.info(radio1);
		if (radio1 == false) {
			logger.info("Auto Accept radion button by defalut not selected - valadiation passed");
		}
		SeleniumUtils.click(autoAcceptOffRadio);
		Synchronizer.explicitWait(5);
		SeleniumUtils.click(saveBtn);

		SeleniumUtils.click(submitBtn);

	}

	public void fIPONotifReprots() throws Exception {

		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.selectOption(dateValue, "This Year");
		SeleniumUtils.selectOption(pocurrencyCode, "USD");
		SeleniumUtils.click(run);
		Synchronizer.explicitWait(10);
		/*
		 * Runtime.getRuntime().exec( "C:/jar/autoTest.exe");
		 */
		Synchronizer.explicitWait(5);
		PDFManager pdfManager = new PDFManager();
		pdfManager.setFilePath();
		Synchronizer.explicitWait(8);
		logger.info(pdfManager.ToText());
		Synchronizer.explicitWait(5);
		String username = System.getProperty("user.name");
		SeleniumUtils.deleteFile("C:/Users/" + username + "/Downloads", "PDF");

	}

	public void fIRenmitAdvOutboundReprots() throws AWTException, Exception {

		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.selectOption(dateValue, "This Year");
		SeleniumUtils.selectOption(rmcurrencyCode, "USD");

		SeleniumUtils.click(run);
		Synchronizer.explicitWait(10);
		/*
		 * Runtime.getRuntime().exec( "C:/jar/autoTest.exe");
		 */
		Synchronizer.explicitWait(5);
		PDFManager pdfManager = new PDFManager();
		pdfManager.setFilePath();
		Synchronizer.explicitWait(8);
		logger.info(pdfManager.ToText());
		Synchronizer.explicitWait(5);
		String username = System.getProperty("user.name");
		SeleniumUtils.deleteFile("C:/Users/" + username + "/Downloads", "PDF");

	}

	public void fISummaryBookingReprots() throws Exception {

		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.selectOption(dateValue, "This Year");
		SeleniumUtils.selectOption(pocurrencyCode, "USD");
		SeleniumUtils.click(run);
		Synchronizer.explicitWait(10);
		/*
		 * Runtime.getRuntime().exec(
		 * "C:/Users/samuluru/Documents/AutoIt/autoTest.exe");
		 */
		Synchronizer.explicitWait(5);
		PDFManager pdfManager = new PDFManager();
		pdfManager.setFilePath();
		Synchronizer.explicitWait(8);
		logger.info(pdfManager.ToText());
		Synchronizer.explicitWait(5);
		String username = System.getProperty("user.name");
		SeleniumUtils.deleteFile("C:/Users/" + username + "/Downloads", "PDF");

	}

	public void fIAddBPAuto() {
		PageFactory.initElements(Browser.eDriver, this);
		int addcount = addLinks.size();
		logger.info(addcount);
		WebElement lastElement = Iterables.getLast(addLinks);
		String sssaaaa = lastElement.getText();
		logger.info(sssaaaa);
		SeleniumUtils.click(lastElement);

		SeleniumUtils.selectOption(settlmentBankAccountId, "rohficom103_bank");
		SeleniumUtils.selectOption(clearingBankAccountId, "rohficom103_bank");
		Synchronizer.explicitWait(3);
		boolean radio1 = autoAcceptOffRadio.isSelected();
		logger.info(radio1);
		if (radio1 == false) {
			logger.info("Auto Accept radion button by defalut not selected - valadiation passed");
		}

		Synchronizer.explicitWait(3);
		SeleniumUtils.click(saveBtn);
		Synchronizer.explicitWait(2);
		SeleniumUtils.click(submitBtn);

	}
}
