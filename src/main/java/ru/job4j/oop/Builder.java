package ru.job4j.oop;

public class Builder extends Engineer {
    private String industry;

    public String getIndustry() {
        return this.industry;
    }

    public Construction build(Blueprint blueprint) {
        Construction building = new Construction();
        return building;
    }

    public void repair(Construction construction) {
    }
}
