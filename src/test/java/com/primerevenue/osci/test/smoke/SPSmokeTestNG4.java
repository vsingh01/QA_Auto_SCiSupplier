package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.SCiSupplierSPMenu;
import com.primerevenue.osci.pageobjects.common.SPAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.SPAddNewSupplier;
import com.primerevenue.osci.pageobjects.common.SPAddSupplierToBP;
import com.primerevenue.osci.pageobjects.common.SPMaintainMembership;
import com.primerevenue.osci.utils.Synchronizer;

public class SPSmokeTestNG4 extends PRBase {
	
	final static Logger logger = Logger.getLogger(SPSmokeTestNG4.class);


	@Test
	public void smokeTest1() throws InterruptedException {
        Synchronizer.implicitWait(10);
		login(SP_USER);
		
		SCiSupplierSPMenu spMenuObjRef = PageFactory.initElements(Browser.eDriver,
        		SCiSupplierSPMenu.class);
        
		spMenuObjRef.menuToMainMembership();
        
        SPMaintainMembership mainMembObjRef = PageFactory.initElements(Browser.eDriver,
        		SPMaintainMembership.class);
        mainMembObjRef.addSupplierToBP();
        
        SPAddSupplierToBP spAddSuppObjRef = PageFactory.initElements(Browser.eDriver,
        		SPAddSupplierToBP.class);
        spAddSuppObjRef.addSupplierToBP();
        
        SPAddBuyerProgram spAddByObjRef = PageFactory.initElements(Browser.eDriver,
        		SPAddBuyerProgram.class);
        
        /*testMenu.menuToTrackDocuments();
        testMenu3.trackDocumentsSearch();
        
        testMenu.menuToLoadConfirm();
        testMenu3.loadConfirm();
        
        testMenu.menuToUserPwdMaintenance();
        testMenu3.userPwdMaintenance();*/
        
        //test case---- Adding a new Supplier from SP
        /*SPAddNewSupplier testMenu4 = PageFactory.initElements(Browser.eDriver,
        		SPAddNewSupplier.class);
        
        testMenu.menuToAddSupplier();
        testMenu4.addNewSupplier();
        testMenu4.verifyingAddedNewSupplier();
        
        testMenu.menuToFIList();
        testMenu4.editSaveComanyInfoForFI();*/
		
}
}
