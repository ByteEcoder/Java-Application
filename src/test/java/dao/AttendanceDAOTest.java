import dao.AttendanceDAO;
import main.DatabaseConnection;
import model.Attendance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

class AttendanceDAOTest {

    @Mock
    private DatabaseConnection mockDbConnection;
    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockStatement;
    @Mock
    private ResultSet mockResultSet;

    private AttendanceDAO attendanceDAO;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        attendanceDAO = new AttendanceDAO();

        when(mockDbConnection.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
    }

    @Test
    void testRecordAttendance() throws SQLException {
        Attendance attendance = new Attendance(1, new java.util.Date(), "Present");
        
        attendanceDAO.recordAttendance(attendance);
        
        verify(mockStatement, times(1)).setInt(1, attendance.getStudentId());
        verify(mockStatement, times(1)).setDate(2, new java.sql.Date(attendance.getDate().getTime()));
        verify(mockStatement, times(1)).setString(3, attendance.getStatus());
        verify(mockStatement, times(1)).executeUpdate();
    }

    @Test
    void testCalculateAttendancePercentage() throws SQLException {
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(10);
        
        // Mocking the total and attended queries
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        double percentage = attendanceDAO.calculateAttendancePercentage(1);
        
        // Verifying percentage calculation
        verify(mockStatement, times(2)).executeQuery();
        verify(mockResultSet, times(2)).getInt(1);
    }
}
