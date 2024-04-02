package edu.generic;

import java.util.Date;

public class Teacher extends Person {
    private int id; // Add ID field
    private String empType;
    private Date employmentStart;
    private Date employmentEnd;

    public Teacher(String firstName, String middleName, String lastName,
                   int id, String empType, Date employmentStart, Date employmentEnd) {
        super(firstName, middleName, lastName);
        this.id = id;
        this.empType = empType;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public Date getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(Date employmentStart) {
        this.employmentStart = employmentStart;
    }

    public Date getEmploymentEnd() {
        return employmentEnd;
    }

    public void setEmploymentEnd(Date employmentEnd) {
        this.employmentEnd = employmentEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
