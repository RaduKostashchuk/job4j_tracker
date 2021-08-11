package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String company;

    public Dentist(String name, String surname, String birthday,
                   String education, String direction, String company) {
        super(name, surname, birthday, education, direction);
        this.company = company;
    }

    public String getCompany() {
        return this.company;
    }

    public void wrest(Patient patient) {
    }

    public void cure(Patient patient) {
    }
}
