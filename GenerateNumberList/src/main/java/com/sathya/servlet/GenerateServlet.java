package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerateServlet")
public class GenerateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step-1:read the data
		int start  =Integer.parseInt(request.getParameter("Start Number"));
		int end =Integer.parseInt(request.getParameter("End Number"));
		String operation=request.getParameter("operation");
		// step-2:process the data
		
		ArrayList<Integer> l=new ArrayList<Integer>();
		
		      switch(operation) {
		      case"Even":
				for(int i=start;i<=end;i++) {
				if(i%2==0) 
					l.add(i);
				}
				break;
				
		      case"Odd":
		    	  for(int i=start;i<=end;i++)
		    	  {
		    		  if(i%2!=0)
		    			  l.add(i);
		    	  }
		    	  break;
		    	  
		      case "Prime":
					for(int i=start;i<=end;i++) {
						int count=0;
						for(int j=2;j<i;j++) {
							if(i%j==0)
								count++;
						}
						if(count==0)
							l.add(i);
					}
					break;
				case "Perfect":
					for(int i=start;i<=end;i++) {
						int sum=0;
						for(int j=1;j<i;j++) {
							 if(i%j==0) {
								 sum=sum+j;
							 }
						}
						if(sum==i)
							l.add(sum);
					}
					break;
				case "Strong":
					for(int i=start;i<=end;i++) {
						int temp=i;
						int rem=1;
						int result=1;
						int result1=0;
						while(temp>0) {
							rem=temp%10;
							temp=temp/10;
							result=1;
							while (rem>0) {
							result=result*rem;
							rem--;
							}
							result1=result1+result;
						}
						if(result1==i)
							l.add(i);
					}
					break;
				case "Armstrong":
					for(int i=start;i<=end;i++) {
						int temp=i;
						int temp1=i;
						int rem=0;
						int result=0;
						int count=0;
						int p=1;
						while(temp>0) {
							temp=temp/10;
							count++;
						}
						while(temp1>0) {
							int count1=count;
							rem=temp1%10;
							temp1=temp1/10;
							p=1;
							while(count1>0) {
								p=p*rem;
								count1--;
							}
							result=result+p;
						}
						if(result==i)
							l.add(i);
					}
					break;
		      }
		
		
			
			response.setContentType("text/html");
          PrintWriter writer=response.getWriter();
          writer.println("<html>");
          writer.println("The "+ operation+" " + "numbers between"+" "+start+" "+ "and" +" " +end+" "+ "are"+l);
          writer.println("</html>");


	}
}