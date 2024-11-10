-- Table for storing course information
CREATE TABLE Courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    teacher_id INT
);

-- Table for storing teacher information
CREATE TABLE Teachers (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- Table for storing student information
CREATE TABLE Students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    course_id INT,
    enrollment_date DATE,
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

-- Table for storing attendance records
CREATE TABLE Attendance (
    attendance_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    date DATE,
    status ENUM('Present', 'Absent', 'Late', 'Excused') NOT NULL,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES Students(student_id)
);

-- Table for storing grades
CREATE TABLE Grades (
    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    teacher_id INT,
    grade_value VARCHAR(2),  -- Example: A+, A, B, C, D, F
    grade_date DATE,
    CONSTRAINT fk_grade_student FOREIGN KEY (student_id) REFERENCES Students(student_id),
    CONSTRAINT fk_grade_course FOREIGN KEY (course_id) REFERENCES Courses(course_id),
    CONSTRAINT fk_grade_teacher FOREIGN KEY (teacher_id) REFERENCES Teachers(teacher_id)
);
