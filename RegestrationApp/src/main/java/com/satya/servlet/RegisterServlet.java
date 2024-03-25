package com.satya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// step-1: read the data
		String UserName=request.getParameter("User Name");
		String Paswword=request.getParameter("User Password");
		int number=Integer.parseInt(request.getParameter("User Number"));
		String email =request.getParameter("Email"); 
		String gender=request.getParameter("Gender");
		String[] qualification=request.getParameterValues("Qualification");
		String[] language=request.getParameterValues("Languages");
		String dob=request.getParameter("DOB");
		String Country=request.getParameter("Country");
		String Comments=request.getParameter("comments");
		
		//step-2: process the data
		String  q= String.join(",", qualification);
		String l=String.join(",", language);
		
		//step-3: render the response
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("user name="+UserName+"<br><br>");
		writer.println("password="+Paswword+"<br><br>");
		writer.println("number="+number+"<br><br>");
		writer.println("email="+email+"<br><br>");
		writer.println("gender="+gender+"<br><br>");
		writer.println("qualification="+q+"<br><br>");
		writer.println("language="+l+"<br><br>");
		writer.println("dob="+dob+"<br><br>");
		writer.println("Country="+Country+"<br><br>");
		writer.println("Comments="+Comments);
		writer.println("</html>");
		
	}

	

}
