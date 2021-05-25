package com.revature.delegates;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repository.ReimbDAOImpl;
import com.revature.repository.ReimbursementDAO;
import com.revature.repository.UserDAO;
import com.revature.repository.UserDAOImpl;
import com.revature.service.ReimbServiceImpl;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class ManagerDelegate implements Delegateable{
	private ObjectMapper om = new ObjectMapper();
	private UserDAO userDao;
	private UserService userService;
	private ReimbursementDAO reimbDao;
	private ReimbursementService reimbService;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//DAOs and Services
		userDao = new UserDAOImpl();
		userService = new UserServiceImpl(userDao);
		reimbDao = new ReimbDAOImpl();
		reimbService = new ReimbServiceImpl(reimbDao);
				
		String path = (String) request.getAttribute("path");
				
		//Add time datatype to Jackson
		om.registerModule(new JavaTimeModule());
		HttpSession session = request.getSession();
		Integer id = tryParseInt((String)(session.getAttribute("id")));
		//System.out.println(path);
		
		switch(request.getMethod()) {
		case "GET":
			switch(path) {
			case "viewPending":
				List<Reimbursement> pendingList = reimbService.getReimbursementsByStatus(0);
				response.getWriter().write(om.writeValueAsString(pendingList));
				break;
			case "viewResolved":
				List<Reimbursement> resolvedList = reimbService.getResolvedReimbursements();
				response.getWriter().write(om.writeValueAsString(resolvedList));
				break;
			case "viewEmployees":
				List<User> empList = userService.getAllEmployees();
				response.getWriter().write(om.writeValueAsString(empList));	
				break;
			default:
				break;
			}
		
			break;
		case "POST":
			switch(path) { //Create View
			case "viewEmployeeReimbursement":
				String empId = request.getParameter("empId");
				System.out.println(id);

				Integer employeeId = tryParseInt(empId);
				List<Reimbursement> employeeReimb = reimbService.getReimbursementsByAuthor(employeeId);
				
				if(employeeReimb.isEmpty()) {
					response.getWriter().write(om.writeValueAsString(null));
				}
				else {
					response.getWriter().write(om.writeValueAsString(employeeReimb));
				}
				break;
			case "editReimbursementStatus":
				Integer reimbId = tryParseInt(request.getParameter("reimbId"));
				Integer reimbStatus = tryParseInt(request.getParameter("status"));
				
				boolean isUnresolved = reimbService.checkIfUnresolved(reimbId);
				
				if(isUnresolved) {
					Reimbursement reimb = reimbService.getReimbursementById(reimbId);
					LocalDateTime timeResolved = LocalDateTime.now();
					
					reimb.setReimbStatus(reimbStatus);
					reimb.setReimbResolved(timeResolved);
					reimb.setResolverId(id);
					
					reimbService.changeReimbursement(reimb);
					
					response.sendRedirect("/static/manager.html");
				}
				break;
			case "logout":
				session.invalidate();
				response.sendRedirect("/index.html");
				break;
			}
			break;
		case "PUT":

			break;
		default:
			break;
		}
		
	}
	
	public Integer tryParseInt(String input) {
		Integer num;
		
		try {
			num = Integer.parseInt(input);
		}catch(NumberFormatException e){
			num = 0;
		}
		
		return num;
	}

}
