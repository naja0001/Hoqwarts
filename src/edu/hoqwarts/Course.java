package edu.hoqwarts;

public class Course {
    private String name;
    private String textbook;
    private Teacher teacher;

    public Course(String name, String textbook, Teacher teacher) {
        this.name = name;
        this.textbook = textbook;
        this.teacher = teacher;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextbook() {
        return textbook;
    }

    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", textbook='" + textbook + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public static void main(String[] args) {
        // Create a single Teacher object and add it to the list
        Teacher teacher = new Teacher("Horace Slughorn");

        // Create a Course object
        Course potionsCourse = new Course("Potions", "Advanced Potion-Making", teacher);

        // Print the course details
        System.out.println("Course details:");
        System.out.println(potionsCourse);
    }
}