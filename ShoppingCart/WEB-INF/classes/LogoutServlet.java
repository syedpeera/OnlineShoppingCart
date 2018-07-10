package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		HttpSession hs = req.getSession(false);
		if(hs != null)
		{
			hs.invalidate();
		}

		pw.println("<link rel = 'stylesheet' type = 'text/css' href = 'style.css'> <center class = 'fontshop'>Successfully Logged Out</center><br/>");

		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.include(req,res);
	}
}