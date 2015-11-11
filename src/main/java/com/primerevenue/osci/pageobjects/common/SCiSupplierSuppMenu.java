package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;

public class SCiSupplierSuppMenu {

	final static Logger logger = Logger.getLogger(SCiSupplierSuppMenu.class);

	@FindBy(id = "dashboard-toggle")
	public WebElement userMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement home;

	@FindBy(id = "watFunding")
	public WebElement funding;

	@FindBy(xpath = "//a[contains(text(),'Sell Offer History')]")
	public WebElement sellOfferHistory;

	@FindBy(xpath = "//a[contains(text(),'Payment Obligation & Credit Memo History')]")
	public WebElement poCmHistroy;
	
	@FindBy(xpath = "//a[contains(text(),'Trade History')]")
	public WebElement tradeHistory;
	
	@FindBy(xpath = "//a[contains(text(),'Track Documents')]")
	public WebElement trackDocument;
	
	//Menu to Reports
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	public WebElement reports;
	
	@FindBy(xpath = "//a[contains(text(),'Payment Obligation Aged Forecast')]")
	public WebElement paymentObliAgedForcast;
	
	@FindBy(xpath = "//a[contains(text(),'Remittance Advice Report')]")
	public WebElement remtAdviceReport;
	
	@FindBy(xpath = "//a[contains(text(),'Payment Obligation Report')]")
	public WebElement poReport;
	
	@FindBy(xpath = "//a[contains(text(),'Credit Memo Report')]")
	public WebElement creditMemoReport;
	
	@FindBy(xpath = "//a[contains(text(),'Tax Report')]")
	public WebElement taxReport;
	
	@FindBy(xpath = "//a[contains(text(),'Payment Obligation Notification Report')]")
	public WebElement ponReport;
	
	
	

	public void menuToSellOfferHistPage() {
		PageFactory.initElements(Browser.eDriver, this);

		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, userMenu click.");
		} catch (Exception e) {
			logger.error("Failed, userMenu click");
		}
		try {
			SeleniumUtils.click(funding);
			logger.debug("Successful, funding click.");
		} catch (Exception e) {
			logger.error("Failed, funding click");
		}
		try {
			SeleniumUtils.click(sellOfferHistory);
			logger.debug("Successful, sellOfferHistory click.");
		} catch (Exception e) {
			logger.error("Failed, sellOfferHistory click");
		}
	}

	public void menuToPOandCMHistPage() {
		PageFactory.initElements(Browser.eDriver, this);

		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, userMenu click.");
		} catch (Exception e) {
			logger.error("Failed, userMenu click");
		}
		try {
			SeleniumUtils.click(home);
			logger.debug("Successful, home click.");
		} catch (Exception e) {
			logger.error("Failed, home click");
		}
		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, userMenu click.");
		} catch (Exception e) {
			logger.error("Failed, userMenu click");
		}
		try {
			SeleniumUtils.click(funding);
			logger.debug("Successful, funding click.");
		} catch (Exception e) {
			logger.error("Failed, funding click");
		}
		try {
			SeleniumUtils.click(poCmHistroy);
			logger.debug("Successful, Payment Obligation & Credit Memo History click.");
		} catch (Exception e) {
			logger.error("Failed, Payment Obligation & Credit Memo History click");
		}

	}
	public void menuTradeHistPage() {
		PageFactory.initElements(Browser.eDriver, this);

		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, userMenu click.");
		} catch (Exception e) {
			logger.error("Failed, userMenu click");
		}
		try {
			SeleniumUtils.click(home);
			logger.debug("Successful, home click.");
		} catch (Exception e) {
			logger.error("Failed, home click");
		}
		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, userMenu click.");
		} catch (Exception e) {
			logger.error("Failed, userMenu click");
		}
		try {
			SeleniumUtils.click(funding);
			logger.debug("Successful, funding click.");
		} catch (Exception e) {
			logger.error("Failed, funding click");
		}
		try {
			SeleniumUtils.click(tradeHistory);
			logger.debug("Successful, tradeHistory click.");
		} catch (Exception e) {
			logger.error("Failed, tradeHistory click");
		}

	}
	public void menuTrackDocumentPage() {
		PageFactory.initElements(Browser.eDriver, this);

		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, userMenu click.");
		} catch (Exception e) {
			logger.error("Failed, userMenu click");
		}
		try {
			SeleniumUtils.click(trackDocument);
			logger.debug("Successful, Track Documents click.");
		} catch (Exception e) {
			logger.error("Failed, Track Documents click");
		}
		

	}
	public void menuToPOAFReport() {
		PageFactory.initElements(Browser.eDriver, this);
		
		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, userMenu click.");
		} catch (Exception e) {
			logger.error("Failed, userMenu click");
		}
		try {
			SeleniumUtils.click(reports);
			logger.debug("Successful, Reports click.");
		} catch (Exception e) {
			logger.error("Failed, Reports click");
		}
		try {
			SeleniumUtils.click(paymentObliAgedForcast);
			logger.debug("Successful, paymentObliAgedForcast click.");
		} catch (Exception e) {
			logger.error("Failed, paymentObliAgedForcast click");
		}
}
	public void menuToRemitAdvReport() {
		PageFactory.initElements(Browser.eDriver, this);
		
		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, userMenu click.");
		} catch (Exception e) {
			logger.error("Failed, userMenu click");
		}
		/*try {
			SeleniumUtils.click(reports);
			logger.debug("Successful, Reports click.");
		} catch (Exception e) {
			logger.error("Failed, Reports click");
		}*/
		try {
			SeleniumUtils.click(remtAdviceReport);
			logger.debug("Successful, remtAdviceReport click.");
		} catch (Exception e) {
			logger.error("Failed, remtAdviceReport click");
		}
}
	public void menuToPOReport()	{
PageFactory.initElements(Browser.eDriver, this);
		
		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, userMenu click.");
		} catch (Exception e) {
			logger.error("Failed, userMenu click");
		}
		/*try {
			SeleniumUtils.click(reports);
			logger.debug("Successful, Reports click.");
		} catch (Exception e) {
			logger.error("Failed, Reports click");
		}*/
		try {
			SeleniumUtils.click(poReport);
			logger.debug("Successful, poReport click.");
		} catch (Exception e) {
			logger.error("Failed, poReport click");
		}
	}
	public void menuToCreditMemoReport()	{
		PageFactory.initElements(Browser.eDriver, this);
				
				try {
					SeleniumUtils.click(userMenu);
					logger.debug("Successful, userMenu click.");
				} catch (Exception e) {
					logger.error("Failed, userMenu click");
				}
				/*try {
					SeleniumUtils.click(reports);
					logger.debug("Successful, Reports click.");
				} catch (Exception e) {
					logger.error("Failed, Reports click");
				}*/
				try {
					SeleniumUtils.click(creditMemoReport);
					logger.debug("Successful, creditMemoReport click.");
				} catch (Exception e) {
					logger.error("Failed, creditMemoReport click");
				}
			}
	public void menuToTaxReport()	{
		PageFactory.initElements(Browser.eDriver, this);
				
				try {
					SeleniumUtils.click(userMenu);
					logger.debug("Successful, userMenu click.");
				} catch (Exception e) {
					logger.error("Failed, userMenu click");
				}
				/*try {
					SeleniumUtils.click(reports);
					logger.debug("Successful, Reports click.");
				} catch (Exception e) {
					logger.error("Failed, Reports click");
				}*/
				try {
					SeleniumUtils.click(taxReport);
					logger.debug("Successful, taxReport click.");
				} catch (Exception e) {
					logger.error("Failed, taxReport click");
				}
			}
	public void menuToPONotificationReport()	{
		PageFactory.initElements(Browser.eDriver, this);
				
				try {
					SeleniumUtils.click(userMenu);
					logger.debug("Successful, userMenu click.");
				} catch (Exception e) {
					logger.error("Failed, userMenu click");
				}
				/*try {
					SeleniumUtils.click(reports);
					logger.debug("Successful, Reports click.");
				} catch (Exception e) {
					logger.error("Failed, Reports click");
				}*/
				try {
					SeleniumUtils.click(ponReport);
					logger.debug("Successful, ponReport click.");
				} catch (Exception e) {
					logger.error("Failed, ponReport click");
				}
			}
}