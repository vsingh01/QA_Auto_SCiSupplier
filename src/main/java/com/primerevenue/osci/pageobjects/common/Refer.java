package com.primerevenue.osci.pageobjects.common;

import java.util.Set;

import org.openqa.selenium.By;

import com.primerevenue.osci.driver.Browser;

public class Refer {
	
	public static void switchWindows() {

		//Get all window handles
		Set<String> allHandles = Browser.eDriver.getWindowHandles();

		//count the handles Here count is=2
		System.out.println("Count of windows:"+allHandles.size());      

		//Get current handle or default handle
		String currentWindowHandle = allHandles.iterator().next();
		System.out.println("currentWindow Handle"+currentWindowHandle);

		//Remove first/default Handle
		allHandles.remove(allHandles.iterator().next());

		//get the last Window Handle
		String lastHandle = allHandles.iterator().next();
		System.out.println("last window handle"+lastHandle);

		//switch to second/last window, because we know there are only two windows 1-parent window 2-other window(ad window)
		Browser.eDriver.switchTo().window(lastHandle);
		System.out.println(Browser.eDriver.getTitle());
		Browser.eDriver.findElement(By.tagName("body")).click();
	}
	
	public static void switchWindows1() {

		 //wait till two windows are not opened
		 
		 //waitForNumberofWindowsToEqual(2);//this method is for wait
		 
		 Set handles = Browser.eDriver.getWindowHandles();
		 
		 String firstWinHandle = Browser.eDriver.getWindowHandle(); 
		 
		 //handles.remove(firstWinHandle);
		 
		 String  winHandle=(String) handles.iterator().next();
		 
		 if (winHandle!=firstWinHandle){
		 
		 //To retrieve the handle of second window, extracting the handle which does not match to first window handle
		 
		 String secondWinHandle = winHandle; //Storing handle of second window handle
		 
		 System.out.println("window1 :::::" + firstWinHandle + "window2 :::::" + secondWinHandle);
		//Switch control to new window
		 
		 Browser.eDriver.switchTo().window(secondWinHandle);
	}	

}
	/*public static FirefoxProfile FirefoxDriverProfile() throws Exception {
	FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("browser.download.folderList", 1);
	profile.setPreference("browser.download.manager.showWhenStarting",
			false);
	// profile.setPreference("browser.download.dir", downloadPath);
	profile.setPreference(
			"browser.helperApps.neverAsk.openFile",
			"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/pdf,text/pdf");
	profile.setPreference(
			"browser.helperApps.neverAsk.saveToDisk",
			"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/pdf,text/pdf");
	profile.setPreference("browser.helperApps.alwaysAsk.force", false);
	profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
	profile.setPreference("browser.download.manager.focusWhenStarting",
			false);
	profile.setPreference("browser.download.manager.useWindow", false);
	profile.setPreference("browser.download.manager.showAlertOnComplete",
			false);
	profile.setPreference("browser.download.manager.closeWhenDone", false);
	return profile;
}*/
public void table()	{
	//Browser.eDriver.findElement(By.linkText("Community Buyers")).click();
	//Browser.eDriver.findElement(By.xpath("//a[contains(text(),'vishbuy_tom1')]//..//..//td[5]//a")).click();
	//Browser.eDriver.findElement(By.xpath("//a[contains(text(),'"+config.getProperty("bp_Name")+"')]")).click();

}
	
}
