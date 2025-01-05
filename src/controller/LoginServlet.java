package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Render login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simulating user authentication (you can replace this with real validation logic)
        if ("admin".equals(username) && "admin123".equals(password)) {
            // Set session and redirect based on role (student or teacher)
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            // Redirect based on role (use roles for real applications)
            response.sendRedirect("stud_landing.jsp");  // Assuming student role for now
        } else {
            // Invalid login credentials
            request.setAttribute("errorMessage", "Invalid login credentials");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
