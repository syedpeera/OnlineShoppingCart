package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class DisServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ServletContext sct = req.getServletContext();
		Bean b = (Bean)sct.getAttribute("ref");

		String result = req.getParameter("preview");

		if(result.equals("Preview"))
		{
			pw.println("<link rel = 'stylesheet' type = 'text/css' href = 'style.css'>");
			pw.println("<div class = 'namefont'><center><strong>Username :</strong> "+b.getUname()+"</center><br/>");
			pw.println("<center><strong>Password :</strong> "+b.getPword()+"</center><br/>");
			pw.println("<center><strong>First Name :</strong> "+b.getFname()+"</center><br/>");
			pw.println("<center><strong>Last Name :</strong> "+b.getLname()+"</center><br/>");
			pw.println("<center><strong>Email Id :</strong> "+b.getEmail()+"</center><br/>");
			pw.println("<center><strong>Phone No. :</strong> "+b.getPhoneno()+"</center><br/></div>");

			RequestDispatcher rd = req.getRequestDispatcher("final.html");
			rd.include(req,res);
		}
		else
		{
			try
			{
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement("insert into RegForm values(?,?,?,?,?,?)");
				ps.setString(1,b.getUname());
				ps.setString(2,b.getPword());
				ps.setString(3,b.getFname());
				ps.setString(4,b.getLname());
				ps.setString(5,b.getEmail());
				ps.setLong(6,b.getPhoneno());
				int k = ps.executeUpdate();
				if(k == 1)
				{
					pw.println("<link rel = 'stylesheet' type = 'text/css' href = 'style.css'> <center class = 'fontshop'>Account Created Successfully</center><br/>");

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
}

