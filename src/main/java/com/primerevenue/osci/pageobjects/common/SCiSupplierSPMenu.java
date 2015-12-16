package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class SCiSupplierSPMenu {

	final static Logger logger = Logger.getLogger(SCiSupplierSPMenu.class);

	@FindBy(id = "dashboard-toggle")
	public WebElement userMenu;

	@FindBy(id = "watLogout")
	public WebElement logout;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement home;

	@FindBy(id = "watCommDir")
	public WebElement comManagement;

	@FindBy(id = "watComDirectory")
	public WebElement comDir;

	@FindBy(xpath = "//a[contains(text(),'Track Documents')]")
	public WebElement trackDocument;

	@FindBy(xpath = "//a[contains(text(),'Provide Support')]")
	public WebElement provideSupport;

	@FindBy(xpath = "//a[contains(text(),'Load Confirmations')]")
	public WebElement loadConfirmations;

	@FindBy(xpath = "//a[contains(text(),'User Password Maintenance')]")
	public WebElement userPwdMaintenance;

	@FindBy(id = "watAddSupplier")
	public WebElement manageSuppliers;

	@FindBy(xpath = "//a[contains(text(),'Add Supplier')]")
	public WebElement addSupplier;

	@FindBy(id = "watListSuppliers")
	public WebElement listSuppliers;

	@FindBy(id = "watAddFi")
	public WebElement manageFIs;

	@FindBy(xpath = "//a[contains(text(),'FI List')]")
	public WebElement listFIs;

	/* SP Community Directory page */

	@FindBy(xpath = "//a[contains(text(),'Rktcommunity')]")
	public WebElement comDirName;

	public void menuToMainMembership() {
		PageFactory.initElements(Browser.eDriver, this);
		Synchronizer.waitUntilDisplayed(userMenu, 5);
		Boolean spTitle = SeleniumUtils.isTextPresent("Service Provider Home");
		System.out.println("Service Provider Home Title verified : : :"
				+ spTitle);
		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(comManagement);
		SeleniumUtils.click(comDir);
		SeleniumUtils.click(comDirName);
	}

	public void menuToTrackDocuments() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(trackDocument);
	}

	public void menuToLoadConfirm() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(provideSupport);
		SeleniumUtils.click(loadConfirmations);
	}

	public void menuToUserPwdMaintenance() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(userPwdMaintenance);
	}

	public void menuToAddSupplier() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(comManagement);
		SeleniumUtils.click(manageSuppliers);
		SeleniumUtils.click(addSupplier);
	}

	public void menuToListSupplier() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(comManagement);
		SeleniumUtils.click(manageSuppliers);
		SeleniumUtils.click(listSuppliers);
	}

	public void menuToFIList() {
		PageFactory.initElements(Browser.eDriver, this);

		SeleniumUtils.click(userMenu);
		SeleniumUtils.click(comManagement);
		SeleniumUtils.click(manageFIs);
		SeleniumUtils.click(listFIs);
	}

	public void logout() {
		PageFactory.initElements(Browser.eDriver, this);
		try {
			SeleniumUtils.click(logout);
			logger.debug("Successful, logout.");
		} catch (Exception e) {
			logger.error("Failed, user logout.");
		}
	}

}
