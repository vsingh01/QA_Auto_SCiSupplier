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

public class ComEditUsers {

	/* COMMUNITY "Edit User page" */
	final static Logger logger = Logger.getLogger(ComEditUsers.class);

	@FindBy(xpath = "//a[contains(@href, 'javascript: onAddClick();')]")
	public WebElement addBtn;

	@FindBy(name = "selectedBuyerProgram")
	public WebElement chkBox;

	@FindBy(xpath = "//a[contains(@href, 'javascript: addSelectedClick();')]")
	public WebElement addSelected;

	@FindBy(xpath = "//a[contains(@href, 'javascript: onSaveClick()')]")
	public WebElement saveBtn;

	/* Community Pending Buyer Programs page */

	@FindBy(xpath = "(//a[contains(text(),'Add')])[3]")
	public WebElement addPendingBP;

	public void cmAddBuyerProgram() {

		PageFactory.initElements(Browser.eDriver, this);

		try {
			SeleniumUtils.click(addBtn);
			logger.info("Successful, Add Btn click.");
		} catch (Exception e) {
			logger.error("Failed, Add Btn click");
		}

		try {
			SeleniumUtils.clickCheckBox(chkBox, "ON");
			logger.info("Successful, checkbox click.");
		} catch (Exception e) {
			logger.error("Failed, checkbox click");

		}
		try {
			SeleniumUtils.click(addSelected);
			logger.info("Successful, Add Selected Btn click.");
		} catch (Exception e) {
			logger.error("Failed, Add Selected Btn click");

		}
		try {
			SeleniumUtils.click(saveBtn);
			logger.info("Successful, Save Btn click.");
		} catch (Exception e) {
			logger.error("Failed, Save Btn click");

		}

		SCiSupplierCOMMenu cmtestMenu10 = PageFactory.initElements(
				Browser.eDriver, SCiSupplierCOMMenu.class);
		cmtestMenu10.menuToPendingBuyerProgram();

		try {
			SeleniumUtils.click(addPendingBP);
			logger.info("Successful, addPendingBP Btn click.");
		} catch (Exception e) {
			logger.error("Failed, addPendingBP Btn click");

		}
	}

}
