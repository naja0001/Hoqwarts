package edu.hoqwarts.application;

import edu.generic.Student;


import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private List<Student> students;
    private int idCounter;

    public StudentController() {
        students = new ArrayList<>();
        idCounter = 1;
    }

    public void createStudent(Student student) {

        boolean idExists = students.stream().anyMatch(s -> s.getId() == student.getId());
        if (idExists) {
            System.out.println("Student cannot be created. Student with the same ID already exists.");
        } else {
            students.add(student);
            System.out.println("Student created successfully.");
        }
    }

    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void updateStudent(int id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                updatedStudent.setId(id);
                students.set(i, updatedStudent);
                break;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
