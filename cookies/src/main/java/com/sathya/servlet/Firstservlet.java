package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("userName");
		String age=request.getParameter("Age");
		
		//create the cookies object
		Cookie cookie1=new Cookie("userName",name);
		Cookie cookie2=new Cookie("Age",age);
		
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("form2.html");
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		dispatcher.forward(request, response);
		
	}

}
