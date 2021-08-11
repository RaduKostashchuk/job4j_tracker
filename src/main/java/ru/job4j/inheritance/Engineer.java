package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String indutry;

    public Engineer(String name, String surname, String birthday,
                    String education, String indutry) {
        super(name, surname, birthday, education);
        this.indutry = indutry;
    }
}