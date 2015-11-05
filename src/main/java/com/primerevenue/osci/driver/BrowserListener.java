package com.primerevenue.osci.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.events.WebDriverEventListener;

import com.primerevenue.osci.utils.Synchronizer;

public class BrowserListener implements WebDriverEventListener {

final static Logger logger = Logger.getLogger(BrowserListener.class);
	
	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
        Synchronizer.waitUntilPageReady();

	}
	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
        Synchronizer.waitUntilPageReady();
	}
	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub
	}
	@Override
	public void afterNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub
	}
	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void afterScript(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
	}
	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		arg0.clear();
	}
	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
        Synchronizer.waitClickableElement(arg0);
	}
	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
        // TODO Auto-generated method stub
	}
	@Override
	public void beforeNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub
	}
	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
        // TODO Auto-generated method stub
	}
	
	
}
