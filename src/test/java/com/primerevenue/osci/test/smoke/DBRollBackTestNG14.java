package com.primerevenue.osci.test.smoke;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.naming.NamingException;

import org.testng.annotations.Test;

import com.primerevenue.osci.driver.PRBase;
import com.primerevenue.osci.pageobjects.common.PDFManager;
import com.primerevenue.osci.utils.ActiveDirectory;
import com.primerevenue.osci.utils.DatabaseUtil;
import com.primerevenue.osci.utils.LDAPTest;
import com.primerevenue.osci.utils.RetrieveUserAttributes;
import com.primerevenue.osci.utils.SeleniumUtils;


/**
 * @author Sai Amuluru;
 *
 **/


public class DBRollBackTestNG14 extends PRBase {
	
	@Test
	public void testdb()  {
		
		databaseUtil = new DatabaseUtil();
        databaseUtil.getMySqlConnection();
        //databaseUtil.printResults(databaseUtil.getSupIdResults());
        databaseUtil.delSupId();
        
        //Add delete buyer program here
	}
		
	
}
	
	
	

	
	

