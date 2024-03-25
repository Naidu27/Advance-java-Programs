package com.satya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 // step-1:read the data
		int proid=Integer.parseInt(request.getParameter("proid"));
		String proname=request.getParameter("proname");
		int proprice=Integer.parseInt(request.getParameter("proprice"));
		int proQuantity=Integer.parseInt(request.getParameter("proQuantity"));
		
		
		//step-2: process the data
		
		float netpayableprice=0;
		float tprice=proprice*proQuantity;
		float discount=0.0f;
		
		if(tprice<=1000)
		{
			discount=proprice*0.0f;
			netpayableprice=proprice-discount;
		}
		else if(tprice>1000 && tprice<5000)
		 {
				discount=proprice*0.05f;
				netpayableprice=proprice-discount;
		 }
		else if(tprice>5000 && tprice<10000)
		{
			discount=proprice*0.10f;
			netpayableprice=proprice-discount;
					}
		
		else if(tprice>10000)
		{
			discount=proprice*0.15f;
			netpayableprice=proprice-discount;
					}
		
		 
		// step-3 render the response
		response.setContentType("text/html");
		PrintWriter writer= response.getWriter();
		writer.println("<html>");
		writer.println("productId= "+proid);
		writer.println("<br>productName= "+proname);
		writer.println("<br>product	price= "+proprice);
		writer.println("<br> productquantity= "+proQuantity);
		writer.println(" <br>productbill= "+tprice);
		writer.println("<br>productdiscount= "+discount);
		writer.println("<br>product net payable= "+netpayableprice);
	}


}
