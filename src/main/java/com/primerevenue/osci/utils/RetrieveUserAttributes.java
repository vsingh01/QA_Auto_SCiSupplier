package com.primerevenue.osci.utils;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Environment;

public class RetrieveUserAttributes  {
	
	 public static void main(String[] args) {
	        RetrieveUserAttributes retrieveUserAttributes = new RetrieveUserAttributes();
	        retrieveUserAttributes.getUserBasicAttributes("ykyuen", retrieveUserAttributes.getLdapContext());
	    }
	 
	 public LdapContext getLdapContext(){
	        LdapContext ctx = null;
	        try{
	            Hashtable env = new Hashtable();
	            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	            env.put(Context.SECURITY_AUTHENTICATION, "Simple");
	            env.put(Context.SECURITY_PRINCIPAL, "administrator@cecid03server.hku.hk");
	            env.put(Context.SECURITY_CREDENTIALS, "your password here");
	            env.put(Context.PROVIDER_URL, "ldap://cecid-03server:389");
	            ctx = new InitialLdapContext(env, null);
	            System.out.println("Connection Successful.");
	        }catch(NamingException nex){
	            System.out.println("LDAP Connection: FAILED");
	            nex.printStackTrace();
	        }
	        return ctx;
	    }
	 
	    private void getUserBasicAttributes(String username, LdapContext ctx) {
	        try {
	            SearchControls constraints = new SearchControls();
	            constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
	            String[] attrIDs = { "distinguishedName", "sn", "givenname", "mail", "telephonenumber"};
	            constraints.setReturningAttributes(attrIDs);
	            //First input parameter is search bas, it can be "CN=Users,DC=YourDomain,DC=com"
	            //Second Attribute can be uid=username
	            NamingEnumeration answer = ctx.search("DC=cecid03server,DC=hku,DC=hk", "sAMAccountName=" + username, constraints);
	            if (answer.hasMore()) {
	                Attributes attrs = ((SearchResult) answer.next()).getAttributes();
	                System.out.println(attrs.get("distinguishedName"));
	                System.out.println(attrs.get("givenname"));
	                System.out.println(attrs.get("sn"));
	                System.out.println(attrs.get("mail"));
	                System.out.println(attrs.get("telephonenumber"));
	            }else{
	                throw new Exception("Invalid User");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return;
	    }

}
