package com.harvey.vchat.bas.utils;



import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import com.harvey.common.core.config.Config;

public class ADUtil {

	public static boolean adAuthen(String userName,String password) throws NamingException {
		String host = Config.get("host");  //AD Server
		String port =Config.get("port");              //SSL port
		String domain= Config.get("domain");
		//String root = "dc=gsst,dc=com"; // root
		String url = new String(Config.get("ldap_protocal") + "://" + host + ":" + port);
		String user = userName.indexOf(domain) > 0 ? userName : userName + domain;
        // user="cn="+userName+",dc="+Config.get("dc1")+",dc="+Config.get("dc2");
		Hashtable<String, String> env = new Hashtable<String, String>();
		DirContext ctx;
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, user);//Manager,dc=GSST,dc=com
		env.put(Context.SECURITY_CREDENTIALS, password);//"abc123"
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, url);
		
		ctx = new InitialDirContext(env);
		ctx.close();
			
		return true;
	}

}
