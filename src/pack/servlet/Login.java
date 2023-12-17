package pack.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

import jdbc.connect.Model;


@WebServlet("/Loginn")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	String userName=request.getParameter("username");
//	String password=request.getParameter("password");
//	Model app=new Model();
//	app.setUserName(userName);
//	app.setPassword(password);
//    app.login();
//	
//	
//		System.out.println("connection");
//		String dbUser = app.getUserName();
//		String dbPassword = app.getPassword();
//		System.out.println(dbUser+"input->"+userName);
//		System.out.println(dbPassword +"input->"+password);
//		if(userName.equals(dbUser)&&password.equals(dbPassword)) {
			
//		response.sendRedirect("/MVCProject1/LoginSuccessful.html");
		request.getServletContext().getRequestDispatcher("/Details").forward(request, response);
//		}else 
//	
//		response.sendRedirect("/MVCProject1/LoginFailed.html");
//
	}

}
