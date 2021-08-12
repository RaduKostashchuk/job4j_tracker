package ru.job4j.poly;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle autobus = new Autobus();
        Vehicle[] array = new Vehicle[] {plane, train, autobus};

        for (Vehicle element : array) {
            element.move();
            System.out.println(element.getClass().getSimpleName()
            + " использует в качестве топлива " + element.getFuel() + ".");
        }

    }
}
