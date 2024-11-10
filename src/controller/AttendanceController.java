package controller;

import service.AttendanceService;

import java.util.Date;

public class AttendanceController {
    private AttendanceService attendanceService = new AttendanceService();

    public void markAttendance(int studentId, Date date, String status) {
        attendanceService.markAttendance(studentId, date, status);
    }

    // Additional methods for handling attendance-related requests
}
