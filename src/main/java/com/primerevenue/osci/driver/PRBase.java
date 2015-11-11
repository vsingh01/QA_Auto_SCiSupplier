package com.primerevenue.osci.driver;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.primerevenue.osci.utils.CommonUtils;
import com.primerevenue.osci.driver.TesterListener;
import com.primerevenue.osci.pageobjects.common.PRLogin;
import com.primerevenue.osci.utils.DatabaseUtil;
import com.primerevenue.osci.utils.FileUtils;
import com.primerevenue.osci.utils.PropertiesUtil;


@Listeners({TesterListener.class})
public class PRBase {
	

    final static Logger logger = Logger.getLogger(PRBase.class);
    protected PRLogin login;
    public static DatabaseUtil databaseUtil;
    public static String gridBrowser, gridNodeIP, gridNodePort, screenSize;
    /*protected PowerBar powerBar;*/
    
    public static String ENABLE_EXECUTION_TRACE;
    public static String EXECUTION_TRACE_FILE;
    public static Map<String, String> execTrace = new HashMap<>();
    public static String EXECUTION_TRACE_KEY_VALUE;

    public static Properties setupProp;
    public static Properties objectMapProp;

    public static String CORPORATE_UG;
    public static String COM_USER;
    public static String SUPP_USER;
    public static String CORPORATE_USER3;

    public static String SMB_UG;
    public static String SP_USER;
    public static String FI_USER;
    public static String BUY_USER;

    public static String CHANGE_PASSWORD;

    // Disable webdriver debug
    static {

        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");

    }

    @BeforeClass
    public void beforeClass() throws Exception {
        logger.debug("EXECUTING before class");

    }

    @AfterClass
    protected void afterClass() throws Exception {
        logger.debug("EXECUTING after class");
    }

    @BeforeMethod
    protected void beforeMethod(Method method) throws Exception {
        String testName = this.getClass().getName() + "." + method.getName();
        logger.info("Running Test: " + testName);
        execTrace.put("test", testName);
    }

    @AfterMethod
    protected void afterMethod(Method method) throws Exception {
        String testName = this.getClass().getName() + "." + method.getName();
        logger.info("Finishing Test: " + testName);
        if (login != null) {
            login.loggOff();
            Browser.close();
        }
        FileUtils.saveExecutionTraceData(EXECUTION_TRACE_FILE, execTrace);
        execTrace.clear();
    }

    protected void login(String user) {
        Browser.open(gridBrowser, gridNodeIP, gridNodePort);
        Browser.setScreenSize(screenSize);
        login = new PRLogin(user);
    }

    protected void logOff() {
        if (login != null) {
            login.loggOff();
            Browser.close();
        }


    }

    private void initGlobalData() {
        logger.debug("INITIALIZING GLOBAL VARIABLES... ");
        CORPORATE_UG = setupProp.getProperty("corp.user.group");
        COM_USER = setupProp.getProperty("com.user.username");
        SUPP_USER = setupProp.getProperty("supp.user.username");
        CORPORATE_USER3 = setupProp.getProperty("corp.user.username3");

        SMB_UG = setupProp.getProperty("smb.user.group");
        SP_USER = setupProp.getProperty("sp.user.username");
        FI_USER = setupProp.getProperty("fi.user.username");
        BUY_USER = setupProp.getProperty("buy.user.username");
        CHANGE_PASSWORD = setupProp.getProperty("user.password.change");

        ENABLE_EXECUTION_TRACE = setupProp.getProperty("execution.trace.enable");
        EXECUTION_TRACE_FILE = setupProp.getProperty("execution.trace.file");
        EXECUTION_TRACE_KEY_VALUE = setupProp.getProperty("execution.trace.key.value");
    }

    /**
     * Do actions to be performed only once throughout the entire suite
     *
     * @param ctx
     */
    @BeforeSuite
    public void beforeSuite(ITestContext ctx) {

        logger.info("STARTING TEST SUITE: '" + ctx.getName() + "'");

        //initialize grid parameters
        gridBrowser = ctx.getSuite().getParameter("gridBrowser");
        gridNodeIP = ctx.getSuite().getParameter("gridNodeIP");
        gridNodePort = ctx.getSuite().getParameter("gridNodePort");
        screenSize = ctx.getSuite().getParameter("screenSize");

        //load properties files
        setupProp = new PropertiesUtil().getProperties("setup.properties");
        objectMapProp = new PropertiesUtil().getProperties("objectmap.properties");

        //initialize global variables
        initGlobalData();
        /*--------------------------------------------------------------------------------
        //connect my sql database
        databaseUtil = new DatabaseUtil();
        databaseUtil.getMySqlConnection();
        databaseUtil.printResults(databaseUtil.getResults());
        //databaseUtil.getOracleConnection();
       
		/*-----------------------------------------------------------------------------     
        //kill all process of browser where test is to be run
        String browser = null;
        /*try {
            browser = setupProp.getProperty("browser");
            switch (browser) {
                case "chrome": {
                    CommonUtils.killWindowsProcess(browser + ".exe");
                    CommonUtils.killWindowsProcess(browser + "driver.exe");
                }
                case "firefox": {
                    CommonUtils.killWindowsProcess(browser + ".exe");
                }

            }

        } catch (Exception e) {
            logger.info("No windows process to kill " + browser + ".exe");
        }*/

    }

    @AfterSuite
    public void afterSuite(ITestContext ctx) {
        logger.info("FINISHING TEST SUITE: '" + ctx.getName() + "'");
        setupProp = null;
        objectMapProp = null;
        databaseUtil.closeConnection();
        databaseUtil = null;
    }

}
