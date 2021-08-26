package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortAsc() {
        List<String> input = Arrays.asList("k1/sk1/ssk2", "k2", "k1/sk1", "k1/sk1/ssk1",
                "k2/sk1/ssk2", "k2/sk1", "k1");
        List<String> expected = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk1",
            "k1/sk1/ssk2", "k2", "k2/sk1", "k2/sk1/ssk2");
        Departments.sortAsc(input);
        assertThat(input, is(expected));
    }

    @Test
    public void whenSortDesc() {
        List<String> input = Arrays.asList("k2", "k1/sk1", "k1/sk1/ssk1",
                "k2/sk1/ssk2", "k2/sk1/ssk1", "k2/sk1", "k1");
        List<String> expected = Arrays.asList("k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk2",
                "k1", "k1/sk1", "k1/sk1/ssk1");
        Departments.sortDesc(input);
        assertThat(input, is(expected));
    }
}