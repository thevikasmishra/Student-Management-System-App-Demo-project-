package com.studentapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.studentapp.model.DAOServiceImpl;


@WebServlet("/updateInquiry")
public class UpdateInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateInquiryController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailId");
		String mobile = request.getParameter("mobile");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_inquiry.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		DAOServiceImpl service = new DAOServiceImpl();
		service.connectDB();
		service.updateInquiry(email, mobile);
		ResultSet result = service.ListInquiry();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_inquiry.jsp");
		rd.forward(request, response);
		
	}

}
