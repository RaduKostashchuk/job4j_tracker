package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String specialization;

    public Surgeon(String name, String surname, String birthday,
                   String education, String direction, String specialization) {
        super(name, surname, birthday, education, direction);
        this.specialization = specialization;
    }

    public String getSpec() {
        return this.specialization;
    }

    public Diagnosis diag(Patient patient) {
        Diagnosis diag = new Diagnosis();
        return diag;
    }

    public void cure(Patient patient) {
    }
}
