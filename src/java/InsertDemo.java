import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class InsertDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("n1");
		String s2=request.getParameter("n2");
		String s3=request.getParameter("n3");
		String s4=request.getParameter("n4");
		String s5=request.getParameter("n5");
		out.println("<html>");
		out.println("<body>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajava?useSSL=false","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into insmarks values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
			con.close();
		}
		catch(Exception e)
		{
		out.println(e);
		}
	    response.sendRedirect("ShowAll");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}