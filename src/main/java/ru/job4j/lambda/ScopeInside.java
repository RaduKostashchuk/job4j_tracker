package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int total = 0;
        for (int num : numbers) {
            int sum = total;
            total = add(
                    () -> num + sum
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}