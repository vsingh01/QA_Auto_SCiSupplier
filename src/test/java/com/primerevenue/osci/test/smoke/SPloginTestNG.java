package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.SCiSupplierMenu;
import com.primerevenue.osci.pageobjects.common.SPAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.SPMaintainMembership;
import com.primerevenue.osci.utils.Synchronizer;



public class SPloginTestNG extends PRBase {
	
	final static Logger logger = Logger.getLogger(SPloginTestNG.class);


	@Test
	public void smokeTest1() throws InterruptedException {
        Synchronizer.implicitWait(10);
		login(SP_USER1);
		
		SCiSupplierMenu testMenu = PageFactory.initElements(Browser.eDriver,
        		SCiSupplierMenu.class);
        
        testMenu.theMenu();
        SPMaintainMembership testMenu1 = PageFactory.initElements(Browser.eDriver,
        		SPMaintainMembership.class);
        testMenu1.maintainMembTab();
        
        SPAddBuyerProgram testMenu2 = PageFactory.initElements(Browser.eDriver,
        		SPAddBuyerProgram.class);
        testMenu2.addBuyerProgram();
        
        
        
	}
	
	/*@Test
	public void smokeTest2() throws InterruptedException {
        Synchronizer.implicitWait(10);
		
        //PageFactory.initElements(Browser.eDriver, this);
        SCiSupplierMenu testMenu = PageFactory.initElements(Browser.eDriver,
        		SCiSupplierMenu.class);
        
        testMenu.theMenu();
        
        
		
	}*/

}
