package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String specialization;

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
