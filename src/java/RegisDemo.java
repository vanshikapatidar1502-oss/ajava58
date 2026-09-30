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
		out.println("<html>");
		out.println("<body>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava?useSSL=false","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into regis values('"+s1+"','"+s2+"','"+s3+"')");
			con.close();
		}
		catch(Exception e)
		{
		out.println(e);
		}
	    response.sendRedirect("login.html");
		out.println("</body>");
		out.println("</html>");
		out.close();
        }
}