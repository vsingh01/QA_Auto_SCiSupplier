package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.SCiSupplierSuppMenu;
import com.primerevenue.osci.pageobjects.common.SuppModVerifyReports;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class SuppReportsTestNG5 extends PRBase {
	final static Logger logger = Logger.getLogger(SuppReportsTestNG5.class);

	@Test
	public void smokeTestReports() throws InterruptedException {
		Synchronizer.implicitWait(10);
		login(SUPP_USER);
		Synchronizer.implicitWait(5);
		SCiSupplierSuppMenu testMenusupp1 = PageFactory.initElements(
				Browser.eDriver, SCiSupplierSuppMenu.class);

		SuppModVerifyReports testMenusupp2 = PageFactory.initElements(
				Browser.eDriver, SuppModVerifyReports.class);
		testMenusupp1.menuToPOAFReport();
		testMenusupp2.generatePOAF();
		testMenusupp1.menuToRemitAdvReport();
		testMenusupp2.remAdviceReport();
		testMenusupp1.menuToPOReport();
		testMenusupp2.poReport();
		testMenusupp1.menuToCreditMemoReport();
		testMenusupp2.creditMemoReport();
		testMenusupp1.menuToTaxReport();
		testMenusupp2.taxReport();
		testMenusupp1.menuToPONotificationReport();
		testMenusupp2.poNotificationReport();

	}

	@AfterClass
	public void afterClass() {

		Browser.close();
	}
}