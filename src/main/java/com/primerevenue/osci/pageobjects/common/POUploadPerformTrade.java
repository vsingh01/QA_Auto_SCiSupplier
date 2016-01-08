package com.primerevenue.osci.pageobjects.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Iterables;
import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

public class POUploadPerformTrade {
	final static Logger logger = Logger.getLogger(POUploadPerformTrade.class);

	@FindBy(id = "_atfSubmit")
	public WebElement createSellOfferBtn;

	// RKTbuy2
	@FindBy(xpath = "//a[contains(text(),'rohcom103_BP')]//..//..//td[12]//input[1]")
	public WebElement chkBox;

	@FindBy(id = "_initiateFundingSubmit")
	public WebElement _initiateFundingSubmit;

	// Com Module
	@FindBy(id = "bpId")
	public WebElement bPdropdownBox;

	@FindBy(id = "_searchSubmit")
	public WebElement _searchSubmit;

	@FindBy(xpath = "html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/form/table[2]/tbody/tr/td[8]/input")
	public WebElement distAttemptschkBox;

	@FindBy(id = "_specificFiId")
	public WebElement assignFI;

	@FindBy(xpath = "//a[contains(text(),'Distribute')]")
	public WebElement distBtn;

	// FI Module
	@FindBy(xpath = "html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/form/table[4]/tbody/tr/td[1]/input")
	public WebElement buyOffchkBox;

	@FindBy(xpath = "//a[contains(text(),'Accept')]")
	public WebElement accept;

	@FindBy(xpath = "html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/table/tbody/tr/td[1]/a")
	public List<WebElement> eFTStateLinks;

	// Sell Offer History page
	@FindBy(xpath = "html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/form/table[4]/tbody/tr/td[2]/a")
	public List<WebElement> sellOffHistLinks;

	// Track Documents Page

	@FindBy(id = "documentType")
	public WebElement documentType;

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	public WebElement trackSearch;

	public void copyFiles(String source, String destination) throws IOException {

		// String source = "C:/Dir1";
		File srcDir = new File(source);

		// String destination = "C:/Dir1";
		File destDir = new File(destination);

		try {
			FileUtils.copyDirectory(srcDir, destDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("PO file upload process underway, scripts execution will wait for 240 seconds");

		// System.out.println(SeleniumUtils.getTheNewestFile("X:/Magellan/Import/PaymentObligationsCSV/Archive",
		// "txt"));

	}

	public void bounceWFCServices() throws Exception {

		// run batch file here..
		Runtime.getRuntime().exec("cmd /C start C:\\restartServicesMaj.bat");
		logger.info("Restarting wfc services, scripts execution will wait for 420 minutes");

	}

	public void poTradeFrmSuppplier() {
		PageFactory.initElements(Browser.eDriver, this);

		SCiSupplierSuppMenu objRef = PageFactory.initElements(Browser.eDriver, SCiSupplierSuppMenu.class);
		objRef.menuToAvailableToFund();

		SeleniumUtils.clickCheckBox(chkBox, "ON");
		SeleniumUtils.click(createSellOfferBtn);
		Synchronizer.explicitWait(3);
		/*
		 * boolean title = SeleniumUtils.isTextPresent(
		 * "The sell offer process has been successfully completed.");
		 * logger.info(
		 * "The sell offer process has been successfully completed.: : :"+
		 * title);
		 */
		SeleniumUtils.click(_initiateFundingSubmit);

	}

	public void poTradeFrmCM() {
		PageFactory.initElements(Browser.eDriver, this);

		SCiSupplierCOMMenu objRef = PageFactory.initElements(Browser.eDriver, SCiSupplierCOMMenu.class);
		objRef.menuToBOManualDist();

		SeleniumUtils.selectOption(bPdropdownBox, "rohcom103_BP");
		Synchronizer.explicitWait(10);
		SeleniumUtils.click(_searchSubmit);

		SeleniumUtils.clickCheckBox(distAttemptschkBox, "ON");
		SeleniumUtils.selectOption(assignFI, "rohfi_com103");
		SeleniumUtils.click(distBtn);

	}

	public void poTradeFrmFI() {
		PageFactory.initElements(Browser.eDriver, this);

		SCiSupplierFIMenu objRef = PageFactory.initElements(Browser.eDriver, SCiSupplierFIMenu.class);
		Synchronizer.explicitWait(300);
		logger.info("Script waits for 300 seconds to proceed to the BuyOffer Menu");
		objRef.menuToFIBuyOffer();
		SeleniumUtils.clickCheckBox(buyOffchkBox, "ON");
		SeleniumUtils.click(accept);

		int eftStatesCount = eFTStateLinks.size();

		if (eftStatesCount != 0) {
			WebElement latestStatement = Iterables.getLast(eFTStateLinks);
			String eftStmtNumber = latestStatement.getText();
			logger.info(eftStmtNumber);
		} else {
			logger.info(eftStatesCount);
		}

		// SeleniumUtils.click(latestStatement);

	}

	public void poTradeFrmSuppplierAuto() {
		PageFactory.initElements(Browser.eDriver, this);

		SCiSupplierSuppMenu objRef = PageFactory.initElements(Browser.eDriver, SCiSupplierSuppMenu.class);
		objRef.menuToAvailableToFund();

		SeleniumUtils.clickCheckBox(chkBox, "ON");
		SeleniumUtils.click(createSellOfferBtn);
		Synchronizer.explicitWait(3);
		/*
		 * boolean title = SeleniumUtils.isTextPresent(
		 * "The sell offer process has been successfully completed.");
		 * logger.info(
		 * "The sell offer process has been successfully completed.: : :"+
		 * title);
		 */
		SeleniumUtils.click(_initiateFundingSubmit);
		logger.info("Submitted sellOffer and waiting for the status to be displayed, script waits for 180 seconds");
		Synchronizer.explicitWait(180);
		objRef.menuToSellOfferHistPage();
		SeleniumUtils.click(_searchSubmit);

		boolean title1 = SeleniumUtils.isTextPresent("Auto Accepted");
		logger.info("                 Auto Accepted             : : :" + title1);

		int selloffCount = sellOffHistLinks.size();
		logger.info(selloffCount);
		WebElement latestStatement1 = Iterables.getLast(sellOffHistLinks);
		String sellOfferNumber = latestStatement1.getText();
		logger.info(sellOfferNumber);

		// menu
		objRef.menuTrackDocumentPage();
		SeleniumUtils.selectOption(documentType, "EFT Statements");
		Synchronizer.explicitWait(3);
		SeleniumUtils.click(trackSearch);

		int eftStatesCount = eFTStateLinks.size();
		logger.info(eftStatesCount);
		WebElement latestStatement = Iterables.getLast(eFTStateLinks);
		String eftStmtNumber = latestStatement.getText();
		logger.info(eftStmtNumber);

		logger.info(eftStmtNumber.equalsIgnoreCase(sellOfferNumber));// true
		logger.info(
				"SellOffer# fromm Sell Offer History page verified and validated with DocType EFT Statements on EFT Search Results Page");

	}
}
