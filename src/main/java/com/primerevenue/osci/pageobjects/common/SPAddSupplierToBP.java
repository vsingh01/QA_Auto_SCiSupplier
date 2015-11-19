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

public class SPAddSupplierToBP {
	final static Logger logger = Logger.getLogger(SPAddSupplierToBP.class);
	
	// 		View Buyer Program page
	
	@FindBy(xpath = "//a[contains(@href, 'javascript: addSuppliers()')]")
	public WebElement addBtn;
	
	// 		Add Supplier page
	
	@FindBy(name = "searchValue")
	public WebElement searchValue;
	
	@FindBy(id = "_searchSubmit")
	public WebElement searchSubmit;
	
	// After Search
	
	@FindBy(name = "selectedSupplier")
	public WebElement selectedSupplierChlBox;
	
	@FindBy(xpath = "//table[@id='row']/tbody/tr/td[6]/input")
	public WebElement buyerSuppRef;
	
	@FindBy(xpath = "//a[contains(text(),'Add Selected to Buyer Program')]")
	public WebElement addSelectedtoBuyerProBtn;

public void addSupplierToBP1() {
		PageFactory.initElements(Browser.eDriver, this);
		
		SeleniumUtils.click(addBtn);
		
		SeleniumUtils.type(searchValue, "Rktsup2");
		SeleniumUtils.click(searchSubmit);
		
		SeleniumUtils.clickCheckBox(selectedSupplierChlBox, "ON");
		SeleniumUtils.type(buyerSuppRef, "786");
		SeleniumUtils.click(addSelectedtoBuyerProBtn);
		
		
		
}
	
}
