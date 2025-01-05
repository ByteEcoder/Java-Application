package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import service.StudentService;
import model.Student;

public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the updated registration page (form)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from the registration form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Create a new student object
        Student student = new Student(firstName, lastName, email, password, role);

        // Register student using StudentService
        StudentService studentService = new StudentService();
        boolean isRegistered = studentService.registerStudent(student);

        // Redirect to login if registration is successful, else back to the registration form
        if (isRegistered) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
