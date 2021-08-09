package ru.job4j.oop;

public class Battery {
    private int load;

    private Battery(int load) {
        this.load = load;
    }

    private void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(50);
        Battery second = new Battery(0);
        System.out.println("First battery load was: " + first.load);
        System.out.println("Second battery load was: " + second.load);
        first.exchange(second);
        System.out.println("After echange first battary load is: " + first.load);
        System.out.println("and second battery load is: " + second.load);
    }

}
