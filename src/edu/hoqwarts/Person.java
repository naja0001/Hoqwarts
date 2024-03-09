package edu.hoqwarts;

import java.util.List;

public class Person {

        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public static void addStudent(List<edu.hoqwarts.Person> students, String firstName, String lastName) {
            students.add(new edu.hoqwarts.Person(firstName, lastName));
        }

}
