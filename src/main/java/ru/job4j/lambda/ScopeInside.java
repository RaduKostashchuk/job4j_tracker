package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int total = add(
                    () -> {
                        int sum = 0;
                        for (int num : numbers) {
                            sum += num;
                        }
                        return sum;
                    }
            );
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}