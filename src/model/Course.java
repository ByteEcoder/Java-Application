package model;

public class Course {
    private int courseId;
    private String courseName;
    private int creditHours;

    public Course(String courseName, int creditHours) {
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    // Getters and setters
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public int getCreditHours() { return creditHours; }
    public void setCreditHours(int creditHours) { this.creditHours = creditHours; }
}
