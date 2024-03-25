package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Thirdservlet")
public class Thirdservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session=request.getSession(false);
		
		
		response.setContentType("text/html");
		
		PrintWriter Writer=response.getWriter();
		Writer.println("<html>");
		Writer.println("<pre style=color:blue>");
		Writer.println("<body>");
		Writer.println("name"   +"------------>"+session.getAttribute("userName"));
		Writer.println("age"   +"------------>"+session.getAttribute("Age"));
		Writer.println("qualification"   +"--------------->"+session.getAttribute("qualification"));
		Writer.println("designation"   +"----------------->"+session.getAttribute("designation"));
		Writer.println("email"  +"--------------------->"+request.getParameter("email"));
		Writer.println("mobile"   +"------------------------"+request.getParameter("mobile"));
		Writer.println("</pre>");
		Writer.println("</body>");
		Writer.println("</html>");
		
		
		
		
	}



}
