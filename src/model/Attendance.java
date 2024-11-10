package model;

import java.util.Date;

public class Attendance {
    private int attendanceId;
    private int studentId;
    private Date date;
    private String status;

    public Attendance(int studentId, Date date, String status) {
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    // Getters and setters
    public int getAttendanceId() { return attendanceId; }
    public void setAttendanceId(int attendanceId) { this.attendanceId = attendanceId; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}