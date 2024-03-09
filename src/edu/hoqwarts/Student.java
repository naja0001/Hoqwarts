package edu.hoqwarts;


import java.util.ArrayList;
import java.util.List;




public class Student {
    public static void main(String[] args) {
        // Creating a list
        List<Person> students = new ArrayList<>();

        // Adding students
        Person.addStudent(students, "Harry", "Potter");
        Person.addStudent(students, "Ron", "Weasley");
        Person.addStudent(students, "Hermione", "Granger");

        // Printing information
        for (int i = 0; i < students.size(); i++) {
            Person student = students.get(i);
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName());
        }
    }
}
