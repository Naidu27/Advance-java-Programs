package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginapplication")
public class loginapplication extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//step 1:read the data
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
//step 2:process the data
		String Status;
		if(username.equals("sai") && password.equals("saisree"))
		{
			Status="login successfull";
		}
		else
		{
			Status="login fail";
		}
		
//step 3:render the response to client
		
		PrintWriter Writer=response.getWriter();
		response.setContentType("text/html");
		Writer.println("<html>");
		Writer.println("<h1>Login status----</h1>"+Status);
		Writer.println("/html");
	}


}