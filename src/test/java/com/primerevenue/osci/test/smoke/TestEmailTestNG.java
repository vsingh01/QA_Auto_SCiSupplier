package com.primerevenue.osci.test.smoke;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.EmailClient;
import com.primerevenue.osci.pageobjects.common.SCiSupplierSPMenu;
import com.primerevenue.osci.utils.Synchronizer;

public class TestEmailTestNG extends PRBase {

	@Test
	public void smokeTest1() throws InterruptedException {
		Synchronizer.implicitWait(10);
		emlogin(HM_USER);

	}

	@Test
	public void smokeTest2() throws InterruptedException {
		Synchronizer.implicitWait(5);

		EmailClient emalObjRef = PageFactory.initElements(Browser.eDriver,
				EmailClient.class);
		emalObjRef.readEmail();

	}

	/*
	 * @AfterClass public void afterClass() {
	 * 
	 * Browser.close(); }
	 */
}
