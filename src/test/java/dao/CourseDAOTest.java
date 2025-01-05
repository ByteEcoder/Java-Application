import dao.CourseDAO;
import main.DatabaseConnection;
import model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

class CourseDAOTest {

    @Mock
    private DatabaseConnection mockDbConnection;
    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockStatement;

    private CourseDAO courseDAO;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        courseDAO = new CourseDAO();

        when(mockDbConnection.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
    }

    @Test
    void testAddCourse() throws SQLException {
        Course course = new Course("Math", 4);

        courseDAO.addCourse(course);

        verify(mockStatement, times(1)).setString(1, course.getCourseName());
        verify(mockStatement, times(1)).setInt(2, course.getCreditHours());
        verify(mockStatement, times(1)).executeUpdate();
    }
}
