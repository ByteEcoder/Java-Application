import service.AttendanceService;
import dao.AttendanceDAO;
import model.Attendance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.*;

class AttendanceServiceTest {

    @Mock
    private AttendanceDAO mockAttendanceDAO;

    private AttendanceService attendanceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        attendanceService = new AttendanceService();
        attendanceService = Mockito.spy(attendanceService);
        attendanceService.attendanceDAO = mockAttendanceDAO;
    }

    @Test
    void testMarkAttendance() {
        Date date = new Date();
        attendanceService.markAttendance(1, date, "Present");

        verify(mockAttendanceDAO, times(1)).recordAttendance(any());
    }
}
