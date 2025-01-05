import dao.StudentDAO;
import main.DatabaseConnection;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

class StudentDAOTest {

    @Mock
    private DatabaseConnection mockDbConnection;
    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockStatement;

    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        studentDAO = new StudentDAO();

        // Mock the connection and prepared statement
        when(mockDbConnection.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
    }

    @Test
    void testAddStudent() throws SQLException {
        // Create a mock Student object
        Student student = new Student("John Doe", "john.doe@example.com", 1);

        // Call the addStudent method
        studentDAO.addStudent(student);

        // Verify that the correct parameters are set on the PreparedStatement
        verify(mockStatement, times(1)).setString(1, student.getName());
        verify(mockStatement, times(1)).setString(2, student.getEmail());
        verify(mockStatement, times(1)).setInt(3, student.getCourseId());

        // Verify that executeUpdate() was called once to insert the student
        verify(mockStatement, times(1)).executeUpdate();
    }
}
