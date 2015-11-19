package com.primerevenue.osci.utils;

import com.primerevenue.osci.driver.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sai Amuluru on 11/3/2015.
 */

public class Synchronizer {
    final static Logger logger = Logger.getLogger(Synchronizer.class);

    public static boolean implicitWait(long time) {
        try {
            Browser.eDriver.manage().timeouts()
                    .implicitlyWait(time, TimeUnit.SECONDS);
            logger.info("Waited for " + time + " sec implicity.");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void resetImplicitWait() {
        Browser.eDriver.manage().timeouts()
                .implicitlyWait(0, TimeUnit.SECONDS);
        logger.info("Implicit wait is reset to zero second");
    }


    public static void waitUntilVisible(List<WebElement> element, int seconds) {

        WebDriverWait wait = new WebDriverWait(Browser.eDriver, seconds);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));


    }

    public static void waitUntilVisible(WebElement element, int seconds) {

        WebDriverWait wait = new WebDriverWait(Browser.eDriver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));


    }

    /**
     * Verify element visibility by waiting 1 second with each attempt
     *
     * @param element
     * @param attempt
     */
    public static boolean pollElementVisibility(WebElement element, int attempt) {

        WebDriverWait wait = new WebDriverWait(Browser.eDriver, 1);
        WebElement elem = null;
        boolean flag = false;
        while (attempt > 0 && elem == null) {
            elem = wait.until(ExpectedConditions.visibilityOf(element));
            if (elem != null) {
                flag = true;
                break;
            }
            attempt--;
            logger.info("Wait 1 second for element's visibility...");
        }
        return flag;


    }
    /**
     * Verify element visibility by waiting 1 second with each attempt
     *
     * @param by
     * @param attempt
     */
    public static boolean pollElementVisibilityBy(By by, int attempt) {

        WebDriverWait wait = new WebDriverWait(Browser.eDriver, 1);
        WebElement elem = null;
        boolean flag = false;
        while (attempt > 0 && elem == null) {
            elem = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            if (elem != null) {
                flag = true;
                break;
            }
            attempt--;
            logger.info("Wait 1 second for element's visibility...");
        }
        return flag;


    }

    public static boolean waitUntilDisplayed(WebElement we, int seconds) {

        int tries = 0;
        Boolean bIsDisplayed = false;

        while (!bIsDisplayed && tries < 2) {

            try {

                bIsDisplayed = we.isDisplayed();

            } catch (Exception e) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }

            tries++;

        }
        return bIsDisplayed;
    }

    public static void waitClickableById(WebDriver driverObj, String id, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driverObj, seconds);
            wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        } catch (Exception e) {
            logger.error("Failed waiting for clickable ID: " + id);
        }
    }

    public static void waitClickableBy(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(Browser.eDriver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            logger.error("Failed waiting for web element locator");
        }
    }

    public static void waitClickableElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Browser.eDriver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("Failed waiting for clickable");
        }
    }
    public static void waitClickableElementBy(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(Browser.eDriver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("Failed waiting for clickable");
        }
    }


    public static WebElement waitUntilVisible(By by, int seconds) {

        WebDriverWait wait = new WebDriverWait(Browser.eDriver, seconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));


    }
    public static void explicitWait(int seconds){
        try{
            Thread.sleep(1000*seconds);
            logger.info("Explicit wait "+seconds+ " second");
        }catch(InterruptedException ie){

        }
    }


    public static void waitClickableBy(WebDriver driverObj, By by, int seconds) {
        boolean bFoundIt = false;
        try {
            WebDriverWait wait = new WebDriverWait(driverObj, seconds);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            bFoundIt = true;
        }
        catch (Exception e) {
            logger.error("Failed waiting for web element locator");
        }
    }
    public static void waitUntilPageReady() {
        JavascriptExecutor js = (JavascriptExecutor)Browser.eDriver;
        for (int i=0; i<30; i++){
            try {
                Thread.sleep(500);
            }catch (InterruptedException e) {}
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }
    }
}
