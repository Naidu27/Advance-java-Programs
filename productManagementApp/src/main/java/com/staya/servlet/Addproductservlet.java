package com.staya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/Addproductservlet")
@MultipartConfig
public class Addproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String  proid=request.getParameter("proId");
		String  proName=request.getParameter("proName");
		Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		 Date proMfgDate=Date.valueOf(request.getParameter("proMfgdate"));
		 Date proExpdate=Date.valueOf(request.getParameter("proExpdate"));
		 Part part=request.getPart("proImage");
		 InputStream inputStream=part.getInputStream();
		 
		//conversion of inputStream into byte[]
		 byte[] proImage=IOUtils.toByteArray(inputStream);
		 
		 Part part2=request.getPart("proAudio");
		 InputStream inputStream2=part2.getInputStream();
		 byte[] proAudio=IOUtils.toByteArray(inputStream2);
		 
		 Part part3=request.getPart("proVideo");
		 InputStream inputStream3=part3.getInputStream();
		 byte[] proVideo=IOUtils.toByteArray(inputStream3);
		 
		 Product product=new Product();
		 
		 product.setProId(proid);
		 product.setProName(proName);
		 product.setProPrice(proPrice);
		 product.setProBrand(proBrand);
		 product.setProMadeIn(proMadeIn);
		 product.setProMfgDate(proMfgDate);
		 product.setProExpdate(proExpdate);
		 product.setProImage(proImage);
		 product.setProAudio(proAudio);
		 product.setProVideo(proVideo);
		 
	     ProdcutDao p=new ProdcutDao();
	    
		 int result=p.save(product);
		 

		 if(result==1)
		 {
			 request.setAttribute("saveResult", result);
			 RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response); 
		 }
		
		 else
		 {
			 response.setContentType("text/html");
			 PrintWriter writer=response.getWriter();
		      writer.println("data inserted successfull"+result);
		      RequestDispatcher dispatcher=request.getRequestDispatcher("Add-product.html");
		      dispatcher.include(request, response);
		 }
	
		  
	}

}
