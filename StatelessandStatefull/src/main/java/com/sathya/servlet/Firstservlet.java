package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name=request.getParameter("userName");
		int age=Integer.parseInt(request.getParameter("Age"));
		
		HttpSession Session=request.getSession();
		
		Session.setAttribute("userName", name);
		Session.setAttribute("Age", age);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("form2.html");
		
		dispatcher.forward(request,response);
	}


}
