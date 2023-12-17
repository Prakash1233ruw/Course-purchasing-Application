package pack.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connect.Model;


@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String gender= request.getParameter("gender");
		String city = request.getParameter("city");
		String password = request.getParameter("password");
		String conformPassword = request.getParameter("confirmPassword");
		
		
		
	if(password.equals(conformPassword)) {

		Model app=new Model();
		app.setUserName(userName);
		app.setGender(gender);
		app.setCity(city);
		app.setPassword(password);
		app.register();
		int row =app.getRow();
		if(row!=0) {
		response.sendRedirect("/MVCProject1/registrationSuccess.html");
		}else {
			response.sendRedirect("/MVCProject1/failed.html");
		}
	}else {
		response.sendRedirect("/MVCProject1/registrationFailed.html");
	}
	}

}
