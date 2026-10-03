import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ShowAll extends HttpServlet
{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
	
		out.println("<html>");
		out.println("<head>");
        out.println("<link rel='stylesheet' href='abc.css'/>");
        out.println("</head>");
               out.println("<body><div id='mymenu'><ul><li> Home </li><li><a href='insertdemo.html'>Insert</a></li><li><a href='searchdemo.html'>Search</a></li><li><a href='ShowAll'>ShowAll</a></li><li><a href='updatedemo.html'>Update</a></li><li><a href='deletedemo.html'>Delete</a></li><li><a href='LogoutDemo'>LogOut</a></li></ul></div>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajava?useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from insmarks");
			out.println("<center>");
			out.println("<table cellpadding='12'>");
			out.println("<tr>");
			out.println("<td> RNO</td>");
			out.println("<td> Name</td>");
			out.println("<td> Phy</td>");
			out.println("<td> Chem</td>");
			out.println("<td> Maths</td>");
			out.println("</tr>");
		    while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</center>");
			out.println("</div>");
			con.close();
		}
		catch(Exception e)
		{
		out.println(e);
		}
	   
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}