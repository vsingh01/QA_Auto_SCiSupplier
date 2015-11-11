package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;

public class ComAddBuyerProgram {

	final static Logger logger = Logger.getLogger(ComAddBuyerProgram.class);
	// Add Buyer Program page
	@FindBy(id = "contactPerson")
	public WebElement contactPerson;

	@FindBy(id = "phone")
	public WebElement phone;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(xpath = "//a[contains(@href, 'javascript: onNextClick();')]")
	public WebElement next;

	// Edit Buyer Program page
	@FindBy(name = "supplierTransactionFee")
	public WebElement supplierTransactionFee;

	@FindBy(name = "fiTransactionFee")
	public WebElement fiTransactionFee;

	@FindBy(xpath = "//a[contains(@href, 'javascript: onNextClick();')]")
	public WebElement next1;

	@FindBy(xpath = "//a[contains(text(),'Save And Continue')]")
	public WebElement saveAndCont;
	
	//Buyer Program Details page
	
	@FindBy(id = "_addFISubmit")
	public WebElement addFISubmit;
	
	//Buyer Program Add - FI page
	
	@FindBy(xpath = "(//input[@name='checkedFIValue'])[2]")
	public WebElement checkBoxFIValue;
	
	@FindBy(id = "_acceptFISubmit")
	public WebElement acceptFISubmit;
	
	@FindBy(xpath = "//a[contains(text(),'RktFI')]")
	public WebElement fIName;
	
	//Reports
	
	@FindBy(id = "dateOption")
	public WebElement dateValue;
	
	@FindBy(xpath = "//a[contains(text(),'Run')]")
	public WebElement run;
	
	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]")
	public WebElement fbMainContainer;
	
	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[17]")
	public WebElement supplierActivityReportTitle;
	
	@FindBy(xpath = "xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]/xhtml:div[59]")
	public WebElement maturePayForcastReportTitle;

	public void addEditBuyerProgram() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(contactPerson);
		SeleniumUtils.click(phone);
		SeleniumUtils.click(email);
		SeleniumUtils.click(next);

		SeleniumUtils.type(supplierTransactionFee, null);
		SeleniumUtils.type(fiTransactionFee, null);
		SeleniumUtils.click(next1);

		SeleniumUtils.click(saveAndCont);
		
		SeleniumUtils.click(addFISubmit);
		
		SeleniumUtils.click(checkBoxFIValue);
		
		SeleniumUtils.isTextPresent("RktFI");

	}
	public void supplierActivityReport() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.selectOption(dateValue, "This Year");
		SeleniumUtils.click(run);
		SeleniumUtils.switchToNewWindow(fbMainContainer, supplierActivityReportTitle);
	}
	public void buyerMaturePayForcastReport() {
		PageFactory.initElements(Browser.eDriver, this);
		
		//SeleniumUtils.selectOption(dateValue, "This Year");
		SeleniumUtils.click(run);
		SeleniumUtils.switchToNewWindow(fbMainContainer, maturePayForcastReportTitle);
	}
	
}
