
package com.primerevenue.osci.test.UATsmoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.ComAddBuyerProgram;
import com.primerevenue.osci.pageobjects.common.SCiSupplierCOMMenu;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class CMModReportsTestNG10 extends PRBase{
	
	final static Logger logger = Logger.getLogger(CMModReportsTestNG10.class);

	@Test
	public void cmsmokeTest1() throws InterruptedException {
		Synchronizer.implicitWait(10);
		login(UAT_COM_USER);
		
				
	}
	@Test
	public void cmsmokeTest3() throws Exception {
		
		SCiSupplierCOMMenu cmMenuObjRef = PageFactory.initElements(
				Browser.eDriver, SCiSupplierCOMMenu.class);
		
		ComAddBuyerProgram cmAddByObjRef = PageFactory.initElements(
				Browser.eDriver, ComAddBuyerProgram.class);
		
		cmMenuObjRef.menuToCOMSuppActivityReport();
		cmAddByObjRef.supplierActivityReport();
		
		cmMenuObjRef.menuToCOMbuyerMaturepayForcastReport();
		cmAddByObjRef.buyerMaturePayForcastReport();
			
	}
	
	@AfterClass
	public void afterClass() {
		           
		Browser.close();
        }

}
