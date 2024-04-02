package edu.hoqwarts.data;

import edu.generic.Person;

public class HoqwartsTeacher extends Person implements HoqwartsPerson {
    private House house;
    private boolean headOfHouse;
    private int id; // Add ID field

    public HoqwartsTeacher(String firstName, String middleName, String lastName, House house, boolean headOfHouse, int id) {
        super(firstName, middleName, lastName);
        this.house = house;
        this.headOfHouse = headOfHouse;
        this.id = id;
    }

    @Override
    public String getName() {
        return super.getFirstName();
    }


    public int getId() {
        return id;
    }

    @Override
    public House getHouse() {
        return house;
    }

    @Override
    public void setHouse(House house) {
        this.house = house;
    }

    public boolean isHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(boolean headOfHouse) {
        this.headOfHouse = headOfHouse;
    }
}
