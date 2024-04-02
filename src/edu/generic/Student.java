package edu.generic;

public class Student extends Person {
    private int id;
    private int enrollmentYear;
    private int graduationYear;
    private boolean graduated;

    public Student(String firstName, String middleName, String lastName,
                   int id, int enrollmentYear, int graduationYear, boolean graduated) {
        super(firstName, middleName, lastName);
        this.id = id;
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public String getRole() {
        return "student";
    }
}
