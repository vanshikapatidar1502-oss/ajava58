import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class UpdateDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
                String s3=request.getParameter("u3");
                String s4=request.getParameter("u4");
	        String s5=request.getParameter("u5");
               try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava?useSSL=false","root","root");
			Statement st=con.createStatement();
			int x=st.executeUpdate(" update insmarks  set u2='"+s2+"',u3='"+s3+"',u4='"+s4+"',u5='"+s5+"' where u1='"+s1+"' ");
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