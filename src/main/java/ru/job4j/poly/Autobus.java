package ru.job4j.poly;

public class Autobus implements Vehicle {
    private String fuel = "дизтопливо";

    @Override
    public String getFuel() {
        return this.fuel;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по дорогам.");
    }
}
