package ru.job4j.poly;

public class Plane implements Vehicle {
    private String fuel = "керосин";

    @Override
    public String getFuel() {
        return this.fuel;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по воздуху.");
    }
}
