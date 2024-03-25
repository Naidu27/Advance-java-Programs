package com.naidu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FullNameApplication")
public class FullNameApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step 1: get the data
		
		String FIRSTNAME=request.getParameter("FIRSTNAME");
		String MIDDLENAME=request.getParameter("MIDDLENAME");
		String LASTNAME=request.getParameter("LASTNAME");
		
		//step 2: process the data
		
		String status;
		if(FIRSTNAME.equals("KILAPARTHI") && MIDDLENAME.equals("SAI") && LASTNAME.equals("KANNAYYA NAIDU") )
		{
			status="KILAPARTHI SAI KANNAYYA NAIDU";
		}
		else
		{
			status="fail";
		}
		
		// render the response	
		  PrintWriter Writer=response.getWriter();
			response.setContentType("text/html");
			Writer.println("<html>");
			Writer.println("<h1>full name</h1>"+status);
			Writer.println("</html>");

	}

}


