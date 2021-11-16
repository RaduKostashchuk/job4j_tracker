package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int number) {
        return number - x;
    }

    public int divide(int number) {
        return number / x;
    }

    public int sumAllOperations(int number) {
        return sum(number) + multiply(number) + minus(number) + divide(number);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(10));
        System.out.println(new Calculator().multiply(10));
        System.out.println(Calculator.minus(10));
        System.out.println(new Calculator().divide(10));
        System.out.println(new Calculator().sumAllOperations(10));
    }
}
