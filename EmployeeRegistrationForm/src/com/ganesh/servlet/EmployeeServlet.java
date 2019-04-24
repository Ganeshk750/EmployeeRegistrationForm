package com.ganesh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ganesh.dao.EmployeeDao;
import com.ganesh.model.Employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao employeeDao;
	
	public void init() {
		employeeDao = new EmployeeDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		    String firstName = req.getParameter("firstName");
	        String lastName = req.getParameter("lastName");
	        String username = req.getParameter("username");
	        String password = req.getParameter("password");
	        String address = req.getParameter("address");
	        String contact = req.getParameter("contact");
	        
	        Employee employee = new Employee();
	        employee.setFirstName(firstName);
	        employee.setLastName(lastName);
	        employee.setUsername(username);
	        employee.setPassword(password);
	        employee.setContact(contact);
	        employee.setAddress(address);
	        
	        try {
	            employeeDao.registerEmployee(employee);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        resp.sendRedirect("details.jsp");
	}

}
