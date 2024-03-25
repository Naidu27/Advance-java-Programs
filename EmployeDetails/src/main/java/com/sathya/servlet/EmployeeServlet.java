package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// step-1 : read the data
		
		int EmployeeId=Integer.parseInt(request.getParameter("EmpId"));
        String EmployeeName=request.getParameter("EmpName");
       Double EmployeeBasicSalarly= Double.parseDouble(request.getParameter("EmpBsSalarly"));
       
       //step-2 : process the data
       
       double HRA,DA,PF,GS;
       
       if(EmployeeBasicSalarly >=50000)
       {
    	   HRA=0.3*EmployeeBasicSalarly;
    	   DA=0.1*EmployeeBasicSalarly;
    	   PF=0.06*EmployeeBasicSalarly;
    	   GS=EmployeeBasicSalarly+HRA+DA-PF;
       }
       else if(EmployeeBasicSalarly <50000 && EmployeeBasicSalarly >25000)
       {
    	   HRA=0.2*EmployeeBasicSalarly;
    	   DA=0.05*EmployeeBasicSalarly;
    	   PF=0.03*EmployeeBasicSalarly;
    	   GS=EmployeeBasicSalarly+HRA+DA-PF;   
       }
       else
       {  
    	   HRA=0.1*EmployeeBasicSalarly;
    	   DA=0.03*EmployeeBasicSalarly;
    	   PF=0.02*EmployeeBasicSalarly;
    	   GS=EmployeeBasicSalarly+HRA+DA-PF;
       }
          
       //step-3: render the response
       response.setContentType("text/html");
       PrintWriter writer=response.getWriter();
       writer.println("<html>");
       writer.println("<br> Employee id = "+EmployeeId);
       writer.println("<br> Employee Name = "+EmployeeName);
       writer.println("<br> Employee Basic Salarly = "+EmployeeBasicSalarly);
       writer.println("<br> Employee HRA AMOUNT = "+HRA);
       writer.println("<br> Employee DA AMOUNT = "+DA);
       writer.println("<br> Employee PF AMOUNT = "+PF);
       writer.println("<br> Employee GROSS SALARLY = "+GS);

	
	}
}
