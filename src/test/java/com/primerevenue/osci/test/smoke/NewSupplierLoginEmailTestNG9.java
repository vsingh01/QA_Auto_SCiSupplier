package com.primerevenue.osci.test.smoke;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.EBrowser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.EmailClient;
import com.primerevenue.osci.utils.Synchronizer;

public class NewSupplierLoginEmailTestNG9 extends PRBase {

	@Test
	public void smokeTest1() {
		Synchronizer.implicitWait(2);
		emorglogin(HM_USER);

	}

	@Test
	public void smokeTestss() throws Exception {
		Synchronizer.implicitWait(5);

		EmailClient emalObjRef = PageFactory.initElements(Browser.eDriver,
				EmailClient.class);

		emalObjRef.getTempPwd();

		login(SP_USER);
		emalObjRef.getTempPwd1();
	}

	@AfterClass
	public void afterClass() {
		Browser.close();
	}

}
