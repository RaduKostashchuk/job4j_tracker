package ru.job4j.examen;

public class Child extends Parent {

    public int hey(int a) {
        System.out.println(1);
        int b = 4;
        return a * b;
    }

    public long hey(long a) {
        System.out.println(2);
        int b = 4;
        return a * b;
    }

    private void run() {
        System.out.println(this.hey(3l));
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.run();
    }
}
