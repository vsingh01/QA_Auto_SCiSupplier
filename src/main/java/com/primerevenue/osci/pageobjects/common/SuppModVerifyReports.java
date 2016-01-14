package com.primerevenue.osci.pageobjects.common;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;
import com.thoughtworks.selenium.webdriven.commands.SelectFrame;

/**
 * @author Sai Amuluru;
 *
 **/

public class SuppModVerifyReports {

	final static Logger logger = Logger.getLogger(SuppModVerifyReports.class);

	@FindBy(id = "forecastType")
	public WebElement forecastType;

	@FindBy(xpath = "//a[contains(text(),'Run')]")
	public WebElement run;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]")
	public WebElement fbMainContainer;

	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[13]")
	public WebElement poafRepoTitle;
	
	//Remittance Report Page
	@FindBy(id = "bankAccountId")
	public WebElement bankAccountId;
	
	@FindBy(id = "dateOption")
	public WebElement dateOption;
	
	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[15]")
	public WebElement remAdvRepoTitle;
	
	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[13]")
	public WebElement poRepoTitle;
	
	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[13]")
	public WebElement creditMemoRepoTitle;
	
	
	//Tax Report page
	@FindBy(id = "reportingMonthId")
	public WebElement reportingMonthId;
	
	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[1]")
	public WebElement taxInvoiceReprt;
	
	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[14]")
	public WebElement poNotificationReprt;

	public void generatePOAF() {
		PageFactory.initElements(Browser.eDriver, this);
		//SeleniumUtils.click(forecastType);
		SeleniumUtils.selectOption(forecastType, "Weekly / Monthly Forecast");
		Synchronizer.implicitWait(10);
		SeleniumUtils.click(run);
		Synchronizer.implicitWait(10);
		SeleniumUtils.switchToNewWindow(fbMainContainer, poafRepoTitle);
		boolean title = SeleniumUtils.isTextPresent("Payment Obligation Aged Forecast");
		logger.info("Payment Obligation Aged Forecast Report Title verified: : :"+ title);
		
	}
	public void remAdviceReport() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.selectOption(bankAccountId, "  RKTsup2_bank  ");
		SeleniumUtils.selectOption(dateOption, "Last Year");
		SeleniumUtils.click(run);
		Synchronizer.implicitWait(10);
		SeleniumUtils.switchToNewWindow(fbMainContainer, remAdvRepoTitle);
		boolean title = SeleniumUtils.isTextPresent("Remittance Advice Report");
		logger.info("Remittance Advice Report Title verified: : :"+ title);
			
	}
	public void poReport() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.selectOption(dateOption, "Last Year");
		SeleniumUtils.click(run);
		Synchronizer.implicitWait(10);
		SeleniumUtils.switchToNewWindow(fbMainContainer, poRepoTitle);
		boolean title = SeleniumUtils.isTextPresent("Payments Obligation Report");
		logger.info("Payments Obligation Report Title verified: : :"+ title);
		
	}	
	public void creditMemoReport() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.selectOption(dateOption, "Last Year");
		SeleniumUtils.click(run);
		Synchronizer.implicitWait(10);
		SeleniumUtils.switchToNewWindow(fbMainContainer, creditMemoRepoTitle);
		boolean title = SeleniumUtils.isTextPresent("Credit Memo Report");
		logger.info("Credit Memo Report Title verified: : :"+ title);
		
	}
	public void taxReport() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.selectOption(reportingMonthId, "January");
		SeleniumUtils.click(run);
		Synchronizer.implicitWait(10);
		SeleniumUtils.switchToNewWindow(fbMainContainer, taxInvoiceReprt);
		boolean title = SeleniumUtils.isTextPresent("Tax Report");
		logger.info("Tax Report Title verified: : :"+ title);
		
	}
	public void poNotificationReport() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.selectOption(dateOption, "Last Year");
		SeleniumUtils.click(run);
		Synchronizer.implicitWait(10);
		SeleniumUtils.switchToNewWindow(fbMainContainer, poNotificationReprt);
		boolean title = SeleniumUtils.isTextPresent("Payment Obligation Notification Report");
		logger.info("Payment Obligation Notification Report Title verified: : :"+ title);
		
	}
}
