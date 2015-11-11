package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.ComAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.ComEditUsers;
import com.primerevenue.osci.pageobjects.common.ComUsersPage;
import com.primerevenue.osci.pageobjects.common.SCiSupplierCOMMenu;
import com.primerevenue.osci.utils.Synchronizer;

public class CMLoginTestNG2 extends PRBase {

	final static Logger logger = Logger.getLogger(CMLoginTestNG2.class);

	@Test
	public void cmsmokeTest1() throws InterruptedException {
		Synchronizer.implicitWait(10);
		login(COM_USER);
	}

	@Test
	public void cmsmokeTest2() throws InterruptedException {
		SCiSupplierCOMMenu cmtestMenu = PageFactory.initElements(
				Browser.eDriver, SCiSupplierCOMMenu.class);
		cmtestMenu.theComMenu();

		ComUsersPage cmtestMenu1 = PageFactory.initElements(Browser.eDriver,
				ComUsersPage.class);
		cmtestMenu1.usersEditMethod();

		ComEditUsers cmtestMenu3 = PageFactory.initElements(Browser.eDriver,
				ComEditUsers.class);
		cmtestMenu3.cmAddBuyerProgram();

		ComAddBuyerProgram cmtestMenu4 = PageFactory.initElements(
				Browser.eDriver, ComAddBuyerProgram.class);
		cmtestMenu4.addEditBuyerProgram();

	}
	@Test
	public void cmsmokeTest3() throws InterruptedException {
		
		SCiSupplierCOMMenu cmtestMenu5 = PageFactory.initElements(
				Browser.eDriver, SCiSupplierCOMMenu.class);
		
		ComAddBuyerProgram cmtestMenu6 = PageFactory.initElements(
				Browser.eDriver, ComAddBuyerProgram.class);
		
		cmtestMenu5.menuToCOMSuppActivityReport();
		cmtestMenu6.supplierActivityReport();
		
		cmtestMenu5.menuToCOMbuyerMaturepayForcastReport();
		cmtestMenu6.buyerMaturePayForcastReport();
		
		
	}
	
}
