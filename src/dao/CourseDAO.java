package dao;
import main.DatabaseConnection;
import model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDAO {
    public void addCourse(Course course) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Course (course_name, credit_hours) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, course.getCourseName());
            stmt.setInt(2, course.getCreditHours());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Additional methods for updating, deleting, and fetching courses
}
