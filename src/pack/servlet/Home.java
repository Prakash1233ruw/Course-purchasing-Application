package pack.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
       

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Course Purchase Result</title>");
            out.println("</head>");
            out.println("<body>");

            // Retrieve selected courses from the request
            String[] selectedCourses = request.getParameterValues("courses");

            out.println("<h2>Thank you for your purchase!</h2>");

            if (selectedCourses != null && selectedCourses.length > 0) {
                out.println("<p>You have purchased the following courses:</p>");
                out.println("<ul>");
                for (String course : selectedCourses) {
                    out.println("<li>" + course + "</li>");
                }
                out.println("</ul>");
            } else {
                out.println("<p>No courses selected</p>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }
}

