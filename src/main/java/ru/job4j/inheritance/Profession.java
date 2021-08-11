package ru.job4j.inheritance;

public class Profession {
    private String name;
    private String surname;
    private String birthday;
    private String education;

    public Profession(String name, String surname, String birthday, String education) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.education = education;
    }

    public String getName() {
        return this.name;
    }

    public String getSurame() {
        return this.surname;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getEducation() {
        return this.education;
    }
}
