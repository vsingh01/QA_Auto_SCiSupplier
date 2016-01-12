package com.primerevenue.osci.test.UATsmoke;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.EBrowser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.EmailClient;
import com.primerevenue.osci.pageobjects.common.Otp2fa;
import com.primerevenue.osci.utils.Synchronizer;

public class Otp2FATestNG12 extends PRBase {

	@Test
	public void oTPTest1() {

		Synchronizer.implicitWait(2);
		login(UAT_USER_2FA);

		Otp2fa ObjRef = PageFactory.initElements(Browser.eDriver, Otp2fa.class);
		ObjRef.sendOtpToEmail();
		Synchronizer.explicitWait(2);
		oTPTest2();

	}

	public void oTPTest2() {
		emlogin(HM_USER);

		EmailClient emalObjRef = PageFactory.initElements(EBrowser.eDriver,
				EmailClient.class);

		emalObjRef.getOTP();

		Otp2fa ObjRef = PageFactory.initElements(Browser.eDriver, Otp2fa.class);
		ObjRef.typeOtp2fapwd(emalObjRef.accessCode);

	}

	@AfterClass
	public void afterClass() {

		Browser.close();
	}

}
