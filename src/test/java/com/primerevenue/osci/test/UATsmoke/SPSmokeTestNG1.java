package com.primerevenue.osci.test.UATsmoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.SCiSupplierSPMenu;
import com.primerevenue.osci.pageobjects.common.SPAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.SPMaintainMembership;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class SPSmokeTestNG1 extends PRBase {

	final static Logger logger = Logger.getLogger(SPSmokeTestNG1.class);

	@Test
	public void smokeTest1() throws InterruptedException {
		Synchronizer.implicitWait(10);
		login(UAT_SP_USER);

		SCiSupplierSPMenu spMenuObjRef = PageFactory.initElements(
				Browser.eDriver, SCiSupplierSPMenu.class);
		SPMaintainMembership spMainMembShipObjRef = PageFactory.initElements(
				Browser.eDriver, SPMaintainMembership.class);
		SPAddBuyerProgram spAddBPObjeRef = PageFactory.initElements(
				Browser.eDriver, SPAddBuyerProgram.class);

		spMenuObjRef.menuToMainMembership();
		spMainMembShipObjRef.maintainMembComBuyersTab();
		spAddBPObjeRef.addBuyerProgram();

	}

	@AfterClass
	public void afterClass() {

		Browser.close();
	}

}
