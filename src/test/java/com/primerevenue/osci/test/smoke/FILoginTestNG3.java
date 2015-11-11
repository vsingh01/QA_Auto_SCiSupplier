package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.FIAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.SCiSupplierFIMenu;
import com.primerevenue.osci.utils.Synchronizer;

public class FILoginTestNG3 extends PRBase {

	final static Logger logger = Logger.getLogger(FILoginTestNG3.class);

	@Test
	public void smokeTestfi1() throws InterruptedException {
		Synchronizer.implicitWait(10);
		login(FI_USER);
		/*
		 * }
		 * 
		 * @Test public void smokeTestfi2() throws InterruptedException {
		 */

		SCiSupplierFIMenu testMenufi1 = PageFactory.initElements(
				Browser.eDriver, SCiSupplierFIMenu.class);
		//testMenufi1.verifyFIPages();
		

		FIAddBuyerProgram testMenufi2 = PageFactory.initElements(
				Browser.eDriver, FIAddBuyerProgram.class);

		//testMenufi2.fIAddBP();
		
		
	
		testMenufi1.menuToFIremitAdvOutboundReport();
		testMenufi2.fIRenmitAdvOutboundReprots();
		testMenufi1.menuToFIpoNotificationReport();
		testMenufi2.fIPONotifReprots();
		testMenufi1.menuToFISummBookReport();
		testMenufi2.fISummaryBookingReprots();
		
	}
}
