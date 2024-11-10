package dao;
import main.DatabaseConnection;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public void addStudent(Student student) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Student (name, email, course_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setInt(3, student.getCourseId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Additional methods for update, delete, and fetch operations
}
