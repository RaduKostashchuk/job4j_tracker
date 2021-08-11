package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String direction;

    public Doctor(String name, String surname, String birthday,
                  String education, String direction) {
        super(name, surname, birthday, education);
        this.direction = direction;
    }
}
