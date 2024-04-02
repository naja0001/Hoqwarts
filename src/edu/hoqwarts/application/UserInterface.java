package edu.hoqwarts.application;

import edu.hoqwarts.data.HoqwartsPerson;
import edu.hoqwarts.data.HoqwartsStudent;
import edu.hoqwarts.data.HoqwartsTeacher;
import edu.hoqwarts.data.House;
import edu.generic.Student;
import edu.generic.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private List<HoqwartsPerson> persons;
    private StudentController studentController;
    private TeacherController teacherController;

    public UserInterface() {
        scanner = new Scanner(System.in);
        persons = new ArrayList<>();
        studentController = new StudentController();
        teacherController = new TeacherController();
    }

    public void start() {
        int choice;
        do {
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageTeachers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void manageStudents() {
        int choice;
        do {
            System.out.println("\nStudent Management");
            System.out.println("1. Create Student");
            System.out.println("2. Get Student by Name");
            System.out.println("3. Get All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    getStudentByName();
                    break;
                case 3:
                    getAllStudents();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void createStudent() {
        try {
            System.out.print("Enter student first name: ");
            String firstName = scanner.next();
            System.out.print("Enter student middle name: ");
            String middleName = scanner.next();
            System.out.print("Enter student last name: ");
            String lastName = scanner.next();

            System.out.print("Enter student house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
            House house = House.valueOf(scanner.next().toUpperCase());

            System.out.print("Is the student a prefect? (true/false): ");
            boolean prefect = scanner.nextBoolean();

            System.out.print("Enter student teams: ");
            String teams = scanner.next();

            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter student enrollment year: ");
            int enrollmentYear = scanner.nextInt();
            System.out.print("Enter student graduation year: ");
            int graduationYear = scanner.nextInt();
            System.out.print("Has the student graduated? (true/false): ");
            boolean graduated = scanner.nextBoolean();

            Student student = new Student(firstName, middleName, lastName, id, enrollmentYear, graduationYear, graduated);
            HoqwartsStudent hoqwartsStudent = new HoqwartsStudent(student.getFirstName(), student.getMiddleName(), student.getLastName(),
                    house, prefect, teams);

            persons.add(hoqwartsStudent);

            System.out.println("Student created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input for house.");
        }
    }

    private void getStudentByName() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        for (HoqwartsPerson person : persons) {
            if (person instanceof HoqwartsStudent && person.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found: " + person.getName());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private void getAllStudents() {
        System.out.println("All Students:");
        for (HoqwartsPerson person : persons) {
            if (person instanceof HoqwartsStudent) {
                System.out.println(person.getName());
            }
        }
    }

    private void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (HoqwartsPerson person : persons) {
            if (person instanceof HoqwartsStudent && ((Student) person).getId() == id) {
                found = true;
                System.out.print("Enter new house (Gryffindor, Hufflepuff, Ravenclaw, Slytherin): ");
                String houseName = scanner.next();
                House house = House.valueOf(houseName.toUpperCase());
                System.out.print("Is the student now a prefect? (true/false): ");
                boolean prefect = scanner.nextBoolean();
                System.out.print("Enter new student teams: ");
                String teams = scanner.next();
                ((HoqwartsStudent) person).setHouse(house);
                ((HoqwartsStudent) person).setPrefect(prefect);
                ((HoqwartsStudent) person).setTeams(teams);
                System.out.println("Student updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter student name to delete: ");
        String name = scanner.next();
        persons.removeIf(person -> person instanceof HoqwartsStudent && person.getName().equalsIgnoreCase(name));
        System.out.println("Student deleted successfully.");
    }

    private void manageTeachers() {
        int choice;
        do {
            System.out.println("\nTeacher Management");
            System.out.println("1. Create Teacher");
            System.out.println("2. Get Teacher by ID");
            System.out.println("3. Get All Teachers");
            System.out.println("4. Update Teacher");
            System.out.println("5. Delete Teacher");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createTeacher();
                    break;
                case 2:
                    getTeacherById();
                    break;
                case 3:
                    getAllTeachers();
                    break;
                case 4:
                    updateTeacher();
                    break;
                case 5:
                    deleteTeacher();
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void createTeacher() {
        try {
            System.out.print("Enter teacher first name: ");
            String firstName = scanner.next();
            System.out.print("Enter teacher middle name: ");
            String middleName = scanner.next();
            System.out.print("Enter teacher last name: ");
            String lastName = scanner.next();

            System.out.print("Enter teacher house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
            House house = House.valueOf(scanner.next().toUpperCase());

            System.out.print("Is the teacher the head of house? (true/false): ");
            boolean headOfHouse = scanner.nextBoolean();

            System.out.print("Enter teacher ID: ");
            int id = scanner.nextInt();

            // Create a HoqwartsTeacher object
            HoqwartsTeacher teacher = new HoqwartsTeacher(firstName, middleName, lastName, house, headOfHouse, id);

            // Add the teacher to the list of persons
            persons.add(teacher);

            System.out.println("Teacher created successfully.");
        } catch (IllegalArgumentException e) {
            // Handle invalid input for House enum
            System.out.println("Invalid input for house.");
        }
    }

    private void getTeacherById() {
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();
        Teacher teacher = teacherController.getTeacher(id);
        if (teacher != null) {
            System.out.println("Teacher found: " + teacher);
        } else {
            System.out.println("Teacher not found.");
        }
    }

    private void getAllTeachers() {
        System.out.println("All Teachers:");
        for (Teacher teacher : teacherController.getAllTeachers()) {
            System.out.println(teacher);
        }
    }

    private void updateTeacher() {
        System.out.print("Enter teacher ID to update: ");
        int id = scanner.nextInt();
        for (HoqwartsPerson person : persons) {
            if (person instanceof HoqwartsTeacher && ((HoqwartsTeacher) person).getId() == id) {
                System.out.print("Enter new first name: ");
                String firstName = scanner.next();
                System.out.print("Enter new middle name: ");
                String middleName = scanner.next();
                System.out.print("Enter new last name: ");
                String lastName = scanner.next();
                System.out.print("Enter new house (GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN): ");
                House house = House.valueOf(scanner.next().toUpperCase());
                System.out.print("Is the teacher now the head of house? (true/false): ");
                boolean headOfHouse = scanner.nextBoolean();
                ((HoqwartsTeacher) person).setFirstName(firstName);
                ((HoqwartsTeacher) person).setMiddleName(middleName);
                ((HoqwartsTeacher) person).setLastName(lastName);
                ((HoqwartsTeacher) person).setHouse(house);
                ((HoqwartsTeacher) person).setHeadOfHouse(headOfHouse);
                System.out.println("Teacher updated successfully.");
                return;
            }
        }
        System.out.println("Teacher not found.");
    }

    private void deleteTeacher() {
        System.out.print("Enter teacher name to delete: ");
        String name = scanner.next();
        persons.removeIf(person -> person instanceof HoqwartsTeacher && person.getName().equalsIgnoreCase(name));
        System.out.println("Teacher deleted successfully.");
    }
}
