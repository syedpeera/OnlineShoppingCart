package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RegServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String uname = req.getParameter("username");
		String pword = req.getParameter("password");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("mailid");
		long phoneno = Long.parseLong(req.getParameter("phoneno"));

		Bean b = new Bean();
		b.setUname(uname);
		b.setPword(pword);
		b.setFname(fname);
		b.setLname(lname);
		b.setEmail(email);
		b.setPhoneno(phoneno);

		ServletContext sct = req.getServletContext();
		sct.setAttribute("ref",b);

		RequestDispatcher rd = req.getRequestDispatcher("final.html");
		rd.forward(req,res);
	}
}