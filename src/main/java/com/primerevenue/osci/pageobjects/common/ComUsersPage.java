package com.primerevenue.osci.pageobjects.common;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.utils.PropertiesUtil;
import com.primerevenue.osci.utils.SeleniumUtils;

/**
 * @author Sai Amuluru;
 *
 **/

public class ComUsersPage extends PRBase {

	

	/* COMMUNITY "Users page" */
	final static Logger logger = Logger.getLogger(ComUsersPage.class);

	/* rohcom103 user id */

	/*@FindBy(xpath = "//td[text()='rohcom103']//..//td[7]")
	public WebElement edit;*/
	
	
	public void usersEditMethod() {
		
		PageFactory.initElements(Browser.eDriver, this);
		
		try {
			Browser.eDriver.findElement(By.xpath("//td[text()='"+ UAT_COM_USER +"']//..//td[7]")).click();
			logger.info("Successful, edit link click.");
		} catch (Exception e) {
			logger.error("Failed, edit link click");
		}
		/*try {
			SeleniumUtils.click(edit);
			logger.info("Successful, edit link click.");
		} catch (Exception e) {
			logger.error("Failed, edit link click");
		}*/
	}

}
