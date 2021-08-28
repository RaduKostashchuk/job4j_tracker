package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    private static int total = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        for (int num : numbers) {
            total = add(
                    () -> num + total
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}