package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;

public class SPAddNewSupplier {
	final static Logger logger = Logger.getLogger(SPAddNewSupplier.class);
	
	//Add Suppplier Page
	
	@FindBy(id = "_companyName")
	public WebElement companyName;
	
	@FindBy(id = "_street1")
	public WebElement street1;
	
	@FindBy(id = "_city")
	public WebElement city;
	
	@FindBy(id = "_country")
	public WebElement country;
	
	@FindBy(id = "_state")
	public WebElement state;
	
	@FindBy(id = "_zip")
	public WebElement zip;
	
	@FindBy(id = "_contactPerson")
	public WebElement contactPerson;
	
	@FindBy(id = "_phone")
	public WebElement phone;
	
	@FindBy(id = "_email")
	public WebElement email;
	
	@FindBy(id = "taxTypeField")
	public WebElement taxTypeField;
	
	@FindBy(id = "taxIdField")
	public WebElement taxIdField;
	
	@FindBy(id = "_userName")
	public WebElement userName;
	
	@FindBy(id = "_firstName")
	public WebElement firstName;
	
	@FindBy(id = "_lastName")
	public WebElement lastName;
	
	@FindBy(id = "_userEmailAddress")
	public WebElement userEmailAddress;
	
	@FindBy(id = "localeCode")
	public WebElement localeCode;
	
	@FindBy(id = "_userCountryCode")
	public WebElement userCountryCode;
	
	@FindBy(id = "timeZoneCode")
	public WebElement timeZoneCode;
	
	@FindBy(id = "dynamicCodeLockoutAfter")
	public WebElement dynamicCodeLockoutAfter;
	
	@FindBy(id = "_dynamicCodeForceChangeAfter")
	public WebElement dynamicCodeForceChangeAfter;
	
	@FindBy(xpath = "//a[contains(text(),'Save')]")
	public WebElement save;
	
	//Supplier List Page
	
	@FindBy(id = "searchValue")
	public WebElement searchValue;
	
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	public WebElement search;
	
	// New Supplier Name
	

	@FindBy(xpath = "//a[contains(text(),'AmulSupp')]")
	public WebElement supplierName;
	
	
	public void addNewSupplier() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.type(companyName, "AmulSupp");
		SeleniumUtils.type(street1, "1575 Apple");
		SeleniumUtils.type(city, "Cuumming");
		SeleniumUtils.selectOption(country, "United States of America");
		SeleniumUtils.selectOption(state, "Georgia");
		SeleniumUtils.type(zip, "30041");
		SeleniumUtils.type(contactPerson, "Sai");
		SeleniumUtils.type(phone, "6785927880");
		SeleniumUtils.type(email, "primerevenueqa@hotmail.com");
		//SeleniumUtils.selectOption(taxTypeField, "AA");
		SeleniumUtils.type(taxIdField, "6901");
		SeleniumUtils.type(userName, "suppsam");
		SeleniumUtils.type(firstName, "sai");
		SeleniumUtils.type(lastName, "amul");
		SeleniumUtils.type(userEmailAddress, "primerevenueqa@hotmail.com");
		SeleniumUtils.selectOption(localeCode, "English");
		SeleniumUtils.selectOption(userCountryCode, "United States of America");
		SeleniumUtils.selectOption(timeZoneCode, "Eastern Standard Time (America/New_York, EST)");
		SeleniumUtils.selectOption(dynamicCodeLockoutAfter, "4");
		SeleniumUtils.selectOption(dynamicCodeForceChangeAfter, "60");
		SeleniumUtils.click(save);
		
		}
	
	//Verifying just added Supplier creation
	
	public void verifyingAddedNewSupplier() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SCiSupplierSPMenu verify = PageFactory.initElements(Browser.eDriver,
				SCiSupplierSPMenu.class);
		
		verify.menuToListSupplier();
		
		SeleniumUtils.type(searchValue, "AmulSupp");
		SeleniumUtils.click(search);
		
		SeleniumUtils.click(supplierName);      /*Table logic implementation here */
		
	}
	public void editSaveComanyInfoForFI() {
		PageFactory.initElements(Browser.eDriver, this);
		SCiSupplierSPMenu editSave = PageFactory.initElements(Browser.eDriver,
				SCiSupplierSPMenu.class);
		
		editSave.menuToFIList();
		SeleniumUtils.type(searchValue, "vishfi9");
		SeleniumUtils.click(search);					 /*Table logic implementation here */
		
	}
}
