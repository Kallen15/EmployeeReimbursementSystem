package com.revature;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Driver {

	public static void main(String[] args) throws LifecycleException {
//		UserDAO ud = new UserDAOImpl();
//		ReimbursementDAO rd = new ReimbDAOImpl();
//		UserService us = new UserServiceImpl(ud);
//		ReimbursementService rs = new ReimbServiceImpl(rd);
//		
//		LocalDateTime ts = LocalDateTime.now();
//		
//		Reimbursement r = new Reimbursement(0, 1, null, 0, 10.11, null, ts, null, 1, "Testing 2");
//		
//		//rs.addReimbursement(r);
//		
//		System.out.println(rs.getAllReimbursements());
//		System.out.println(us.getAllUsers());
		
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir("temp");
		tomcat.setPort(8080);	 
		
		
		String webappDirLocation = "src/main/webapp/";
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("/" + webappDirLocation).getAbsolutePath());
        
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);
        
        tomcat.start();
        tomcat.getServer().await();
        
        //tomcat.stop();
	}

}
