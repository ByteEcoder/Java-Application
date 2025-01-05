import dao.GradeDAO;
import main.DatabaseConnection;
import model.Grade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

class GradeDAOTest {

    @Mock
    private DatabaseConnection mockDbConnection;
    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockStatement;

    private GradeDAO gradeDAO;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        gradeDAO = new GradeDAO();

        when(mockDbConnection.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
    }

    @Test
    void testAssignGrade() throws SQLException {
        Grade grade = new Grade(1, 101, 10, "A");

        gradeDAO.assignGrade(grade);

        verify(mockStatement, times(1)).setInt(1, grade.getStudentId());
        verify(mockStatement, times(1)).setInt(2, grade.getCourseId());
        verify(mockStatement, times(1)).setInt(3, grade.getTeacherId());
        verify(mockStatement, times(1)).setString(4, grade.getGradeValue());
        verify(mockStatement, times(1)).executeUpdate();
    }
}
