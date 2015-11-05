package com.primerevenue.osci.driver;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.primerevenue.osci.driver.TesterListener;
import com.primerevenue.osci.utils.SeleniumUtils;


public class TesterListener extends TestListenerAdapter {

	final static Logger logger = Logger.getLogger(TesterListener.class);


    @Override
    public void onTestFailure(ITestResult tr) {

        logger.error(tr.getThrowable());
        logger.error(tr.getName() + " -- Test method failed !!");
        SeleniumUtils.takeScreenShoot(tr.getMethod());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {

        logger.info(tr.getName() + " -- Test method skipped.");

    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        logger.info(tr.getName() + " -- Test method successful.");

    }



	
}
