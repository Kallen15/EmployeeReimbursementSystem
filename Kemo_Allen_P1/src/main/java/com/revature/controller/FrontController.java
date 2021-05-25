package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet{

	private static final long serialVersionUID = 1L;
	
	private RequestHelper rh = new RequestHelper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// Kemo_Allen_P1/subdirectory/{value} - returns subdirectory/
		String path = request.getRequestURI().substring(request.getContextPath().length());
		//System.out.println(path);
				
		if(path.startsWith("/static/") || path.equals("/") || path.equals("/index.html")) {
			super.doGet(request, response);
		}else {	
			rh.processRequest(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
	
}
