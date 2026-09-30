import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SearchDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("n1");
		
	
		out.println("<html>");
		out.println("<head>");
        out.println("<link rel='stylesheet' href='abc.css'/>");
        out.println("</head>");
                out.println("<body><div id='mymenu'><ul><li> Home </li><li><a href='insertdemo.html'>Insert</a></li><li><a href='searchdemo.html'>Search</a></li><li><a href='ShowAll'>ShowAll</a></li><li><a href='updatedemo.html'>Update</a></li><li><a href='deletedemo.html'>Delete</a></li><li><a href='LogoutDemo'>LogOut</a></li></ul></div>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava?useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from insmarks  where u1='"+s1+"'" );
			out.println("<center>");
                        
		   if(rs.next())
			{
                          out.println("<form action='UpdateDemo'>");  
			out.println("<table cellpadding='12'>");
			out.println("<tr>");
			out.println("<td> RNO.</td>");
                        out.println("<td><input type='text' name='n1' value='"+rs.getString(1)+"'></td>");
			 out.println("</tr>");
                                 
                         
			out.println("<tr>");
			out.println("<td> Name.</td>");
                        out.println("<td><input type='text' name='n2' value='"+rs.getString(2)+"'></td>");
			 out.println("</tr>");
                                 
                                 
			out.println("<tr>");
			out.println("<td> PHY.</td>");
                        out.println("<td><input type='text' name='n3' value='"+rs.getString(3)+"'></td>");
			 out.println("</tr>");
                                 
                                 
			out.println("<tr>");
			out.println("<td> Che.</td>");
                        out.println("<td><input type='text' name='n4' value='"+rs.getString(4)+"'></td>");
			 out.println("</tr>");
                                 
                                        
			out.println("<tr>");
			out.println("<td> Maths.</td>");
                        out.println("<td><input type='text' name='n5' value='"+rs.getString(5)+"'></td>");
			 out.println("</tr>");
                      
				out.println("<tr>");
				out.println("<th colspan='2'><input type='submit' class='B' value='Update..'></th>");
				out.println("</tr>");
			
			out.println("</table>");
                        out.println("</form>");
                        }
                   else
                           {
                               out.println("Invalid RNO...");
                           }
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