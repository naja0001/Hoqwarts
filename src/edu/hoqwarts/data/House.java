package edu.hoqwarts.data;

public enum House {
    GRYFFINDOR("Gryffindor"),
    HUFFLEPUFF("Hufflepuff"),
    RAVENCLAW("Ravenclaw"),
    SLYTHERIN("Slytherin");

    private final String name;

    House(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static House getHouseByName(String name) {
        for (House house : House.values()) {
            if (house.name.equalsIgnoreCase(name)) {
                return house;
            }
        }
        return null;
    }
}
