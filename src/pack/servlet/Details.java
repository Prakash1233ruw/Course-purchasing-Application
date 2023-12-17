package pack.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.connect.JDBCUtility;
import jdbc.connect.Model;


@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String gender;
	private String city;
	private Connection connect=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter  out=response.getWriter();
		HttpSession session = request.getSession(false);
		String userName=(String) session.getAttribute("username");
		
		try {
			connect = JDBCUtility.getDBConnection();
		
	
		if(connect!=null) {
			stmt=connect.prepareStatement("select*from ninja where username=?");
		}
		
		if(stmt!=null) {
			
			stmt.setString(1, userName);
			rs=stmt.executeQuery();
			
			
		}
		while(rs.next()) {
			name=rs.getString("username");
			System.out.println(userName);
			gender=rs.getString("gender");
			city=rs.getString("city");
		}
		 out.println("<html><body>");
         out.println("<h2>User Details</h2>");
         out.println("<table border='1'><tr><th>name</th><th>gender</th><th>city</th></tr>");

       
             out.println("<tr>");
             out.println("<td>" + name+ "</td>");
             out.println("<td>" + gender+ "</td>");
             out.println("<td>" + city + "</td>");
             out.println("</tr>");
         

         out.println("</table>");
         out.println("<br><a href='/MVCProject1/Home.html'>Home</a>");
         out.println("</body></html>");
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		finally {
			try {
				JDBCUtility.closeResource(connect, stmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
}