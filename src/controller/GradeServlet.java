package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import service.GradeService;
import model.Grade;
import java.util.List;

public class GradeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve student session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // Check if user is logged in, otherwise redirect to login
        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Fetch grades from service
        GradeService gradeService = new GradeService();
        List<Grade> gradeList = gradeService.getGradesByStudent(username);

        // Set the grade data to the request scope
        request.setAttribute("gradeList", gradeList);

        // Forward to the updated grades JSP page to display data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Gradepage.jsp");
        dispatcher.forward(request, response);
    }
}
