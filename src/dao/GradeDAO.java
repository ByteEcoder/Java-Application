package dao;
import main.DatabaseConnection;
import model.Grade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GradeDAO {
    public void assignGrade(Grade grade) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Grade (student_id, course_id, teacher_id, grade_value) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, grade.getStudentId());
            stmt.setInt(2, grade.getCourseId());
            stmt.setInt(3, grade.getTeacherId());
            stmt.setString(4, grade.getGradeValue());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Additional methods for updating and retrieving grades
}
