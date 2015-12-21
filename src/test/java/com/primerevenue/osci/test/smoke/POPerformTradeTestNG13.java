package com.primerevenue.osci.test.smoke;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.POUploadPerformTrade;
import com.primerevenue.osci.pageobjects.common.SCiSupplierCOMMenu;
import com.primerevenue.osci.utils.DatabaseUtil;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

public class POPerformTradeTestNG13 extends PRBase {
	final static Logger logger = Logger.getLogger(POPerformTradeTestNG13.class);
	
	@Test
	public void test1() throws IOException	{
	
		POUploadPerformTrade poUpload1 = PageFactory.initElements(
			Browser.eDriver, POUploadPerformTrade.class);
	
	//POUploadPerformTrade poupload1 = new POUploadPerformTrade();
		
		poUpload1.copyFiles("C:/Dir1", "X:/Magellan/Import/PaymentObligationsCSV");
		
		
	//run restart services
	
	}
	@Test
	public void runServices() throws Exception {
		POUploadPerformTrade poUpload1 = PageFactory.initElements(
				Browser.eDriver, POUploadPerformTrade.class);
		
		poUpload1.bounceWFCServices();
		Synchronizer.explicitWait(360);
	}
	@Test
	public void dBQueries() {
		
		databaseUtil = new DatabaseUtil();
        databaseUtil.getMySqlConnection();
        //databaseUtil.printResults(databaseUtil.getSupIdResults());
        databaseUtil.poTradedBQueries();
		}
	
	@Test
	public void test2()	{
		login(SUPP_USER);
		POUploadPerformTrade poUpload2 = PageFactory.initElements(
				Browser.eDriver, POUploadPerformTrade.class);
		
		poUpload2.poTradeFrmSuppplier();
	}
	@Test
	public void test3()	{
		login(COM_USER);
		POUploadPerformTrade poUpload3 = PageFactory.initElements(
				Browser.eDriver, POUploadPerformTrade.class);
		
		poUpload3.poTradeFrmCM();
		
	}
	@Test
	public void test4()	{
		login(FI_USER);
		POUploadPerformTrade poUpload4 = PageFactory.initElements(
				Browser.eDriver, POUploadPerformTrade.class);
		poUpload4.poTradeFrmFI();
			
	}
	@AfterClass
	public void afterClass() {

		Browser.close();
	}
}

