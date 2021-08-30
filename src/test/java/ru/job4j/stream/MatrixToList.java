package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public List<Integer> matrixToList(Integer[][] input) {
        return Stream.of(input)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}