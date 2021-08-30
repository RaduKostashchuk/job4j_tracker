package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void whenConvertToList() {
        MatrixToList obj = new MatrixToList();
        Integer[][] array = {
                {1, 3, 3, 6},
                {10, 12, 11},
                {1, 3}
        };
        List<Integer> result = obj.matrixToList(array);
        assertThat(result, is(List.of(1, 3, 3, 6, 10, 12, 11, 1, 3)));
    }

    @Test
    public void whenEmpty() {
        MatrixToList obj = new MatrixToList();
        Integer[][] array = {};
        List<Integer> result = obj.matrixToList(array);
        assertTrue(result.isEmpty());
    }
}