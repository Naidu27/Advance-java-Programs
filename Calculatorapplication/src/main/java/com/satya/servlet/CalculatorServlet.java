package com.satya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step-1 : read the data
		int num1=Integer.parseInt(request.getParameter("firstnumber"));
		int num2=Integer.parseInt(request.getParameter("secondnumber"));
		String operation=request.getParameter("operation");
		
		// step-2 : process the data
		
		int result=0;
		switch (operation)
		{
		case "+" : result=num1+num2;
		           break;
		case "-" : result=num1-num2;
                     break;
        
		case "*" : result=num1*num2;
                      break;
		case "/" : result=num1/num2;
                    break;
		case "%" : result=num1%num2;
                       break;
		}
		
		
		//step-3 : render the response
		
		response.setContentType("text/html");
		
		PrintWriter  writer=response.getWriter();
		writer.println("<html>");
		writer.println("your result is ="+result);
		writer.println("</html>");
		
	}
}



