package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.LoginDelegate;
import com.revature.delegates.ManagerDelegate;
import com.revature.delegates.RegisterDelegate;

public class RequestHelper {

	public RequestHelper() {
		super();
		
	}
	//Delegates
	private LoginDelegate ld = new LoginDelegate();
	private EmployeeDelegate ed = new EmployeeDelegate();
	private ManagerDelegate md = new ManagerDelegate();
	private RegisterDelegate rd = new RegisterDelegate();

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		StringBuilder uriBuilder = new StringBuilder(request.getRequestURI());
		//System.out.println(uriBuilder);
		
		//Replace domain with ""
		uriBuilder.replace(0, request.getContextPath().length() + 1, "");
		//System.out.println(uriBuilder);
		
		if(uriBuilder.indexOf("/") != -1) {
			request.setAttribute("path", uriBuilder.substring(uriBuilder.indexOf("/") + 1));
			//places subdirectory in an attribute called path
			//System.out.println(uriBuilder);
			
			uriBuilder.replace(uriBuilder.indexOf("/"), uriBuilder.length(), "");
			//System.out.println(uriBuilder);
			
		}
		
		switch(uriBuilder.toString()) {
		case "login":
				ld.process(request, response);
			break;
		case "register":
			rd.process(request, response);
		break;
			
		case "employee":
				ed.process(request, response);
			break;
			
		case "manager":
				md.process(request, response);
			break;
		
		default:
			response.sendError(404, "Path not supported.");
			break;
		
		}
	}
	
}
	
