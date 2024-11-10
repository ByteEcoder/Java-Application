package main;

import dao.StudentDAO;
import model.Student;

public class Main {
    public static void main(String[] args) {
        // Example: Adding a student
        Student student = new Student("John Doe", "john@example.com", 1);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student);

        System.out.println("Student added successfully!");
    }
}
