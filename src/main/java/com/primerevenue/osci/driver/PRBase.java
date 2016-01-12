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
import com.primerevenue.osci.driver.EMLogin;
import com.primerevenue.osci.utils.DatabaseUtil;
import com.primerevenue.osci.utils.FileUtils;
import com.primerevenue.osci.utils.PropertiesUtil;


@Listeners({TesterListener.class})
public class PRBase {
	

    final static Logger logger = Logger.getLogger(PRBase.class);
    protected PRLogin login;
    protected EMLogin emlogin;
    protected EMOrgLogin emorglogin;
    public static DatabaseUtil databaseUtil;
    public static String gridBrowser, gridNodeIP, gridNodePort, screenSize;
    /*protected PowerBar powerBar;*/
    
    public static String ENABLE_EXECUTION_TRACE;
    public static String EXECUTION_TRACE_FILE;
    public static Map<String, String> execTrace = new HashMap<>();
    public static String EXECUTION_TRACE_KEY_VALUE;

    public static Properties setupProp;
    public static Properties objectMapProp;
    public static Properties setupPropU;

    public static String CORPORATE_UG;
    public static String COM_USER;
    public static String SUPP_USER;
    public static String CORPORATE_USER3;

    public static String SMB_UG;
    public static String SP_USER;
    public static String FI_USER;
    public static String BUY_USER;
    
    public static String HM_USER;
    public static String USER_2FA;

    public static String CHANGE_PASSWORD;
    
    public static String STACK_POFILE_PATH;
    public static String LOCAL_POFILE_PATH;
    
    public static String RESTART_SERV;
    
    // UAT Variables
    public static String UAT_COM_USER;
    public static String UAT_SUPP_USER;
    public static String UAT_SP_USER;
    public static String UAT_FI_USER;
    public static String UAT_BUY_USER;
    public static String UAT_USER_2FA;


    // Disable webdriver debug
    static {

        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");

    }

    @BeforeClass
    public void beforeClass() throws Exception {
        logger.info("EXECUTING before class");

    }

    @AfterClass
    protected void afterClass() throws Exception {
        logger.info("EXECUTING after class");
    }

    @BeforeMethod
    protected void beforeMethod(Method method) throws Exception {
        String testName = this.getClass().getName() + "." + method.getName();
        logger.info("Running Test: " + testName);
        execTrace.put("test", testName);
    }

    /*@AfterMethod
    protected void afterMethod(Method method) throws Exception {
        String testName = this.getClass().getName() + "." + method.getName();
        logger.info("Finishing Test: " + testName);
        if (login != null) {
            login.loggOff();
            Browser.close();
        }
        FileUtils.saveExecutionTraceData(EXECUTION_TRACE_FILE, execTrace);
        execTrace.clear();
    }*/

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
   /*  OTP */ 
    protected void emlogin(String user) {
        EBrowser.eMopen(gridBrowser, gridNodeIP, gridNodePort);
        EBrowser.setScreenSize(screenSize);
        emlogin = new EMLogin(user);
    }

    protected void emlogOff() {
        if (emlogin != null) {
            emlogin.loggOff();
            EBrowser.close();
        }
      /*  OTP */

    }
    protected void emorglogin(String user) {
        Browser.eMopen(gridBrowser, gridNodeIP, gridNodePort);
        Browser.setScreenSize(screenSize);
        emorglogin = new EMOrgLogin(user);
    }

    protected void emorglogOff() {
        if (emlogin != null) {
            emlogin.loggOff();
            Browser.close();
        }


    }

    private void initGlobalData() {
        logger.info("INITIALIZING GLOBAL VARIABLES... ");
        COM_USER = setupProp.getProperty("com.user.username");
        SUPP_USER = setupProp.getProperty("supp.user.username");
        SP_USER = setupProp.getProperty("sp.user.username");
        FI_USER = setupProp.getProperty("fi.user.username");
        BUY_USER = setupProp.getProperty("buy.user.username");
        CHANGE_PASSWORD = setupProp.getProperty("user.password.change");
        
        HM_USER = setupProp.getProperty("em.user");
        USER_2FA = setupProp.getProperty("com.user.2fa");
        
        LOCAL_POFILE_PATH = setupProp.getProperty("local.pofile.path");
        STACK_POFILE_PATH = setupProp.getProperty("stack.server.path");
        
        RESTART_SERV = setupProp.getProperty("restart.serv.bat.file");
               
        ENABLE_EXECUTION_TRACE = setupProp.getProperty("execution.trace.enable");
        EXECUTION_TRACE_FILE = setupProp.getProperty("execution.trace.file");
        EXECUTION_TRACE_KEY_VALUE = setupProp.getProperty("execution.trace.key.value");
        
        //UAT variables
        UAT_COM_USER = setupPropU.getProperty("com.user.username");
        UAT_SUPP_USER = setupPropU.getProperty("supp.user.username");
        UAT_SP_USER = setupPropU.getProperty("sp.user.username");
        UAT_FI_USER = setupPropU.getProperty("fi.user.username");
        UAT_BUY_USER = setupPropU.getProperty("buy.user.username");
        UAT_USER_2FA = setupPropU.getProperty("com.user.2fa");
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
        setupPropU = new PropertiesUtil().getProperties("uatsetup.properties");

        //initialize global variables
        initGlobalData();
        /*--------------------------------------------------------------------------------*/
        //connect my sql database
        /*databaseUtil = new DatabaseUtil();
        databaseUtil.getMySqlConnection();
        databaseUtil.printResults(databaseUtil.getResults());*/
        //databaseUtil.getOracleConnection();
       
		/*-----------------------------------------------------------------------------  */   
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

    /*@AfterSuite
    public void afterSuite(ITestContext ctx) {
        logger.info("FINISHING TEST SUITE: '" + ctx.getName() + "'");
        setupProp = null;
        objectMapProp = null;
        databaseUtil.closeConnection();
        databaseUtil = null;
    }*/

}
