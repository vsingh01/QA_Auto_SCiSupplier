package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import java.io.File;

		

public class UserNameCheck {

	final static Logger logger = Logger.getLogger(UserNameCheck.class);
	
	public String UserNameChecks(){
		
	String username = System.getProperty("user.name");
	if (username.equalsIgnoreCase("MrCheese-Office"))
	{
	  username = "MrCheese";
	  return username;
	}
	else 
      return username;
	}
	
	
}
