package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.EmailClient;
import com.primerevenue.osci.pageobjects.common.SCiSupplierSPMenu;
import com.primerevenue.osci.pageobjects.common.SPAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.SPAddNewSupplier;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class SPModReportsTestNG8 extends PRBase {

	final static Logger logger = Logger.getLogger(SPModReportsTestNG8.class);

	@Test
	public void smokeTest1() throws InterruptedException {
		Synchronizer.implicitWait(10);
		login(SP_USER);
		Synchronizer.implicitWait(5);
		SCiSupplierSPMenu spMenuObjRef = PageFactory.initElements(
				Browser.eDriver, SCiSupplierSPMenu.class);
		SPAddBuyerProgram spAddByObjRef = PageFactory.initElements(
				Browser.eDriver, SPAddBuyerProgram.class);

		// Search validations

		spMenuObjRef.menuToTrackDocuments();
		spAddByObjRef.trackDocumentsSearch();

		spMenuObjRef.menuToLoadConfirm();
		spAddByObjRef.loadConfirm();

		spMenuObjRef.menuToUserPwdMaintenance();
		spAddByObjRef.userPwdMaintenance();

		// test case---- Adding a new Supplier from SP

		SPAddNewSupplier spAddNewSuppObjRef = PageFactory.initElements(
				Browser.eDriver, SPAddNewSupplier.class);

		spMenuObjRef.menuToAddSupplier();
		spAddNewSuppObjRef.addNewSupplier();
		spAddNewSuppObjRef.verifyingAddedNewSupplier();

		// spMenuObjRef.menuToFIList();
		spAddNewSuppObjRef.editSaveComanyInfoForFI();

	}
	@Test
	public void afterClass() {

		Browser.close();
	}
	

}