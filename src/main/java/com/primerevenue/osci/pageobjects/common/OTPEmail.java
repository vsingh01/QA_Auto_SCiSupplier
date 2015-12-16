package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import com.primerevenue.osci.driver.Browser;
import com.primerevenue.osci.utils.SeleniumUtils;

public class OTPEmail {
	final static Logger logger = Logger.getLogger(OTPEmail.class);
	
	@FindBy(name = "loginfmt")
    public WebElement euser_name;

    @FindBy(name = "passwd")
    public WebElement epassword;

    @FindBy(id = "idSIButton9")
    public WebElement esignIn;
    
    @FindBy(xpath = "//script[@type='jsv#7^']/..")
	public WebElement inbox;

	@FindBy(xpath = "html/body/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/ul/li[1]/span[2]/span[1]/div/span/span")
	public WebElement newEmail;

	@FindBy(xpath = "html/body/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/pre")
	public WebElement msgEmail;
	
	@FindBy(xpath = "html/body/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/pre")
	public WebElement otpMsgEmail;
	
	public String accessCode;
    
    public void loginToEmail()	{
    	
    
    WebDriver sddsads = new FirefoxDriver();
	
    sddsads.manage().window().maximize();
    
	sddsads.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1449004365&rver=6.4.6456.0&wp=MBI_SSL_SHARED&wreply=https:%2F%2Fcol126.mail.live.com%2Fdefault.aspx%3Frru%3Dinbox&lc=1033&id=64855&mkt=en-us&cbcxt=mai");
	
	sddsads.findElement(By.name("loginfmt")).sendKeys("primerevenueqauto@hotmail.com");
	sddsads.findElement(By.name("passwd")).sendKeys("Prime109");
	sddsads.findElement(By.id("idSIButton9")).click();
	
	
	System.out.println("email title::::"+ sddsads.getTitle());
	
		
	
	sddsads.findElement(By.xpath("//script[@type='jsv#7^']/..")).click();
	sddsads.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/ul/li[1]/span[2]/span[1]/div/span/span")).click();
	
	
	
	
	/*SeleniumUtils.typeText(euser_name, "primerevenueqauto@hotmail.com");
	SeleniumUtils.typeText(epassword, "Prime109");
	SeleniumUtils.click(esignIn);*/
	
	
	
	//SeleniumUtils.click(inbox);
	//SeleniumUtils.click(newEmail);

	/*String accessCode;
	String otpmsgCont = sddsads.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/pre")).getText();
	int xx = otpmsgCont.indexOf("Code:");
	System.out.println("Access Code:::::" + xx);
	accessCode = otpmsgCont.substring(xx+5, xx+11);
	System.out.println("Access Code>>>>>"+ accessCode);
	this.accessCode = accessCode;
	Browser.close();
		
	return accessCode;*/
    
    }
	
}
