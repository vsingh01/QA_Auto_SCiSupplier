package com.primerevenue.osci.test.smoke;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.FIAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.SCiSupplierFIMenu;
import com.primerevenue.osci.utils.Synchronizer;

public class FISmokeTestNG3 extends PRBase {

	final static Logger logger = Logger.getLogger(FISmokeTestNG3.class);

	@Test
	public void smokeTestfi1() throws Exception {
		
		
		Synchronizer.implicitWait(10);
		login(FI_USER);
		/*
		 * }
		 * 
		 * @Test public void smokeTestfi2() throws InterruptedException {
		 */

		SCiSupplierFIMenu fIMenuObjRef = PageFactory.initElements(
				Browser.eDriver, SCiSupplierFIMenu.class);
		//testMenufi1.verifyFIPages();
		

		FIAddBuyerProgram fIByProObjRef = PageFactory.initElements(
				Browser.eDriver, FIAddBuyerProgram.class);

		fIMenuObjRef.menuToAvailablePortfolios();
		fIByProObjRef.fIAddBP();
		
		
	// Reports
		/*testMenufi1.menuToFIremitAdvOutboundReport();
		testMenufi2.fIRenmitAdvOutboundReprots();
		testMenufi1.menuToFIpoNotificationReport();
		testMenufi2.fIPONotifReprots();
		testMenufi1.menuToFISummBookReport();
		testMenufi2.fISummaryBookingReprots();*/
		
	}
}
