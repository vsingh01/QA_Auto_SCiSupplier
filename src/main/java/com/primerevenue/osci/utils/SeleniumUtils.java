package com.primerevenue.osci.utils;

import com.asprise.util.ocr.OCR;
import com.primerevenue.osci.driver.PRBase;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.primerevenue.osci.driver.Browser;

//import org.sikuli.script.Key;
import org.testng.ITestNGMethod;
import org.testng.Reporter;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

/**
 * @author Sai Amuluru;
 *
 **/

public class SeleniumUtils {

	final static Logger logger = Logger.getLogger(SeleniumUtils.class);

	public static Alert isAlertPresent(EventFiringWebDriver driver) {

		Alert myDynamicElement = null;
		try {
			myDynamicElement = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println("Alert not appear");
		}
		return myDynamicElement;

	}

	public static boolean isTextPresent(String text) {
		try {
			boolean flag = Browser.eDriver.getPageSource().contains(text);
			return flag;
		} catch (Exception e) {
			return false;
		}

	}

	public static void selectCheckBox(WebElement checkbox, String flag) {
		Synchronizer.pollElementVisibility(checkbox, 3);
		if (!flag.equalsIgnoreCase("ON")
				&& (!checkbox.getAttribute("value").equalsIgnoreCase("1"))) {
			checkbox.click();
			logger.info("Checkbox clicked");
		}
	}

	public static void selectButtonByText(WebDriver driverObj,
			String buttonLabel) {
		boolean bFoundIt = false;
		try {
			int attempts = 0;
			List<WebElement> buttons = null;
			while ((!bFoundIt) && (attempts < 5)) {
				buttons = driverObj.findElements(By.tagName("button"));
				for (WebElement button : buttons) {
					String appText = button.getText();
					if (button.isDisplayed()
							&& appText.equalsIgnoreCase(buttonLabel)) {
						Synchronizer.waitClickableElement(button);
						button.click();

						bFoundIt = true;
						break;
					}

				}

				attempts++;
				Synchronizer.explicitWait(1);
			}

		} catch (Exception e) {
			logger.error("ERROR: Failed clicking button, " + buttonLabel);
		}

	}

	public static void scrollInFocusBy(WebDriver driverObj, By by) {
		WebElement we = null;

		try {
			we = driverObj.findElement(by);

			((JavascriptExecutor) driverObj).executeScript(
					"arguments[0].scrollIntoView(true);", we);

		} catch (Exception e) {
			logger.error("EXCEPTION: Failed scrolling web element in focus, "
					+ we.getAttribute("id"));
		}
	}

	public static void scrollInFocus(WebElement element) {

		try {
			((JavascriptExecutor) Browser.eDriver).executeScript(
					"arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			logger.error("EXCEPTION: Failed scrolling web element in focus, "
					+ element.getAttribute("id"));
		}
	}

	public static void mouseClick(WebElement element) {
		try {
			Synchronizer.waitUntilDisplayed(element, 60);
			Actions builder = new Actions(Browser.eDriver);
			builder.moveToElement(element).perform();
			builder.click().perform();
		} catch (Exception e) {

		}

	}

	public static WebElement getElementPresent(String logicalName,
			EventFiringWebDriver driver) {

		WebElement myDynamicElement = null;
		By by = null;
		try {
			by = getLocator(logicalName);
			myDynamicElement = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			System.out.println("Element " + by + " not found");
		}
		return myDynamicElement;

	}

	public static boolean presenceOfElementLocatedBy(By element,
			EventFiringWebDriver driver) {
		boolean flag = true;
		try {

			WebElement we = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(element));
			if (we == null)
				flag = false;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public static void waitForVisibility(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(Browser.eDriver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void selectOptionByText(WebElement parent, String text) {
		boolean found = false;
		List<WebElement> list = parent.findElements(By.tagName("li"));
		for (WebElement elem : list) {
			if (elem.findElement(By.tagName("div")).getText().trim()
					.equalsIgnoreCase(text)) {
				elem.click();
				found = true;
				break;
			}

		}
		if (!found) {
			logger.info("Option '" + text + "' not found");
		}
	}

	public static void selectOptionByPartialText(WebElement parent, String text) {
		boolean found = false;
		Synchronizer.waitUntilPageReady();
		if (Synchronizer.pollElementVisibility(parent, 10)) {
			List<WebElement> list = parent.findElements(By.tagName("li"));
			for (WebElement elem : list) {
				if (elem.findElement(By.tagName("div")).getText().trim()
						.contains(text)) {
					Synchronizer.waitClickableElement(elem);
					elem.click();
					found = true;
					break;
				}

			}
		}
		if (!found) {
			logger.info("Option '" + text + "' not found");
		}

	}

	public static void selectOptionByPartialText(WebElement dropDown,
			WebElement dropList, String text) {
		boolean found = false;
		SeleniumUtils.click(dropDown);
		Synchronizer.pollElementVisibility(dropList, 10);
		List<WebElement> list = dropList.findElements(By.tagName("li"));
		for (WebElement elem : list) {
			if (elem.findElement(By.tagName("div")).getText().trim()
					.contains(text)) {
				Synchronizer.waitClickableElement(elem);
				elem.click();
				found = true;
				break;
			}

		}
		if (!found) {
			logger.info("Option '" + text + "' not found");
		}
	}

	public static void selectOption(WebElement elem, String text) {
		WebElement select = elem;
		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (text.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

	public static void selectOptionBy(By elem, String text) {
		WebElement select = SeleniumUtils.getElementBy(elem);
		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (text.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

	public static void click(WebElement element) {
		SeleniumUtils.scrollInFocus(element);
		Synchronizer.waitClickableElement(element);
		element.click();
	}

	public static void clickBy(By predecessor, By element) throws Exception {
		if (Synchronizer.pollElementVisibilityBy(predecessor, 3)) {
			WebElement preD = null;
			try {
				preD = Browser.eDriver.findElement(predecessor);
			} catch (Exception e) {
				logger.error("Failed to find predecessor in clickBy");
				throw (e);
			}
			WebElement elem = null;
			try {
				elem = preD.findElement(element);
			} catch (Exception e) {
				logger.error("Failed to find child element in predecessor");
				throw (e);
			}
			SeleniumUtils.click(elem);

		}
	}

	public static void type(WebElement element, String text) {
		if (Synchronizer.pollElementVisibility(element, 10)) {
			Synchronizer.waitClickableElement(element);
			SeleniumUtils.scrollInFocus(element);
			element.click();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			element.clear();
			element.sendKeys(text);
			logger.info("Typed text:  " + text);
		}
	}

	public static void clearWithBackSpace(WebElement element) {
		if (Synchronizer.pollElementVisibility(element, 10)) {
			Synchronizer.waitClickableElement(element);
			SeleniumUtils.scrollInFocus(element);
			String text = element.getText();
			element.sendKeys(Keys.ENTER);
			for (int i = 0; i < text.length(); i++) {
				element.sendKeys(Keys.BACK_SPACE);
			}
		}
	}

	public static void typeText(WebElement element, String text) {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		element.click();
		element.clear();
		element.sendKeys(text);
		logger.info("Typed text:  " + text);
	}

	public static void typeBy(By predecessor, By ancestor, String text)
			throws Exception {
		WebElement anC = null;
		WebElement preD = SeleniumUtils.getElementBy(predecessor);
		try {
			anC = preD.findElement(ancestor);
		} catch (Exception e) {
			logger.error("ANCESTOR not found");
			throw (e);
		}

		if (Synchronizer.pollElementVisibility(anC, 5)) {
			anC.sendKeys(text);
		}

	}

	public static void typeBy(WebElement predecessor, By ancestor, String text)
			throws Exception {
		WebElement anC = null;
		try {
			anC = predecessor.findElement(ancestor);
		} catch (Exception e) {
			logger.error("ANCESTOR not found");
			throw (e);
		}

		if (Synchronizer.pollElementVisibility(anC, 5)) {
			anC.sendKeys(text);
		}

	}

	public static void typeAndEnter(WebElement element, String text) {
		Synchronizer.pollElementVisibility(element, 5);
		element.clear();
		element.sendKeys(text + Keys.ENTER);
		logger.info("Typed text:  " + text);
	}

	public static void selectFromList(WebElement listId, WebElement dropDown,
			String value) {
		Synchronizer.waitUntilPageReady();
		Synchronizer.pollElementVisibility(listId, 10);
		SeleniumUtils.scrollInFocus(listId);
		try {
			Synchronizer.waitUntilDisplayed(
					listId.findElement(By.xpath("./a/span[1]")), 60);
			Synchronizer.waitClickableElement(listId.findElement(By
					.xpath("./a/span[1]")));
			SeleniumUtils.click(listId.findElement(By.xpath("./a/span[1]")));
		} catch (Exception e) {
			SeleniumUtils.click(listId.findElement(By.xpath("./a/span[1]")));
		}
		try {

			Synchronizer.pollElementVisibility(dropDown, 5);
			SeleniumUtils.selectOptionByPartialText(dropDown, value);
		} catch (Exception e) {
			SeleniumUtils.selectOptionByPartialText(dropDown, value);
		}

	}

	public static void typeFromList(WebElement we, String text) {
		int wait_time = 1000;

		SeleniumUtils.scrollInFocus(we);
		Synchronizer.waitClickableElement(we);

		we = we.findElement(By.xpath("./a"));

		we.click();
		Synchronizer.explicitWait(1);

		By by = By.xpath("//div[@id='select2-drop']/div[1]/input[1]");
		Synchronizer.waitClickableBy(by);
		WebElement textBox = Browser.eDriver.findElement(by);
		textBox.sendKeys(text);
		Synchronizer.waitUntilPageReady();

		Synchronizer.waitClickableElement(textBox);
		try {
			Thread.sleep(wait_time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		textBox.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(wait_time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollInFocusByWebElement(WebDriver driverObj,
			WebElement we) {
		try {
			((JavascriptExecutor) driverObj).executeScript(
					"arguments[0].scrollIntoView(true);", we);
		} catch (Exception e) {
			logger.error("EXCEPTION: Failed scrolling web element in focus, "
					+ we.getAttribute("id"));
		}
	}

	public static void selectFromList(WebElement parent, String text) {
		Synchronizer.waitUntilPageReady();
		SeleniumUtils.scrollInFocus(parent);
		Synchronizer.waitClickableElement(parent);
		SeleniumUtils.click(parent);
		WebElement dropId = Browser.eDriver.findElement(By
				.xpath("//div[@id='select2-drop']"));
		Synchronizer.explicitWait(1);
		WebElement input = dropId.findElement(By.tagName("input"));
		input.sendKeys(text);
		input.sendKeys(Keys.ENTER);

	}

	public static void takeScreenShoot(ITestNGMethod testMethod) {
		try {
			WebDriver augmentedDriver = new Augmenter()
					.augment(Browser.eDriver);
			File screenShot = ((TakesScreenshot) augmentedDriver)
					.getScreenshotAs(OutputType.FILE);
			String nameScreenShot = testMethod.getTestClass().getRealClass()
					.getSimpleName()
					+ "_" + testMethod.getMethodName();
			String path = getPath(nameScreenShot);
			org.apache.commons.io.FileUtils
					.copyFile(screenShot, new File(path));
			Reporter.log("<a href=" + path + " target='_blank' >"
					+ getFileName(nameScreenShot) + "</a>");
		} catch (Exception e) {
			logger.error("Failed in capturing screen shot");
		}
	}

	private static String getFileName(String nameTest) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		Date date = new Date();
		return dateFormat.format(date) + "_" + nameTest + ".png";
	}

	private static String getPath(String nameTest) throws IOException {
		File directory = new File(".");
		String newFileNamePath = directory.getCanonicalPath()
				+ "/target/surefire-reports/screen_shots/NHScreenShot_"
				+ getFileName(nameTest);
		return newFileNamePath;
	}

	public static void selectButtonByText(By predecessor, String buttonLabel) {
		boolean bFoundIt = false;
		try {
			if (Synchronizer.pollElementVisibilityBy(predecessor, 5)) {
				WebElement preD = null;
				try {
					preD = Browser.eDriver.findElement(predecessor);
				} catch (Exception e) {
					logger.error("Predecessor for button not found");
					throw (e);
				}
				int attempts = 0;
				List<WebElement> buttons = null;
				while ((!bFoundIt) && (attempts < 5)) {
					try {
						buttons = preD.findElements(By.tagName("button"));
					} catch (Exception e) {

					}
					for (WebElement button : buttons) {
						String appText = button.getText();
						if (button.isDisplayed()
								&& appText.equalsIgnoreCase(buttonLabel)) {
							Synchronizer.waitClickableElement(button);
							button.click();
							bFoundIt = true;
							break;
						}

					}

					attempts++;
					Synchronizer.explicitWait(1);
				}
			}

		} catch (Exception e) {
			logger.error("ERROR: Failed clicking button, " + buttonLabel);
		}
	}

	public static void selectButtonByText(WebElement predecessor,
			String buttonLabel) {
		boolean bFoundIt = false;
		try {
			if (Synchronizer.pollElementVisibility(predecessor, 5)) {

				int attempts = 0;
				List<WebElement> buttons = null;
				while ((!bFoundIt) && (attempts < 5)) {
					try {
						buttons = predecessor
								.findElements(By.tagName("button"));
					} catch (Exception e) {

					}
					for (WebElement button : buttons) {
						String appText = button.getText();
						if (button.isDisplayed()
								&& appText.equalsIgnoreCase(buttonLabel)) {
							Synchronizer.waitClickableElement(button);
							button.click();
							bFoundIt = true;
							break;
						}

					}

					attempts++;
					Synchronizer.explicitWait(1);
				}
			}

		} catch (Exception e) {
			logger.error("ERROR: Failed clicking button, " + buttonLabel);
		}
	}

	public static String getTagAttribute(By by, String attribute)
			throws Exception {
		String attr = null;
		if (Synchronizer.pollElementVisibilityBy(by, 3)) {
			WebElement elem = null;
			try {
				elem = Browser.eDriver.findElement(by);
			} catch (Exception e) {
				logger.error("Failed to find element for tag attribute");
				throw (e);
			}
			attr = elem.getAttribute(attribute);
		}
		return attr;
	}

	public static void selectPopupMenu(String menuItem) throws Exception {
		Synchronizer.waitUntilPageReady();
		boolean found = false;
		WebElement popupMenu = null;
		try {
			popupMenu = Browser.eDriver.findElement(By
					.className("dropdown-menu"));
		} catch (Exception e) {
			logger.error("pop up menu not found");
			throw (e);
		}

		String buttonLabel = "";
		WebElement button = null;
		List<WebElement> list = popupMenu.findElements(By.tagName("li"));
		for (WebElement li : list) {
			try {
				button = li.findElement(By.tagName("button"));
				buttonLabel = button.getText();
				if (menuItem.toLowerCase().equalsIgnoreCase(
						buttonLabel.toLowerCase())) {
					button.click();
					found = true;
					break;
				}
			} catch (Exception e) {

			}
		}
		if (!found) {
			logger.error("drop down menu " + menuItem + " not found");
			throw (new Exception("drop down menu " + menuItem + " not found"));
		}

	}

	public static void clickCheckBox(WebElement checkBox, String onOfFlga) {
		switch (onOfFlga) {
		case "ON": {
			if (!checkBox.getAttribute("value").equalsIgnoreCase("1")) {
				checkBox.click();
			}
			break;
		}
		case "OFF": {
			if (!checkBox.getAttribute("value").equalsIgnoreCase("1")) {
				checkBox.click();
			}
			break;
		}
		}
	}

	public static By getLocator(String logicalElementName) {
		String locator = PRBase.objectMapProp.getProperty(logicalElementName);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		switch (locatorType.toString().toLowerCase()) {
		case "id": {
			return By.id(locatorValue);
		}

		case "name": {
			return By.name(locatorValue);
		}

		case "classname": {
			return By.className(locatorValue);
		}

		case "tagname": {
			return By.tagName(locatorValue);
		}

		case "linktext": {
			return By.linkText(locatorValue);
		}

		case "partciallinktext": {
			return By.partialLinkText(locatorValue);
		}

		case "cssselector": {
			return By.cssSelector(locatorValue);
		}

		case "xpath": {
			return By.xpath(locatorValue);
		}

		default: {

			try {
				throw new NoSuchElementException("Locator type, " + locatorType
						+ "not defined !!");
			} catch (Exception e) {
				e.printStackTrace();
			}

			return By.id("NOT FOUND");

		}

		}

	}

	/**
	 * Search for element either found or maximum attempt reached
	 *
	 * @param by
	 * @return
	 */
	public static WebElement getElementBy(By by) {
		WebElement element = null;
		boolean found = false;
		int attempt = 0;
		while (!found && attempt < 5) {
			try {
				element = Browser.eDriver.findElement(by);
				found = true;
			} catch (Exception x) {
				Synchronizer.explicitWait(1);
				attempt++;
			}
		}
		return element;
	}

	public static void switchToNewWindow(WebElement elm1, WebElement elm2) {

		String parent_window = Browser.eDriver.getWindowHandle();
		System.out.println("Main windowId :::::" + parent_window);

		Set<String> s1 = Browser.eDriver.getWindowHandles();

		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String child_window = i1.next();

			if (!parent_window.equalsIgnoreCase(child_window)) {

				Browser.eDriver.switchTo().window(child_window);
				System.out.println("Report windowId :::::" + child_window);
				Synchronizer.explicitWait(5);

				Browser.eDriver.switchTo().window(child_window).close();
			}
		}
		Browser.eDriver.switchTo().window(parent_window);
	}

	public static boolean isElementPresent(String eleXpath) {

		int count = Browser.eDriver.findElements(By.xpath(eleXpath)).size();

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	/* Get the newest file for a specific extension */
	public static File getTheNewestFile(String filePath, String ext) {
		File theNewestFile = null;
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("*." + ext);
		File[] files = dir.listFiles(fileFilter);

		if (files.length > 0) {
			/** The newest file comes first **/
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		}

		return theNewestFile;
	}

}
