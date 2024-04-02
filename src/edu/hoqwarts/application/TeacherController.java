package edu.hoqwarts.application;

import edu.generic.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherController {
    private List<Teacher> teachers;
    private int idCounter;

    public TeacherController() {
        teachers = new ArrayList<>();
        idCounter = 1; // Initialize the ID counter
    }

    public void createTeacher(Teacher teacher) {
        // Check if a teacher with the same ID already exists
        boolean idExists = teachers.stream().anyMatch(t -> t.getId() == teacher.getId());
        if (idExists) {
            System.out.println("Teacher cannot be created. Teacher with the same ID already exists.");
        } else {
            // Set the ID for the teacher and increment the counter for the next teacher
            teacher.setId(idCounter++);
            teachers.add(teacher);
            System.out.println("Teacher created successfully.");
        }
    }

    public Teacher getTeacher(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public void updateTeacher(int id, Teacher updatedTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                updatedTeacher.setId(id);
                teachers.set(i, updatedTeacher);
                break;
            }
        }
    }

    public void deleteTeacher(int id) {
        teachers.removeIf(teacher -> teacher.getId() == id);
    }
}
