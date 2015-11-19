package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
/**
 * @author Sai Amuluru;
 *
 **/

public class SuppModePageNavigations {

	final static Logger logger = Logger
			.getLogger(SuppModePageNavigations.class);

	@FindBy(xpath = "//div[text()='Sell Offer History']")
	public WebElement titleSellerOfferPage;

	@FindBy(xpath = "//div[text()='Payment Obligation & Credit Memo History']")
	public WebElement titlePOCMPage;

	@FindBy(xpath = "//div[text()='Trade History']")
	public WebElement titleTradHistPage;
	
	@FindBy(xpath = "//div[text()='Track Documents']")
	public WebElement titleTrackDocPage;

	public void verifySellOfferPage() {
		PageFactory.initElements(Browser.eDriver, this);

		try {
			boolean title1 = SeleniumUtils.isTextPresent("Sell Offer History");
			logger.debug("Successful, Sell Offer History title verified.: : :"+ title1);
		} catch (Exception e) {
			logger.error("Failed, Sell Offer History title verified.");

		}
	}

	public void verifyPOCMPage() {
		PageFactory.initElements(Browser.eDriver, this);
		try {
			boolean title2 = SeleniumUtils
					.isTextPresent("Payment Obligation & Credit Memo History");
			logger.debug("Successful, Payment Obligation & Credit Memo History title verified."
					+ title2);
		} catch (Exception e) {
			logger.error("Failed, Payment Obligation & Credit Memo History title verified.");
		}
	}

	public void verifyTradeHisMPage() {
		PageFactory.initElements(Browser.eDriver, this);
		try {
			boolean title3 = SeleniumUtils.isTextPresent("Trade History");
			logger.debug("Successful, Trade History title verified."+ title3);
		} catch (Exception e) {
			logger.error("Failed, Trade History title verified.");
		}
	}
	public void verifyTrackDocumentMPage() {
		PageFactory.initElements(Browser.eDriver, this);
		try {
			boolean title4 = SeleniumUtils.isTextPresent("Track Documents");
			logger.debug("Successful, Track Documents title verified."+ title4);
		} catch (Exception e) {
			logger.error("Failed, Track Documents title verified.");
		}
	}
}