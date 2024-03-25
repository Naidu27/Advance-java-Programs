package com.staya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdatesProductServlet")
@MultipartConfig
public class UpdatesProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String proId=request.getParameter("proId");
		String updatedProductName=request.getParameter("proName");
		
		double UpdatedProductPrice=Double.parseDouble(request.getParameter("proPrice"));
		String UpdatedProductBrand=request.getParameter("proBrand");
		
		String UpdatedProductMadeIn=request.getParameter("proMadeIn");
		Date UpdatedProductMfgDate=Date.valueOf(request.getParameter("proMfgdate"));
		Date UpdatedProductExpDate=Date.valueOf(request.getParameter("proExpdate"));
	    
		  
		Product product=new Product();
		product.setProId(proId);
		product.setProName(updatedProductName);
		product.setProPrice(UpdatedProductPrice);
		product.setProBrand(UpdatedProductBrand);
		product.setProMadeIn(UpdatedProductMadeIn);
		product.setProMfgDate(UpdatedProductMfgDate);
		product.setProExpdate(UpdatedProductExpDate);
		
		Part filePart=request.getPart("newProImage");
		
		// new proimage is the name of your file input field
		
		if(filePart !=null && filePart.getSize()>0)
		{
			InputStream inputStream=filePart.getInputStream();
			byte[] newImageData=IOUtils.toByteArray(inputStream);
			product.setProImage(newImageData);
		}
		else {
			//Part file=request.getPart("existingImage");
			String s=request.getParameter("existingImage");
			//InputStream inputStream =file.getInputStream();
			byte[] existingImage=Base64.getDecoder().decode(s);
			product.setProImage(existingImage);
		}
		
		ProdcutDao dao= new ProdcutDao();
		int result=dao.updateById(product);
		if(result==1) {
			
			//request.setAttribute("result", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);
		}
		
		else
		{
			PrintWriter writer=response.getWriter();
			writer.println("Data Updatation failed check once....."+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("editform.jsp");
			dispatcher.include(request, response);
		}
		
		
	}

}
