package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import service.GradeService;
import model.Grade;

public class UpdateGradeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Render the update grade page (if needed, can be used for fetching data for the form)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/up_grade.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the student name, subject, and marks from the form
        String studentName = request.getParameter("student");
        String subject = request.getParameter("subject");
        int marks = Integer.parseInt(request.getParameter("marks"));

        // Update the grade using GradeService
        GradeService gradeService = new GradeService();
        boolean isUpdated = gradeService.updateGrade(studentName, subject, marks);

        // Redirect based on the result
        if (isUpdated) {
            response.sendRedirect("teach_landing.jsp");
        } else {
            request.setAttribute("errorMessage", "Failed to update grade.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/up_grade.jsp");
            dispatcher.forward(request, response);
        }
    }
}
