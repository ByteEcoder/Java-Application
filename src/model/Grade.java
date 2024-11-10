package model;

public class Grade {
    private int gradeId;
    private int studentId;
    private int courseId;
    private int teacherId;
    private String gradeValue;

    public Grade(int studentId, int courseId, int teacherId, String gradeValue) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.gradeValue = gradeValue;
    }

    // Getters and setters
    public int getGradeId() { return gradeId; }
    public void setGradeId(int gradeId) { this.gradeId = gradeId; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
    public String getGradeValue() { return gradeValue; }
    public void setGradeValue(String gradeValue) { this.gradeValue = gradeValue; }
}
