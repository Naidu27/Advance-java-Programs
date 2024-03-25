package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Thirdservlet")
public class Thirdservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
     Cookie[] s=request.getCookies();
     
     response.setContentType("text/html");
     
     
     PrintWriter  Writer=response.getWriter();
     Writer.println("<html>");
     Writer.println("<body>");
     Writer.println("<pre style= color:green");
     Writer.println("name"+s[0].getValue());
     Writer.println("age"+s[1].getValue());
     Writer.println("qualification"+s[2].getValue());
     Writer.println("designation"+s[3].getValue());
     Writer.println("email" +request.getParameter("email"));
     Writer.println("mobile"+request.getParameter("mobile"));
     Writer.println("</pre>");
     Writer.println("</body>");
     Writer.println("</html>");
     
     
	
	}

}
