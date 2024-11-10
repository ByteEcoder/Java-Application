package dao;

import main.DatabaseConnection;
import model.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AttendanceDAO {
    public void recordAttendance(Attendance attendance) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Attendance (student_id, date, status) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, attendance.getStudentId());
            stmt.setDate(2, new java.sql.Date(attendance.getDate().getTime()));
            stmt.setString(3, attendance.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to calculate attendance percentage
    public double calculateAttendancePercentage(int studentId) {
        double percentage = 0.0;
        String totalClassesQuery = "SELECT COUNT(*) FROM Attendance WHERE student_id = ?";
        String attendedClassesQuery = "SELECT COUNT(*) FROM Attendance WHERE student_id = ? AND status = 'Present'";

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Calculate total classes
            PreparedStatement totalStmt = conn.prepareStatement(totalClassesQuery);
            totalStmt.setInt(1, studentId);
            ResultSet totalResult = totalStmt.executeQuery();
            int totalClasses = 0;
            if (totalResult.next()) {
                totalClasses = totalResult.getInt(1);
            }

            // Calculate attended classes
            PreparedStatement attendedStmt = conn.prepareStatement(attendedClassesQuery);
            attendedStmt.setInt(1, studentId);
            ResultSet attendedResult = attendedStmt.executeQuery();
            int attendedClasses = 0;
            if (attendedResult.next()) {
                attendedClasses = attendedResult.getInt(1);
            }

            // Calculate percentage
            if (totalClasses > 0) {
                percentage = ((double) attendedClasses / totalClasses) * 100;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return percentage;
    }

    // Additional methods for updating and retrieving attendance records
}
