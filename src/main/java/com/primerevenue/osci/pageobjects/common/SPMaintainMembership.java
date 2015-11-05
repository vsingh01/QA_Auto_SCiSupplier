package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

public class SPMaintainMembership {
	
	final static Logger logger = Logger.getLogger(SPMaintainMembership.class);
	
	@FindBy(id = "communityBuyers-tab")
	public WebElement commBuyersTab;
	
	/*Buyer Name = RKTbuy2*/
	@FindBy(xpath = "//table[@id='row']/tbody/tr[3]/td[5]/a")
	public WebElement view;
	
	@FindBy(xpath = "//a[contains(@href, 'javascript: addBuyerProgram();')]")
	public WebElement addBtn;
	
	
	public void maintainMembTab() {
		
		PageFactory.initElements(Browser.eDriver, this);
		
		try {
			SeleniumUtils.click(commBuyersTab);
			logger.debug("Successful, Community Buyers Tab click.");
		} catch (Exception e) {
			logger.error("Failed, Community Buyers Tab click");
		}
		try {
			SeleniumUtils.click(view);
			logger.debug("Successful, View link click");
		} catch (Exception e) {
			logger.error("Failed, View link click ");
		}
		try {
			SeleniumUtils.click(addBtn);
			logger.debug("Successful, Add Button click");
		} catch (Exception e) {
			logger.error("Failed, Add Button click ");
		}
	}

}
