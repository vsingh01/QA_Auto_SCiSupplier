package com.primerevenue.osci.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.primerevenue.osci.utils.SeleniumUtils;
import com.primerevenue.osci.utils.Synchronizer;

public class EMLogin {
	
	final static Logger logger = Logger.getLogger(EMLogin.class);


    @FindBy(name = "loginfmt")
    public WebElement user_name;

    @FindBy(name = "passwd")
    public WebElement password;

    @FindBy(id = "idSIButton9")
    public WebElement signIn;

    @FindBy(id = "c_meun")
    public WebElement userMenu;

    /*@FindBy(linkText = "Change password")
    public WebElement changePassword;*/

    @FindBy(id = "c_signout")
    public WebElement logout;

    @FindBy(xpath = "//div[@class='title']")
    public WebElement title;

    public static String SUCCESSFUL_LANDING_PAGE_TITLE = "Service Provider Home";
    public static String SECURITY_QUESTION_LANDING_PAGE_TITLE = "Establish Security Questions";

    public EMLogin(String user) {
        PageFactory.initElements(Browser.eDriver, this);
        emlogin(user);
    }

    public void emlogin(String user) {
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
        if (Synchronizer.waitUntilDisplayed(userMenu, 5)) {
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
        }
        return bLoginFailed;
    }

    public void loggOff() {
        Synchronizer.waitUntilDisplayed(userMenu, 5);
        Actions actions = new Actions(Browser.eDriver);
        try {
            // move mouse on user menu which expands drop down pop up
            actions.moveToElement(userMenu).perform();
            // click on log off menu item from drop down pop up
            actions.moveToElement(logout).click().build();
            logger.debug("Successful, logout.");
        } catch (Exception e) {
            logger.error("Failed, user logout.");
        }
    }


}
