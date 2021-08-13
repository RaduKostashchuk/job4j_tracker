package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("The bus is departing.");
    }

    @Override
    public void passengers(int number) {
        System.out.println("The bus has " + number + " passengers on board.");
    }

    @Override
    public double fillup(int volume) {
        double price = 50;
        return price * volume;
    }
}
