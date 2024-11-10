package service;

import dao.AttendanceDAO;
import model.Attendance;

import java.util.Date;

public class AttendanceService {
    private AttendanceDAO attendanceDAO = new AttendanceDAO();

    public void markAttendance(int studentId, Date date, String status) {
        Attendance attendance = new Attendance(studentId, date, status);
        attendanceDAO.recordAttendance(attendance);
    }

    // Additional methods for attendance business logic
}
