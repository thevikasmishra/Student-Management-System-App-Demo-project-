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


@WebServlet("/deleteInquiry")
public class DeleteControllerInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteControllerInquiry() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailId");
		DAOServiceImpl service = new DAOServiceImpl();
		service.connectDB();
		service.deleteInquiry(email);
		ResultSet result = service.ListInquiry();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_inquiry.jsp");
		rd.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
