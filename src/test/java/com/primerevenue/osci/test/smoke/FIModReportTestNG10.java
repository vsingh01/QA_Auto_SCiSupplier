package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.FIAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.SCiSupplierFIMenu;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class FIModReportTestNG10 extends PRBase {

	final static Logger logger = Logger.getLogger(FIModReportTestNG10.class);

	@Test
	public void smokeTestfi1() throws Exception {

		Synchronizer.implicitWait(10);
		login(FI_USER);

	}

	@Test
	public void smokeTestfi2() throws Exception {

		SCiSupplierFIMenu fIMenuObjRef = PageFactory.initElements(
				Browser.eDriver, SCiSupplierFIMenu.class);
		FIAddBuyerProgram fIByProObjRef = PageFactory.initElements(
				Browser.eDriver, FIAddBuyerProgram.class);

		// Verify Pages
		fIMenuObjRef.verifyFIPages();

		// Reports
		fIMenuObjRef.menuToFIremitAdvOutboundReport();
		fIByProObjRef.fIRenmitAdvOutboundReprots();
		fIMenuObjRef.menuToFIpoNotificationReport();
		fIByProObjRef.fIPONotifReprots();
		fIMenuObjRef.menuToFISummBookReport();
		fIByProObjRef.fISummaryBookingReprots();
	}
	@AfterClass
	public void afterClass() {
		           
		Browser.close();
        }
}