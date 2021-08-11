package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String company;

    public Builder(String name, String surname, String birthday,
                   String education, String indutry, String company) {
        super(name, surname, birthday, education, indutry);
        this.company = company;
    }

    public String getCompany() {
        return this.company;
    }

    public Construction build(Blueprint blueprint) {
        Construction building = new Construction();
        return building;
    }

    public void repair(Construction construction) {
    }
}
