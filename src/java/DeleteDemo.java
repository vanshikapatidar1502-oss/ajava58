import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class DeleteDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("n1");
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajava?useSSL=false","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("delete from insmarks where u1='"+s1+"'");
			response.sendRedirect("ShowAll");
            con.close();
        }
		catch(Exception e)
		{
		out.println(e);
		}
		out.close();
	}
}
