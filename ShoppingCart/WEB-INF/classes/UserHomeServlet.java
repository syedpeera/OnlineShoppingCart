package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UserHomeServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		if(hs == null)
		{
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req,res);
		}
		String uname = (String)hs.getAttribute("Username");
		String pword = (String)hs.getAttribute("Password");
		pw.println("	<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("	<head>");
		pw.println("		<title>Online Shopping Site | UserHome Page</title>");
		pw.println("		<meta charset = 'UTF-8'>");
		pw.println("		<meta name = 'viewport' content = 'width=device-width, initial-scale = 1.0'>");
		pw.println("		<link rel = 'stylesheet' type = 'text/css' href = 'style.css'>");
		pw.println("		<link rel = 'icon' type = 'text/image' href = 'shoppingcart.png'>");
		pw.println("	</head>");
		pw.println("	<body background = ''>");
		pw.println("		<table width = '100%'  border = '0'> ");
		pw.println("			<thead>");
		pw.println("				<tr align = 'center'>");
		pw.println("					<td class = 'fontshop'><h1>My Shopping Site</h1></td>");
		pw.println("				</tr>");
		pw.println("			</thead>");
		pw.println("			<tbody>");
		pw.println("				<table width = '100%' border = '0'>");
		pw.println("					<tr>");
		pw.println("						<td class = 'sizeform'>");
		pw.println("							<a href = 'getproducts'>View Products</a><br/><br/>");
		pw.println("							<a href = 'viewcartdetails'>View Cart</a><br/><br/>");
		pw.println("							<a href = 'logout'>Logout</a><br/><br/>");
		pw.println("						</td>	");
		pw.println("						<td>");
		pw.println("							<blockquote><h1 class = 'shopquote'>Welcome , " + uname );
		pw.println("							<br/><center>One stop for all your needs</center></h1></blockquote>         ");  
		pw.println("						</td>	");
		pw.println("					</tr>");
		pw.println("				</table>");
		pw.println("			</tbody>");
		pw.println("		</table>");
		pw.println("		<footer>");
		pw.println("			<center>");
		pw.println("				<strong class = 'fontshop'>©Copyrights 2017-2018</strong>");
		pw.println("			</center>");
		pw.println("		</footer>");
		pw.println("	</body>");
		pw.println("	</html>		");
	}
}