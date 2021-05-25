package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.User;
import com.revature.repository.UserDAO;
import com.revature.repository.UserDAOImpl;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class RegisterDelegate implements Delegateable{

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
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String email = request.getParameter("email");
			String userRole = request.getParameter("userrole");
			
			boolean isNew = userService.checkIfNewUser(userName); 
			
			if(isNew) {
				Integer roleNum = tryParseInt(userRole);
				
				response.setStatus(201);
				User user = new User(0, userName, password, firstName, lastName, email, roleNum);
				userService.addUser(user);
				
				//createCookie(loggedInUser, response);

				if(user.getUserRole() == 2) {
					response.sendRedirect("static/manager.html");
				}else {
					response.sendRedirect("static/employee.html");
				}
			} else {
				String htmlResponse = "<html>";
				htmlResponse += "<h2>The user name " + userName + " is aleady taken.</h2>";
				htmlResponse += "</html>";
				 
				pw.println(htmlResponse);
			}

			break;
		default:
			response.sendError(400, "Request not supported.");
			break;
		}
		
	}
	
	public Integer tryParseInt(String input) {
		Integer num;
		
		try {
			num = Integer.parseInt(input);
		}catch(NumberFormatException e){
			num = 1;
		}
		
		return num;
	}

}
