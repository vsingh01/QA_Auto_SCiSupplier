package com.primerevenue.osci.test.UATsmoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.ComAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.ComEditUsers;
import com.primerevenue.osci.pageobjects.common.ComUsersPage;
import com.primerevenue.osci.pageobjects.common.SCiSupplierCOMMenu;
import com.primerevenue.osci.utils.Synchronizer;

public class CMAutoPerformTradeTestNG2 extends PRBase {
	final static Logger logger = Logger.getLogger(CMAutoPerformTradeTestNG2.class);
	
	@Test
	public void cmsmokeTest1() throws InterruptedException {
		Synchronizer.implicitWait(10);
		login(UAT_COM_USER);

	}

	@Test
	public void cmsmokeTest2() throws InterruptedException {

		SCiSupplierCOMMenu cmMenuObjRef = PageFactory.initElements(
				Browser.eDriver, SCiSupplierCOMMenu.class);
		//perform target credit capacity until the issue got ficed..
		/*----------------------------------------------------------------*/
		cmMenuObjRef.resetTargetCreditCapacity();
		/*----------------------------------------------------------------*/
		cmMenuObjRef.menuToUsers();

		ComUsersPage cmUserPageObjeRef = PageFactory.initElements(
				Browser.eDriver, ComUsersPage.class);
		cmUserPageObjeRef.usersEditMethod();

		ComEditUsers cmEditObjRef = PageFactory.initElements(Browser.eDriver,
				ComEditUsers.class);
		cmEditObjRef.cmAddBuyerProgram();

		ComAddBuyerProgram cmAddByObjRef = PageFactory.initElements(
				Browser.eDriver, ComAddBuyerProgram.class);
		cmAddByObjRef.addEditBuyerProgramAuto();

	}
	@AfterClass
	public void afterClass() {
		           
		Browser.close();
        }

}
