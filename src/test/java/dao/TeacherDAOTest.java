import dao.TeacherDAO;
import main.DatabaseConnection;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

class TeacherDAOTest {

    @Mock
    private DatabaseConnection mockDbConnection;
    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockStatement;

    private TeacherDAO teacherDAO;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        teacherDAO = new TeacherDAO();

        when(mockDbConnection.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
    }

    @Test
    void testAddTeacher() throws SQLException {
        Teacher teacher = new Teacher("John Doe", "john.doe@example.com", 101);

        teacherDAO.addTeacher(teacher);

        verify(mockStatement, times(1)).setString(1, teacher.getName());
        verify(mockStatement, times(1)).setString(2, teacher.getEmail());
        verify(mockStatement, times(1)).setInt(3, teacher.getSubjectId());
        verify(mockStatement, times(1)).executeUpdate();
    }
}
