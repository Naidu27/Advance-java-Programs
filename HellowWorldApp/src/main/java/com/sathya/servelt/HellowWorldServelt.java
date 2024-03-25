package com.sathya.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HellowWorldServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   	/*	PrintWriter Writer =response.getWriter();   		
   		Writer.println("This first application");
   		Writer.println("Hellow java");
   		Writer.println("First application wow...");*/
   		
   	    
   	 	PrintWriter Writer =response.getWriter();  
   	 	Writer.println("<Html>");
   		Writer.println("<h1>This first application</h1>");
   		Writer.println("<h2>Hellow java</h2>");
   		Writer.println("<h3>First application wow...</h3>");
   		Writer.println("<h4>First application wow...</h4>");
   		Writer.println("<h5>First application wow...</h5>");
   		Writer.println("<html>");
   		
	}

}
