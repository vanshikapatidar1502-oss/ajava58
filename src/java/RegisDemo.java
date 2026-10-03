import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RegisDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		String s3=request.getParameter("uc");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajava?useSSL=false","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into regis values('"+s1+"','"+s2+"','"+s3+"')");
			con.close();
			response.sendRedirect("login.html");
		}
		catch(Exception e)
		{
			out.println("<html><body>");
			out.println(e);
			out.println("</body></html>");
		}
		out.close();
        }
}