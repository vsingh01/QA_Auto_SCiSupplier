package com.primerevenue.osci.pageobjects.common;

import java.io.IOException;

import org.apache.log4j.Logger;
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

	// Buyer Program Details page

	@FindBy(id = "_addFISubmit")
	public WebElement addFISubmit;

	// Buyer Program Add - FI page

	@FindBy(xpath = "html/body/div[1]/div/div/div/div/table[4]/tbody/tr/td[2]/table[2]/tbody/tr/td/form/table/tbody/tr[2]/td[1]/input")
	public WebElement checkBoxFIValue;

	@FindBy(id = "_acceptFISubmit")
	public WebElement acceptFISubmit;

	@FindBy(xpath = "//a[contains(text(),'RktFI')]")
	public WebElement fIName;

	@FindBy(name = "selectedBuyerProgram")
	public WebElement chkBox;

	// Reports

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

		SeleniumUtils.typeText(contactPerson, "Sai");
		SeleniumUtils.typeText(phone, "6785927880");
		SeleniumUtils.typeText(email, "primerevenueqa@hotmail.com");
		SeleniumUtils.click(next);

		SeleniumUtils.type(supplierTransactionFee, "2000");
		SeleniumUtils.type(fiTransactionFee, "1000");
		SeleniumUtils.click(next1);

		SeleniumUtils.click(saveAndCont);

		SeleniumUtils.click(addFISubmit);
		Synchronizer.explicitWait(5);

		SeleniumUtils.clickCheckBox(checkBoxFIValue, "ON");

		SeleniumUtils.isTextPresent("RktFI");

		SeleniumUtils.click(acceptFISubmit);

	}

	public void supplierActivityReport() throws Exception {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.selectOption(dateValue, "This Year");
		SeleniumUtils.click(run);
		Synchronizer.explicitWait(5);
		SeleniumUtils.switchToNewWindow(fbMainContainer,
				supplierActivityReportTitle);
		boolean title = SeleniumUtils.isTextPresent("Supplier Activity Report");
		System.out.println("Supplier Activity Report Title verified: : :"+ title);
	}

	public void buyerMaturePayForcastReport() throws Exception {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(run);
		Synchronizer.explicitWait(5);
		Runtime.getRuntime().exec(
				"C:/Users/samuluru/Documents/AutoIt/autoTest.exe");
		Synchronizer.explicitWait(5);
		PDFManager pdfManager = new PDFManager();
		pdfManager.setFilePath();
		System.out.println(pdfManager.ToText());
		pdfManager.setFilePath();

	}

}
