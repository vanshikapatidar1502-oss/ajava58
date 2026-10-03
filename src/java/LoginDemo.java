import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LoginDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajava?useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from regis where un='"+s1+"' AND up='"+s2+"' " );
			if(rs.next())
			{
				HttpSession session = request.getSession();
				session.setAttribute("un", s1);
				response.sendRedirect("MenuDemo");
			}
			else
			{
				out.println("<html><body>");
				out.println("<h> invalid username and password</h>");
				out.println("</body></html>");
			}
			con.close();
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