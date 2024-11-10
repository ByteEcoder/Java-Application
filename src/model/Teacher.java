package model;

public class Teacher {
    private int teacherId;
    private String name;
    private String email;
    private int subjectId;

    public Teacher(String name, String email, int subjectId) {
        this.name = name;
        this.email = email;
        this.subjectId = subjectId;
    }

    // Getters and setters
    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getSubjectId() { return subjectId; }
    public void setSubjectId(int subjectId) { this.subjectId = subjectId; }
}
