package com.primerevenue.osci.test.UATsmoke;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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

	@Test(priority = 1)
	public void test1() throws IOException {

		POUploadPerformTrade poUpload1 = PageFactory.initElements(Browser.eDriver, POUploadPerformTrade.class);

		poUpload1.copyFiles(LOCAL_POFILE_PATH, STACK_POFILE_PATH);

		Synchronizer.explicitWait(240);

	}
	// run restart services

	@Test(priority = 2)
	public void runServices() throws Exception {
		POUploadPerformTrade poUpload1 = PageFactory.initElements(Browser.eDriver, POUploadPerformTrade.class);

		poUpload1.bounceWFCServices();
		Synchronizer.explicitWait(420);
	}

	@Test(priority = 3)
	public void dBQueries() {

		databaseUtil = new DatabaseUtil();
		databaseUtil.getMySqlConnection();
		databaseUtil.printResults(databaseUtil.getSupIdResults());
		databaseUtil.poTradedBQueries();
	}

	@Test(priority = 4)
	public void test2() {
		login(UAT_SUPP_USER);
		POUploadPerformTrade poUpload2 = PageFactory.initElements(Browser.eDriver, POUploadPerformTrade.class);

		poUpload2.poTradeFrmSuppplier();
	}

	@Test(priority = 5)
	public void test3() {
		login(UAT_COM_USER);
		POUploadPerformTrade poUpload3 = PageFactory.initElements(Browser.eDriver, POUploadPerformTrade.class);

		poUpload3.poTradeFrmCM();

	}

	@Test(priority = 6)
	public void test4() {
		login(UAT_FI_USER);
		POUploadPerformTrade poUpload4 = PageFactory.initElements(Browser.eDriver, POUploadPerformTrade.class);
		poUpload4.poTradeFrmFI();

	}

	@AfterMethod
	public void afterClass() {

		Browser.close();
	}
}
