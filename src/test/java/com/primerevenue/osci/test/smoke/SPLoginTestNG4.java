package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.SCiSupplierSPMenu;
import com.primerevenue.osci.pageobjects.common.SPAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.SPAddNewSupplier;
import com.primerevenue.osci.pageobjects.common.SPAddSupplier;
import com.primerevenue.osci.pageobjects.common.SPMaintainMembership;
import com.primerevenue.osci.utils.Synchronizer;

public class SPLoginTestNG4 extends PRBase {
	
	final static Logger logger = Logger.getLogger(SPLoginTestNG4.class);


	@Test
	public void smokeTest1() throws InterruptedException {
        Synchronizer.implicitWait(10);
		login(SP_USER);
		
		SCiSupplierSPMenu testMenu = PageFactory.initElements(Browser.eDriver,
        		SCiSupplierSPMenu.class);
        
        /*testMenu.navigateToMainMembership();
        
        SPMaintainMembership testMenu1 = PageFactory.initElements(Browser.eDriver,
        		SPMaintainMembership.class);
        testMenu1.maintainMembTabNavAddSupplier();
        
        SPAddSupplier testMenu2 = PageFactory.initElements(Browser.eDriver,
        		SPAddSupplier.class);
        testMenu2.addSupplier();
        
        SPAddBuyerProgram testMenu3 = PageFactory.initElements(Browser.eDriver,
        		SPAddBuyerProgram.class);
        
        testMenu.menuToTrackDocuments();
        testMenu3.trackDocumentsSearch();
        
        testMenu.menuToLoadConfirm();
        testMenu3.loadConfirm();
        
        testMenu.menuToUserPwdMaintenance();
        testMenu3.userPwdMaintenance();*/
        
        //Adding a new Supplier from SP
        SPAddNewSupplier testMenu4 = PageFactory.initElements(Browser.eDriver,
        		SPAddNewSupplier.class);
        
        testMenu.menuToAddSupplier();
        testMenu4.addNewSupplier();
        testMenu4.verifyingAddedNewSupplier();
        
        testMenu.menuToFIList();
        testMenu4.editSaveComanyInfoForFI();
		
}
}
