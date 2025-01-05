package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import service.AttendanceService;
import model.Attendance;
import java.util.List;

public class AttendanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve student session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // Check if user is logged in, otherwise redirect to login
        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Fetch attendance from service
        AttendanceService attendanceService = new AttendanceService();
        List<Attendance> attendanceList = attendanceService.getAttendanceByStudent(username);

        // Set the attendance data to the request scope
        request.setAttribute("attendanceList", attendanceList);

        // Forward to the updated attendance JSP page to display data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/attendance.jsp");
        dispatcher.forward(request, response);
    }
}
