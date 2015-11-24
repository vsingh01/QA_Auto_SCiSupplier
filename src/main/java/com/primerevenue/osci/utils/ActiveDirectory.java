/*package com.primerevenue.osci.utils;

import java.util.Properties;

import javax.naming.*;
import javax.naming.ldap.*;
import java.util.Hashtable;
import javax.naming.directory.*;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.log4j.Logger;

public class ActiveDirectory {
	
	final static Logger logger = Logger.getLogger(SeleniumUtils.class);
	*//**
	 * constructor with parameter for initializing a LDAP context
	 * 
	 * @param username a {@link java.lang.String} object - username to establish a LDAP connection
	 * @param password a {@link java.lang.String} object - password to establish a LDAP connection
	 * @param domainController a {@link java.lang.String} object - domain controller name for LDAP connection
	 *//*
	public ActiveDirectory(String username, String password, String domainController) {
		Properties properties = new Properties();
	    properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	    properties.put(Context.PROVIDER_URL, "LDAP://" + domainController);
	    properties.put(Context.SECURITY_PRINCIPAL, username + "@" + domainController);
	    properties.put(Context.SECURITY_CREDENTIALS, password);
	 
	    // initializing active directory LDAP connection
	    try {
	    	InitialDirContext dirContext = new InitialDirContext(properties);
	    } catch (NamingException e) {
	        logger.info(e.getMessage());
	    }    
	 
	    // default domain base for search
	    domainBase = getDomainBase(domainController);  
	    
	 
	    // initializing search controls
	    SearchControls searchCtls = new SearchControls();
	    searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
	    searchCtls.setReturningAttributes(returnAttributes);

}
	*//**
	 * search the Active directory by username/email id for given search base
	 * 
	 * @param searchValue a {@link java.lang.String} object - search value used for AD search for eg. username or email
	 * @param searchBy a {@link java.lang.String} object - scope of search by username or by email id
	 * @param searchBase a {@link java.lang.String} object - search base value for scope tree for eg. DC=myjeeva,DC=com
	 * @return search result a {@link javax.naming.NamingEnumeration} object - active directory search result
	 * @throws NamingException
	 *//*
	public NamingEnumeration<SearchResult> searchUser(String searchValue, 
	                String searchBy, String searchBase) throws NamingException {
	    String filter = getFilter(searchValue, searchBy);    
	 
	    // For eg.: "DC=myjeeva,DC=com";
	    String base = (null == searchBase) ? domainBase : getDomainBase(searchBase);
	 
	    return this.dirContext.search(base, filter, this.searchCtls);
	}
	 
	private String getFilter(String searchValue, String searchBy) {
	    String filter = this.baseFilter;
	    if(searchBy.equals("email")) {
	        filter += "(mail=" + searchValue + "))";
	    } else if(searchBy.equals("username")) {
	        filter += "(samaccountname=" + searchValue + "))";
	    }
	 
	    return filter;
	}

}*/