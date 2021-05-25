package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.repository.UserDAO;
import com.revature.repository.UserDAOImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class LoginDelegate implements Delegateable{
	
	private ObjectMapper om = new ObjectMapper();
	private UserDAO userDao;
	private UserService userService;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		userDao = new UserDAOImpl();
		userService = new UserServiceImpl(userDao);
		
		PrintWriter pw = response.getWriter();
		
		switch(request.getMethod()) {
		case "POST":
			String userName = request.getParameter("username");
			String password = request.getParameter("password");	
			
			User loggedInUser = userService.loginUser(userName, password);
			
			if(loggedInUser != null) {
				response.setStatus(201);
				
				request.getSession().setAttribute("id", loggedInUser.getId()+"");
				
				//createCookie(loggedInUser, response);

				if(loggedInUser.getUserRole() == 2) {
					response.sendRedirect("static/manager.html");
				}else {
					response.sendRedirect("static/employee.html");
				}
			} else {
				String htmlResponse = "<html>";
				htmlResponse += "<h2>The password was either incorrect or user " + userName + " doesn't exist.</h2>";
				htmlResponse += "</html>";
				 
				pw.println(htmlResponse);
			}

			break;
		default:
			response.sendError(400, "Request not supported.");
			break;
		}
		
	}
	
	public void createCookie(User user, HttpServletResponse response) {
		//Cookie cookies[]=request.getCookies();
		
		Cookie newCookie = new Cookie("userId", user.getId() +"");
		
		response.addCookie(newCookie);
		
	}

	
}
