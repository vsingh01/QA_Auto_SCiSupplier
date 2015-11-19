package com.primerevenue.osci.test.smoke;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.SCiSupplierBuyerMenu;
import com.primerevenue.osci.pageobjects.common.VerifyBuyerPagesReports;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class BuyerTestNG7 extends PRBase {

	final static Logger logger = Logger.getLogger(BuyerTestNG7.class);

	@Test
	public void buyertest1() throws Exception {
		Synchronizer.implicitWait(10);
		login(BUY_USER);

		SCiSupplierBuyerMenu testMenu = PageFactory.initElements(
				Browser.eDriver, SCiSupplierBuyerMenu.class);

		VerifyBuyerPagesReports testMenu1 = PageFactory.initElements(
				Browser.eDriver, VerifyBuyerPagesReports.class);
		testMenu.menuToPaySchedule();
		testMenu1.paymentSchedulePage();

		testMenu.menuToPaysHistory();
		testMenu1.paymentHistoryPage();

		testMenu.menuToSetMaturingCalendar();
		testMenu1.matureCalendarPage();

		testMenu.menuToTrackDocuments();
		testMenu1.payObligationSerachResultsPage();

		testMenu.menuToViewRejDocuments();
		testMenu1.viewRejectedPage();

		testMenu.menuToLoadConfirmations();
		testMenu1.loadConfirmationPage();

		testMenu.menuToEndOfDayReports();
		testMenu1.endOfDayReportGen();

		testMenu.menuToTradeDetailReports();
		testMenu1.tradeDetailsReportGen();

		testMenu.menuToSupplierTradTrendReports();
		testMenu1.supplierTradTrendReportsGen();
	}

	@AfterClass
	public void afterClass() {

		Browser.close();
	}

}
