package masters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Participants")
public class Participants extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		pw.println("<Html><Boby>");
		pw.println("<h1 align='center'><B>SoftwareOne Training Services</B></h1>");
		pw.println("<h2 align='center'><I>CMB Office, 82933749-Sri Lanaka</I></h2>");
		pw.println("<hr/>");
		pw.println("<br/><br/><br/><br/>");
		participatsList(pw);
		pw.println("</Body></Html>");
	}
	
	private void participatsList(PrintWriter pw)
	{
		Participant pList[]=Admin.getParticipantDetails();
		pw.println("<h2 align='center'>Participant List</h2>");
		pw.println("<table align='center' border='1'>");
		pw.println("<tr bgcolor='DABF35'><th>Participant ID</th><th>Name</th><th>Course</th><th>Session</th><th>Fee paid</th></tr>");
		for(int i=0;i<Admin.count;i++) {
		pw.println("<tr><td>"+pList[i].getId()+"</td><td>"+pList[i].getName()+"</td><td>"+pList[i].getCourseId()+"</td><td>"+pList[i].getSessionId()+"</td><td>"+pList[i].getFeePaid()+"</td></tr>");
		}
		pw.println("</table>");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
