package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Secondservlet")
public class Secondservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String qualification= request.getParameter("qualification");
		String designation=request.getParameter("designation");
		
		HttpSession session=request.getSession(false);
		
		session.setAttribute("qualification", qualification);
		session.setAttribute("designation", designation);
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("form3.html");
		
		dispatcher.forward(request, response);
	}



}
