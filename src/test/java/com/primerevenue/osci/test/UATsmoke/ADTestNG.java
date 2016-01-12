package com.primerevenue.osci.test.UATsmoke;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.primerevenue.osci.utils.ActiveDirectory;
import com.primerevenue.osci.utils.Synchronizer;

public class ADTestNG {
	
	final static Logger logger = Logger.getLogger(ADTestNG.class);
	
	@Test
	public void admokeTest1() throws InterruptedException, NamingException {
		Synchronizer.implicitWait(10);
		
				
		ActiveDirectory dcd = new ActiveDirectory("QATEST/qaadmin", "Prpass99", "qatestdc.qatest.pr.net:389" );
		dcd.searchUser("samulu2", "cn=ldap,cn=Users,dc=qatest,dc=pr,dc=net", "ou=SCF,dc=qatest,dc=pr,dc=net");
		

	}

}
