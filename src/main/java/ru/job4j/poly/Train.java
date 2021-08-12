package ru.job4j.poly;

public class Train implements Vehicle {
    private String fuel = "электричество";

    @Override
    public String getFuel() {
        return this.fuel;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам.");
    }
}
