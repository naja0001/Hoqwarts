package edu.hoqwarts;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

        public static void main(String[] args) {
            // Creating a list
            List<Person> teacher = new ArrayList<>();

            // Adding students
            Person.addStudent(teacher, "Horace", "Slughorn");
            Person.addStudent(teacher, "Severus", "Snape");

            // Printing information
            for (int i = 0; i < teacher.size(); i++) {
                Person student = teacher.get(i);
                System.out.println("Teacher " + (i + 1) + ":");
                System.out.println("First Name: " + student.getFirstName());
                System.out.println("Last Name: " + student.getLastName());
            }
        }
    }


