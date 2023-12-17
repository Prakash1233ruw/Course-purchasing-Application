package pack.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.connect.Model;

@WebFilter("/Loginn")
public class Filtering implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
       
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
   
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(true);
        
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
       

       
        if (isValidUser(userName, password)) {
        	 session.setAttribute( "username",userName);
           
            chain.doFilter(request, response);
        } else {
           
            httpResponse.sendRedirect("/MVCProject1/LoginFailed.html");
        }
    }

    public void destroy() {
        
    }

    private boolean isValidUser(String userName, String password) {
        Model app = new Model();

        try {
            
            app.setUserName(userName);
            app.setPassword(password);
            app.login();

            
            String dbUser = app.getUserName();
            String dbPassword = app.getPassword();

            
            return userName.equals(dbUser) && password.equals(dbPassword);
        } catch (Exception e) {
           
            e.printStackTrace();
            return false;
        } 
    }

}
