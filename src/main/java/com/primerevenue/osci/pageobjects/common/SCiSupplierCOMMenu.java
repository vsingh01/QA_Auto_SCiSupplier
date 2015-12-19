package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

public class SCiSupplierCOMMenu {

	final static Logger logger = Logger.getLogger(SCiSupplierCOMMenu.class);

	@FindBy(id = "dashboard-toggle")
	public WebElement userMenu;

	@FindBy(id = "watAdministration")
	public WebElement admin;

	@FindBy(id = "watListUsers")
	public WebElement users;

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
	
	//		Edit FI / Buyer / Currency Configuration page
	
	@FindBy(xpath = "//table[@id='rowBuyerPerformance']/tbody/tr[3]/td[3]/a")
	public WebElement targetCreditCapAmountLink;
	
	@FindBy(id = "targetCreditCapacity")
	public WebElement targetCreditCapacity;
	
	@FindBy(xpath = "//a[contains(text(),'Save')]")
	public WebElement save;
	
	@FindBy(xpath = "//a[contains(text(),'Buy Offer Manual Distribution')]")
	public WebElement bOManDistribution;
	
	
	// Target Credit Capacity
	
	
	public void resetTargetCreditCapacity() {

		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.click(targetCreditCapAmountLink);

		/*//Buyer Name or First name
		//html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/div[2]/table/tbody/tr[1]/td[1]/a
		//html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[1]/a
		//html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/div[2]/table/tbody/tr[3]/td[1]/a	
		
		String xpath_Start = ("html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/div[2]/table/tbody/tr[");
		String xpath_End = ("]/td[1]/a");
		int i=1;
		
		while(SeleniumUtils.isElementPresent(xpath_Start+i+xpath_End)) {
		String buyerName = Browser.eDriver.findElement(By.xpath(xpath_Start+i+xpath_End)).getText();
		if(buyerName.equalsIgnoreCase("rktbuyer2")) {
			logger.info("Buyer Name Found : : : : :" + buyerName);
			
			//Browser.eDriver.findElement(By.xpath(xpath_Start+i+xpath_End)).click();
		
		// Check for Target Credit Capacity 
		//html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/div[2]/table/tbody/tr[1]/td[3]/a
		//html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[3]/a
		//html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/div[2]/table/tbody/tr[3]/td[3]/a
				
		
		String buyerProgramView = Browser.eDriver.findElement(By.xpath(xpath_Start+i+xpath_End.replace("td[1]","td[3]"))).getText();
		
		if (buyerProgramView.equalsIgnoreCase("View")) {
			logger.info("Buyer Program Found : : : : :" + buyerProgramView);
			Browser.eDriver.findElement(By.xpath(xpath_Start+i+xpath_End.replace("td[1]","td[3]"))).click();
			break;
		}
		
		}
		i++; 
	
		}*/
		
		SeleniumUtils.type(targetCreditCapacity, "1000000000000.00");
		SeleniumUtils.click(save);
		
	}
	
	

	public void menuToUsers() {
		PageFactory.initElements(Browser.eDriver, this);
		Synchronizer.waitUntilDisplayed(userMenu, 5);

		Boolean spTitle = SeleniumUtils.isTextPresent("Community Home");
		logger.info("Community Home Title verified : : :"
				+ spTitle);

		try {
			SeleniumUtils.click(userMenu);
			logger.debug("Successful, User Menu click.");
		} catch (Exception e) {
			logger.error("Failed, User Menu click");
		}
		Synchronizer.implicitWait(5);
		try {
			SeleniumUtils.click(admin);
			logger.debug("Successful, Administration click.");
		} catch (Exception e) {
			logger.error("Failed, Administration click");
		}
		Synchronizer.implicitWait(5);
		try {
			SeleniumUtils.click(users);
			logger.debug("Successful, Users click.");
		} catch (Exception e) {
			logger.error("Failed, Users click");
		}
	}

	public void menuToPendingBuyerProgram() {
		PageFactory.initElements(Browser.eDriver, this);

		try {
			SeleniumUtils.click(userMenu);
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

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(reports);
		SeleniumUtils.click(suppActivityReports);

	}

	public void menuToCOMbuyerMaturepayForcastReport() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(buyerMaturepayForcastReport);

	}
	public void menuToBOManualDist() {
		PageFactory.initElements(Browser.eDriver, this);

		try {
			SeleniumUtils.click(userMenu);
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
			SeleniumUtils.click(bOManDistribution);
			logger.debug("Successful, Buy Offer Manual Distribution click");
		} catch (Exception e) {
			logger.error("Failed, Buy Offer Manual Distribution  click");
		}
}
}