package masters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("user_name");
		String pass=request.getParameter("password");
		if(name.equalsIgnoreCase("sam")&&pass.equalsIgnoreCase("abcd"))
		{		
		RequestDispatcher rd=request.getRequestDispatcher("Menu.html");
		rd.forward(request, response);
		}
		else
		{
			pw.println("<HTML><BODY>");
			pw.println("<h4 align='center'>Invalid user name/password....</h4>");
			pw.println("</Body></Html>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
