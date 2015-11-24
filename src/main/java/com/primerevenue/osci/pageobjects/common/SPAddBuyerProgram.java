package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;

/**
 * @author Sai Amuluru;
 *
 **/

public class SPAddBuyerProgram {
	final static Logger logger = Logger.getLogger(SPAddBuyerProgram.class);

	@FindBy(id = "_buyerProgramName")
	public WebElement buyerProgramName;

	@FindBy(id = "countryCode")
	public WebElement countryCode;

	@FindBy(id = "_currencyCode")
	public WebElement currencyCode;
	
	//Track Documents page currency code
	@FindBy(id = "currencyCode")
	public WebElement currencyCode1;

	@FindBy(id = "_bankAccountId")
	public WebElement bankAccountId;

	@FindBy(id = "_profileId")
	public WebElement profileId;

	@FindBy(id = "timeZoneCode")
	public WebElement timeZoneCode;

	@FindBy(id = "_tradeCalendarName")
	public WebElement tradeCalendarName;

	@FindBy(id = "_maturityCalendarName")
	public WebElement maturityCalendarName;

	@FindBy(id = "_buyOfferWindowOpen")
	public WebElement buyOfferWindowOpen;

	@FindBy(id = "_buyOfferWindowClose")
	public WebElement buyOfferWindowClose;

	@FindBy(id = "_buyOfferTotalTimeOut")
	public WebElement buyOfferTotalTimeOut;

	@FindBy(id = "_buyOfferFiTimeOut")
	public WebElement buyOfferFiTimeOut;

	@FindBy(id = "_preMatureLeadDays")
	public WebElement preMatureLeadDays;

	/* Radio Buttons */

	@FindBy(xpath = "(//input[@name='intraDayRatesUpdate'])[1]")
	public WebElement intraDayRatesUpdate1;

	@FindBy(xpath = "(//input[@name='intraDayRatesUpdate'])[2]")
	public WebElement intraDayRatesUpdate2;

	@FindBy(xpath = "(//input[@name='sendTransferNotifyBuyer'])[1]")
	public WebElement sendTransferNotifyBuyer1;

	@FindBy(xpath = "(//input[@name='sendTransferNotifyBuyer'])[2]")
	public WebElement sendTransferNotifyBuyer2;

	@FindBy(xpath = "(//input[@name='sendTransferNotifySupplier'])[1]")
	public WebElement sendTransferNotifySupplier1;

	@FindBy(xpath = "(//input[@name='sendTransferNotifySupplier'])[2]")
	public WebElement sendTransferNotifySupplier2;

	@FindBy(xpath = "(//input[@name='sendTransferNotifyFI'])[1]")
	public WebElement sendTransferNotifyFI1;

	@FindBy(xpath = "(//input[@name='sendTransferNotifyFI'])[2]")
	public WebElement sendTransferNotifyFI2;

	@FindBy(xpath = "(//input[@name='requireDynamicCode'])[1]")
	public WebElement requireDynamicCode1;

	@FindBy(xpath = "(//input[@name='requireDynamicCode'])[2]")
	public WebElement requireDynamicCode2;

	@FindBy(xpath = "(//input[@name='busDayCalcOfInt'])[1]")
	public WebElement busDayCalcOfInt1;

	@FindBy(xpath = "(//input[@name='busDayCalcOfInt'])[2]")
	public WebElement busDayCalcOfInt2;

	@FindBy(xpath = "(//input[@name='limitTradingNetPositive'])[1]")
	public WebElement limitTradingNetPositive1;

	@FindBy(xpath = "(//input[@name='limitTradingNetPositive'])[2]")
	public WebElement limitTradingNetPositive2;
	/*------------------------------------------------------------*/
	@FindBy(id = "_svcProvTransactionId")
	public WebElement svcProvTransactionId;

	@FindBy(id = "_commTransactionId")
	public WebElement commTransactionId;

	@FindBy(id = "_obligorTransactionId")
	public WebElement obligorTransactionId;

	@FindBy(id = "_supplierTradeTransactionId")
	public WebElement supplierTradeTransactionId;

	@FindBy(id = "_supplierMatureTransactionId")
	public WebElement supplierMatureTransactionId;

	@FindBy(id = "_fiTradeTransactionId")
	public WebElement fiTradeTransactionId;

	@FindBy(id = "_fiMatureTransactionId")
	public WebElement fiMatureTransactionId;

	@FindBy(id = "_gatewayId")
	public WebElement gatewayId;
	/*------------------------------------------------------------*/
	@FindBy(xpath = "//a[contains(text(),'Save')]")
	public WebElement save;

	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	public WebElement cancel;
	
	//Track Documents Page
	
	@FindBy(id = "dateOption")   
	public WebElement dateOption;
	
	@FindBy(xpath = "//a[contains(text(),'Search')]")   
	public WebElement search;
	
	//Payment Obligation Search Results page
	
	@FindBy(xpath = "//div[text()='Payment Obligation Search Results']")
	public WebElement payObligSearchResultsPageTitle;
	
	@FindBy(xpath = "//div[text()='Load Confirmations']")
	public WebElement loadConfirmPageTitle;
	
	@FindBy(xpath = "//div[text()='User Search']")
	public WebElement userSearchTitle;
	
	
	

	public void addBuyerProgram() {
		PageFactory.initElements(Browser.eDriver, this);

		/*
		 * SeleniumUtils.isTextPresent("RKTbuy2"); buyerProgramName.clear();
		 * buyerProgramName.sendKeys("RKTbuy2_BP");
		 * 
		 * SeleniumUtils.selectFromList(countryCode,
		 * "United States of America");
		 */

		try {
			SeleniumUtils.clearWithBackSpace(buyerProgramName);
			SeleniumUtils.type(buyerProgramName, "rktcommunity_BP");
			SeleniumUtils.selectOption(countryCode, "United States of America");
			SeleniumUtils.selectOption(currencyCode, "USD");
			SeleniumUtils.selectOption(bankAccountId, "Prime Revenue Ltd");
			SeleniumUtils.selectOption(profileId, "GMAC PP");
			SeleniumUtils.selectOption(timeZoneCode,
					"USA - Eastern Standard Time (New York)");
			SeleniumUtils.selectOption(tradeCalendarName,
					"US United States with Extra Holidays");
			SeleniumUtils.selectOption(maturityCalendarName,
					"US United States with Extra Holidays");
			SeleniumUtils.type(buyOfferWindowOpen, "0001");
			SeleniumUtils.type(buyOfferWindowClose, "2355");
			SeleniumUtils.type(buyOfferTotalTimeOut, "1");
			SeleniumUtils.type(buyOfferFiTimeOut, "1");
			//SeleniumUtils.type(preMatureLeadDays, "1");
			

			String preMatLedDays = preMatureLeadDays.getAttribute("value");
			logger.info(preMatLedDays);
			Assert.assertEquals("1", preMatLedDays);
			boolean radio1 = intraDayRatesUpdate1.isSelected();
			System.out.println(radio1);
			if (radio1 == false) {
				logger.info("radion button by defalut not selected - valadiation passed");
			}
			boolean radio2 = sendTransferNotifyBuyer1.isSelected();
			System.out.println(radio2);
			if (radio2 == true) {
				logger.info("radion button by defalut selected - valadiation passed");
			}
			boolean radio3 = sendTransferNotifySupplier1.isSelected();
			if (radio3 == true) {
				logger.info("radion button by defalut selected - valadiation passed");
			}
			boolean radio4 = sendTransferNotifyFI1.isSelected();
			if (radio4 == true) {
				logger.info("radion button by defalut selected - valadiation passed");
			}
			boolean radio5 = requireDynamicCode1.isSelected();
			if (radio5 == false) {

				logger.info("radion button by defalut selected - valadiation passed");
			}
			boolean radio6 = busDayCalcOfInt1.isSelected();
			if (radio6 == false) {
				logger.info("radion button by defalut selected - valadiation passed");
			}
			boolean radio7 = limitTradingNetPositive1.isSelected();
			if (radio7 == false) {

				logger.info("radion button by defalut selected - valadiation passed");
			}

			SeleniumUtils.selectOption(svcProvTransactionId,
					"SEB - SEB File - Credit");
			SeleniumUtils.selectOption(commTransactionId,
					"SEB - SEB File - Credit");
			SeleniumUtils.selectOption(obligorTransactionId,
					"SEB - SEB File - Debit");
			SeleniumUtils.selectOption(supplierTradeTransactionId,
					"SEB - SEB File - Credit");
			SeleniumUtils.selectOption(supplierMatureTransactionId,
					"SEB - SEB File - Credit");
			SeleniumUtils.selectOption(fiTradeTransactionId,
					"SEB - SEB File - Debit");
			SeleniumUtils.selectOption(fiMatureTransactionId,
					"SEB - SEB File - Credit");
			SeleniumUtils.selectOption(gatewayId, "SEB");
			
			SeleniumUtils.click(save);
			
			logger.debug("Successful, Community Buyers Tab click.");
		} catch (Exception e) {
			logger.error("Failed, Community Buyers Tab click");
		}

	}
	public void trackDocumentsSearch() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.selectOption(dateOption, "This Year");
		SeleniumUtils.selectOption(currencyCode1, "USD");
		SeleniumUtils.click(search);
		
		boolean title = SeleniumUtils.isTextPresent("Payment Obligation Search Results");
		System.out.println("Payment Obligation Search Results Title verified: : :"+ title);
	}
	public void loadConfirm() {
		PageFactory.initElements(Browser.eDriver, this);
		
		boolean title = SeleniumUtils.isTextPresent("Load Confirmations");
		System.out.println("Load Confirmations Title verified: : :"+ title);
		
	}
	public void userPwdMaintenance() {
		PageFactory.initElements(Browser.eDriver, this);
		
		boolean title = SeleniumUtils.isTextPresent("User Search");
		System.out.println("Load Confirmations Title verified: : :"+ title);
	}
}
