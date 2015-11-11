package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.SCiSupplierSuppMenu;
import com.primerevenue.osci.pageobjects.common.SuppModePageNavigations;
import com.primerevenue.osci.utils.Synchronizer;

public class SupplierModPageNavTestNG extends PRBase {
	final static Logger logger = Logger.getLogger(SupplierModPageNavTestNG.class);
	
	@Test
	public void smokeTest1() throws InterruptedException {
        Synchronizer.implicitWait(10);
		login(SUPP_USER);
		
		SCiSupplierSuppMenu testMenusupp1 = PageFactory.initElements(Browser.eDriver,
				SCiSupplierSuppMenu.class);
		testMenusupp1.menuToSellOfferHistPage();
		
		SuppModePageNavigations testMenusupp2 = PageFactory.initElements(Browser.eDriver,
				SuppModePageNavigations.class);
		 
		testMenusupp1.menuToPOandCMHistPage();
		testMenusupp2.verifyPOCMPage();
		
		testMenusupp1.menuTradeHistPage();
		testMenusupp2.verifyTradeHisMPage();
		
		testMenusupp1.menuTrackDocumentPage();
		testMenusupp2.verifyTrackDocumentMPage();
		
	}

}
