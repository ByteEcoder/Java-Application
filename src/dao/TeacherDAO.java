package dao;
import main.DatabaseConnection;
import model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDAO {
    public void addTeacher(Teacher teacher) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Teacher (name, email, subject_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getEmail());
            stmt.setInt(3, teacher.getSubjectId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Additional methods for grading students, fetching teacher data, etc.
}
