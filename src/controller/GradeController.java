package controller;

import service.GradeService;

public class GradeController {
    private GradeService gradeService = new GradeService();

    public void assignGrade(int studentId, int courseId, int teacherId, String gradeValue) {
        gradeService.assignGrade(studentId, courseId, teacherId, gradeValue);
    }

    // Additional methods for handling grade-related requests
}
