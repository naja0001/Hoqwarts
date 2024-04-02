package edu.hoqwarts.data;

import edu.generic.Person;

public class HoqwartsStudent extends Person implements HoqwartsPerson {
    private House house;
    private boolean prefect;
    private String teams;

    public HoqwartsStudent(String firstName, String middleName, String lastName,
                           House house, boolean prefect, String teams) {
        super(firstName, middleName, lastName);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    @Override
    public String getName() {
        return super.getFirstName() + " " + super.getMiddleName() + " " + super.getLastName();
    }

    @Override
    public House getHouse() {
        return house;
    }

    @Override
    public void setHouse(House house) {
        this.house = house;
    }

    public boolean isPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }
}
