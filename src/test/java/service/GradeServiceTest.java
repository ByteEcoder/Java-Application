import service.GradeService;
import dao.GradeDAO;
import model.Grade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class GradeServiceTest {

    @Mock
    private GradeDAO mockGradeDAO;

    private GradeService gradeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gradeService = new GradeService();
        gradeService = Mockito.spy(gradeService);
        gradeService.gradeDAO = mockGradeDAO;
    }

    @Test
    void testAssignGrade() {
        gradeService.assignGrade(1, 101, 10, "A");

        verify(mockGradeDAO, times(1)).assignGrade(any());
    }
}
