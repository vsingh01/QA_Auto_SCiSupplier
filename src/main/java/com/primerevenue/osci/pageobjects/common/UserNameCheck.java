package com.primerevenue.osci.pageobjects.common;

import org.apache.log4j.Logger;
import java.io.File;

<<<<<<< HEAD
//Vishal



public class UserNameCheck {

	final static Logger logger = Logger.getLogger(UserNameCheck.class);
	
	public String UserNameChecks(){
		
		
	String user1;	
=======
public class UserNameCheck {

	final static Logger logger = Logger.getLogger(UserNameCheck.class);
	
	public String UserNameChecks(){
		
>>>>>>> refs/heads/master
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
