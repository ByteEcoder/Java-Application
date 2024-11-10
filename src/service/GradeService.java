package service;

import dao.GradeDAO;
import model.Grade;

public class GradeService {
    private GradeDAO gradeDAO = new GradeDAO();

    public void assignGrade(int studentId, int courseId, int teacherId, String gradeValue) {
        Grade grade = new Grade(studentId, courseId, teacherId, gradeValue);
        gradeDAO.assignGrade(grade);
    }

    // Additional methods for grade-related business logic
}
