package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>(
                Arrays.asList(1, 20, 45, -8, 29, -4, 78, 419, -76, 3));
        List<Integer> result = source.stream()
                .filter(n -> n > 0)
                .toList();
        System.out.println(source);
        System.out.println(result);
    }
}