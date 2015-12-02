package com.primerevenue.osci.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.BrowserListener;
import com.primerevenue.osci.driver.PRBase;

public class Browser {

	final static Logger logger = Logger.getLogger(Browser.class);

	public static WebDriver driver;
	public static EventFiringWebDriver eDriver;
	public static BrowserListener oc;
	public static String url;
	public static DesiredCapabilities capabilities;

	// Browser Size
	public static String SMALL = "small";
	public static String MEDIUM = "medium";
	public static String LARGE = "large";

	// Browser Profile
	public static String FIREFOX_PROFILE = "webdriver";

	public static FirefoxProfile FirefoxDriverProfile() throws Exception {
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
	}

	public static void open(String gridBrowser, String gridNodeIP,
			String gridNodePort) {
		try {
			if (isGridModeOn(gridBrowser, gridNodeIP, gridNodePort)) {
				initGrid(gridBrowser, gridNodeIP, gridNodePort);
			} else {
				init();
			}
			eDriver.manage().window().maximize();
			url = PRBase.setupProp.getProperty("browser.url");
			eDriver.get(url);
		} catch (Exception e) {
			logger.error("Failed to get browser URL: " + url);
			return;
		}
	}

	public static void eMopen(String gridBrowser, String gridNodeIP,
			String gridNodePort) {
		try {
			if (isGridModeOn(gridBrowser, gridNodeIP, gridNodePort)) {
				initGrid(gridBrowser, gridNodeIP, gridNodePort);
			} else {
				init();
			}
			eDriver.manage().window().maximize();
			url = PRBase.setupProp.getProperty("embrowser.url");
			eDriver.get(url);
		} catch (Exception e) {
			logger.error("Failed to get browser URL: " + url);
			return;
		}

	}

	public static void initBrowserWebDriver() {

		String browser = PRBase.setupProp.getProperty("browser");
		String browserDriverDirectory = System.getProperty("user.dir")
				+ File.separator + "Webdriver" + File.separator;
		switch (browser) {
		case "firefox":
			driver = getFirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					browserDriverDirectory + "chromedriver.exe");
			driver = getChromeDriver();
			break;
		case "explorer":
			System.setProperty("webdriver.ie.driver", browserDriverDirectory
					+ "IEDriverServer.exe");
			driver = getIEDriver();
			break;
		default:
			logger.info("Invalid browser " + browser);
			System.exit(0);
		}

	}

	public static void initGridDriver(String gridBrowser, String gridNodeIP,
			String gridNodePort) {
		setBrowserCapabilities(gridBrowser);
		try {
			driver = new RemoteWebDriver(new URL("http://" + gridNodeIP + ":"
					+ gridNodePort + "/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eDriver = new EventFiringWebDriver(driver);

	}

	public static void initEventFiringWebDriver() {

		eDriver = new EventFiringWebDriver(driver);
	}

	public static void addBrowserListener() {
		oc = new BrowserListener();
		eDriver.register(oc);
	}

	public static void close() {
		try {
			if (driver != null) {
				driver.close();
				driver.quit();
			}

		} catch (Exception e) {

			logger.error("Failed to close browser !!");

		}
	}

	public static void init() {
		initBrowserWebDriver();
		initEventFiringWebDriver();
		addBrowserListener();

	}

	public static void initGrid(String gridBrowser, String gridNodeIP,
			String gridNodePort) {
		initGridDriver(gridBrowser, gridNodeIP, gridNodePort);
		addBrowserListener();

	}

	public static void setBrowserCapabilities(String browser) {
		switch (browser) {
		case "firefox":

			capabilities = DesiredCapabilities.firefox();
			capabilities.setJavascriptEnabled(true);
			capabilities.setPlatform(Platform.VISTA);
			// set firefox profile
			FirefoxProfile profile = new ProfilesIni()
					.getProfile(FIREFOX_PROFILE);

			capabilities.setCapability(FirefoxDriver.PROFILE, profile);

			break;
		case "chrome":
			capabilities = DesiredCapabilities.chrome();
			capabilities.setJavascriptEnabled(true);
			capabilities.setPlatform(Platform.VISTA);

			break;
		case "explorer":
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setJavascriptEnabled(true);
			capabilities.setPlatform(Platform.VISTA);

			break;
		default:
			logger.info("Invalid browser " + browser);
		}
	}

	public static void setScreenSize(String aScreenSize) {

		if (Browser.SMALL.equalsIgnoreCase(aScreenSize)) {
			Browser.eDriver.manage().window()
					.setSize(getBrowserDimension(Browser.SMALL));

		} else if (Browser.MEDIUM.equalsIgnoreCase(aScreenSize)) {
			Browser.eDriver.manage().window()
					.setSize(getBrowserDimension(Browser.MEDIUM));

		} else if (Browser.LARGE.equalsIgnoreCase(aScreenSize)) {
			// temporarily commented as creating issue
			// Browser.eDriver.manage().window().setSize(prop.getBrowserDimension(Browser.LARGE));

		}

	}

	public static WebDriver getIEDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		return new InternetExplorerDriver(capabilities);
	}

	public static WebDriver getChromeDriver() {
		return new ChromeDriver();
	}

	public static WebDriver getFirefoxDriver() {
		logger.info("Firefox profile: " + FIREFOX_PROFILE);
		FirefoxProfile profile = new ProfilesIni().getProfile(FIREFOX_PROFILE);

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		return new FirefoxDriver(capabilities);
	}

	public static WebDriver configureHtmlUnit() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setJavascriptEnabled(true);
		return new HtmlUnitDriver(capabilities);
	}

	public static Dimension getBrowserDimension(String aScreenSize) {

		String size = null;

		if (aScreenSize.equalsIgnoreCase(Browser.SMALL)) {
			size = PRBase.setupProp.getProperty("browser.size.small");
		}

		if (aScreenSize.equalsIgnoreCase(Browser.MEDIUM)) {
			size = PRBase.setupProp.getProperty("browser.size.medium");
		}

		if (aScreenSize.equalsIgnoreCase(Browser.LARGE)) {
			size = PRBase.setupProp.getProperty("browser.size.large");
		}

		String[] parsedSize = size.split(",");

		return new Dimension(Integer.valueOf(parsedSize[0]),
				Integer.valueOf(parsedSize[1]));

	}

	public static boolean isGridModeOn(String gridBrowser, String gridNodeIP,
			String gridNodePort) {
		if ((gridBrowser == null) || (gridNodeIP == null)
				|| (gridNodePort == null)) {
			return false;
		} else if (gridBrowser.isEmpty() || gridNodeIP.isEmpty()
				|| gridNodePort.isEmpty()) {
			return false;

		} else {
			return true;
		}
	}

}
