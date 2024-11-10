package model;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private int courseId;

    public Student(String name, String email, int courseId) {
        this.name = name;
        this.email = email;
        this.courseId = courseId;
    }

    // Getters and setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
}
