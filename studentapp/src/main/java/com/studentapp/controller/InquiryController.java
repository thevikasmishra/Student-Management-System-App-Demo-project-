package com.studentapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.studentapp.model.DAOServiceImpl;


@WebServlet("/addInquiry")
public class InquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InquiryController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/inquiry.jsp");
		rd.forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("email")!=null) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			DAOServiceImpl service = new DAOServiceImpl();
			service.connectDB();
			service.createInquiry(name, email, mobile);
			request.setAttribute("Message", "saved!!");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/inquiry.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

}
