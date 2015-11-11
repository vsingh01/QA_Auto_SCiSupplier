package com.primerevenue.osci.pageobjects.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Iterables;
import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;

public class FIAddBuyerProgram {

	final static Logger logger = Logger.getLogger(FIAddBuyerProgram.class);

	// on Available Portfolios page

	@FindBy(xpath = "html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/form/table[2]/tbody/tr/td[1]/a")
	public List<WebElement> addLinks;

	@FindBy(xpath = "(//a[contains(text(),'Add')])[5]")
	public WebElement addBtn;

	// Edit Program page

	@FindBy(id = "_settlmentBankAccountId")
	public WebElement settlmentBankAccountId;

	@FindBy(id = "_clearingBankAccountId")
	public WebElement clearingBankAccountId;

	@FindBy(xpath = "(//input[@name='autoAccept'])[2]")
	public WebElement autoAcceptRadio;

	@FindBy(xpath = "//a[contains(text(),'Save')]")
	public WebElement saveBtn;

	@FindBy(xpath = "//a[contains(text(),'Submit')]")
	public WebElement submitBtn;
	
	@FindBy(id = "dateOption")
	public WebElement dateValue;
	
	@FindBy(id = "currencyCode")
	public WebElement currencyCode;
	
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
		System.out.println(addcount);
		WebElement lastElement = Iterables.getLast(addLinks);
		String sssaaaa = lastElement.getText();
		System.out.println(sssaaaa);
		SeleniumUtils.click(lastElement);

		SeleniumUtils.selectOption(settlmentBankAccountId, "RktFI_Bank");
		SeleniumUtils.selectOption(clearingBankAccountId, "RktFI_Bank");
		SeleniumUtils.clickCheckBox(autoAcceptRadio, "ON");
		SeleniumUtils.click(saveBtn);

		SeleniumUtils.click(submitBtn);

	}

	public void fIPONotifReprots() {
		
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.selectOption(dateValue, "This Year");
		SeleniumUtils.selectOption(currencyCode, "USD");
		SeleniumUtils.click(run);
		SeleniumUtils.switchToNewWindow(fbMainContainer, payObligNotificReportTitle);
		
		
		
		
	}
public void fIRenmitAdvOutboundReprots() {
		
		PageFactory.initElements(Browser.eDriver, this);
		SeleniumUtils.selectOption(dateValue, "This Year");
		SeleniumUtils.selectOption(currencyCode, "USD");
		SeleniumUtils.click(run);
		SeleniumUtils.switchToNewWindow(fbMainContainer, remitAdviceOutboundReportTitle);
		
		
		
		
	}
public void fISummaryBookingReprots() {
	
	PageFactory.initElements(Browser.eDriver, this);
	SeleniumUtils.selectOption(dateValue, "This Year");
	SeleniumUtils.selectOption(currencyCode, "USD");
	SeleniumUtils.click(run);
	SeleniumUtils.switchToNewWindow(fbMainContainer, summaryBookingReportTitle);
	
	
	
	
}
}
