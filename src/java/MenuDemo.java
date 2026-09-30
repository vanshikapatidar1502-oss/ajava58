//Session

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class MenuDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request ,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
                String s1=(String)session.getAttribute("un");
	if(s1!=null)
                {
		out.println("<html>");
		out.println("<head>");
        out.println("<link rel='stylesheet' href='abc.css'/>");
        out.println("</head>");
        out.println("<body><div id='mymenu'><ul><li> Home </li><li><a href='insertdemo.html'>Insert</a></li><li><a href='searchdemo.html'>Search</a></li><li><a href='ShowAll'>ShowAll</a></li><li><a href='updatedemo.html'>Update</a></li><li><a href='deletedemo.html'>Delete</a></li><li><a href='LogoutDemo'>LogOut</a></li></ul></div>");
        out.println("<center>");
         out.println("Welcome "+s1);
         out.println("</center>");
            
		out.println("</body>");
		out.println("</html>");
                }
        else
        {
            response.sendRedirect("login.html");
        }
		out.close();
	}
}