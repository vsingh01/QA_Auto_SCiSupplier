package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

/**
 * @author Sai Amuluru;
 *
 **/

public class PRLogin {
	
	final static Logger logger = Logger.getLogger(PRLogin.class);


    @FindBy(xpath = ".//input[@type='text']")
    public WebElement user_name;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement signIn;

    @FindBy(id = "forgotPassword")
    public WebElement fgpwd;

    @FindBy(id = "dashboard-toggle")
    public WebElement userMenu;

    /*@FindBy(linkText = "Change password")
    public WebElement changePassword;*/

    @FindBy(id = "watLogout")
    public WebElement logout;

    @FindBy(xpath = "//div[@class='title']")
    public WebElement title;

    public static String SUCCESSFUL_LANDING_PAGE_TITLE = "Service Provider Home";
    public static String SECURITY_QUESTION_LANDING_PAGE_TITLE = "Establish Security Questions";

    public PRLogin(String user) {
        PageFactory.initElements(Browser.eDriver, this);
        login(user);
    }

    public void login(String user) {
        int attempt = 0;
        boolean bFoundUg = false;
        while (!bFoundUg) {
            try {
                user_name.isDisplayed();
                bFoundUg = true;
            } catch (Exception e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.getMessage();
                }

            }

        }

        do {
            SeleniumUtils.type(user_name, user);
            PRBase.execTrace.put("user", user);
            password.clear();
            password.sendKeys(PRBase.setupProp.getProperty("user.password"));
            SeleniumUtils.click(signIn);
            Synchronizer.explicitWait(1);
            attempt++;
        } while (isLoginFailed() == true && attempt < 3);

    }

    public Boolean isLoginFailed() {
        Synchronizer.explicitWait(2);
        boolean bLoginFailed = false;
        //if user menu is displayed then login is successful
        /*if (Synchronizer.waitUntilDisplayed(userMenu, 5)) {
            bLoginFailed = false;
            //check correct Landing page appears
            if (Synchronizer.pollElementVisibility(title, 5)) {
                if (title.getText().trim().equalsIgnoreCase(SUCCESSFUL_LANDING_PAGE_TITLE)) {
                    logger.info("Successful login.");
                    //check if security question page appears
                } 
            }
        } else {
            bLoginFailed = true;
        }*/
        return bLoginFailed;
    }

    public void loggOff() {
    	PageFactory.initElements(Browser.eDriver, this);
        //Synchronizer.waitUntilDisplayed(userMenu, 5);
       // Actions actions = new Actions(Browser.eDriver);
        try {
            // move mouse on user menu which expands drop down pop up
            //actions.moveToElement(logout).perform();
            // click on log off menu item from drop down pop up
           // actions.moveToElement(logout).click().build();
        	SeleniumUtils.click(logout);
            logger.debug("Successful, logout.");
        } catch (Exception e) {
            logger.error("Failed, user logout.");
        }
    }

   
}
