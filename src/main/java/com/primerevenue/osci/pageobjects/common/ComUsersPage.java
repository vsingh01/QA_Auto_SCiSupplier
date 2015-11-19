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

public class ComUsersPage {
	/* COMMUNITY "Users page" */
	final static Logger logger = Logger.getLogger(ComUsersPage.class);

	/* Rktcommunity user id */

	@FindBy(xpath = "(//a[contains(text(),'Edit')])[2]")
	public WebElement edit;

	public void usersEditMethod() {

		PageFactory.initElements(Browser.eDriver, this);

		try {
			SeleniumUtils.click(edit);
			logger.debug("Successful, edit link click.");
		} catch (Exception e) {
			logger.error("Failed, edit link click");
		}
	}

}
