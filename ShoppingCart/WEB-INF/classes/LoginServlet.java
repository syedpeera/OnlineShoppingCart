package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String uname = req.getParameter("username");
		String pword = req.getParameter("password");
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from RegForm where uname = ? and pword = ?");
			ps.setString(1,uname);
			ps.setString(2,pword);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				pw.println("<link rel = 'stylesheet' type = 'text/css' href = 'style.css'> <center = 'fontshop'>Login Successfull</center><br/>");

				HttpSession hs = req.getSession();
				hs.setAttribute("Username",uname);
				hs.setAttribute("Password",pword);

				RequestDispatcher rd = req.getRequestDispatcher("home");
				rd.include(req,res);
			}
			else
			{
				pw.println("<link rel = 'stylesheet' type = 'text/css' href = 'style.css'> <center class = 'fontshop'>Plz create an account if you don't have one</center><br/>");

				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req,res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}